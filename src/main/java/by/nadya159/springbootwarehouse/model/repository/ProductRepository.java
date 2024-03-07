package by.nadya159.springbootwarehouse.model.repository;

import by.nadya159.springbootwarehouse.model.entity.Product;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepository implements CrudRepository<UUID, Product>{

    private EntityManager entityManager;

    @Override
    public Optional<Product> findById(UUID id) {
        Product product = entityManager.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public Product save(Product entity) {
        return null;
    }

    @Override
    public void update(Product entity) {

    }
}
