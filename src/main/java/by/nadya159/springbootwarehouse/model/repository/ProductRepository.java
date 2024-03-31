package by.nadya159.springbootwarehouse.model.repository;

import by.nadya159.springbootwarehouse.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Репозиторий для {@link Product} (товара)
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
