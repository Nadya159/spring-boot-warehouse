package by.nadya159.springbootwarehouse.mapper;

import by.nadya159.springbootwarehouse.dto.ProductCreateDto;
import by.nadya159.springbootwarehouse.dto.ProductDto;
import by.nadya159.springbootwarehouse.dto.ProductEditDto;
import by.nadya159.springbootwarehouse.dto.ProductResponseDto;
import by.nadya159.springbootwarehouse.entity.Product;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Interface для преобразования {@link Product} и {@link ProductCreateDto}, {@link ProductResponseDto}
 */
@Mapper(componentModel = SPRING)
public interface ProductMapper {
    Product toProduct(ProductDto productDto);

    /**
     * Метод преобразует {@link ProductCreateDto} в {@link Product}
     *
     * @param productCreateDto {@link ProductCreateDto}, который нужно преобразовать
     * @return {@link Product} результат преобразования
     */
        ProductDto toProductDto(ProductCreateDto productCreateDto);

    Product toProduct(ProductEditDto productDto);

    /**
     * Метод преобразует {@link Product} в {@link ProductResponseDto}
     *
     * @param product {@link Product}, который нужно преобразовать
     * @return {@link ProductResponseDto}, полученный в результате преобразования
     */
    ProductResponseDto toProductReadDto(Product product);

    ProductCreateDto toProductCreateDto(Product product);
}
