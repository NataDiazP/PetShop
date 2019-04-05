/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.MainController.setMessages;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Pedido;
import models.Persona;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "OrdenesDiaController", urlPatterns = {"/dayOrders"})
public class OrdenesDiaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setMessages(request);
        HttpSession session = request.getSession();
        List<Persona> personas = new ArrayList<Persona>();

        if (null != session.getAttribute("Personas")) {
            personas = (ArrayList<Persona>) session.getAttribute("Personas");
        }

        Map<String, Float> retorno = new HashMap<String, Float>();

        retorno = Pedido.valorPromedioYTotalVentasDia(personas);

        if (retorno.get("total") == 0) {
            request.setAttribute("no_orders", "Aun no hay ventas el dia de hoy");
        } else {
            request.setAttribute("promedio", retorno.get("promedio"));
            request.setAttribute("total", retorno.get("total"));
        }

        RequestDispatcher view = request.getRequestDispatcher("dayOrders.jsp");
        view.forward(request, response);
    }
}
