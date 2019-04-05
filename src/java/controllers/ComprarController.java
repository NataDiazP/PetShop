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
import models.Pedido;
import models.PedidoProducto;
import models.Persona;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "ComprarController", urlPatterns = {"/ComprarController"})
public class ComprarController extends MainController {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);
        HttpSession session = request.getSession();

        Persona personaActual = (Persona) session.getAttribute("usuarioActual");

        request.setAttribute("listaPedidos", personaActual.misPedidosComprados());

        RequestDispatcher view = request.getRequestDispatcher("misCompras.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);
        HttpSession session = request.getSession();

        List<Pedido> pedidos = new ArrayList<Pedido>();

        if (null != session.getAttribute("Pedidos")) {
            pedidos = (ArrayList<Pedido>) session.getAttribute("Pedidos"); // Se obtienen los empleados de la sesión
        }

        Persona personaActual = (Persona) session.getAttribute("usuarioActual");

        Pedido pedidoPendiente = Pedido.getPedidoPendiente(personaActual);
        String[] cantidad_productos = request.getParameterValues("cantidad_producto");

        int contador = 0;

        for (String id_producto_actual : request.getParameterValues("id_productos")) {
            int id_producto_buscar = Integer.parseInt(id_producto_actual);
            PedidoProducto productoBuscado = Pedido.getProductoCarrito(pedidoPendiente, id_producto_buscar);
            productoBuscado.setCantidad(Integer.parseInt(cantidad_productos[contador]));
            productoBuscado.setSubtotal(Integer.parseInt(cantidad_productos[contador]) * productoBuscado.getProducto().getValor());
            contador += 1;
        }

        pedidoPendiente.calcularValorTotal();
        pedidoPendiente.comprar();

        request.setAttribute("listaPedidos", personaActual.misPedidosComprados());
        session.setAttribute("usuarioActual", personaActual);

        RequestDispatcher view = request.getRequestDispatcher("misCompras.jsp");
        view.forward(request, response);

    }

}
