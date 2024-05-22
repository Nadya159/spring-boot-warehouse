package by.nadya159.springbootwarehouse.integration.model;

import by.nadya159.springbootwarehouse.integration.annotation.IT;
import by.nadya159.springbootwarehouse.entity.Category;
import by.nadya159.springbootwarehouse.entity.Product;
import by.nadya159.springbootwarehouse.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for {@link ProductRepository}
 */
@IT
class ProductRepositoryTest {
    private static final UUID PRODUCT_ID = UUID.fromString("401d19a1-fae2-47ad-b3ad-e35468eafec8");

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("Check find productRepository by ID")
    void findByIdTest() {
        var product = productRepository.findById(PRODUCT_ID);
        assertTrue(product.isPresent());
    }

    @Test
    @DisplayName("Check create new productRepository")
    void saveTest() {
        var product = Product.builder()
                .name("Test")
                .article("test-test")
                .category(Category.FOOD)
                .description("testing")
                .price(BigDecimal.valueOf(1001.50))
                .amount(1)
                .build();
        var productId = productRepository.save(product).getId();
        var expectedProduct = productRepository.getReferenceById(productId);
        assertEquals("Test", expectedProduct.getName());
    }

    @Test
    @DisplayName("Check delete productRepository")
    void deleteTest() {
        var product = productRepository.findById(PRODUCT_ID);
        assertTrue(product.isPresent());
        product.ifPresent(productRepository::delete);
        entityManager.flush();
        assertTrue(productRepository.findById((PRODUCT_ID)).isEmpty());
    }

    @Test
    @DisplayName("Check update productRepository by name")
    void updateByNameTest() {
        var product = productRepository.getReferenceById(PRODUCT_ID);
        product.setName("Test123!");
        productRepository.save(product);

        product = productRepository.getReferenceById(PRODUCT_ID);
        assertEquals("Test123!", product.getName());
    }
}
