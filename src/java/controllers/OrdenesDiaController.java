/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.MainController.setMessages;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Pedido;

/**
 *
 * @author Mateo
 */
@WebServlet(name = "OrdenesDiaController", urlPatterns = {"/dayOrders"})
public class OrdenesDiaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        setMessages(request);
        Map<String, Float> retorno = new HashMap<String, Float>();
        
        retorno = Pedido.valorPromedioYTotalVentasDia();
        
        request.setAttribute("promedio",retorno.get("promedio"));
        request.setAttribute("total",retorno.get("total"));
        
           
        RequestDispatcher view = request.getRequestDispatcher("dayOrders.jsp");
        view.forward(request, response);
        
                     
    }

    
}
