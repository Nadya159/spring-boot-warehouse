package by.nadya159.springbootwarehouse.repository;

import by.nadya159.springbootwarehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий для {@link Product} (товара)
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findByArticle(String article);
}
