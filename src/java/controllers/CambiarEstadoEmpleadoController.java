/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.MainController.setMessages;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Empleado;

/**
 *
 * @author Natalia Diaz
 */
@WebServlet(name = "CambiarEstadoEmpleadoController", urlPatterns = {"/CambiarEstadoEmpleado"})
public class CambiarEstadoEmpleadoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);

        HttpSession session = request.getSession(); // Session es como una cookie
        List<Empleado> empleados = new ArrayList<Empleado>();

        if (null != session.getAttribute("Empleados")) {
            empleados = (ArrayList<Empleado>) session.getAttribute("Empleados"); // Se obtienen los empleados de la sesión
        }

        request.setAttribute("empleados", empleados);

        RequestDispatcher view = request.getRequestDispatcher("empleados.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);

        HttpSession session = request.getSession();

        List<Empleado> empleados = new ArrayList<Empleado>();

        if (null != session.getAttribute("Empleados")) {
            empleados = (ArrayList<Empleado>) session.getAttribute("Empleados"); // Se obtienen los empleados de la sesión
        }

        Empleado.cambiarEstadoEmpleado(empleados, Integer.parseInt(request.getParameter("id_empleado")));

        session.setAttribute("Empleados", empleados);
        request.setAttribute("empleados", empleados);

        RequestDispatcher view = request.getRequestDispatcher("empleados.jsp");
        view.forward(request, response);
    }
}
