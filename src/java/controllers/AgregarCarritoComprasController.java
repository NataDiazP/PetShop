/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.MainController.setMessages;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Pedido;
import models.PedidoProducto;
import models.Persona;
import models.Producto;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "AgregarCarritoComprasController", urlPatterns = {"/AgregarCarritoCompras"})
public class AgregarCarritoComprasController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        setMessages(request);
        HttpSession session = request.getSession();
        
        Persona personaActual = (Persona)session.getAttribute("usuarioActual");       
        
        Pedido pedidoPendiente = Pedido.getPedidoPendiente(personaActual);
        
        if (pedidoPendiente == null){
            request.setAttribute("listaCarrito", new ArrayList());           
        }
        else{
            request.setAttribute("listaCarrito", pedidoPendiente.getLista_pedidos_producto());
        }
        
        RequestDispatcher view = request.getRequestDispatcher("carritoCompras.jsp");
        view.forward(request, response);
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        setMessages(request);
        HttpSession session = request.getSession();
        
        Persona personaActual = (Persona)session.getAttribute("usuarioActual");
        
        List<Producto> productos = new ArrayList<Producto>();

        if (null != session.getAttribute("Productos")) {
            productos = (ArrayList<Producto>) session.getAttribute("Productos"); // Se obtienen los empleados de la sesión
        }
        
        int idProductoAgregar = Integer.parseInt(request.getParameter("id_producto"));
        Producto productoAgregar = Producto.seleccionarProducto(idProductoAgregar, productos);
        
        Pedido pedidoPendiente = Pedido.getPedidoPendiente(personaActual);
        
        if (pedidoPendiente == null){
            pedidoPendiente = new Pedido(LocalDate.now(),personaActual); 
        }
        

        PedidoProducto pedidoProductoActual = new PedidoProducto(1,pedidoPendiente,productoAgregar);
        
        
        request.setAttribute("listaCarrito", pedidoPendiente.getLista_pedidos_producto());
        session.setAttribute("usuarioActual", personaActual);
        
        RequestDispatcher view = request.getRequestDispatcher("carritoCompras.jsp");
        view.forward(request, response);
        
        
        
        
        
        
        
    }

}
