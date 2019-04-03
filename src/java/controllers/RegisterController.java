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
import models.Persona;
import static util.Mensajes.mensajes;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);
        HttpSession session = request.getSession();

        List<Persona> personas = new ArrayList<Persona>();

        if (null != session.getAttribute("Personas")) {
            personas = (ArrayList<Persona>) session.getAttribute("Personas");
        }

        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("correo");
        String password = request.getParameter("password");

        Persona usuarioRegistrar = Persona.registrarse(personas, nombre, email, telefono, direccion, password);

        if (usuarioRegistrar != null) {
            session.setAttribute("usuarioActual", usuarioRegistrar);
            RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
            view.forward(request, response);
        } else {
            request.setAttribute("mensajeErrorRegistro", mensajes.get("error_register"));
            RequestDispatcher view = request.getRequestDispatcher("login.jsp");
            view.forward(request, response);
        }

    }

}
