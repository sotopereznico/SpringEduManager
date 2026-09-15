#  SpringEduManager

**SpringEduManager** es un sistema de gestión académica integral desarrollado en Java con Spring Boot. Esta aplicación web permite la administración eficiente de estudiantes, cursos y evaluaciones, implementando un diseño moderno y buenas prácticas de arquitectura de software orientadas a entornos corporativos.

##  Características Principales

*   **Gestión de Usuarios (CRUD):** Registro, listado y eliminación segura de estudiantes, cursos y evaluaciones.
*   **Seguridad y Roles (RBAC):** Autenticación y autorización mediante **Spring Security**. Interfaz adaptativa dependiendo de los roles (`ADMIN` y `USER`).
*   **Arquitectura Multicapa:** Separación estricta de responsabilidades (Model, Repository, Service, Controller).
*   **Transferencia de Datos Segura:** Implementación del **Patrón DTO** (Data Transfer Object) para la exposición segura de APIs REST y prevención de ciclos de recursividad.
*   **Interoperabilidad:** Consumo de APIs REST internas/externas simulado exitosamente utilizando `RestTemplate`.
*   **Interfaz de Usuario Moderna:** Diseño responsivo basado en **Glassmorphism**, separando de manera estricta el código HTML5 del diseño CSS3 centralizado.
*   **Calidad de Código:** Pruebas unitarias implementadas con **JUnit 5** y **Mockito**, garantizando la estabilidad del software con reportes de cobertura generados mediante **JaCoCo**.

##  Stack Tecnológico

*   **Backend:** Java 17, Spring Boot 3, Spring MVC, Spring Data JPA, Spring Security.
*   **Base de Datos:** H2 Database (In-Memory) para despliegues ágiles.
*   **Frontend:** HTML5, CSS3 (Custom styles sin frameworks pesados), Thymeleaf.
*   **Herramientas & Testing:** Maven, Git, JUnit 5, Mockito, JaCoCo, Eclipse IDE.

##  Instalación y Ejecución

1. Clonar el repositorio:
   ```bash
   git clone [https://github.com/tu-usuario/springedumanager.git](https://github.com/tu-usuario/springedumanager.git)
   
   
##   Navegar al directorio del proyecto:

   cd springedumanager
   
## Acceder a la aplicación en el navegador web:

http://localhost:8080/login

##  Credenciales de Acceso (Demo)

El sistema viene preconfigurado con dos usuarios para probar los diferentes niveles de acceso:

| Rol | Correo / Usuario | Contraseña | Permisos |
| :--- | :--- | :--- | :--- |
| **Administrador** | `admin@clase.cl` | `admin123` | Control total (CRUD completo, inscripción de alumnos, creación de evaluaciones). |
| **Alumno (User)** | `alumno@clase.cl` | `1234` | Acceso de solo lectura al catálogo y listados. |

##  Pruebas y Cobertura (JaCoCo)

Para ejecutar la suite de pruebas unitarias y generar el reporte de cobertura de código, utiliza el siguiente comando en la terminal:

```bash
mvn clean test jacoco:report
El reporte HTML se generará en la ruta: target/site/jacoco/index.html.




## Desarrollado por Nicolás Soto