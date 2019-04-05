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
import models.Persona;
import models.Producto;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "verListaDeseosController", urlPatterns = {"/AgregarListaDeseos"})
public class verListaDeseosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);
        HttpSession session = request.getSession();
        Persona personaActual = (Persona) session.getAttribute("usuarioActual");

        request.setAttribute("lista_deseos", personaActual.getLista_deseos());

        RequestDispatcher view = request.getRequestDispatcher("listaDeseos.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);
        HttpSession session = request.getSession();

        Persona personaActual = (Persona) session.getAttribute("usuarioActual");

        List<Producto> productos = new ArrayList<Producto>();

        if (null != session.getAttribute("Productos")) {
            productos = (ArrayList<Producto>) session.getAttribute("Productos"); // Se obtienen los empleados de la sesión
        }

        int idProductoAgregar = Integer.parseInt(request.getParameter("id_producto"));
        Producto productoAgregar = Producto.seleccionarProducto(idProductoAgregar, productos);

        if (personaActual.validarExistenciaCarrito(idProductoAgregar) == true) {
            personaActual.getLista_deseos().add(productoAgregar);
            request.setAttribute("lista_deseos", personaActual.getLista_deseos());
            session.setAttribute("usuarioActual", personaActual);
            RequestDispatcher view = request.getRequestDispatcher("listaDeseos.jsp");
            view.forward(request, response);
        } else {
            request.setAttribute("error_agg", "Producto ya agregado");
            request.setAttribute("productos", productos);
            RequestDispatcher view = request.getRequestDispatcher("productos.jsp");
            view.forward(request, response);
        }
    }
}
