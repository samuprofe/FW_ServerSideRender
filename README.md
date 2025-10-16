# FW_ServerSideRender

## 📝 Descripción del Proyecto

Este proyecto es una implementación de ejemplo de un **Renderizado en el Lado del Servidor (Server-Side Rendering - SSR)**. A diferencia del Client-Side Rendering, el servidor genera la página HTML completa antes de enviarla al navegador.

La aplicación demuestra las operaciones **CRUD (Create, Read, Update, Delete)** sobre la entidad `Mensaje`, utilizando la lógica de negocio y la generación de vistas enteramente en el servidor.

***

## 🛠️ Tecnologías Utilizadas

Este proyecto se centra en la parte del servidor para la generación de contenido dinámico:

| Tecnología | Rol | Porcentaje en el Código | Notas Clave |
| :--- | :--- | :--- | :--- |
| **Java** | Lógica principal de servidor, controladores, acceso a datos y generación de vistas. | 54.7% | **Alto peso en la lógica del servidor (Backend).** |
| **HTML** | Plantillas de vista que son renderizadas por el servidor. | 45.3% | Se utiliza como lenguaje de plantilla (ej. Thymeleaf, JSP) para SSR. |
| **Apache Maven** | Gestión de dependencias y ciclo de vida de la construcción. | (Configuración) | Herramienta estándar para proyectos Java. |
| **CSS / JavaScript** | (Asumido) Estilado y pequeñas interacciones del lado del cliente. | (No visible en la estructura principal) | Uso mínimo en comparación con CSR. |

***

## 🚀 Instalación y Ejecución

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local.

### Prerrequisitos

Asegúrate de tener instalado lo siguiente:

* **Java Development Kit (JDK)** (Versión 8 o superior).
* **Git** (Para clonar el repositorio).
* Un IDE con soporte para Maven (e.g., IntelliJ IDEA).

### Pasos de Instalación

1.  **Clona el repositorio desde IntelliJ:** Utiliza la opción de clonar el proyecto desde la URL de GitHub dentro de IntelliJ.

2.  **Ejecuta la aplicación desde IntelliJ:**
    * Una vez que el proyecto se haya indexado y resuelto las dependencias de Maven, busca la clase principal (típicamente la que contiene el método `main` y la anotación `@SpringBootApplication` si usa Spring Boot) y ejecútala.

3.  **Accede a la aplicación:**
    Una vez que el servidor inicie, la aplicación web (la vista generada por el servidor) estará disponible en la URL:
    `http://localhost:8080/mensajes`

    > **Nota:** En un proyecto de Server-Side Rendering (SSR), el archivo `.html` no se debe abrir directamente en el navegador desde el explorador de archivos; la aplicación debe ser accedida a través de la URL del servidor web (`http://localhost:8080/mensajes`).

***

## 💡 Uso y Estructura

La estructura del proyecto es típica de una aplicación basada en Java y Maven con arquitectura de Renderizado del Lado del Servidor (SSR/MVC):

* **`src/main/java/`**: Contiene todo el código fuente de **Java** (controladores, servicios, modelos). Aquí reside la lógica principal que se encarga de recibir peticiones, procesar datos (CRUD) y seleccionar la vista a renderizar.
* **`src/main/resources/`**:
    * Contiene archivos de configuración y propiedades.
    * Aquí se encuentran las **Plantillas de Vista** (ej. archivos `.html` con lógica de plantilla como Thymeleaf), que son procesadas por el servidor para generar el HTML final.
* **`pom.xml`**: Define el proyecto, las dependencias de Maven y los plugins de construcción y ejecución.

## 📄 Licencia

Este proyecto está distribuido bajo la licencia **Creative Commons Atribución-No Comercial 4.0 Internacional (CC BY-NC 4.0)**.

**Esto significa que puedes:**
* Compartir y adaptar el código.

**Pero debes:**
1.  **Dar atribución** al autor original.
2.  **No usar** el material con fines **comerciales**.
***

## 👤 Autor

* **[Samuel Garcia](https://github.com/samuprofe)** - *Trabajo Inicial*