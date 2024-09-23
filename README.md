# Link de acceso para la aplicación 

https://lexart-app-production.up.railway.app/

*	Usuario: felipe
*	Contraseña: 1234

# Product Management System

Este es un sistema de gestión de productos desarrollado con **React**, **Redux**, **TypeScript**, y **Spring Boot**. El sistema permite listar y crear productos, gestionando los detalles de cada uno, como el precio y color, con integración de autenticación JWT para proteger las rutas.

# Product Management System

Este es un sistema de gestión de productos desarrollado con **React**, **Redux**, **TypeScript**, y **Spring Boot**. El sistema permite listar y crear productos, gestionando los detalles de cada uno, como el precio y color, con integración de autenticación **JWT** para proteger las rutas.

## Características

- **Autenticación**: Integración de autenticación mediante **JWT** en el backend de **Spring Boot** y gestionada en el frontend con **Redux**.
- **Productos**: El usuario puede listar productos y añadir nuevos productos mediante un formulario que incluye múltiples detalles, como el precio y el color de cada variante del producto.
- **Interfaz de usuario**: Utiliza **Bootstrap** para mejorar la UI y proporcionar una experiencia de usuario fluida.
- **Validación de formularios**: Los formularios de creación de productos están validados usando **Formik** y **Yup**.
- **Alertas y navegación**: Tras la creación exitosa de un producto, se muestra una alerta con un mensaje y luego se redirige al usuario a la lista de productos.
- **Persistencia**: La información de los productos se almacena en una base de datos a través del backend de **Spring Boot**.

## Requisitos

- **Node.js** (>= 14.x)
- **npm** o **yarn**
- **Java 11** o superior
- **Spring Boot** (>= 2.5.x)
- **Base de datos** compatible con JPA (ej. MySQL, PostgreSQL)

## Instalación

### Backend (Spring Boot)

1. Clonar el repositorio del backend.
2. Configura el archivo `application.properties` con los detalles de tu base de datos y tu configuración JWT.
3. Ejecuta el backend con el siguiente comando:

./mvnw spring-boot:run

El backend estará disponible en `http://localhost:8080`.

### Frontend (React + Redux + TypeScript)

1.  Clonar el repositorio del frontend.
2.  Instalar las dependencias:

bash

Copiar código

`npm install` 

3.  Ejecutar la aplicación:

bash

Copiar código

`npm run dev` 

El frontend estará disponible en `http://localhost:5173`.

## Uso

### Crear un Producto

1.  Inicia sesión en el sistema.
2.  Navega a la sección de **Crear Producto** desde el menú.
3.  Completa el formulario con el nombre del producto, marca, y detalles como el precio y color.
4.  Haz clic en **Crear Producto**. Si la creación es exitosa, se mostrará una alerta de confirmación y serás redirigido a la lista de productos.

### Listar Productos

-   Navega a la sección **Productos** en el menú para ver todos los productos registrados en el sistema. Los productos se mostrarán en tarjetas uniformes con sus detalles.



## Licencia

Este proyecto está licenciado bajo la MIT License. Para más información, ver el archivo LICENSE.

javascript

 ``Este `README.md` incluye una descripción del proyecto, características, instrucciones de instala``
