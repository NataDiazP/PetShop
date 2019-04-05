<!-- LO PRIMERO QUE IBA AQUI FUE COGIDO DE INDEX DE WEBPAGES 2-->
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

        <title>${mensajes["header_text_shopcar"]}</title>

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
                    <!-- DataTables Example -->
                    <c:if test="${!empty listaCarrito}">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            ${mensajes["shopping_cart"]}
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <form action="./ComprarController" method="POST" id="comprar">
                                    <table class="table table-bordered" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>${mensajes["id"]}</th>
                                                <th>${mensajes["product"]}</th>
                                                <th>${mensajes["description"]}</th>
                                                <th>${mensajes["value"]}</th>
                                                <th>${mensajes["quantitie"]}</th>
                                                <th>${mensajes["cantideishon"]}</th>
                                                <th>${mensajes["delete"]}</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listaCarrito}" var="list_car">
                                                <tr>
                                                    <td>${list_car.getProducto().getId()}</td>
                                                    <td>${list_car.getProducto().getNombre()}</td>
                                                    <td>${list_car.getProducto().getDescripcion()}</td>
                                                    <td>${list_car.getProducto().getValor()}</td>
                                                    <td>${list_car.getProducto().getCantidad_inventario()}</td>
                                                    <td>
                                                        <input name="id_productos" type="hidden" value="${list_car.getProducto().getId()}" >
                                                        <input name="cantidad_producto" required="required" min="1" max="${list_car.getProducto().getCantidad_inventario()}" value="${list_car.getCantidad()}" type="number">
                                                    </td>    
                                                    <td> 
                                                        <a href="./EliminarProductoCarrito?id_producto=${list_car.getProducto().getId()}">
                                                            <button class="btn btn-danger" type="button"><i class="fas fa-minus-circle"></i></button>
                                                        </a>                            
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <button class="btn btn-success" form="comprar">${mensajes["buy"]}</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    </c:if>
                    <c:if test="${empty listaCarrito}">
                        <div class="alert alert-primary" role="alert">
                            <h4>${mensajes["empty_shopping_cart"]}</h4>
                        </div>
                    </c:if>
                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <footer class="sticky-footer">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright © Your Website 2018</span>
                        </div>
                    </div>
                </footer>

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
        <script src="js/chart-js/Chart.min.js"></script>
        <script src="js/datatables/jquery.dataTables.js"></script>
        <script src="js/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin.min.js"></script>

        <!-- Demo scripts for this page-->
        <script src="js/demo/datatables-demo.js"></script>
        <script src="js/demo/chart-area-demo.js"></script>

    </body>

</html>
