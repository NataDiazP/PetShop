package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Producto {
    
    public static List<Producto> productos = new ArrayList<Producto>();
    public static int contador_ids = 0;
    
    private int id;
    private String nombre;
    private String descripcion;
    private float valor;
    private int cantidad_inventario;
    private List<PedidoProducto> lista_pedidos_producto;
    private List<Comentario> lista_comentarios;

    public Producto(String nombre, String descripcion, float valor, int cantidad_inventario, List<PedidoProducto> lista_pedidos_producto, List<Comentario> lista_comentarios) {
        Producto.contador_ids += 1;
        this.id = Producto.contador_ids;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.cantidad_inventario = cantidad_inventario;
        this.lista_pedidos_producto = lista_pedidos_producto;
        this.lista_comentarios = lista_comentarios;
    }
    public Producto(String nombre, String descripcion, float valor, int cantidad_inventario) {
        Producto.contador_ids += 1;
        this.id = Producto.contador_ids;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.cantidad_inventario = cantidad_inventario;
        this.setLista_pedidos_producto(new ArrayList());
        this.setLista_comentarios(new ArrayList());
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCantidad_inventario() {
        return cantidad_inventario;
    }

    public void setCantidad_inventario(int cantidad_inventario) {
        this.cantidad_inventario = cantidad_inventario;
    }

    public List<PedidoProducto> getLista_pedidos_producto() {
        return lista_pedidos_producto;
    }

    public void setLista_pedidos_producto(List<PedidoProducto> lista_pedidos_producto) {
        this.lista_pedidos_producto = lista_pedidos_producto;
    }

    public List<Comentario> getLista_comentarios() {
        return lista_comentarios;
    }

    public void setLista_comentarios(List<Comentario> lista_comentarios) {
        this.lista_comentarios = lista_comentarios;
    }
    
    public String validarExistenciaEnLista (Map<String, String> mensajes){
        for (Producto producto_actual : Producto.productos){
            if (producto_actual.getNombre().toLowerCase().equals(this.getNombre().toLowerCase())){
                return mensajes.get("product_with_same_name");
            }
        }
        
        Producto.productos.add(this);
        return mensajes.get("product_added");
    }
    
    public void actualizarProducto(String nombre, float valor, String descripcion, int cantidad_inventario){
        this.nombre = nombre;
        this.valor = valor;
        this.descripcion = descripcion;
        this.cantidad_inventario = cantidad_inventario;
    }
    
    public boolean validarCantidadInventario(int cantidad_venta){
        return (this.cantidad_inventario >= cantidad_venta);
    }
    
    public static List<Producto> buscarProductoNombre(String nombre_a_buscar){
        List<Producto> listado_productos_buscados = new ArrayList<Producto>();
        
        for (Producto producto_actual : Producto.productos){
            if (producto_actual.getNombre().toLowerCase().contains(nombre_a_buscar.toLowerCase())){
                listado_productos_buscados.add(producto_actual);
            }
            
        }
        
        return listado_productos_buscados;
    }
    
    public static Producto seleccionarProducto(int numero_id, List<Producto> lista_productos){
        for(Producto producto_actual : lista_productos){
            if (producto_actual.getId() == numero_id){
                return producto_actual;
            }
        }
        
        return null;
        
    }
    
    public static String borrarProducto (int numero_id, Map<String, String> mensajes){
        for (Producto producto_actual : Producto.productos){
            if (producto_actual.getId() == numero_id){
                Producto.productos.remove(producto_actual);
                return mensajes.get("product_deleted");
            }
        }
        return mensajes.get("product_not_found");
    }
    
    public static boolean validarIdEnListaProductosAComentar (int numero_id, List<Producto> lista_productos){
        for(Producto producto_actual : lista_productos){
            if(numero_id == producto_actual.getId()){
                return true;
            }
        }
        return false;
    }
 
}
