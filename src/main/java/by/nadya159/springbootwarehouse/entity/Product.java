package by.nadya159.springbootwarehouse.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Сущность товара в базе данных
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "article")
@Getter
@Setter
@Builder
@Entity
@Table(name = "products", schema = "public")
public class Product implements BaseEntity<UUID>{
    /**
     * Уникальный идентификатор товара
     */
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    /**
     * Наименование товара
     */
    @Column(nullable = false)
    private String name;

    /**
     * Артикул товара
     */
    @Column(unique = true, nullable = false)
    private String article;

    /**
     * Описание товара
     */
    private String description;

    /**
     * Категория товара
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    /**
     * Цена товара
     */
    @Column(nullable = false)
    private BigDecimal price;

    /**
     * Количество товара
     */
    @Column(nullable = false)
    private Integer amount;

    /**
     * Дата последнего изменения количества товара
     */
    @Column(name = "modified_amount_at")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAmountAt;

    /**
     * Дата создания товара
     */
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * Устанавливает дату создания и последнего изменения количества перед созданием товара
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.modifiedAmountAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        this.modifiedAmountAt = LocalDateTime.now();
    }
}
