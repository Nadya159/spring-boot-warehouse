package by.nadya159.springbootwarehouse.dto;

import by.nadya159.springbootwarehouse.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.UUID;
import java.time.LocalDateTime;

/**
 * DTO для чтения сущности {@link Product} (товар)
 */
public record ProductReadDto(UUID id,
                             String name,
                             String article,
                             String description,
                             String category,
                             Double price,
                             Integer amount,
                             @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                             LocalDateTime modifiedAmountAt,
                             @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                             LocalDateTime createdAt) {
}
