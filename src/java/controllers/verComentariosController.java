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
import models.Comentario;
import models.Persona;
import models.Producto;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "verComentariosController", urlPatterns = {"/MisComentarios"})
public class verComentariosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);
        HttpSession session = request.getSession();

        Persona personaActual = (Persona) session.getAttribute("usuarioActual");

        request.setAttribute("lista_comentarios", personaActual.getLista_comentarios());

        RequestDispatcher view = request.getRequestDispatcher("misComentarios.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);
        HttpSession session = request.getSession();

        Persona personaActual = (Persona) session.getAttribute("usuarioActual");
        List<Producto> productos = (ArrayList<Producto>) session.getAttribute("Productos");

        int idComentarioBorrar = Integer.parseInt(request.getParameter("id_comentario"));
        int idProductoReferenciado = Integer.parseInt(request.getParameter("id_producto"));

        Comentario.eliminarComentario(idComentarioBorrar, personaActual, productos);

        request.setAttribute("lista_comentarios", personaActual.getLista_comentarios());

        session.setAttribute("Productos", productos);
        session.setAttribute("usuarioActual", personaActual);

        RequestDispatcher view = request.getRequestDispatcher("misComentarios.jsp");
        view.forward(request, response);
    }
}
