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
            .category(Category.DEVICES)
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
                .category(Category.DEVICES)
                .price(BigDecimal.valueOf(28050.00))
                .amount(10)
                .build();
    }

    public static Product getProductTest2Transient() {
        return Product.builder()
                .name("Электронная книга ONYX BOOX Faust 6")
                .article("DVC-002-311")
                .description("Электронная книга ONYX BOOX Faust 6 черный + чехол")
                .category(Category.DEVICES)
                .price(BigDecimal.valueOf(18550.00))
                .amount(5)
                .build();
    }

    public static Product getProductTest2Persisted() {
        return Product.builder()
                .id(UUID.randomUUID())
                .name("Электронная книга ONYX BOOX Faust 6")
                .article("DVC-002-311")
                .description("Электронная книга ONYX BOOX Faust 6 черный + чехол")
                .category(Category.DEVICES)
                .price(BigDecimal.valueOf(18550.00))
                .amount(5)
                .build();
    }

    public static Product getProductTest3Transient() {
        return Product.builder()
                .name("Блокнот Brauberg Office Pro А5")
                .article("NTB-003-205")
                .description("Блокнот Brauberg Office Pro А5 в клетку")
                .category(Category.STATIONER)
                .price(BigDecimal.valueOf(300.00))
                .amount(15)
                .build();
    }

    public static Product getProductTest3Persisted() {
        return Product.builder()
                .id(UUID.randomUUID())
                .name("Блокнот Brauberg Office Pro А5")
                .article("NTB-003-205")
                .description("Блокнот Brauberg Office Pro А5 в клетку")
                .category(Category.STATIONER)
                .price(BigDecimal.valueOf(300.00))
                .amount(15)
                .build();
    }
}
