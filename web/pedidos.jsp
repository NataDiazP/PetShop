<!-- LO PRIMERO QUE IBA AQUI FUE COGIDO DE INDEX DE WEBPAGES 2-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Petshop - Pedidos</title>

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

                    <c:if test="${empty pedidos}">
                        <div class="alert alert-primary" role="alert">
                            <h4>${mensajes["no_orders"]}</h4>
                        </div>
                    </c:if>
                    <c:if test="${!empty pedidos}">
                        <!-- DataTables Example -->
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fas fa-list"></i>
                                Histórico de pedidos
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Fecha</th>
                                                <th>Cliente</th>
                                                <th>Estado</th>
                                                <th>Productos</th>
                                                <th>Valor total</th>
                                                <th>Accion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${pedidos}" var="pedido">
                                                <tr>
                                                    <td>${pedido.getId()}</td>
                                                    <td>${pedido.getFecha()}</td>
                                                    <td>${pedido.getPersona().getNombre()}</td>
                                                    <td>${pedido.getEstado()}</td>
                                                    <td>
                                                        <c:forEach items="${pedido.getLista_pedidos_producto()}" var="prod">
                                                            <p>${prod.getProducto().getNombre()} - ${prod.getCantidad()} - ${prod.getSubtotal()}</p>
                                                        </c:forEach>
                                                    </td>
                                                    <td>${pedido.getValor_total()}</td>
                                                    <c:if test="${pedido.getEstado() != 'Anulado'}">
                                                        <td>
                                                            <form action="./AnularPedido" method="POST">
                                                                <input type ="hidden" name="id_pedido" value="${pedido.getId()}"/>
                                                                <button class="btn btn-danger" alt="Anular">
                                                                    <i class="fas fa-ban fa-fw"></i>
                                                                </button>
                                                            </form>
                                                        </td>                   
                                                    </c:if>
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
