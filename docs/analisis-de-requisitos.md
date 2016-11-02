# Análisis de requisitos

**Etapa de análisis**

Un cliente se ha puesto en contacto con nosotros para que desarrollemos una aplicación para gestionar sus ventas online.
Después de varias entrevistas nos ha trasladado todo lo que necesita.

* Desea un interface dual que funcione en modo ventana y en modo web.

* Le gustaría poder gestionar sus productos, proveedores y clientes mediante una aplicación de ventanas.

* También le gustaría que sus clientes se pudiesen hacer **login** en una página web y ver los productos que se ofertan. Además el cliente podrá comprar esos productos si lo desea de forma online.

* **Base de datos**

* **Interfaz gráfica GUI**

    - Clientes (insertar, borrar, actualizar, buscar, listar)

        * Modelo del cliente
        * Vista: GUI para la gestión de cliente
        * Controlador de los clientes

    - Productos (insertar, borrar, actualizar, buscar, listar)

        * Modelo del productos
        * Vista: GUI para la gestión de productos
        * Controlador de los clientes

    - Proveedores (insertar, borrar, actualizar, buscar, listar)

        * Modelo del proveedor
        * Vista: GUI para la gestión de proveedores
        * Controlador de los proveedores


* **Interfaz web** (HTML, CSS, Javascript, jQuery, JSP, Servlet...)

      - Zona login (login, logout)
      - Portada
      - Zona de productos (buscar, listar, añadir al carrito)
      - Carrito (listar, borrar, modificar cantidad a comprar, comprar)
      - Comprar lo guardado en el carrito

* **Sistema noticias** (Ruby + Ruby on Rails)

* **Etapa de diseño**

Diagrama ER

El proyecto se desarrollará en 2 fases, usando el modelo de ciclo de vida del software iterativo incremental.

____

![Alt DiagramaER](/references/DiagramaER.png)

____

# Fase 1
## Desarrollo de la parte backend

* [ ] Crear la estructura de la **base de datos** en función del diagrama entidad relación especificado anteriormente.

* [ ] También se necesita crear un usuario llamado **store** con password **Ad1234** y permisos adecuados sobre el esquema creado en el punto anterior.

* [ ] Crear 3 modelos

* [x] Un modelo para el cliente que llamaremos **Client** cuyos campos serán `id`, `name`, `surname`, `telephone`,`email`, `address`, `password`.

* [x] Un modelo para el proveedor llamado **Provider** cuyos campos serán:
`id`, `name`, `email`, `address`

* [ ] Un modelo para el producto llamado **Product** cuyos campos serán:
`id`, `name`, `ref`, `Price`, `idProvider`

* [ ] Crear las interfaces gráficas para cada uno de los módulos. (clientes, proveedores, productos).


# Controlador

**Se necesita crear el controlador de acceso a datos (para clientes, proveedores y productos)**

Este controlador consistirá en una clase con los siguientes métodos:

## `findClientsDB`

Se encargará de buscar clientes en la base de datos.

Devolverá un ArrayListclientes

Admitirá como parámetro el texto a buscar.

Lanzará una SQLException en caso de algún problema

## `selectSingleDB`

Se encarga de buscar un cliente dado su ID

Devolverá un objeto de tipo cliente

  * `id` (Integer) - Cliente a buscar

Lanzará una SQLException en caso de algún problema

## `selectAllDB`

Se encarga de obtener todos los clientes de la base de datos

Devolverá un array de (por ejemplo) clientes

No necesita parámetros

Lanzará una SQLException en caso de algún problema

## `deleteDB`

Se encarga de borrar un cliente dado su ID

Devolverá un booleano (true si ha borrado correctamente)

Admitirá como parámetro:

  * `id` (Integer) - Cliente a borrar

Lanzará una SQLException en caso de algún problema

## `updateDB`

Se encarga de actualizar los datos de un cliente dado

Devolverá un booleano (true si ha actualizado correctamente)

Admitirá como parámetro:

  * `id` (Integer) - Cliente a actualizar

Un objeto de tipo cliente con los datos nuevos

Lanzará una SQLException en caso de algún problema

## `addDB`

Se encarga de añadir un cliente a la base de datos

Devolverá un entero con el id del cliente insertado

Admitirá como parámetro un objeto de tipo cliente con los datos a insertar

Lanzará una SQLException en caso de algún problema


## `getConnectionDB`

Se encarga de devolver una conexión con la base de datos

Devolverá un objeto de tipo connection


## `closeConnectionDB`

Se encarga de cerrar una conexión de la base de datos        

Admitirá como parámetro:

  * `con` Object (Connection)

____


# Fase 2
## Desarrollo de la parte frontend
