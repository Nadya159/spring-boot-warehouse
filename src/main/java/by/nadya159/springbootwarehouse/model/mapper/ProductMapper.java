package by.nadya159.springbootwarehouse.model.mapper;

import by.nadya159.springbootwarehouse.model.dto.ProductCreateEditDto;
import by.nadya159.springbootwarehouse.model.dto.ProductReadDto;
import by.nadya159.springbootwarehouse.model.entity.Product;
import org.mapstruct.Mapper;

/**
 * Interface для преобразования {@link Product} и {@link ProductCreateEditDto}, {@link ProductReadDto}
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    /**
     * Метод преобразует {@link ProductCreateEditDto} в {@link Product}
     *
     * @param productDto {@link ProductCreateEditDto}, который нужно преобразовать
     * @return {@link Product} результат преобразования
     */
    Product toProduct(ProductCreateEditDto productDto);

    /**
     * Метод преобразует {@link Product} в {@link ProductReadDto}
     *
     * @param product {@link Product}, который нужно преобразовать
     * @return {@link ProductReadDto}, полученный в результате преобразования
     */
    ProductReadDto toProductDto(Product product);
}
