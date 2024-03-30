# production-fiap-food

API responsável por receber os pedidos após o pagamento,
acompanhar a produção e atualização dos status dos pedidos


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