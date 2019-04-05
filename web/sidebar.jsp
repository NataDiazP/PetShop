<%-- 
    Document   : sidebar
    Created on : Mar 27, 2019, 7:05:59 PM
    Author     : natalia.diaz
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %> <!-- Esto es para poder usar los atributos que estan en la session aqui adentro en el jsp-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="index.html">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="./productos">
            <i class="fas fa-fw fa-cart-arrow-down"></i>
            <span>${mensajes["products"]}</span></a>
    </li>
    <c:if test="${tipoUsuario == 'cliente'}">
        <li class="nav-item">
            <a class="nav-link" href="./ComprarController">
                <i class="fas fa-fw fa-shopping-bag"></i>
                <span>${mensajes["my_orders"]}</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="./AgregarListaDeseos">
                <i class="fas fa-fw fa-star"></i>
                <span>${mensajes["wish_list"]}</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="./MisComentarios">
                <i class="fas fa-comments"></i>
                <span>${mensajes["my_comments"]}</span></a>
        </li>
    </c:if>
    <c:if test="${sessionScope.tipoUsuario == 'empleado'}">
        <c:if test="${sessionScope.usuarioActual.isAdmin() == true}">
            <li class="nav-item">
                <a class="nav-link" href="./empleados">
                    <i class="fas fa-fw fa-user-friends"></i>
                    <span>${mensajes["employees"]}</span></a>
            </li>
        </c:if>
        <li class="nav-item">
            <a class="nav-link" href="./pedidos">
                <i class="fas fa-list"></i>
                <span>${mensajes["orders"]}</span></a>
        </li> 
        <li class="nav-item">
            <a class="nav-link" href="./dayOrders">
                <i class="fas fa-dollar-sign"></i>
                <span>${mensajes["day_orders"]}</span></a>
        </li>    
    </c:if>
</ul>
