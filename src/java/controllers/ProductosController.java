
package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession(); // Session es como una cookie
        List<Producto> productos = new ArrayList<Producto>();

        if (null != session.getAttribute("Productos")) {
            productos = (ArrayList<Producto>) session.getAttribute("Productos"); // Se obtienen los empleados de la sesión
        }
        
        
        request.setAttribute("productos", Producto.productos);

        RequestDispatcher view = request.getRequestDispatcher("productos.jsp");
        view.forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        setMessages(request);
        
        HttpSession session = request.getSession();
        List<Producto> productos = new ArrayList<Producto>();        
        if(null != session.getAttribute("Productos")){
            productos=(ArrayList<Producto>) session.getAttribute("Productos");
        }
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        float valor = Float.parseFloat(request.getParameter("valor"));
        int cantidad_inventario = Integer.parseInt(request.getParameter("cantidad_inventario")); 
        
        Producto p = new Producto(nombre,descripcion,valor,cantidad_inventario);
        productos.add(p);
        
        session.setAttribute("Productos", productos);
        request.setAttribute("productos", productos);        
        RequestDispatcher view = request.getRequestDispatcher("vistaproductos.jsp");
        view.forward(request, response);
    }
}
