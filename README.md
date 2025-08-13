# 📚 Challenge ForoHub - Programa ONE

API REST desarrollada en Java con Spring Boot que simula la lógica de un foro, permitiendo gestionar temas de
discusión mediante operaciones CRUD.

Este proyecto forma parte del Challenge del programa **ONE (Oracle Next Education)** de Alura Latam y Oracle, cuyo
objetivo es construir una solución backend segura y funcional que implemente autenticación, validaciones de negocio y
persistencia de datos siguiendo buenas prácticas REST.

El consumo de la API puede realizarse mediante herramientas como **Insomnia**, **Postman** o a través de la interfaz
generada por **SpringDoc** para pruebas y documentación.

El proyecto simula la API de un foro web donde usuarios pueden iniciar sesión, crear, editar, eliminar y cerrar
temas de discusión relacionados a cursos.

---

## 🚀 Funcionalidades principales

A través de herramientas como **Insomnia** o **Swagger (SpringDoc)**, podrás:

1. ✅ Iniciar sesión con credenciales válidas y recibir un token JWT.
2. ✅ Crear nuevos temas.
3. ✅ Consultar un tema por su ID.
4. ✅ Listar todos los temas activos (con paginación).
5. ✅ Actualizar un tema (solo si se encuentra activo).
6. ✅ Cerrar un tema marcándolo como resuelto (eliminación lógica).
7. ✅ Eliminar un tema de forma definitiva (eliminación física).

---

## 🛠️ Tecnologías utilizadas

1. ☑️ Java 17
2. ☑️ Spring Boot
3. ☑️ Spring Data JPA
4. ☑️ Spring Security
5. ☑️ Flyway
6. ☑️ Lombok
7. ☑️ MySQL
8. ☑️ Maven
9. ☑️ Auth0
10. ☑️ SpringDoc OpenAPI

---

## ⚙️ Requisitos de configuración

Para ejecutar el proyecto necesitas:

1. 🙌 Tener Java 17 instalado.
2. 🙌 Tener MySQL en ejecución.
3. 🙌 Definir las siguientes variables de entorno (o configurarlas directamente en tu `application.properties`):

```properties
spring.datasource.username=${MY_SQL_USER}
spring.datasource.password=${MY_SQL_PASSWORD}
api.security.token.secret=${JWT_SECRET}
```

_Estas variables son utilizadas para establecer la conexión con la base de datos y firmar los tokens JWT._

---

## 📓 Documentación interactiva (Swagger UI)

Una vez corras la aplicación, puedes acceder a la documentación de los endpoints en:

📎 [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

_Allí puedes probar los endpoints directamente desde el navegador._
