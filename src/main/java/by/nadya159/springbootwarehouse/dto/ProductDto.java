package by.nadya159.springbootwarehouse.dto;

import by.nadya159.springbootwarehouse.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO для {@link Product}.
 */
@Data
@AllArgsConstructor
public class ProductDto {

    //private UUID id;

    private String name;

    private String article;

    private String description;

    private String category;

    private BigDecimal price;

    private Integer amount;

    //private LocalDateTime modifiedAmountAt;

    //private LocalDateTime createdAt;
}
