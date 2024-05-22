### Инструкция по запуску приложения (локально)

1. Клонируйте репозиторий проекта на локальную машину
    ````
    git clone https://github.com/Nadya159/spring-boot-warehouse.git
    ````
2. В файле ````application-local.yml```` укажите информацию о подключении к PostgreSQL:
    * cкрипт создания БД: src/main/resources/schema-postgresql.sql
    * cкрипт создания записей в БД: src/main/resources/data-postgresql.sql
  
4. Перейдите в корневую директорию в терминале
5. Выполните команду
    ````
    gradle build
    ````
6. После запуска приложение будет доступно по адресу http://localhost:8080

#### Путь к Swagger - http://localhost:8080/swagger-ui/index.html
