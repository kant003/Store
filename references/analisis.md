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

* [ ] Crear la estructura de la base de datos en función del diagrama entidad relación especificado.

* [ ] También se necesita crear un usuario llamado store con password Ad1234 y permisos adecuados sobre el esquema creado en el punto anterior.

* [ ] Crear 3 modelos

* [ ] Un modelo para el cliente que llamaremos client cuyos campos serán id, name, surname, telephone, email, address, password.

* [ ] Un modelo para el proveedor llamado provider cuyos campos serán:
`id`, `name`, `email`, `address`

* [ ] Un modelo para el producto llamado product cuyos campos serán:
`id`, `name`, `ref`, `Price`, `idProvider`

* [ ] Crear las interfaces gráficas para cada uno de los módulos. (clientes, proveedores, productos).

**Ejemplo para el cliente desktop**

Necesitaremos una interfaz gráfica (GUI) que permita listar y gestionar (añadir, borrar o modificar o CRUD) los clientes de la empresa. Esta interfaz se podrá diseñar con un *CardLayout* (con 2 *jPanel* en su interior).

El aspecto sería este. Veamos la primera parte de la interface:

![Alt DiagramaER](/references/img/gui-mockup-00.png)

Desde ella, se podrán ver todos los clientes guardados, se podrán borrar, editar y añadir nuevos clientes, así como refrescar los datos y realizar filtrados.

El interface estará compuesta por un *JFrame* principal en cuyo interior habrá un *jTable* (de nombre tableClientes) en el centro y 4 botones en la parte inferior.(**buttonDelete**, **buttonUpdate**, **buttonAdd** y **buttonRefresh**).

En la parte superior un label con el titulo de la ventana y una zona para que se pueden filtrar los datos a modo de búsqueda txtFilter.

Necesitaremos crear otro *jPanel* con un formulario para poder editar y añadir nuevos clientes.
En este caso será un *jDialog* que contendrá en su interior *jLabels* y *jTextBox* (**txtName**, **txtSurnames**, **txtTelephone**, **txtEmail**, **txtAddress**).

Y 2 botones para guardar/actualizar y cancelar.

![Alt DiagramaER](/references/img/gui-mockup-01.png)

Lo mismo para los proveedores y con los productos.

**Se necesita crear el controlador de acceso a datos (para clientes, proveedores y productos)**

Este controlador consistirá en una clase con los siguientes métodos:

**findClientsDB**, y se encargará de buscar clientes en la base de datos.

Devolverá un array de (por ejemplo) clientes

Admitirá como parámetro el texto a buscar.

Lanzará una SQLException en caso de algún problema

**selectSingleDB**

Se encarga de buscar un cliente dado su ID

Devolverá un objeto de tipo cliente

  * `id` (Integer) - Cliente a buscar

Lanzará una SQLException en caso de algún problema

**selectAllDB**

Se encarga de obtener todos los clientes de la base de datos

Devolverá un array de (por ejemplo) clientes

No necesita parámetros

Lanzará una SQLException en caso de algún problema

**deleteDB**

Se encarga de borrar un cliente dado su ID

Devolverá un booleano (true si ha borrado correctamente)

Admitirá como parámetro:

  * `id` (Integer) - Cliente a borrar

Lanzará una SQLException en caso de algún problema

**updateDB**

Se encarga de actualizar los datos de un cliente dado

Devolverá un booleano (true si ha actualizado correctamente)

Admitirá como parámetro:

  * `id` (Integer) - Cliente a actualizar

Un objeto de tipo cliente con los datos nuevos

Lanzará una SQLException en caso de algún problema

**addDB**

Se encarga de añadir un cliente a la base de datos

Devolverá un entero con el id del cliente insertado

Admitirá como parámetro un objeto de tipo cliente con los datos a insertar

Lanzará una SQLException en caso de algún problema


**getConnectionDB**

Se encarga de devolver una conexión con la base de datos

Devolverá un objeto de tipo connection


**closeConnectionDB**

Se encarga de cerrar una conexión de la base de datos        

Admitirá como parámetro un objeto de tipo connection

Fase 2:  Desarrollo de la parte web

____


# Fase 2
## Desarrollo de la parte frontend
