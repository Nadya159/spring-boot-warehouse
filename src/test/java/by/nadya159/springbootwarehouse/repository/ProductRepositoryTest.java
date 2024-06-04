package by.nadya159.springbootwarehouse.repository;

import by.nadya159.springbootwarehouse.entity.Product;
import by.nadya159.springbootwarehouse.util.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        productRepository.deleteAll();
    }

    @Test
    @DisplayName("Test save product in Repository layer")
    public void save() {
        //given
        Product productToSave = DataUtils.getProductTest1Transient();
        //when
        Product savedProduct = productRepository.save(productToSave);
        //then
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isNotNull();
    }

    @Test
    @DisplayName("Test update product in Repository layer")
    public void update() {
        //given
        String updateName = "TestProduct";
        Product productToCreate = DataUtils.getProductTest1Transient();
        productRepository.save(productToCreate);
        //when
        Product productToUpdate = productRepository.findById(productToCreate.getId()).orElse(null);
        productToUpdate.setName(updateName);
        Product updatedProduct = productRepository.save(productToUpdate);
        //then
        assertThat(updatedProduct).isNotNull();
        assertThat(updatedProduct.getName()).isEqualTo(updateName);
    }

    @Test
    @DisplayName("Test find product by ID in Repository layer")
    public void findById() {
        //given
        Product productToSave = DataUtils.getProductTest1Transient();
        productRepository.save(productToSave);
        //when
        Product obtainedProduct = productRepository.findById(productToSave.getId()).orElse(null);
        //then
        assertThat(obtainedProduct).isNotNull();
        assertThat(obtainedProduct.getName()).isEqualTo(productToSave.getName());
    }

    @Test
    @DisplayName("Test product not found in Repository layer")
    public void notFindById() {
        //given

        //when
        Product obtainedProduct = productRepository.findById(UUID.randomUUID()).orElse(null);
        //then
        assertThat(obtainedProduct).isNull();
    }

    @Test
    @DisplayName("Test find all products in Repository layer")
    public void findAll() {
        //given
        Product product1 = DataUtils.getProductTest1Transient();
        Product product2 = DataUtils.getProductTest2Transient();
        Product product3 = DataUtils.getProductTest3Transient();
        productRepository.saveAll(List.of(product1, product2, product3));
        //when
        List<Product> obtainedProducts = productRepository.findAll();
        //then
        assertThat(CollectionUtils.isEmpty(obtainedProducts)).isFalse();
    }

    @Test
    @DisplayName("Test find product by article in Repository layer")
    public void findByArticle() {
        //given
        Product product = DataUtils.getProductTest1Transient();
        productRepository.save(product);
        //when
        Product obtainedProduct = productRepository.findByArticle(product.getArticle());
        //then
        assertThat(obtainedProduct).isNotNull();
        assertThat(obtainedProduct.getArticle()).isEqualTo(product.getArticle());
    }

    @Test
    @DisplayName("Test delete product by ID in Repository layer")
    public void deleteById() {
        //given
        Product product = DataUtils.getProductTest1Transient();
        productRepository.save(product);
        //when
        productRepository.deleteById(product.getId());
        //then
        Product obtainedProduct = productRepository.findById(product.getId()).orElse(null);
        assertThat(obtainedProduct).isNull();
    }
}
