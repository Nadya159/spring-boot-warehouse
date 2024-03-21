package by.nadya159.springbootwarehouse.service;

import by.nadya159.springbootwarehouse.model.dto.ProductCreateDto;
import by.nadya159.springbootwarehouse.model.dto.ProductReadDto;
import by.nadya159.springbootwarehouse.model.entity.Category;
import by.nadya159.springbootwarehouse.model.entity.Product;
import by.nadya159.springbootwarehouse.model.mapper.ProductMapper;
import by.nadya159.springbootwarehouse.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private ProductMapper productMapper;

    public Optional<ProductReadDto> findById(UUID id) {
        return productRepository.findById(id)
                .map(productMapper::mapToDto);
    }

    public List<ProductReadDto> findAll() {
        return productRepository.findAll().stream().map(productMapper::mapToDto).collect(Collectors.toList());
    }

    public void create(ProductCreateDto productCreateDto) {
        //todo validator
        var entity = new ProductMapper().mapFromDto(productCreateDto);
        productRepository.saveAndFlush(entity);
    }

    public void delete(UUID id) {
        var maybeProduct = productRepository.findById(id);
        maybeProduct.ifPresent(product -> productRepository.deleteById(product.getId()));
    }

    public void update(UUID id, String name, String description, String category, double price) {
        Optional<Product> entity = productRepository.findById(id); //todo .orElseThrow(() -> new ProfileNotFoundException(id));

        entity.ifPresent(object -> object.setName(name));
        entity.ifPresent(object -> object.setDescription(description));
        entity.ifPresent(object -> object.setCategory(Category.valueOf(category)));
        entity.ifPresent(object -> object.setPrice(price));
        entity.ifPresent(productRepository::saveAndFlush);
    }
}
