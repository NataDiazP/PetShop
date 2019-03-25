/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import util.Mensajes;

/**
 *
 * @author DanielGara
 */
public class MainController extends HttpServlet {

    public static void setMessages(HttpServletRequest request) {
        request.setAttribute("mensajes", Mensajes.mensajes);
    }

}
