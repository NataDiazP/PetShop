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
@WebServlet(name = "ComentarController", urlPatterns = {"/ComentarController"})
public class ComentarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);

        HttpSession session = request.getSession(); // Session es como una cookie

        List<Producto> productos = new ArrayList<Producto>();

        if (null != session.getAttribute("Productos")) {
            productos = (ArrayList<Producto>) session.getAttribute("Productos"); // Se obtienen los empleados de la sesión
        }

        int idProductoComentar = Integer.parseInt(request.getParameter("id_producto"));

        Producto producto = Producto.buscarProductoId(productos, idProductoComentar);

        request.setAttribute("idComentar", idProductoComentar);
        request.setAttribute("nombreComentar", producto.getNombre());

        RequestDispatcher view = request.getRequestDispatcher("formularioComentario.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);
        HttpSession session = request.getSession();

        Persona personaActual = (Persona) session.getAttribute("usuarioActual");
        List<Producto> productos = (ArrayList<Producto>) session.getAttribute("Productos");

        int idProductoComentar = Integer.parseInt(request.getParameter("id_producto"));

        Producto productoComentar = Producto.seleccionarProducto(idProductoComentar, productos);

        Comentario comentarioAgregar = new Comentario(request.getParameter("comentario"), personaActual, productoComentar);

        session.setAttribute("Productos", productos);
        session.setAttribute("usuarioActual", personaActual);

        request.setAttribute("productos", productos);

        RequestDispatcher view = request.getRequestDispatcher("productos.jsp");
        view.forward(request, response);
    }

}
