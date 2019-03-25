package models;

import java.util.HashMap;
import java.util.Map;

public class PedidoProducto {

    public static int contador_ids = 0;

    private int id;
    private int cantidad;
    private Pedido pedido;
    private Producto producto;
    private float subtotal;

    public PedidoProducto(int cantidad, Pedido pedido, Producto producto, float subtotal) {
        PedidoProducto.contador_ids += 1;
        this.id = PedidoProducto.contador_ids;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.producto = producto;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
        this.pedido.getLista_pedidos_producto().add(this);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.producto.getLista_pedidos_producto().add(this);
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public static Map<String, String> agregarProductoACarritoCompras(int cantidad_venta, Pedido pedido_pendiente, Producto producto_seleccionado, Map<String, String> mensajes) {

        Map<String, String> retorno = new HashMap<String, String>();
        for (PedidoProducto item_carrito : pedido_pendiente.getLista_pedidos_producto()) {
            if (item_carrito.getProducto().getId() == producto_seleccionado.getId()) {
                if (item_carrito.getProducto().validarCantidadInventario(cantidad_venta)) {
                    item_carrito.setCantidad(cantidad_venta);
                    item_carrito.setSubtotal(cantidad_venta * producto_seleccionado.getValor());
                    pedido_pendiente.calcularValorTotal();

                    retorno.put("exitoso", "True");
                    retorno.put("mensaje", mensajes.get("success_cart_add"));

                    return retorno;

                } else {
                    retorno.put("exitoso", "False");
                    retorno.put("mensaje", mensajes.get("product_sold_out") + item_carrito.getProducto());
                }
            }
        }

        if (producto_seleccionado.validarCantidadInventario(cantidad_venta)) {
            PedidoProducto(cantidad_venta, pedido_pendiente, producto_seleccionado);
            pedido_pendiente.calcularValorTotal();

            retorno.put("exitoso", "True");
            retorno.put("mensaje", mensajes.get("success_cart_add"));

            return retorno;
        } else {

            retorno.put("exitoso", "False");
            retorno.put("mensaje", mensajes.get("product_sold_out") + producto_seleccionado.getCantidad_inventario());

            return retorno;
        }

    }

    public static String borrarProductoDeCarritoCompras(int id_producto, Pedido pedido_pendiente, Map<String, String> mensajes) {
        for (PedidoProducto item_carrito : pedido_pendiente.getLista_pedidos_producto()) {
            if (item_carrito.getProducto().getId() == id_producto) {
                pedido_pendiente.getLista_pedidos_producto().remove(item_carrito);
                pedido_pendiente.calcularValorTotal();

                return mensajes.get("product_deleted");
            }
        }
        return mensajes.get("product_not_found");
    }

}
