package by.nadya159.springbootwarehouse.service;

import by.nadya159.springbootwarehouse.dto.ProductCreateDto;
import by.nadya159.springbootwarehouse.dto.ProductEditDto;
import by.nadya159.springbootwarehouse.dto.ProductReadDto;
import by.nadya159.springbootwarehouse.entity.Product;
import by.nadya159.springbootwarehouse.exception.NotFoundElementException;
import by.nadya159.springbootwarehouse.exception.ProductWithDuplicateArticleException;
import by.nadya159.springbootwarehouse.mapper.ProductMapper;
import by.nadya159.springbootwarehouse.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Класс, реализующий бизнес-логику приложения по работе с товарами
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    /**
     * Получение товара по его идентификатору (UUID)
     *
     * @param id товара (UUID)
     * @return Товар, с заданным идентификатором (UUID)
     * @throws NotFoundElementException если товар с заданным идентификатором (UUID) не найден
     */
    public ProductReadDto findById(UUID id) {
        return productRepository.findById(id)
                .map(productMapper::toProductReadDto)
                .orElseThrow(() -> new NotFoundElementException("Product with id='%s' not found".formatted(id)));
    }

    /**
     * Получение списка всех товаров
     *
     * @return Список всех товаров
     */
    public List<ProductReadDto> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .stream().map(productMapper::toProductReadDto).toList();
    }

    /**
     * Создание нового товара
     *
     * @param productDto {@link ProductCreateDto} товар, который нужно создать
     * @return {@link ProductReadDto} созданный товар
     */
    @Transactional
    public ProductReadDto create(ProductCreateDto productDto) {
        Product maybeProduct = productRepository.findByArticle(productDto.article());
        if (maybeProduct != null) {
            throw new ProductWithDuplicateArticleException("Product with article='%s' already exists"
                    .formatted(productDto.article()));
        } else
            return productMapper.toProductReadDto(productRepository.save
                    (productMapper.toProduct(productDto)));
    }

    /**
     * Обновление товара по его идентификатору (UUID)
     *
     * @param id         идентификатор обновляемого продукта
     * @param productDto {@link ProductCreateDto} товар, который нужно создать
     * @return {@link ProductReadDto} созданный товар
     * @throws NotFoundElementException если товар с заданным идентификатором (UUID) не найден
     */
    @Transactional
    public ProductReadDto update(UUID id, ProductEditDto productDto) {
        var product = productRepository.getReferenceById(id);
        var updateProduct = productRepository.save(productMapper.toProduct(productDto));
        return productMapper.toProductReadDto(updateProduct);
    }

    /**
     * Удаление товара по его идентификатору (UUID)
     *
     * @param id товара, который нужно удалить
     * @return true/false как результат удаления товара
     * @throws NotFoundElementException если товар с заданным идентификатором (UUID) не найден
     */
    @Transactional
    public boolean delete(UUID id) {
        productRepository.findById(id)
                .orElseThrow(() -> new NotFoundElementException("Product with id='%s' not found".formatted(id)));

        return productRepository.findById(id)
                .map(entity -> {
                    productRepository.delete(entity);
                    productRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
