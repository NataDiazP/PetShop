
package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Producto;

/**
 *
 * @author Juan Manuel Trujillo
 */
@WebServlet(name = "MainProducts", urlPatterns = {"/productos"})
public class ProductosController extends MainController {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        setMessages(request);
        
        Producto.productos.add(new Producto("Hueso de Canibal salvaje","bonito, boooonito",1000,10));
        
        request.setAttribute("productos", Producto.productos);

        RequestDispatcher view = request.getRequestDispatcher("productos.jsp");
        view.forward(request, response);

    }
}
