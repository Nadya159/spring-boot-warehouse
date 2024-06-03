package by.nadya159.springbootwarehouse.service;

import by.nadya159.springbootwarehouse.dto.ProductCreateDto;
import by.nadya159.springbootwarehouse.dto.ProductReadDto;
import by.nadya159.springbootwarehouse.entity.Product;
import by.nadya159.springbootwarehouse.mapper.ProductMapper;
import by.nadya159.springbootwarehouse.repository.ProductRepository;
import by.nadya159.springbootwarehouse.util.DataUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Unit tests for Service layer {@link ProductServiceImpl}
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    @DisplayName("Test create Product in Service layer")
    void createTest() {
        //given
        Product productToSave = DataUtils.getProductTest1Transient();
        ProductCreateDto productDtoToSave = productMapper.toProductCreateDto(productToSave);
        BDDMockito.given(productRepository.findByArticle(anyString()))
                .willReturn(null);
        BDDMockito.given(productRepository.save(any(Product.class)))
                .willReturn(DataUtils.getProductTest1Persisted());

        /*var productDtoToSave = DataUtils.getProductCreateEditDtoTest1();
        BDDMockito.given(productMapper.toProduct(any(ProductCreateEditDto.class)))
                .willReturn(productToSave);
        BDDMockito.given(productMapper.toProductDto(any(Product.class)))
                .willReturn(DataUtils.getProductReadDtoTest1());*/

        //when
        ProductReadDto savedProduct = productService.create(productDtoToSave);
        //then
        assertThat(savedProduct).isNotNull();
        //assertEquals(productDtoToSave.name(), savedProduct.name());
    }
}
