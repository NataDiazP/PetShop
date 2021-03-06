package models;
import java.util.List;

public class Comentario {
    
    public static int contador_ids = 0;
    
    private int id;
    private String descripcion;
    private Persona persona;
    private Producto producto;

    public Comentario(String descripcion, Persona persona, Producto producto) {    
        Comentario.contador_ids += 1;
        this.id = Comentario.contador_ids;
        this.setDescripcion(descripcion);
        this.setPersona(persona);
        this.setProducto(producto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
        this.persona.getLista_comentarios().add(this);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.producto.getLista_comentarios().add(this);
    }
    
    public static void eliminarComentario (int id_comentario, Persona persona_actual, List<Producto> productos){
        for(Comentario comentario_actual: persona_actual.getLista_comentarios()){
            if(comentario_actual.getId() == id_comentario){
                persona_actual.getLista_comentarios().remove(comentario_actual);
                break;
            }
        }
        
        for (Producto producto_actual: productos ){
            for (Comentario comentario_actual : producto_actual.getLista_comentarios()){
                if (comentario_actual.getId() == id_comentario){
                    producto_actual.getLista_comentarios().remove(comentario_actual);
                    return;
                }
            }
        }
    }
    
    
}
