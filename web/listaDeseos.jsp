<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <title>${mensajes["header_text"]} - ${mensajes["wish_list"]}</title>

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

            <!-- Sidebar -->
            <%@ include file="sidebar.jsp" %>

            <div id="content-wrapper">

                <div class="container-fluid">
                    <c:if test="${empty lista_deseos}">
                        <div class="alert alert-primary" role="alert">
                        <h4>${mensajes["empty_wish_list"]}</h4>
                        </div>
                    </c:if>
                    <c:if test="${!empty lista_deseos}">
                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-star"></i>
                            ${mensajes["wish_list"]}</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>${mensajes["id"]}</th>
                                            <th>${mensajes["product"]}</th>
                                            <th>${mensajes["description"]}</th>
                                            <th>${mensajes["value"]}</th>
                                            <th>${mensajes["quantitie"]}</th>
                                            <th>${mensajes["actions"]}</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${lista_deseos}" var="list_dese">
                                            <tr>
                                                <td>${list_dese.getId()}</td>
                                                <td>${list_dese.getNombre()}</td>
                                                <td>${list_dese.getDescripcion()}</td>
                                                <td>${list_dese.getValor()}</td>
                                                <td>${list_dese.getCantidad_inventario()}</td>
                                                <td>
                                                    <form action="./AgregarCarritoCompras" method="POST">
                                                        <input type ="hidden" name="id_producto" value="${list_dese.getId()}"/>
                                                        <button class="btn btn-success">
                                                            <i class="fas fa-cart-plus fa-fw"></i>
                                                        </button>
                                                    </form><br>
                                                    <form action="./EliminarProductoListaD" method="POST">
                                                        <input type ="hidden" name="id_producto" value="${list_dese.getId()}"/>
                                                        <button class="btn btn-danger" alt="Eliminar">
                                                            <i class="fas fa-minus-circle fa-fw"></i>
                                                        </button>
                                                    </form>                               
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                    </c:if>

                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- /#wrapper -->

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

        <!-- Demo scripts for this page-->
        <script src="js/demo/datatables-demo.js"></script>
        <script src="js/demo/chart-area-demo.js"></script>

    </body>

</html>
