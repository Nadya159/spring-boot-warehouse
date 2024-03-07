package by.nadya159.springbootwarehouse.model.dto;

public record ProductCreateDto(String name,
                               String article,
                               String description,
                               String category,
                               Double price,
                               Integer amount) {
}
