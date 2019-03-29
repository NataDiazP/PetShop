/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Empleado;
import models.Persona;
import static util.Mensajes.mensajes;

/**
 *
 * @author natalia.diaz
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginController extends MainController {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);

        HttpSession session = request.getSession();
        String usuario = request.getParameter("usuario");

        if (usuario != null) { // Aqui determinamos si es el login de empleado o el de persona
            session.setAttribute("tipoUsuario", usuario);
        }

        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        setMessages(request);

        HttpSession session = request.getSession();

        String email = request.getParameter("correo");
        String password = request.getParameter("password");

        // Login cliente
        if (session.getAttribute("tipoUsuario").equals("cliente")) {

            Persona usuarioActual = Persona.getPersona(email, password);

            if (usuarioActual == null) {
                request.setAttribute("mensajeError", mensajes.get("error_login"));

                RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
            } else {
                session.setAttribute("usuarioActual", usuarioActual);
                request.setAttribute("mensajeExito", mensajes.get("success_login"));

                RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
                view.forward(request, response);
            }

        } else if (session.getAttribute("tipoUsuario").equals("empleado")) {
            // Login Empleado
            Empleado usuarioActual = Empleado.getEmpleado(email, password);

            if (usuarioActual == null) {
                request.setAttribute("mensajeError", mensajes.get("error_login"));
                
                RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
            } else if (usuarioActual.isActivo()) {
                session.setAttribute("usuarioActual", usuarioActual);
                request.setAttribute("mensajeExito", mensajes.get("success_login"));

                RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
                view.forward(request, response);
            } else {
                request.setAttribute("mensajeError", mensajes.get("deactivated_employee"));

                RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
            }
        }
    }
}
