package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {
    
    public static List<Pedido> pedidos = new ArrayList<Pedido>();
    public static int contador_ids = 0;
    
    private int id;
    private LocalDate fecha;
    private Persona persona;
    private float valor_total;
    private String estado;
    private List<PedidoProducto> lista_pedidos_producto;

    public Pedido(LocalDate fecha, Persona persona, float valor_total, String estado, List<PedidoProducto> lista_pedidos_producto) {        
        Pedido.contador_ids += 1;
        this.id = Pedido.contador_ids;
        this.setFecha(fecha);
        this.setPersona(persona);
        this.setValor_total(valor_total);
        this.setEstado(estado);
        this.setLista_pedidos_producto(lista_pedidos_producto);
    }

    public Pedido(LocalDate fecha, Persona persona) {
        Pedido.contador_ids += 1;
        this.id = Pedido.contador_ids;
        setFecha(fecha);
        setPersona(persona);
        setEstado("pendiente");  
        this.setLista_pedidos_producto(new ArrayList());
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
        this.persona.getLista_pedidos().add(this);
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<PedidoProducto> getLista_pedidos_producto() {
        return lista_pedidos_producto;
    }

    public void setLista_pedidos_producto(List<PedidoProducto> lista_pedidos_producto) {
        this.lista_pedidos_producto = lista_pedidos_producto;
    }

    public void calcularValorTotal(){
        float valor_total = 0;
        
        for (PedidoProducto pedido_producto_actual: this.lista_pedidos_producto){
            valor_total += pedido_producto_actual.getSubtotal();
        }
        this.setValor_total(valor_total);
    }
    
    public void comprar(){
        Producto producto_seleccionado;
        for (PedidoProducto pedido_producto_actual: this.lista_pedidos_producto){
            producto_seleccionado = pedido_producto_actual.getProducto();
            producto_seleccionado.setCantidad_inventario(producto_seleccionado.getCantidad_inventario() - pedido_producto_actual.getCantidad());
        }
        this.setFecha(LocalDate.now());
        this.setEstado("Realizado");
        
    }
    
    public static String anularPedido(int id_pedido, Map<String, String> mensajes){
        
        for (Pedido pedido_actual: Pedido.pedidos){
            Producto producto_seleccionado;
            if (pedido_actual.getId() == id_pedido){
                for (PedidoProducto pedido_producto_actual: pedido_actual.getLista_pedidos_producto()){
                    producto_seleccionado = pedido_producto_actual.getProducto();
                    producto_seleccionado.setCantidad_inventario(producto_seleccionado.getCantidad_inventario()+pedido_producto_actual.getCantidad());
                }
                pedido_actual.setEstado("Anulado");
                return mensajes.get("order_successfully_cancel");
                
                    
            }
        }
        return mensajes.get("order_to_cancel_not_found");
    }
    
    public static List<Producto> productosAcomentar(Persona usuario_actual){
        
        List<Producto> lista_productos_a_comentar = new ArrayList<Producto>();
        boolean producto_agregado = false;
        Producto producto_actual;
        
        for(Pedido pedido_actual: usuario_actual.getLista_pedidos()){
            if (pedido_actual.getEstado().equals("Realizado")){
                for(PedidoProducto pedido_producto_actual: pedido_actual.getLista_pedidos_producto()){
                    producto_actual = pedido_producto_actual.getProducto();
                    
                    for(Producto producto_actual_comentar: lista_productos_a_comentar){
                        if (producto_actual_comentar.getId() == producto_actual.getId()){
                            producto_agregado = true;
                            break;
                        }
                    }
                    
                    if (producto_agregado == false){
                        lista_productos_a_comentar.add(producto_actual);
                    }
                    else{
                        producto_agregado = false;
                    }
                }
            }
        }
        
        return lista_productos_a_comentar;
               
    }
    
    public static Map<String,Float> valorPromedioYTotalVentasDia(){
        
        Map<String, Float> retorno = new HashMap<String, Float>();
        float valor_total_dia = 0;
        int contador = 0;
        
        for (Pedido pedido_actual: Pedido.pedidos){
            if (pedido_actual.getFecha() == LocalDate.now()){
                valor_total_dia += pedido_actual.getValor_total();
                contador += 1;
            }
        }
        
        if (contador > 0){
            retorno.put("promedio", (valor_total_dia / contador));
            retorno.put("total", valor_total_dia);
            
            return retorno;       
        }
        else{
            retorno.put("promedio", (float)0);
            retorno.put("total", (float) 0);
            
            return retorno;    
            
        }
        
    }
    
    public static Pedido getPedidoPendiente (Persona usuarioActual){
        
        for (Pedido pedido_actual: usuarioActual.getLista_pedidos()){
            if (pedido_actual.getEstado().equals("pendiente")){
                return pedido_actual;
            }
        }
        
        return null;
        
    }
    
    
    
    
    
}
