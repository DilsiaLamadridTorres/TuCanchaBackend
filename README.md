# TuCancha

API REST para la gestión de complejos deportivos, canchas, reservas y usuarios del proyecto TuCancha.

## Objetivo

Administrar la logística del negocio de alquiler de canchas deportivas: usuarios, roles, complejos, horarios, reservas, pagos y solicitudes de nuevas canchas.

## Stack

- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven

## Requisitos

- JDK 21
- PostgreSQL en localhost:5432
- Maven o wrapper incluido (`./mvnw`)

## Configuración

Ajusta la conexión a la base de datos en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tucancha
spring.datasource.username=postgres
spring.datasource.password=
```

## Ejecución

```bash
./mvnw spring-boot:run
```

La API queda disponible en:

```text
http://localhost:8080
```

## Módulos principales

- Usuarios y roles
- Complejos y canchas
- Horarios y reservas
- Pagos y estados
- Solicitudes y titularidad de complejos

## Integrantes grupo 8
- Dilsia Lamadrid
- Paula Rodriguez
- Miguel Ospina
- Jonathan Paul
- Sebastian Rincon