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
import models.Persona;
import models.Producto;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "verPedidosController", urlPatterns = {"/verPedidosController"})
public class verPedidosController extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        setMessages(request);
        HttpSession session = request.getSession();
        
        Persona usuarioActual = (Persona) session.getAttribute("usuarioActual");              
        List<Pedido> pedidosUsuarioActual = new ArrayList<Pedido>();
        
        pedidosUsuarioActual = usuarioActual.getLista_pedidos();
        
        request.setAttribute("pedidos", pedidosUsuarioActual); 
        RequestDispatcher view = request.getRequestDispatcher("pedidos.jsp");
        view.forward(request, response);        

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        }


   

}
