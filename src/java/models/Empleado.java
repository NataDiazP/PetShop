package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Empleado extends Persona {

    private boolean activo;
    private boolean admin;

    public Empleado(String nombre, String email, String telefono, String direccion, String password, List<Producto> lista_deseos, List<Comentario> lista_comentarios, List<Pedido> lista_pedidos, boolean activo, boolean admin) {
        super(nombre, email, telefono, direccion, password, lista_deseos, lista_comentarios, lista_pedidos);
        this.activo = activo;
        this.admin = admin;
    }

    public Empleado(String nombre, String email, String telefono, String direccion, String password, boolean activo, boolean admin) {
        super(nombre, email, telefono, direccion, password);
        this.activo = activo;
        this.admin = admin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public static Empleado getEmpleado(List<Empleado> empleados, String email, String password) {
        for (Empleado empleado_actual : empleados) {
            if (empleado_actual.getEmail().equals(email) && empleado_actual.getPassword().equals(password)) {
                return empleado_actual;
            }
        }

        return null;
    }

    public Map<String, String> guardarEmpleadoTxt(List<Empleado> empleados, Map<String, String> mensajes) {

        Map<String, String> retorno = new HashMap<String, String>();

        try {
            File archivo = new File("empleados.txt");
            Scanner lector_linea = new Scanner(archivo);
            while (lector_linea.hasNextLine()) {
                String linea = lector_linea.nextLine();
                if (linea.split(";")[1].equals(this.getEmail())) {
                    lector_linea.close();

                    retorno.put("exitoso", "False");
                    retorno.put("mensaje", mensajes.get("error_register"));

                    return retorno;

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura");

        }

        try {
            FileWriter escritor_linea = new FileWriter("empleados.txt");
            escritor_linea.write(this.getNombre() + ";" + this.getEmail() + ";" + this.getPassword() + ";" + this.getTelefono() + ";" + this.getDireccion() + ";" + this.isAdmin() + ";" + this.isActivo() + "\n");
            escritor_linea.close();

            empleados.add(this);

        } catch (IOException e) {
            System.out.println("Error en la escritura");
        }

        retorno.put("exitoso", "True");
        retorno.put("mensaje", mensajes.get("empl_added"));

        return retorno;

    }

    public static boolean cambiarEstadoEmpleado(List<Empleado> empleados, int id_empleado) {
        boolean estado_actual;

        for (Empleado empleado_actual : empleados) {
            if (empleado_actual.getId() == id_empleado) {
                estado_actual = empleado_actual.isActivo();
                empleado_actual.setActivo(!estado_actual);

                return true;

            }
        }
        return false;

    }

}
