package by.nadya159.springbootwarehouse.service;

import by.nadya159.springbootwarehouse.dto.ProductCreateEditDto;
import by.nadya159.springbootwarehouse.dto.ProductReadDto;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс, реализующий бизнес-логику приложения по работе с товарами
 */

public interface ProductService {

    ProductReadDto findById(UUID id);

    List<ProductReadDto> findAll();

    ProductReadDto create(ProductCreateEditDto productDto);

    ProductReadDto update(UUID id, ProductCreateEditDto productDto);

    boolean delete(UUID id);
}
