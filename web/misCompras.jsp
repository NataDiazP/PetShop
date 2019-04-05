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

        <title>${mensajes["header_text"]} - ${mensajes["my_orders"]}</title>

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


                    <c:if test="${empty listaPedidos}">
                        <div class="alert alert-primary" role="alert">
                            <h4>${mensajes["empty_orders"]}</h4>
                        </div>
                    </c:if>
                    <c:if test="${!empty listaPedidos}">
                        <!-- DataTables Example -->
                        <c:forEach items="${listaPedidos}" var="ped">
                            <c:if test="${(ped.getEstado() == 'Realizado')}">
                                <div class="card mb-3">
                                    <div class="card-header">
                                        <i class="fas fa-shopping-bag"></i>
                                        Pedido # ${ped.getId()}</div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table table-bordered" width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>${mensajes["id"]}</th>
                                                        <th>${mensajes["product"]}</th>
                                                        <th>${mensajes["description"]}</th>
                                                        <th>${mensajes["value"]}</th>
                                                        <th>${mensajes["cantideishon"]}</th>
                                                        <th>${mensajes["subtotal"]}</th>
                                                        <th>${mensajes["actions"]}</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${ped.getLista_pedidos_producto()}" var="ppd">
                                                        <tr>
                                                            <td>${ppd.getProducto().getId()}</td>
                                                            <td>${ppd.getProducto().getNombre()}</td>
                                                            <td>${ppd.getProducto().getDescripcion()}</td>
                                                            <td>${ppd.getProducto().getValor()}</td>
                                                            <td>${ppd.getCantidad()}</td>
                                                            <td>${ppd.getSubtotal()}</td>
                                                            <td> 
                                                                <a href="./ComentarController?id_producto=${ppd.getProducto().getId()}">
                                                                    <button class="btn btn-warning" type="button">
                                                                        <i class="fas fa-comments fa-fw"></i>
                                                                    </button>
                                                                </a>                            
                                                            </td>
                                                        </tr>
                                                    </c:forEach>                                                    
                                                </tbody>
                                            </table>        
                                        </div>
                                        <div class="alert alert-success" role="alert">
                                            <h5>Total: ${ped.getValor_total()}</h5>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
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

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
                    </div>
                </div>
            </div>
        </div>

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
