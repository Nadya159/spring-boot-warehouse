package by.nadya159.springbootwarehouse.service;

import by.nadya159.springbootwarehouse.dto.ProductDto;
import by.nadya159.springbootwarehouse.dto.ProductResponseDto;
import by.nadya159.springbootwarehouse.entity.Product;
import by.nadya159.springbootwarehouse.mapper.ProductMapper;
import by.nadya159.springbootwarehouse.repository.ProductRepository;
import by.nadya159.springbootwarehouse.service.impl.ProductServiceImpl;
import by.nadya159.springbootwarehouse.util.DataUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Unit tests for Service layer {@link ProductServiceImpl}
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    @DisplayName("Test create Product in Service layer")
    void createTest() {
        Product productToCreate = DataUtils.getProductTest1Transient();
        ProductDto productDto = DataUtils.getProductDtoTest1();
        when(productMapper.toProductDto(any())).thenReturn(productDto);
        when(productRepository.save(any(Product.class))).thenReturn(productToCreate);
        when(productRepository.findById(productToCreate.getId())).thenReturn(Optional.of(productToCreate));
        when(productRepository.save(any(Product.class))).thenReturn(productToCreate);

        ProductResponseDto productReadDto = productService.create(productDto);
        Assertions.assertNotNull(productReadDto);
    }
}
