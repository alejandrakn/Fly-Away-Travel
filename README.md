# Fly Away Travel API

API REST para la gestión de vuelos, usuarios y reservas con autenticación JWT. Permite registrar usuarios, iniciar sesión, gestionar vuelos, realizar reservas y generar archivos de confirmación.

---

# Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Security
- JWT (Auth0)
- Spring Data JPA
- Hibernate
- Maven
- H2 / MySQL

---

# Autenticación

La API utiliza JWT.

## Flujo
1. Registrar usuario
2. Login
3. Usar token en endpoints protegidos

## Header requerido
Authorization: Bearer <TOKEN>

---

# USERS

## Registrar usuario

POST /users/register

Body (raw JSON):
{
  "name": "Carla",
  "lastName": "Perez",
  "email": "test@gmail.com",
  "password": "Abc12345"
}

---

## Obtener todos los usuarios

GET /users

---

## Obtener usuario por ID

GET /users/{id}

Ejemplo:
GET /users/1

---

# AUTH

## Login

POST /auth/login

Body (raw JSON):
{
  "email": "test@gmail.com",
  "password": "Abc12345"
}

Response:
{
  "token": "JWT_TOKEN"
}

---

# FLIGHTS

## Crear vuelo

POST /flights/create

Body (raw JSON):
{
  "flightNumber": "FL-001",
  "origin": "Lima",
  "destination": "Cusco",
  "price": 150.0,
  "airline": "Latam",
  "departureDate": "2026-05-10"
}

---

## Obtener todos los vuelos

GET /flights

---

## Obtener vuelo por ID

GET /flights/{id}

Ejemplo:
GET /flights/1

---

## Buscar vuelos (PROTEGIDO)

GET /flights/search

Ejemplos:
GET /flights/search?flightNumber=FL
GET /flights/search?airline=Latam
GET /flights/search?startDate=2026-05-01&endDate=2026-05-20

Header:
Authorization: Bearer <TOKEN>

---

# BOOKINGS

## Crear reserva (PROTEGIDO)

POST /flights/book?flightId=1&email=test@gmail.com

Header:
Authorization: Bearer <TOKEN>

---

## Obtener reserva por ID (PROTEGIDO)

GET /flights/book/{id}

Ejemplo:
GET /flights/book/1

Header:
Authorization: Bearer <TOKEN>

---

# CLEANUP

DELETE /cleanup

---

# Funcionalidad adicional

Al crear una reserva se genera automáticamente el archivo:

flight_booking_email_{booking_id}.txt

Contenido:
FLIGHT BOOKING CONFIRMATION
Customer: test@gmail.com
Flight Number: FL-001
Origin: Lima
Destination: Cusco
Departure Date: 2026-05-10
Booking Date: 2026-05-08T10:00:00

---

# Reglas del sistema

- /flights/search y /flights/book requieren JWT
- El resto de endpoints son públicos
- No se permiten reservas de vuelos pasados
- Password mínimo 8 caracteres con letras y números

---

# Ejecución

./mvnw spring-boot:run

---

