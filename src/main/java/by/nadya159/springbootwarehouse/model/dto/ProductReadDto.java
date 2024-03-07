package by.nadya159.springbootwarehouse.model.dto;

import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ProductReadDto(UUID id,
                             String name,
                             String article,
                             String description,
                             String category,
                             Double price,
                             Integer amount,
                             LocalDateTime modifiedAmountAt,
                             LocalDate createdAt) {
}
