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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Producto;

/**
 *
 * @author Natalia Diaz
 */
@WebServlet(name = "EliminarProductoController", urlPatterns = {"/EliminarProducto"})
public class EliminarProductoController extends MainController {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);
        
        HttpSession session = request.getSession(); // Session es como una cookie
        List<Producto> productos = new ArrayList<Producto>();

        if (null != session.getAttribute("Productos")) {
            productos = (ArrayList<Producto>) session.getAttribute("Productos"); // Se obtienen los empleados de la sesión
        }

        request.setAttribute("productos", productos);

        RequestDispatcher view = request.getRequestDispatcher("productos.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);

        HttpSession session = request.getSession();

        List<Producto> productos = new ArrayList<Producto>();

        if (null != session.getAttribute("Productos")) {
            productos = (ArrayList<Producto>) session.getAttribute("Productos"); // Se obtienen los empleados de la sesión
        }

        Producto.borrarProducto(productos, Integer.parseInt(request.getParameter("id_producto")));

        session.setAttribute("Productos", productos);
        request.setAttribute("productos", productos);

        RequestDispatcher view = request.getRequestDispatcher("productos.jsp");
        view.forward(request, response);
    }
}
