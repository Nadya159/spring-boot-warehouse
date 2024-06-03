package by.nadya159.springbootwarehouse.service;

import by.nadya159.springbootwarehouse.dto.ProductCreateDto;
import by.nadya159.springbootwarehouse.dto.ProductEditDto;
import by.nadya159.springbootwarehouse.dto.ProductReadDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс, реализующий бизнес-логику приложения по работе с товарами
 */

public interface ProductService {

    ProductReadDto findById(UUID id);

    List<ProductReadDto> findAll(Pageable pageable);

    ProductReadDto create(ProductCreateDto productDto);

    ProductReadDto update(UUID id, ProductEditDto productDto);

    boolean delete(UUID id);
}
