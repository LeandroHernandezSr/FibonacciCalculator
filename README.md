# 🔢 Fibonacci Calculator - Arquitectura Hexagonal y DDD

Este proyecto implementa un servicio RESTful para cálculos de la secuencia de Fibonacci, destacando por su **diseño basado en la Arquitectura Hexagonal (Ports and Adapters)** y la aplicación de los principios de **Domain-Driven Design (DDD)**. Esto garantiza una separación clara de responsabilidades, alta mantenibilidad y un dominio del negocio expresivo e independiente de la infraestructura.

## 🌟 Características Principales

* **Arquitectura Hexagonal (Ports and Adapters):** Separación estricta entre el **Dominio (Core)**, la **Aplicación** y la **Infraestructura**. Esto facilita el cambio de bases de datos, frameworks web u otros componentes externos sin afectar la lógica de negocio central. 

* **Domain-Driven Design (DDD):** El modelo de negocio (el cálculo de Fibonacci y el registro de consultas) está en el centro, asegurando que la lógica sea clara, testeable y orientada a los requisitos del negocio.
* **Contenedorización con Docker Compose:** Se utiliza Docker para gestionar la base de datos de forma sencilla y reproducible.
* **Documentación Interactiva con Swagger/OpenAPI:** Acceso a una interfaz de usuario para explorar y probar los endpoints del servicio.

---

## 🛠️ Requisitos del Sistema

Para ejecutar el proyecto, necesitarás tener instalados los siguientes componentes:

* **Java Development Kit (JDK) 21**
* **Docker** (para la base de datos)

---

## 🌐 Endpoints del Servicio

El servicio está disponible en el puerto `8080` de forma local (`http://localhost:8080`).
El servicio está disponible en el puerto `8080` en AWS (`http://54.94.97.140:8080`).

| Endpoint | Método | Parámetro | Descripción |
| :--- | :--- | :--- | :--- |
| `/fibonacci/get-nth-number` | `POST` | **number** (obligatorio) | Retorna el **$n$-ésimo número** de la secuencia de Fibonacci.|
| `/fibonacci/occurrences` | `GET` | *Ninguno* | Retorna una lista ordenada de mayor a menor contando las **ocurrencias** de cada número de Fibonacci consultado previamente. |

📖 Interfaz de Usuario de Swagger (OpenAPI)
Accede a la documentación interactiva para explorar y probar todos los endpoints:

Local: http://localhost:8080/swagger-ui/index.html

Cloud: http://54.94.97.140:8080/swagger-ui/index.html

### 📖 Interfaz de Usuario de Swagger (OpenAPI)

Accede a la documentación interactiva para explorar y probar todos los endpoints:

* **URL:** `http://localhost:8080/swagger-ui.html`


## 🚀 Cómo Ejecutar el Proyecto

Tienes dos opciones para poner en marcha el servicio:

### Opción 1: Usando el Script `run.sh` (Recomendado)

El script `run.sh` automatiza todos los pasos necesarios:
1. Inicia el contenedor de la base de datos con Docker Compose.
2. Construye el proyecto utilizando Maven Wrapper.
3. Ejecuta el archivo JAR resultante.

```bash
./run.sh
