package by.nadya159.springbootwarehouse.model.mapper;

import by.nadya159.springbootwarehouse.model.dto.ProductCreateDto;
import by.nadya159.springbootwarehouse.model.dto.ProductReadDto;
import by.nadya159.springbootwarehouse.model.entity.Category;
import by.nadya159.springbootwarehouse.model.entity.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductMapper {
    public Product mapFromDto(ProductCreateDto productDto) {
        return Product.builder()
                .name(productDto.name())
                .article(productDto.article())
                .description(productDto.description())
                .category(Category.valueOf(productDto.category()))
                .price(productDto.price())
                .amount(productDto.amount())
                .modifiedAmountAt(LocalDateTime.now())
                .createdAt(LocalDate.now())
                .build();
    }

    public ProductReadDto mapToDto(Product product) {
        return new ProductReadDto(
                product.getId(),
                product.getName(),
                product.getArticle(),
                product.getDescription(),
                product.getCategory().toString(),
                product.getPrice(),
                product.getAmount(),
                product.getModifiedAmountAt(),
                product.getCreatedAt()
        );
    }
}
