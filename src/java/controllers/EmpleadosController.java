/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.MainController.setMessages;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Producto;
import models.Empleado;

/**
 *
 * @author natalia.diaz
 */
@WebServlet(name = "EmpleadosController", urlPatterns = {"/empleados"})
public class EmpleadosController extends MainController {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);

        HttpSession session = request.getSession(); // Session es como una cookie
        List<Empleado> empleados = new ArrayList<Empleado>();

        if (null != session.getAttribute("Empleados")) {
            empleados = (ArrayList<Empleado>) session.getAttribute("Empleados"); // Se obtienen los empleados de la sesión
        }

        request.setAttribute("empleados", empleados); // Luego se asignan en la vista

        RequestDispatcher view = request.getRequestDispatcher("empleados.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        List<Empleado> empleados = new ArrayList<Empleado>();
        
        if (null != session.getAttribute("Empleados")) {
            empleados = (ArrayList<Empleado>) session.getAttribute("Empleados");
        }

        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String correoElectronico = request.getParameter("correo");
        String password = request.getParameter("password");
        boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
        
        Empleado empleado = new Empleado(nombre, correoElectronico, telefono, direccion, password, true, admin);
        empleados.add(empleado);

        session.setAttribute("Eempleados", empleados); // Guardar en sesion
        request.setAttribute("empleados", empleados); // Guardar en la vista - Asi se llama en el JSP       
        
    }
}
