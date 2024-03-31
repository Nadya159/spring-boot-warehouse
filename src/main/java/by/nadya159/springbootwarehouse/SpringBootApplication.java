package by.nadya159.springbootwarehouse;

import org.springframework.boot.SpringApplication;
/**
 * Основной класс приложения
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    /**
     * Основной метод для запуска приложения
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
