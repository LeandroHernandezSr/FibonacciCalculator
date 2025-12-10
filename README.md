# FibonacciCalculator

Este proyecto implementa la arquitectura hexagonal (puertos y adaptadores) para lograr una separación clara entre el dominio, la aplicación y la infraestructura. La lógica principal del sistema se construye siguiendo principios de Domain-Driven Design (DDD), lo que permite un modelo de dominio expresivo, mantenible y orientado al negocio.

Además, el proyecto incorpora Swagger/OpenAPI para documentar de forma interactiva los dos endpoints disponibles, facilitando la exploración y prueba del servicio.

¿Como ejecutar proyecto?

Primeramente necesitas tener varios requisitos:

-JDK 21
-Docker

Luego de esto, es necesario correr el archivo "docker-compose.yml" para crear el contenedor de la base de datos. El proyecto puedes ejecutarlo desde el IDE o utilizando maven wrapper como ./mvnw package, luego de esto ejecutas el archivo .jar.

De igual manera si se quiere evitar esto, puede ejecutar el script "run.sh" para ejecutar los pasos anteriores en uno solo.

Endpoints disponibles:

/fibonacci/get-nth-number: Retorna el n-e simo número de fibonacci.

/fibonacci/occurrences: Retorna lista ordenada de mayor a menor contando las ocurrencias de cada número consultado. 

