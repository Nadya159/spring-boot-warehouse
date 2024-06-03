package by.nadya159.springbootwarehouse.mapper;

import by.nadya159.springbootwarehouse.dto.ProductCreateDto;
import by.nadya159.springbootwarehouse.dto.ProductEditDto;
import by.nadya159.springbootwarehouse.dto.ProductReadDto;
import by.nadya159.springbootwarehouse.entity.Product;
import org.mapstruct.Mapper;

/**
 * Interface для преобразования {@link Product} и {@link ProductCreateDto}, {@link ProductReadDto}
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    /**
     * Метод преобразует {@link ProductCreateDto} в {@link Product}
     *
     * @param productDto {@link ProductCreateDto}, который нужно преобразовать
     * @return {@link Product} результат преобразования
     */
    Product toProduct(ProductCreateDto productDto);

    Product toProduct(ProductEditDto productDto);

    /**
     * Метод преобразует {@link Product} в {@link ProductReadDto}
     *
     * @param product {@link Product}, который нужно преобразовать
     * @return {@link ProductReadDto}, полученный в результате преобразования
     */
    ProductReadDto toProductReadDto(Product product);

    ProductCreateDto toProductCreateDto(Product product);
}
