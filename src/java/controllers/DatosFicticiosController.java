/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Empleado;
import models.Persona;
import models.Producto;
import static util.Mensajes.mensajes;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "DatosFicticiosController", urlPatterns = {"/index"})
public class DatosFicticiosController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        
        if (request.getParameter("datos").equals("datosFicticios")){
            
            // Datos ficticios 
            
            if (session.getAttribute("datosFicticios") == null){ // Se valida que no se hayan agregado antes.

                Producto.productos.add(new Producto("Collar para gato","Hermoso",50000,2));
                Producto.productos.add(new Producto("Collar para perro","Mas hermoso todavia",50000,5));
                Producto.productos.add(new Producto("Respirador artificial para pez","Burbujas burbujas",38000,6));

                Persona.personas.add(new Persona("Natalia","natalia@gmail.com","666","avenida cosa rica","123"));
                session.setAttribute("datosFicticios", "agregados");
                
            } else{
                request.setAttribute("mensajeErrorDatosFicticios", mensajes.get("fictional_data_added"));
            }
                          
        }
        else if (request.getParameter("datos").equals("datosFicticiosTXT")){

            // Datos ficticios txt

            if (session.getAttribute("datosFicticiosTXT") == null){ // Se valida que no se hayan agregado antes.

                try {

                File archivo = new File("empleados.txt");
                Scanner lector_linea = new Scanner(archivo);
                while (lector_linea.hasNextLine()) {
                    String linea = lector_linea.nextLine();

                    String datos [] = new String[7];
                    datos = linea.split(";");

                    String nombre = datos[0];
                    String correo = datos[1];
                    String password = datos[2];
                    String telefono = datos[3];
                    String direccion = datos[4];
                    boolean admin = Boolean.parseBoolean(datos[5]);
                    boolean activo = Boolean.parseBoolean(datos[6]);

                    Empleado.empleados.add(new Empleado(nombre,correo,password,telefono,direccion,admin,activo));
                }
                lector_linea.close();
                session.setAttribute("datosFicticiosTXT", "agregados");

                } 
                catch (FileNotFoundException e) {

                    System.out.println("Error en la lectura");
                    request.setAttribute("mensajeErrorDatosFicticiosTXT", mensajes.get("error_fictional_data_txt"));

                }
            }
            else{
                request.setAttribute("mensajeErrorDatosFicticiosTXT", mensajes.get("fictional_data_added"));
            }
            
        }
        
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

}
