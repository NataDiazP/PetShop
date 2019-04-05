<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
    <!-- Navigation -->
    <c:choose>
        <c:when test="${empty sessionScope.usuarioActual}">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                <div class="container">
                    <a class="navbar-brand" href="#">${mensajes["header_text"]}</a>
                    <a class="navbar-brand" href="#">${mensajes["header_text"]}</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Home
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">About</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </c:when>
        <c:otherwise>
            <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

                <a class="navbar-brand mr-1" href="/">${mensajes["header_text"]}</a>

                <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                    <i class="fas fa-bars"></i>
                </button>

                <!-- Navbar Search -->
                <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Navbar -->
                <ul class="navbar-nav ml-auto ml-md-0">
                    <c:if test="${sessionScope.tipoUsuario != 'empleado'}">
                        <li class="nav-item no-arrow mx-1">
                            <a class="nav-link" href="./AgregarCarritoCompras" id="messagesDropdown">
                                <i class="fas fa-shopping-cart fa-fw"></i>
                            </a>
                        </li>
                    </c:if>
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-user-circle fa-fw"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">${mensajes["logout"]}</a>
                        </div>
                    </li>
                </ul>
            </nav>

            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">${mensajes["logout"]}</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">${mensajes["confirm_logout"]}</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">${mensajes["cancel"]}</button>
                            <a class="btn btn-primary" href="./logout">${mensajes["accept"]}</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</header>