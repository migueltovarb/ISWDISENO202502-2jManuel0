# Vehicle CRUD API

Spring Boot application that exposes REST endpoints to manage vehicles stored in MongoDB.

## Stack

- Java 17
- Spring Boot 3.2 (Web + Data MongoDB)
- MongoDB (configurable via `application.properties`)

## Running

1. Start a MongoDB instance locally on the default port.
2. Configure `MONGODB_URI` (points to your MongoDB Atlas cluster) or leave unset to connect to localhost.
3. Build and run the app with Maven:

```bash
mvn spring-boot:run
```

4. Use `curl`/Postman to hit:
   - `POST /api/vehicles` with JSON body to create.
   - `GET /api/vehicles` to list.
   - `GET /api/vehicles/{id}`, `PUT /api/vehicles/{id}`, `DELETE /api/vehicles/{id}` for other operations.

## Validation

`Vehicle` requires `make`, `model`, `year`, `color`, and `vin`. Year must be >= 1886.
