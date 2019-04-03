/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
import org.apache.commons.io.IOUtils;
import static util.Mensajes.mensajes;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "DatosFicticiosController", urlPatterns = {"/index"})
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (request.getParameter("datos").equals("datosFicticios")) {

            // Datos ficticios 
            if (session.getAttribute("datosFicticios") == null) { // Se valida que no se hayan agregado antes.

                Producto.productos.add(new Producto("Collar para gato", "Hermoso", 50000, 2));
                Producto.productos.add(new Producto("Collar para perro", "Mas hermoso todavia", 50000, 5));
                Producto.productos.add(new Producto("Respirador artificial para pez", "Burbujas burbujas", 38000, 6));

                Persona.personas.add(new Persona("Mateo", "mateo@gmail.com", "123", "Av 123", "123"));

                Empleado.empleados.add(new Empleado("Natalia", "natalia@gmail.com", "123", "Av seriedad", "123", true, true));

                session.setAttribute("datosFicticios", "agregados");
                session.setAttribute("Productos",Producto.productos);

            } else {
                request.setAttribute("mensajeErrorDatosFicticios", mensajes.get("fictional_data_added"));
            }

        } else if (request.getParameter("datos").equals("datosFicticiosTXT")) {

            // Datos ficticios txt
            if (session.getAttribute("datosFicticiosTXT") == null) { // Se valida que no se hayan agregado antes.

                    InputStream input = getServletContext().getResourceAsStream("/empleados.txt");
                    BufferedReader reader = new BufferedReader( new InputStreamReader (input));
                    
                    while(reader.ready()){
                        String linea = reader.readLine();
                        
                        String datos[] = new String[7];
                        datos = linea.split(";");
                         
                        String nombre = datos[0];
                        String correo = datos[1];
                        String password = datos[2];
                        String telefono = datos[3];
                        String direccion = datos[4];
                        boolean admin = Boolean.parseBoolean(datos[5]);
                        boolean activo = Boolean.parseBoolean(datos[6]);

                        Empleado.empleados.add(new Empleado(nombre, correo, telefono, direccion, password, activo, admin));;
                    }
                    reader.close();
                    session.setAttribute("datosFicticiosTXT", "agregados");
                }
            } else {
                request.setAttribute("mensajeErrorDatosFicticiosTXT", mensajes.get("fictional_data_added"));
            }

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

}