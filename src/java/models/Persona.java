package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Persona {

    public static List<Persona> personas = new ArrayList<Persona>();
    public static int contador_ids = 0;

    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String password;
    private List<Producto> lista_deseos;
    private List<Comentario> lista_comentarios;
    private List<Pedido> lista_pedidos;

    public Persona(String nombre, String email, String telefono, String direccion, String password, List<Producto> lista_deseos, List<Comentario> lista_comentarios, List<Pedido> lista_pedidos) {
        Persona.contador_ids += 1;
        this.id = Persona.contador_ids;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.password = password;
        this.lista_deseos = lista_deseos;
        this.lista_comentarios = lista_comentarios;
        this.lista_pedidos = lista_pedidos;
    }

    public Persona(String email, String password) {
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Producto> getLista_deseos() {
        return lista_deseos;
    }

    public void setLista_deseos(List<Producto> lista_deseos) {
        this.lista_deseos = lista_deseos;
    }

    public List<Comentario> getLista_comentarios() {
        return lista_comentarios;
    }

    public void setLista_comentarios(List<Comentario> lista_comentarios) {
        this.lista_comentarios = lista_comentarios;
    }

    public List<Pedido> getLista_pedidos() {
        return lista_pedidos;
    }

    public void setLista_pedidos(List<Pedido> lista_pedidos) {
        this.lista_pedidos = lista_pedidos;
    }

    public Map<String, String> registrarse(String nombre, String email, String telefono, String direccion, String password, Map<String, String> mensajes) {

        Map<String, String> retorno = new HashMap<String, String>();

        for (Persona persona_actual : personas) {
            if (persona_actual.getEmail().equals(email)) {
                retorno.put("exitoso", "False");
                retorno.put("mensaje", mensajes.get("error_register"));
                return retorno;
            }
        }

        setNombre(nombre);
        setEmail(email);
        setTelefono(telefono);
        setDireccion(direccion);
        setPassword(password);

        Persona.personas.add(this);

        retorno.put("exitoso", "True");
        retorno.put("mensaje", mensajes.get("succes_register"));
        return retorno;

    }

    public boolean iniciar_sesion() {
        for (Persona persona_actual : personas) {
            if (persona_actual.getEmail().equals(this.getEmail()) && persona_actual.getPassword().equals(this.getPassword())) {
                this.setId(persona_actual.getId());
                this.setNombre(persona_actual.getNombre());
                this.setTelefono(persona_actual.getTelefono());
                this.setDireccion(persona_actual.getDireccion());
                this.setLista_deseos(persona_actual.getLista_deseos());
                this.setLista_comentarios(persona_actual.getLista_comentarios());
                this.setLista_pedidos(persona_actual.getLista_pedidos());

                return true;
            }
        }

        return false;
    }

    public Map<String, String> agregar_lista_deseos(Producto producto, Map<String, String> mensajes) {

        Map<String, String> retorno = new HashMap<String, String>();
        for (Producto producto_actual : this.lista_deseos) {
            if (producto_actual.getId() == producto.getId()) {
                retorno.put("exitoso", "False");
                retorno.put("mensaje", mensajes.get("product_already_added"));
                return retorno;
            }
        }
        this.lista_deseos.add(producto);

        retorno.put("exitoso", "True");
        retorno.put("mensaje", mensajes.get("product_added"));
        return retorno;
    }

}
