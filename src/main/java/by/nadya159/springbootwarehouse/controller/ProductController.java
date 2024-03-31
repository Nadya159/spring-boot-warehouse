package by.nadya159.springbootwarehouse.controller;

import by.nadya159.springbootwarehouse.model.dto.ProductCreateEditDto;
import by.nadya159.springbootwarehouse.model.dto.ProductReadDto;
import by.nadya159.springbootwarehouse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Класс, представляющий собой REST-API контролллер для товаров
 * Методы данного класса представляют собой эндпоинты,
 * к которым может обратиться пользователь API
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    /**
     * Endpoint получения всех товаров
     *
     * @return ResponseEntity, содержащий список товаров {@link ProductReadDto}
     */
    @GetMapping("/all")
    public ResponseEntity<List<ProductReadDto>> getAll() {  //todo добавить пагинацию
        return ResponseEntity.ok(productService.findAll());
    }

    /**
     * Endpoint для получения товара по идентификатору (UUID)
     *
     * @param id идентификатор (UUID) товара
     * @return ResponseEntity, содержащий {@link ProductReadDto}, т.е. найденный товар
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductReadDto> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    /**
     * Endpoint для создания нового товара
     *
     * @param product {@link ProductCreateEditDto} объект с данными для создания товара
     * @return ResponseEntity, содержащий {@link ProductReadDto}, т.е. сохраненный товар
     */
    @PostMapping
    public ResponseEntity<ProductReadDto> create(@RequestBody
                                                 @Validated
                                                 ProductCreateEditDto product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    /**
     * Endpoint для обновления товара
     *
     * @param id идентификатор обновляемого продукта
     * @param product {@link ProductCreateEditDto} объект с данными для обновления товара
     * @return ResponseEntity, содержащий {@link ProductReadDto}, т.е. обновленный товар
     */
    @PatchMapping("/{id}")
    public ResponseEntity<ProductReadDto> update(@PathVariable("id") UUID id,
                                                 @RequestBody
                                                 @Validated
                                                 ProductCreateEditDto product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    /**
     * Endpoint для удаления товара по идентификатору (UUID)
     *
     * @param id идентификатор (UUID) товара для удаления
     * @return ResponseEntity, содержащий HttpStatus удаления товара
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") UUID id) {
        try {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
