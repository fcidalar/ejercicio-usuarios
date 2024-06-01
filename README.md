# API de Creación de Usuarios

Esta es una API RESTful para la creación de usuarios, desarrollada utilizando Spring Boot. La API acepta y retorna datos en formato JSON.

## Requisitos

- JDK 17 o superior
- Maven
- Git

## Instalación y Ejecución

1. **Clona el repositorio:**

    ```bash
    git clone https://github.com/fcidalar/ejercicio-usuarios.git
    cd ejercicio-usuarios
    ```

2. **Compila y ejecuta el proyecto utilizando Maven:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Base de Datos

La aplicación utiliza una base de datos en memoria H2. Puedes acceder a la consola H2 para ver los datos almacenados.

- **URL de la consola H2:** [http://localhost:8080/h2-console/](http://localhost:8080/h2-console/)
- **Usuario:** admin
- **Contraseña:** 123456

## Documentación de la API

Puedes acceder a la documentación interactiva de la API generada con Swagger.

- **Ruta Swagger:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Probando la API con Postman

Para facilitar las pruebas de la API, se ha incluido un archivo de colección de Postman llamado `Ejercicio Usuarios.postman_collection.json`, ubicado en la carpeta `Documentos` del repositorio. Sigue los siguientes pasos para cargar la colección en Postman:

1. Abre Postman.
2. Haz click en el botón **Importar** en la esquina superior izquierda.
3. Puedes arrastrar o seleccionar el archivo `Ejercicio Usuarios.postman_collection.json`
   ubicado en la carpeta `Documentos` del repositorio clonado.
5. Haz clic en **Open** para importar la colección.

Una vez importada, podrás ver la colección de solicitudes en tu área de trabajo de Postman. La colección incluye todas las solicitudes necesarias para interactuar con la API.

## Endpoints Disponibles

### Crear Usuario

- **URL:** `/api/usuarios`
- **Método:** `POST`
- **Body:**
    ```json
    {
        "name": "Tony Stark",
        "email": "tony@stark.org",
        "password": "hunter2",
        "phones": [
            {
                "number": "1234567",
                "citycode": "1",
                "contrycode": "57"
            }
        ]
    }
    ```
- **Response:**
    ```json
    {
        "id": "UUID",
        "name": "Tony Stark",
        "email": "tony@stark.org",
        "created": "2023-01-01T00:00:00.000Z",
        "modified": "2023-01-01T00:00:00.000Z",
        "lastLogin": "2023-01-01T00:00:00.000Z",
        "token": "TOKEN",
        "isActive": true
    }
    ```

### Buscar Usuarios por Nombre

- **URL:** `/api/usuarios`
- **Método:** `GET`
- **Query Param:** `nombre`
- **Response:**
    ```json
    [
        {
            "id": "UUID",
            "name": "Juan Rodriguez",
            "email": "juan@rodriguez.org",
            "created": "2023-01-01T00:00:00.000Z",
            "modified": "2023-01-01T00:00:00.000Z",
            "lastLogin": "2023-01-01T00:00:00.000Z",
            "token": "TOKEN",
            "isActive": true
        }
    ]
    ```

## Manejo de Errores

En caso de errores, la API devuelve un JSON con el mensaje de error. Por ejemplo:

```json
{
    "mensaje": "El correo ya registrado"
}