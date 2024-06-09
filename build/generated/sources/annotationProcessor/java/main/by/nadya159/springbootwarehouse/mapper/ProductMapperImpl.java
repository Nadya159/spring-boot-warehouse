package by.nadya159.springbootwarehouse.mapper;

import by.nadya159.springbootwarehouse.dto.ProductCreateDto;
import by.nadya159.springbootwarehouse.dto.ProductDto;
import by.nadya159.springbootwarehouse.dto.ProductEditDto;
import by.nadya159.springbootwarehouse.dto.ProductResponseDto;
import by.nadya159.springbootwarehouse.entity.Category;
import by.nadya159.springbootwarehouse.entity.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( productDto.getName() );
        product.article( productDto.getArticle() );
        product.description( productDto.getDescription() );
        if ( productDto.getCategory() != null ) {
            product.category( Enum.valueOf( Category.class, productDto.getCategory() ) );
        }
        product.price( productDto.getPrice() );
        product.amount( productDto.getAmount() );

        return product.build();
    }

    @Override
    public ProductDto toProductDto(ProductCreateDto productCreateDto) {
        if ( productCreateDto == null ) {
            return null;
        }

        String name = null;
        String article = null;
        String description = null;
        String category = null;
        BigDecimal price = null;
        Integer amount = null;

        name = productCreateDto.getName();
        article = productCreateDto.getArticle();
        description = productCreateDto.getDescription();
        category = productCreateDto.getCategory();
        price = productCreateDto.getPrice();
        amount = productCreateDto.getAmount();

        ProductDto productDto = new ProductDto( name, article, description, category, price, amount );

        return productDto;
    }

    @Override
    public Product toProduct(ProductEditDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( productDto.name() );
        product.article( productDto.article() );
        product.description( productDto.description() );
        if ( productDto.category() != null ) {
            product.category( Enum.valueOf( Category.class, productDto.category() ) );
        }
        if ( productDto.price() != null ) {
            product.price( BigDecimal.valueOf( productDto.price() ) );
        }
        product.amount( productDto.amount() );

        return product.build();
    }

    @Override
    public ProductResponseDto toProductReadDto(Product product) {
        if ( product == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String article = null;
        String description = null;
        String category = null;
        Double price = null;
        Integer amount = null;
        LocalDateTime modifiedAmountAt = null;
        LocalDateTime createdAt = null;

        id = product.getId();
        name = product.getName();
        article = product.getArticle();
        description = product.getDescription();
        if ( product.getCategory() != null ) {
            category = product.getCategory().name();
        }
        if ( product.getPrice() != null ) {
            price = product.getPrice().doubleValue();
        }
        amount = product.getAmount();
        modifiedAmountAt = product.getModifiedAmountAt();
        createdAt = product.getCreatedAt();

        ProductResponseDto productResponseDto = new ProductResponseDto( id, name, article, description, category, price, amount, modifiedAmountAt, createdAt );

        return productResponseDto;
    }

    @Override
    public ProductCreateDto toProductCreateDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductCreateDto.ProductCreateDtoBuilder productCreateDto = ProductCreateDto.builder();

        productCreateDto.name( product.getName() );
        productCreateDto.article( product.getArticle() );
        productCreateDto.description( product.getDescription() );
        if ( product.getCategory() != null ) {
            productCreateDto.category( product.getCategory().name() );
        }
        productCreateDto.price( product.getPrice() );
        productCreateDto.amount( product.getAmount() );

        return productCreateDto.build();
    }
}
