package by.nadya159.springbootwarehouse.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "article")
@Builder
@Entity
@Table(name = "products")
public class Product implements BaseEntity<UUID>{

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String article;

    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private Integer amount;

    @Column(name = "modified_amount_at", nullable = false)
    private LocalDateTime modifiedAmountAt;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;
}
