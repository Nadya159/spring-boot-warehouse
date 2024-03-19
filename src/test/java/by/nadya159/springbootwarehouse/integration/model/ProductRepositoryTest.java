package by.nadya159.springbootwarehouse.integration.model;

import by.nadya159.springbootwarehouse.integration.annotation.IT;
import by.nadya159.springbootwarehouse.model.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@IT
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void checkQueries() {
        /*var products = productRepository.findAll("a", "ov");
        assertThat(products).hasSize(3);*/
    }
}
