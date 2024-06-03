package by.nadya159.springbootwarehouse.util;

import by.nadya159.springbootwarehouse.entity.Category;
import by.nadya159.springbootwarehouse.entity.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class DataUtils {

    public static Product getProductTest1Transient() {
    return Product.builder()
            .name("Смартфон Realme 12 PRO PLUS")
            .article("DVC-001-317")
            .description("Смартфон realme 10 Pro+ NFC 8/256 Гб")
            .category(Category.valueOf("DEVICES"))
            .price(BigDecimal.valueOf(28050.00))
            .amount(10)
            .build();
    }

    public static Product getProductTest1Persisted() {
        return Product.builder()
                .id(UUID.randomUUID())
                .name("Смартфон Realme 12 PRO PLUS")
                .article("DVC-001-317")
                .description("Смартфон realme 10 Pro+ NFC 8/256 Гб")
                .category(Category.valueOf("DEVICES"))
                .price(BigDecimal.valueOf(28050.00))
                .amount(10)
                .build();
    }
}
