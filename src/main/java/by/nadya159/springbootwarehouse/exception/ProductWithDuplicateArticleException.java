package by.nadya159.springbootwarehouse.exception;

import by.nadya159.springbootwarehouse.entity.Product;

/**
 * Exception, которое выбрасывается, когда объект {@link Product},
 * с указанным артикле уже существует в БД
 */
public class ProductWithDuplicateArticleException extends RuntimeException {
    /**
     * Конструктор для создания объекта исключения
     *
     * @param message сообщение об ошибке
     */
    public ProductWithDuplicateArticleException(String message) {
        super(message);
    }
}
