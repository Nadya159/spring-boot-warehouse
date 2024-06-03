package by.nadya159.springbootwarehouse.controller;

import by.nadya159.springbootwarehouse.dto.ErrorResponseDto;
import by.nadya159.springbootwarehouse.dto.ProductCreateDto;
import by.nadya159.springbootwarehouse.dto.ProductEditDto;
import by.nadya159.springbootwarehouse.dto.ProductReadDto;
import by.nadya159.springbootwarehouse.exception.NotFoundElementException;
import by.nadya159.springbootwarehouse.exception.ProductWithDuplicateArticleException;
import by.nadya159.springbootwarehouse.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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

    private final ProductServiceImpl productService;

    /**
     * Endpoint получения всех товаров
     *
     * @return ResponseEntity, содержащий список товаров {@link ProductReadDto}
     */
    @GetMapping("/all")
    public ResponseEntity<List<ProductReadDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    /**
     * Endpoint для получения товара по идентификатору (UUID)
     *
     * @param id идентификатор (UUID) товара
     * @return ResponseEntity, содержащий {@link ProductReadDto}, т.е. найденный товар
     * @throws NotFoundElementException исключение, если товар с заданным ID (UUID) не найден
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok(productService.findById(id));
        } catch (NotFoundElementException e) {
            return ResponseEntity
                    .status(404)
                    .body(ErrorResponseDto.builder()
                            .status(404)
                            .message(e.getMessage())
                            .build())
                    ;
        }
    }

    /**
     * Endpoint для создания нового товара
     *
     * @param product {@link ProductCreateDto} объект с данными для создания товара
     * @return ResponseEntity, содержащий {@link ProductReadDto}, т.е. сохраненный товар
     * @throws ProductWithDuplicateArticleException исключение, если товар с таким же артиклем уже есть в БД
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody
                                    @Validated
                                    ProductCreateDto product) {
        try {
            return ResponseEntity.ok(productService.create(product));
        } catch (ProductWithDuplicateArticleException e) {
            return ResponseEntity.badRequest()
                    .body(ErrorResponseDto.builder()
                            .status(400)
                            .message(e.getMessage())
                            .build())
                    ;
        }
    }

    /**
     * Endpoint для частичного обновления товара
     *
     * @param id      идентификатор обновляемого продукта
     * @param product {@link ProductCreateDto} объект с данными для обновления товара
     * @return ResponseEntity, содержащий {@link ProductReadDto}, т.е. обновленный товар
     * @throws NotFoundElementException исключение, если товар с заданным ID (UUID) не найден
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id,
                                    @RequestBody
                                    @Validated
                                    ProductEditDto product) {
        try {
            return ResponseEntity.ok(productService.update(id, product));
        } catch (NotFoundElementException | ProductWithDuplicateArticleException e) {
            return ResponseEntity.badRequest()
                    .body(ErrorResponseDto.builder()
                            .status(400)
                            .message(e.getMessage())
                            .build());
        }
    }

    /**
     * Endpoint для удаления товара по идентификатору (UUID)
     *
     * @param id идентификатор (UUID) товара для удаления
     * @return ResponseEntity, содержащий HttpStatus удаления товара
     * @throws NotFoundElementException исключение, если товар с заданным ID (UUID) не найден
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") UUID id) {
        try {
            productService.delete(id);
            return ResponseEntity.ok().build();
        } catch (NotFoundElementException e) {
            return ResponseEntity.badRequest()
                    .body(ErrorResponseDto.builder()
                            .status(400)
                            .message(e.getMessage())
                            .build());
        }
    }
}
