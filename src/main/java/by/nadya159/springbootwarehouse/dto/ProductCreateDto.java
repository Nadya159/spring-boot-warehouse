package by.nadya159.springbootwarehouse.dto;

import by.nadya159.springbootwarehouse.entity.Product;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO для создания сущности {@link Product} (товар), не содержит ID
 */
@Data
@Builder
public class ProductCreateDto {
        @NotBlank(message = "Name cannot be null")
        @Size(min = 3, max = 64,
                message = "Must be between 3 and 64 characters")
        private String name;

        @NotBlank(message = "Article cannot be null")
        @Size(min = 3, max = 64,
                message = "Must be between 3 and 64 characters")
        private String article;

        @Size(min = 3, max = 128,
                message = "Must be between 3 and 128 characters")
        private String description;

        @NotBlank(message = "Category cannot be null")
        @Size(min = 3, max = 64,
                message = "Must be between 3 and 64 characters")
        private String category;

        @NotNull(message = "Price cannot be null")
        @PositiveOrZero(message = "Price should not be less than 0")
        private BigDecimal price;

        @NotNull(message = "Amount cannot be null")
        @PositiveOrZero(message = "Amount should not be less than 0")
        private Integer amount;
}

