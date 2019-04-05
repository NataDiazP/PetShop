<%-- 
    Document   : empleados
    Created on : Mar 27, 2019, 8:17:02 PM
    Author     : natalia.diaz
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>${mensajes["header_text"]} - ${mensajes["employees"]}</title>

        <!-- Bootstrap core CSS-->
        <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="fonts/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="css/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>

    <body id="page-top">

        <%@ include file="header.jsp" %>

        <div id="wrapper">

            <%@ include file="sidebar.jsp" %>

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="./dashboard">${mensajes["dashboard"]}</a>
                        </li>
                        <li class="breadcrumb-item active">${mensajes["employees"]}</li>
                    </ol>

                    <!-- Form -->
                    <div class="card card-register mx-auto mb-5">
                        <div class="card-body">
                            <form method="POST" action="./empleados">
                                <div class="form-group">
                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="form-label-group">
                                                <input name="nombre" id="nombre" class="form-control" placeholder="${mensajes["name"]}" required="required" autofocus="autofocus">
                                                <label for="nombre">${mensajes["name"]}</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-label-group">
                                                <input id="telefono" name="telefono" class="form-control" placeholder="${mensajes["phone"]}" required="required">
                                                <label for="telefono">${mensajes["phone"]}</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="form-label-group">
                                                <input name="direccion" id="direccion" class="form-control" placeholder="${mensajes["address"]}" required="required">
                                                <label for="direccion">${mensajes["address"]}</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-label-group">
                                                <input type="email" name="correo" id="correo" class="form-control" placeholder="${mensajes["email"]}" required="required">
                                                <label for="correo">${mensajes["email"]}</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="form-label-group">
                                                <input type="password" id="password" class="form-control" placeholder="Password" required="required">
                                                <label for="password">${mensajes["password"]}</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-label-group">
                                                <input type="checkbox" id="admin">
                                                <label for="admin">${mensajes["admin"]}</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <input class="btn btn-primary btn-block" type="submit" value="${mensajes["create_employee"]}" />
                            </form>
                        </div>
                    </div>

                    <c:if test="${!empty empleados}">
                        <!-- DataTables Example -->
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fas fa-table"></i>
                                ${mensajes["employees"]}</div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>${mensajes["name"]}</th>
                                                <th>${mensajes["phone"]}</th>
                                                <th>${mensajes["address"]}</th>
                                                <th>${mensajes["email"]}</th>
                                                <th>${mensajes["active"]}</th>
                                                <th>${mensajes["actions"]}</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${empleados}" var="empl">
                                                <tr>
                                                    <td>${empl.getNombre()}</td>
                                                    <td>${empl.getTelefono()}</td>
                                                    <td>${empl.getDireccion()}</td>
                                                    <td>${empl.getDireccion()}</td>
                                                    <td>${empl.isActivo()}</td>
                                                    <td>
                                                        <form action="./CambiarEstadoEmpleado" method="POST">
                                                            <input type="hidden" name="id_empleado" value="${empl.getId()}" />
                                                            <c:if test="${empl.isActivo() == true}">

                                                                <button class="btn btn-danger" >
                                                                    <i class="fas fa-user-minus fa-fw"></i>
                                                                </button>
                                                            </c:if>
                                                            <c:if test="${empl.isActivo() == false}">
                                                                <button class="btn btn-warning" >
                                                                    <i class="fas fa-user-plus fa-fw"></i>
                                                                </button>
                                                            </c:if>
                                                        </form><br>
                                                        <!--                                                    
                                                        <form action="./actualizarEmpleado" method="POST">
                                                            <input type="hidden" name="id_empleado" value="${empl.getId()}" />
                                                            <button class="btn btn-primary" alt="Actualizar">
                                                                <i class="fas fa-retweet fa-fw"></i>
                                                            </button>
                                                        </form>-->
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.container-fluid -->
                </c:if>
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Bootstrap core JavaScript-->
        <script src="js/jquery/jquery.min.js"></script>
        <script src="js/bootstrap/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="js/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="js/datatables/jquery.dataTables.js"></script>
        <script src="js/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin.min.js"></script>
    </body>
</html>
