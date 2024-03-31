package by.nadya159.springbootwarehouse.service;

import by.nadya159.springbootwarehouse.exception.NotFoundElementException;
import by.nadya159.springbootwarehouse.model.dto.ProductCreateEditDto;
import by.nadya159.springbootwarehouse.model.dto.ProductReadDto;
import by.nadya159.springbootwarehouse.model.mapper.ProductMapper;
import by.nadya159.springbootwarehouse.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
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
public class ProductService {

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
                .map(productMapper::toProductDto)
                .orElseThrow(() -> new NotFoundElementException("Product with id='%s' not found".formatted(id)));
    }

    /**
     * Получение списка всех товаров
     *
     * @return Список всех товаров
     */
    public List<ProductReadDto> findAll() {
        return productRepository.findAll()
                .stream().map(productMapper::toProductDto).toList();
    }

    /**
     * Создание нового товара
     *
     * @param productDto {@link ProductCreateEditDto} товар, который нужно создать
     * @return {@link ProductReadDto} созданный товар
     */
    @Transactional
    public ProductReadDto create(ProductCreateEditDto productDto) {
        return productMapper.toProductDto(productRepository.save
                (productMapper.toProduct(productDto)));
    }

    /**
     * Обновление товара по его идентификатору (UUID)
     *
     * @param id идентификатор обновляемого продукта
     * @param productDto {@link ProductCreateEditDto} товар, который нужно создать
     * @return {@link ProductReadDto} созданный товар
     * @throws NotFoundElementException если товар с заданным идентификатором (UUID) не найден
     */
    @Transactional
    public ProductReadDto update(UUID id, ProductCreateEditDto productDto) {
        var product = productRepository.getReferenceById(id);
        var updateProduct = productRepository.save(product);
        return productMapper.toProductDto(updateProduct);
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
