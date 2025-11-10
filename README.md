# 🧩 Evaluación Java – API de Registro de Usuarios

API REST desarrollada con **Spring Boot 3.5.7**, **Java 17** y **H2 Database**, que permite registrar usuarios con sus teléfonos, validar correos únicos y generar un **token JWT** al momento del registro.

---

## 🚀 Tecnologías utilizadas

- Java 17  
- Spring Boot 3.5.7  
- Spring Data JPA  
- H2 Database (en memoria)  
- ModelMapper  
- Spring Validation  
- SpringDoc OpenAPI (Swagger UI)  
- JSON Web Tokens (JJWT 0.11.5)  
- JUnit 5 / Mockito / JaCoCo  

---

## ⚙️ Configuración inicial

### 1️⃣ Clonar el repositorio
```bash
git clone https://github.com/usuario/evaluacion-java.git
cd evaluacion-java
```

### 2️⃣ Compilar y ejecutar
```bash
./gradlew bootRun
```
La aplicación se ejecutará en:
```
http://localhost:8080
```

---

## 🧩 Endpoints principales

### 🔹 Crear usuario
**POST** `/api/users`

#### Request Body
```json
{
  "name": "Luis Gonzales",
  "email": "luis@example.com",
  "password": "Luis27042025#",
  "phones": [
    {
      "number": "987654321",
      "citycode": "1",
      "countrycode": "51"
    }
  ]
}
```

#### Response 201 – Created
```json
{
  "id": "b19b6921-b1c0-4ef0-9d88-2b178d836f41",
  "name": "Luis Gonzales",
  "email": "luis@example.com",
  "created": "2025-11-09T23:55:42",
  "modified": "2025-11-09T23:55:42",
  "lastLogin": "2025-11-09T23:55:42",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsdWlzQGV4YW1wbGUuY29tIiwiaWF0IjoxNzMxMTk4OTQyLCJleHAiOjE3MzEyMDI1NDJ9.4XqCVP6QFzJYmlT5vGLtIYk0Q8ydUJ0EefxPQCU62Lg",
  "isActive": true,
  "phones": [
    {
      "number": "987654321",
      "citycode": "1",
      "countrycode": "51"
    }
  ]
}
```

---

## 🔐 Token JWT

Cada usuario recibe un **token JWT firmado** al momento del registro.

| Propiedad | Valor |
|------------|--------|
| **Algoritmo** | HS256 |
| **Expiración** | 1 hora |
| **Clave secreta** | `mySuperSecretKeyForJwtExample123456` |
| **Campo** | `token` |

Verifica el token en [jwt.io](https://jwt.io)

---

## 🧪 Pruebas unitarias

```bash
./gradlew test
```
Ver el reporte de cobertura en:
```
build/reports/jacoco/test/html/index.html
```

---

## 🧭 Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

---

## 📬 Pruebas con Postman

**POST:** `http://localhost:8080/api/users`

**Body → raw → JSON**
```json
{
  "name": "Luis Gonzales",
  "email": "luisgonzacc@yahoo.com",
  "password": "Luis27042025#",
  "phones": [
    { "number": "991238618", "citycode": "1", "countrycode": "57" }
  ]
}
```


![img.png](img.png)
---

## 👨‍💻 Autor

**Luis Miguel Gonzales Ccallohuanca**  
Backend Java Developer  
📧 luisgonzacc@yahoo.com
🏷️ Proyecto de evaluación técnica – Reto Java Spring Boot 2025
