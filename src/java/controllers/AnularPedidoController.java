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
import models.Pedido;

/**
 *
 * @author Natalia Diaz
 */
@WebServlet(name = "AnularPedidoController", urlPatterns = {"/AnularPedido"})
public class AnularPedidoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        setMessages(request);

        HttpSession session = request.getSession();

        List<Pedido> pedidos = new ArrayList<Pedido>();
        
        if (null != session.getAttribute("Pedidos")) {
            pedidos = (ArrayList<Pedido>) session.getAttribute("Pedidos"); // Se obtienen los empleados de la sesión
        }

        Pedido.anularPedido(pedidos, Integer.parseInt(request.getParameter("id_pedido")));

        session.setAttribute("Pedidos", pedidos);
        request.setAttribute("pedidos", pedidos);

        RequestDispatcher view = request.getRequestDispatcher("pedidos.jsp");
        view.forward(request, response);
    }
}
