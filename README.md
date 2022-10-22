### Сборка проекта

Для создания образа использовать команду:

    mvn package dockerfile:build

### Запуск контейнера

Для запуска выполнить команду:

    docker run -d -p 8080:8000 misha912/docker-learn:0.0.1-SNAPSHOT

