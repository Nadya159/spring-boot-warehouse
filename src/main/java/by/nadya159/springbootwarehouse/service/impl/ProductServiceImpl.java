package by.nadya159.springbootwarehouse.service.impl;

import by.nadya159.springbootwarehouse.dto.ProductCreateDto;
import by.nadya159.springbootwarehouse.dto.ProductDto;
import by.nadya159.springbootwarehouse.dto.ProductEditDto;
import by.nadya159.springbootwarehouse.dto.ProductResponseDto;
import by.nadya159.springbootwarehouse.entity.Product;
import by.nadya159.springbootwarehouse.exception.NotFoundElementException;
import by.nadya159.springbootwarehouse.exception.ProductWithDuplicateArticleException;
import by.nadya159.springbootwarehouse.mapper.ProductMapper;
import by.nadya159.springbootwarehouse.repository.ProductRepository;
import by.nadya159.springbootwarehouse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    /**
     * Получение товара по его идентификатору (UUID)
     *
     * @param id товара (UUID)
     * @return Товар, с заданным идентификатором (UUID)
     * @throws NotFoundElementException если товар с заданным идентификатором (UUID) не найден
     */
    @Override
    public ProductResponseDto findById(UUID id) {
        return productRepository.findById(id)
                .map(productMapper::toProductReadDto)
                .orElseThrow(() -> new NotFoundElementException("Product with id='%s' not found".formatted(id)));
    }

    /**
     * Получение товара по его артиклю
     *
     * @param article товара
     * @return Товар, с заданным артиклем
     * @throws NotFoundElementException если товар с заданным артиклем не найден
     */

    @Override
    public ProductResponseDto findByArticle(String article) {
        Product obtainedProduct = productRepository.findByArticle(article);
        if (obtainedProduct == null) {
            throw new NotFoundElementException("Product with article='%s' not found".formatted(article));
        }
        return productMapper.toProductReadDto(obtainedProduct);
    }

    /**
     * Получение списка всех товаров
     *
     * @return Список всех товаров
     */
    @Override
    public List<ProductResponseDto> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .stream().map(productMapper::toProductReadDto).toList();
    }

    /**
     * Создание нового товара
     *
     * @param productDto {@link ProductDto} товар, который нужно создать
     * @return {@link ProductResponseDto} созданный товар
     */
    @Transactional
    @Override
    public ProductResponseDto create(ProductDto productDto) {
        Product maybeProduct = productRepository.findByArticle(productDto.getArticle());
        if (maybeProduct != null) {
            throw new ProductWithDuplicateArticleException("Product with article='%s' already exists"
                    .formatted(productDto.getArticle()));
        } else {
            Product productMapper1 = productMapper.toProduct(productDto);
            Product newProduct = productRepository.save(productMapper.toProduct(productDto));
            ProductResponseDto productResponse = productMapper.toProductReadDto(newProduct);
            return productResponse;
            /*return productMapper.toProductReadDto(productRepository.save
                    (productMapper.toProduct(productDto)));*/
        }
    }

    /**
     * Обновление товара по его идентификатору (UUID)
     *
     * @param id         идентификатор обновляемого продукта
     * @param productDto {@link ProductCreateDto} товар, который нужно создать
     * @return {@link ProductResponseDto} созданный товар
     * @throws NotFoundElementException если товар с заданным идентификатором (UUID) не найден
     */
    @Transactional
    @Override
    public ProductResponseDto update(UUID id, ProductEditDto productDto) {
        var product = productRepository.getReferenceById(id);
        boolean isExists = productRepository.existsById(id);
        if (!isExists) {
            throw new NotFoundElementException("Product with id='%s' not found".formatted(id));
        }
        Product maybeProduct = productRepository.findByArticle(productDto.article());
        if (maybeProduct != null) {
            throw new ProductWithDuplicateArticleException("Product with article='%s' already exists");
        }
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
    @Override
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
