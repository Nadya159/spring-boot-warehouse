package by.nadya159.springbootwarehouse.service;

import by.nadya159.springbootwarehouse.dto.ProductDto;
import by.nadya159.springbootwarehouse.dto.ProductEditDto;
import by.nadya159.springbootwarehouse.dto.ProductResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс, реализующий бизнес-логику приложения по работе с товарами
 */

public interface ProductService {

    ProductResponseDto findById(UUID id);

    ProductResponseDto findByArticle(String article);

    List<ProductResponseDto> findAll(Pageable pageable);

    ProductResponseDto create(ProductDto productDto);

    ProductResponseDto update(UUID id, ProductEditDto productDto);

    boolean delete(UUID id);
}
