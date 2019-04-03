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
import models.Producto;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "EliminarProductoListaDController", urlPatterns = {"/EliminarProductoListaD"})
public class eliminarProductoListaDController extends HttpServlet {
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        setMessages(request);
        HttpSession session = request.getSession();
        
        Persona personaActual = (Persona)session.getAttribute("usuarioActual");
        
        int idProductoEliminar = Integer.parseInt(request.getParameter("id_producto"));
        personaActual.eliminarProductoListaDeseos(idProductoEliminar);
        
        request.setAttribute("lista_deseos", personaActual.getLista_deseos());
        session.setAttribute("usuarioActual", personaActual);
        
        RequestDispatcher view = request.getRequestDispatcher("listaDeseos.jsp");
            view.forward(request, response);       
               
    }


}
