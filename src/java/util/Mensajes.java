/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.HashMap;

/**
 *
 * @author DanielGara
 */
public class Mensajes {

    public static HashMap<String, String> mensajes = new HashMap<String, String>() {
        {
            put("header_text", "Petshop");
            put("welcome_text", "¡Bienvenido a Petshop!");
            put("dashboard", "Dashboard");
            put("login", "Iniciar sesión");
            put("logout", "Cerrar sesión");
            put("email", "Correo electrónico");
            put("name", "Nombre");
            put("phone", "Teléfono");
            put("description", "Descripcion");
            put("value", "Valor");
            put("quantitie", "Cantidad en inventario");
            put("buy", "Comprar");
            put("products", "Productos");
            put("shopping_cart", "Carrito de compras");
            put("address", "Dirección");
            put("password", "Contraseña");
            put("admin", "Empleado administrador");
            put("employees", "Empleados");
            put("create_employee", "Crear empleado");
            put("error_login", "No se pudo encontrar su direccion de correo electronico en el sistema. Por favor intente nuevamente.");
            put("succes_login", "Ha iniciado sesion con exito.");
            put("error_register", "Error al registrarse.");
            put("deactivated_employee", "Este empleado no tiene acceso a Petshop en este momento.");
            put("fictional_data_added", "Datos ficticios ya agregados.");
            put("fictional_data_added_success", "Datos ficticios agregados exitosamente.");
            put("error_fictional_data_txt", "Error de lectura.");
            put("register", "Registrarse");
            put("day_orders", "Resumen del dia");
            put("view_details", "Ver detalles");
            put("total_day_orders", "El valor total de las ventas del dia es: ");
            put("mean_day_orders", "El valor promedio de las ventas del dia es: ");
            put("confirm_logout", "¿Estás seguro de que quieres cerrar sesión?");
            put("cancel", "Cancelar");
            put("accept", "Aceptar");
            put("actions", "Acciones");
            put("add_to_cart", "Añadir al carrito de compras");
            put("add_to_wish_list", "Añadir a la lista de deseos");
            put("create_product", "Crear producto");
            put("delete", "Eliminar");
            put("wish_list", "Lista de deseos");
            put("my_orders", "Mis compras");
            put("comment", "Comentar");
            put("commentary", "Comentario");
            put("empty_orders", "Aún no has realizado pedidos. ¡Ve y compra!");

//             "welcome_menu": "\nBienvenido a Petshop \nSeleccione la opción deseada: \n\n1. Generar datos ficticios.\n2. Generar datos ficticios desde un txt.\n3. Usuarios.\n4. Salir.",
//        "user_type": "\nSeleccione el tipo de usuario: \n\n1. Cliente.\n2. Empleado.\n3. Volver al menu principal.",
//        "client_login_menu": "\nSelecciona una opcion\n\n1. Iniciar sesión.\n2. Registrarse.\n3. Volver al menu principal.",
//        "succes_dummy_data": "\n----------------------------------------\nLos datos han sido añadidos con exito.\n----------------------------------------",
//        "dummy_data_added": "\n----------------------------------------\nERROR\nYa agrego datos ficticios con anterioridad.\n----------------------------------------",
//        "ID": "ID: ",
//        "user_id": "\nIdentificación: ",
//        "user_name": "\nNombre: ",
//        "user_phone": "\nTelefono: ",
//        "user_address": "\nDireccion: ",
//        "user_password": "\nContraseña: ",
//        "user_active": "\nActivo: ",
//        "email": "\nCorreo electrónico: ",
//        "password": "Contraseña: ",
//        "value": "\nPrecio: ",
//        "amount": "\nCantidad: ",
//        "description" : "\nDescripcion: ",
//        "details": "\n\nDetalles: ",
//        "comments": "\n\nComentarios: ",
//        "amount_inventory": "\nCantidad en inventario: ",
//        "date": "\nFecha: ",
//        "state": "\nEstado del pedido: ",
//        "error_login": "\n----------------------------------------\nERROR\nNo se pudo encontrar su direccion de correo electronico en el sistema.\n----------------------------------------",
//        "error_register": "\n----------------------------------------\nERROR\nAlguien ya se ha registrado con ese email.\n----------------------------------------",
//        "succes_login": "\n----------------------------------------\nHa iniciado sesion con exito.\n----------------------------------------",
//        "succes_register": "\n----------------------------------------\nSe ha registrado con exito.\n----------------------------------------",
//        "employee_login_menu": "\nSelecciona una opcion\n\n1. Iniciar sesión.\n2. Volver al menu principal.",
//        "client_menu": ", Bienvenido a PetShop, ¿Que desea hacer?\n\n1. Ver productos. \n2. Seleccionar producto(s). \n3. Crear comentario. \n4. Ver carrito de compras.  \n5. Ver lista de deseos. \n6. Ver mis pedidos realizados. \n7. Desconectarme.",
//        "employee_menu": "\n1. Crear productos. \n2. Buscar productos. \n3. Actualizar producto. \n4. Eliminar producto. \n5. Anular pedidos. \n6. Ver pedidos del día. \n7. Ver promedio ventas del día. \n8. Desconectarse.",
//        "admin_menu": "\n1. Crear administrador. \n2. Crear empleados. \n3. Desactivar o activar empleado. \n4. Crear productos. \n5. Buscar productos. \n6. Actualizar producto. \n7. Eliminar producto. \n8. Anular pedidos. \n9. Ver pedidos del día. \n10. Ver promedio ventas del día. \n11. Desconectarse.",
//        "wrong_option": "\n----------------------------------------\nERROR\nOpción inválida. Por favor digite su seleccion nuevamente.\n----------------------------------------",
//        "empl_exists": "Ya existe un empleado con este correo electrónico, por favor intente con uno diferente.",
//        "empl_added": "\n----------------------------------------\nEl empleado fue creado exitosamente.\n----------------------------------------",
//        "insert_product_id": "\nIngrese el ID del producto a buscar: ",
//        "insert_product_id_select": "\nIngrese el ID del producto a seleccionar: ",
//        "insert_product_id_update": "\nIngrese el ID del producto a actualizar: ",
//        "insert_product_id_delete": "\nIngrese el ID del producto a eliminar: ",
//        "select_product_menu" : "\n¿Que desea hacer con el producto que acaba de seleccionar?\n\n1. Agregar a lista de deseados.\n2. Agregar a carrito de compras.\n3. Salir.",
//        "product_not_found": "\n----------------------------------------\nProducto(s) no encontrado(s).\n----------------------------------------",
//        "product_sold_out": "\nLa cantidad en inventario es menor a la solicitada, por favor intente nuevamente. \nProductos en inventario: ",
//        "go_back_press_any_key": "\nPara volver atras presione cualquier tecla: ",
//        "wish_list": "\n------------------------------------------\nLista de deseos.\n------------------------------------------",
//        "enter_data_employee": "\n----------------------------------\nPor favor ingrese los datos del empleado.\n----------------------------------",
//        "enter_product_info": "\nIngrese la información del producto: ",
//        "product_added": "\n----------------------------------------\nProducto añadido con exito.\n----------------------------------------",
//        "product_with_same_name": "\n----------------------------------------\nERROR\nYa hay un producto con ese mismo nombre.\n----------------------------------------",
//        "product_already_added": "\n----------------------------------------\nERROR\nYa existe este producto en su lista de deseos.\n----------------------------------------",
//        "product_to_search": "\nIngrese el nombre de los productos a buscar: ",
//        "product_deleted": "\n----------------------------------\nProducto borrado con exito.\n----------------------------------",
//        "product_updated": "\n----------------------------------\nProducto actualizado con exito.\n----------------------------------",
//        "insert_employee_id": "\nIngrese el ID del empleado a desactivar o activar: ",
//        "insert_employee_id_delete": "\nIngrese el ID del empleado a eliminar: ",
//        "deactivate_confirmation": "\n----------------------------------\nEl empleado fue desactivado exitosamente.\n----------------------------------",
//        "activate_confirmation": "\n----------------------------------\nEl empleado fue activado exitosamente.\n----------------------------------",
//        "deactivated_employee": "\nEste empleado no tiene acceso a Petshop en este momento.",
//        "delete_employee_confirmation": "\nEste empleado fue eliminado exitosamente.",
//        "employee_not_found": "\nNo existe un empleado con este ID, por favor intente nuevamente.",
//        "success_cart_add": "\n----------------------------------------\nAgregado exitosamente a carrito de compras.\n----------------------------------------",
//        "product_already_added_carrito": "\n----------------------------------------\nERROR\nYa existe este producto en su carrito de compras.\n----------------------------------------",
//        "wish_list_carrito": "\n-------------------------------------------------\nCarrito de Compras:\n-------------------------------------------------",
//        "make_order": "\n1. Realizar Pedido.\n2. Borrar producto.",
//        "product_quantity": "\n¿Cuántas unidades del producto desea agregar al carrito?",
//        "subtotal": "\nSubtotal: ",
//        "order_total_value": "\nTotal: ",
//        "buy_menu": "\n¿Que desea hacer?\n\n1. Comprar.\n2. Retirar producto del carrito.\n3. Volver atras.",
//        "previous_orders": "\n-------------------------------------------------\nPedidos anteriores.\n-------------------------------------------------",
//        "order_number": "Pedido #",
//        "order_successfully": "\n----------------------------------------\nCompra realizada con exito.\n----------------------------------------",
//        "empty_shopping_cart": "\n----------------------------------------\nERROR\nNo hay productos en tu carrito de compras.\n----------------------------------------",
//        "order_not_found": "\n----------------------------------------\nERROR\nNo has realizado pedidos con anterioridad.\n----------------------------------------",
//        "id_order_to_cancel": "\nIngrese el id del pedido a anular: ",
//        "order_successfully_cancel": "\n----------------------------------------\nPedido cancelado con exito.\n----------------------------------------",
//        "order_to_cancel_not_found": "\n----------------------------------------\nERROR\nNo se encontraron pedidos con esa Id.\n----------------------------------------",
//        "autor": "\nHecho por: ",
//        "id_to_comment": "\nIngrese el Id del producto a Comentar: ",
//        "the_comment": "\nIngrese el Comentario: ",
//        "wish_list_menu": "\n¿Que desea hacer?\n\n1. Comprar.\n2. Eliminar productos de mi lista de deseados.\n3. Salir al menu.",
//        "product_not_found_in_wish_list": "\n----------------------------------------\nERROR\nProducto no encontrado en lista deseados.\n----------------------------------------",
//        "insert_product_id_buy": "\n Inserte el ID del producto a comprar.\n",
//        "empty_wish_list": "\n----------------------------------------\nLista de deseos vacia.\n----------------------------------------",
//        "average_sales": "\nEl valor promedio de las ventas del día fue $ ",
//        "total_sales": "\nEl valor total de las ventas del dia fue $ ",
//        "no_orders_day": "\n----------------------------------------\nERROR\nNo hay pedidos para el día de hoy.\n----------------------------------------"
        }
    };
}
