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
import models.Pedido;
import models.PedidoProducto;
import models.Persona;
import models.Producto;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "EliminarProductoCarrito", urlPatterns = {"/EliminarProductoCarrito"})
public class EliminarProductoCarrito extends HttpServlet {
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        setMessages(request);
        HttpSession session = request.getSession();
        
        Persona personaActual = (Persona)session.getAttribute("usuarioActual");
        Pedido pedidoPendiente = Pedido.getPedidoPendiente(personaActual);
        
        int idProductoEliminar = Integer.parseInt(request.getParameter("id_producto"));
        System.out.println(idProductoEliminar);
        
        PedidoProducto.borrarProductoDeCarritoCompras(idProductoEliminar,pedidoPendiente);
        
        request.setAttribute("listaCarrito", pedidoPendiente.getLista_pedidos_producto());
        session.setAttribute("usuarioActual", personaActual);
        
        RequestDispatcher view = request.getRequestDispatcher("carritoCompras.jsp");
            view.forward(request, response);       
                
       
    }
    

}
