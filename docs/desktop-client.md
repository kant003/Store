# Modelo

# Vista

# Controlador


# Controlador

**Se necesita crear el controlador de acceso a datos (para clientes, proveedores y productos)**

Este controlador consistirá en una clase con los siguientes métodos:

**findClientsDB**, y se encargará de buscar clientes en la base de datos.

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
