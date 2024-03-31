package by.nadya159.springbootwarehouse.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Класс, представляющий собой глобальный обработчик исключений
 */
@Slf4j
@RestControllerAdvice(basePackages = "by.nadya159.springbootwarehouse.controller")
public class RestControllerException extends ResponseEntityExceptionHandler {

    /**
     * Обработчик исключения NotFoundElementException
     *
     * @param exception исключение NotFoundElementException
     * @return  ResponseEntity, содержащий текст ошибки и статус NOT_FOUND
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundElementException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(NotFoundElementException exception) {
        log.error("Failed (NOT_FOUND)", exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Validation error: " + exception.getMessage());
    }

    /**
     * Обработчик общих исключений
     *
     * @param exception исключение, которое было получено
     * @return ResponseEntity, содержащий текст ошибки и статус INTERNAL_SERVER_ERROR
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOthersExceptions(Exception exception) {
        log.error("Failed (INTERNAL_SERVER_ERROR)", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server error: " +
                exception.getMessage());
    }
}
