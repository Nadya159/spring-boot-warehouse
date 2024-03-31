package by.nadya159.springbootwarehouse.exception;

import by.nadya159.springbootwarehouse.model.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception, которое выбрасывается, когда объект {@link Product},
 * с указанным идентификатором не был найден
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundElementException extends RuntimeException {

    /**
     * Конструктор для создания объекта исключения
     *
     * @param message сообщение об ошибке
     */
    public NotFoundElementException(String message) {
        super(message);
    }
}
