# production-fiap-food

API responsible for receiving orders after payment,
monitoring production and updating order status

## Prerequisites:
- Apache Maven 3.+
- JDK 21
- Docker 20+
- Docker Compose 1.22.+

## Start application in Docker container in Docker:
```
    docker-compose up -d
```

## Stop all applications in Docker containers:
```
    docker-compose stop
```

## Start application in Docker container in Docker and rebuild service image:
```
    docker-compose up --build --force-recreate --no-deps -d 
```

## Swagger documentation:
```
    http://localhost:8080/swagger-ui.html
```

![swagger.png](images%2Fswagger.png)

## Arquitetura