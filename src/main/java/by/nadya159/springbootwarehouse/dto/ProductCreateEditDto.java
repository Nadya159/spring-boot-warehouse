package by.nadya159.springbootwarehouse.dto;

import by.nadya159.springbootwarehouse.entity.Product;
import jakarta.validation.constraints.*;

/**
 * DTO для создания или изменения сущности {@link Product} (товар)
 */
public record ProductCreateEditDto(
        @NotBlank(message = "Name cannot be null")
        @Size(min = 3, max = 64,
                message = "Must be between 3 and 64 characters")
        String name,

        @NotBlank(message = "Article cannot be null")
        @Size(min = 3, max = 64,
                message = "Must be between 3 and 64 characters")
        String article,

        @Size(min = 3, max = 128,
                message = "Must be between 3 and 128 characters")
        String description,

        @NotBlank(message = "Category cannot be null")
        @Size(min = 3, max = 64,
                message = "Must be between 3 and 64 characters")
        String category,

        @NotNull(message = "Price cannot be null")
        @PositiveOrZero(message = "Price should not be less than 0")
        Double price,

        @NotNull(message = "Amount cannot be null")
        @PositiveOrZero(message = "Amount should not be less than 0")
        Integer amount) {
}
