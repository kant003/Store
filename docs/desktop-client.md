# Modelo

# Vista

# Controlador

**Se necesita crear el controlador de acceso a datos (para clientes, proveedores y productos)**

Este controlador consistirá en una clase con los siguientes métodos:

## `findClientsDB`

Se encargará de buscar clientes en la base de datos.

Devolverá un array de (por ejemplo) clientes

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


_____

**Ejemplo para la GUI de los clientes**

Necesitaremos una interfaz gráfica (GUI) que permita listar y gestionar (añadir, borrar o modificar o CRUD) los clientes de la empresa. Esta interfaz se podrá diseñar con un *CardLayout* (con 2 *jPanel* en su interior).

El aspecto sería este. Veamos la primera parte de la interface:

![Alt DiagramaER](/docs/img/gui-mockup-00.png)

Desde ella, se podrán ver todos los clientes guardados, se podrán borrar, editar y añadir nuevos clientes, así como refrescar los datos y realizar filtrados.

El interface estará compuesta por un *JFrame* principal en cuyo interior habrá un *jTable* (de nombre tableClientes) en el centro y 4 botones en la parte inferior.(**buttonDelete**, **buttonUpdate**, **buttonAdd** y **buttonRefresh**).

En la parte superior un label con el titulo de la ventana y una zona para que se pueden filtrar los datos a modo de búsqueda txtFilter.

Necesitaremos crear otro *jPanel* con un formulario para poder editar y añadir nuevos clientes.
En este caso será un *jDialog* que contendrá en su interior *jLabels* y *jTextBox* (**txtName**, **txtSurnames**, **txtTelephone**, **txtEmail**, **txtAddress**).

Y 2 botones para guardar/actualizar y cancelar.

![Alt DiagramaER](/docs/img/gui-mockup-01.png)

Lo mismo para los proveedores y con los productos.
