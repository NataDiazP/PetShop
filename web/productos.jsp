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

        <title>${mensajes["header_text"]} - ${mensajes["products"]}</title>

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
                    <!-- Formulario-->
                    <c:if test="${sessionScope.tipoUsuario == 'empleado'}">
                        <div class="card-header">
                            <i class="fas fa-cart-plus"></i>
                            Agrega un Producto
                        </div>
                        <div class="card card-register mx-auto mb-5">
                            <div class="card-body">
                                <form method="POST" action="./productos">
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
                                                    <input id="descripcion" name="descripcion" class="form-control" placeholder="${mensajes["description"]}" required="required">
                                                    <label for="descripcion">${mensajes["description"]}</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-row">
                                            <div class="col-md-6">
                                                <div class="form-label-group">
                                                    <input name="valor" id="valor" class="form-control" placeholder="${mensajes["value"]}" required="required">
                                                    <label for="valor">${mensajes["value"]}</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-label-group">
                                                    <input name="cantidad_inventario" id="cantidad" class="form-control" placeholder="${mensajes["quantitie"]}" required="required">
                                                    <label for="cantidad">${mensajes["quantitie"]}</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <input class="btn btn-primary btn-block" type="submit" value="${mensajes["create_product"]}" />
                                </form>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${!empty error_agg}">
                        <div class="alert alert-danger" role="alert">
                            <h4>Error - Producto ya agregado a su lista de deseos</h4>
                        </div>                  
                    </c:if>
                    <c:if test="${!empty error_agg_cart}">
                        <div class="alert alert-danger" role="alert">
                            <h4>Error - Producto ya agregado a su carrito de compras</h4>
                        </div>                  
                    </c:if>

                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-shopping-cart"></i>
                            Productos Disponibles en Petshop</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>${mensajes["id"]}</th>
                                            <th>${mensajes["product"]}</th>
                                            <th>${mensajes["description"]}</th>
                                            <th>${mensajes["value"]}</th>
                                            <th>${mensajes["quantitie"]}</th>
                                            <th>${mensajes["comments"]}</th>
                                            <th>${mensajes["action"]}</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${productos}" var="pro">
                                            <c:if test="${(pro.getCantidad_inventario() > 0 and sessionScope.tipoUsuario == 'cliente') or (sessionScope.tipoUsuario == 'empleado')}">
                                                <tr>
                                                    <td>${pro.getId()}</td>
                                                    <td>${pro.getNombre()}</td>
                                                    <td>${pro.getDescripcion()}</td>
                                                    <td>${pro.getValor()}</td>
                                                    <td>${pro.getCantidad_inventario()}</td>
                                                    <td>
                                                        <c:forEach items="${pro.getLista_comentarios()}" var="comment">
                                                            <p>${comment.getPersona().getNombre()} - ${comment.getDescripcion()}</p>
                                                        </c:forEach>
                                                    </td>
                                                    <td>
                                                        <c:if test="${sessionScope.tipoUsuario == 'empleado'}">
                                                            <form action="./EliminarProducto" method="POST">
                                                                <input type ="hidden" name="id_producto" value="${pro.getId()}"/>
                                                                <button class="btn btn-danger" alt="Eliminar">
                                                                    <i class="fas fa-trash-alt fa-fw"></i>
                                                                </button>
                                                            </form><br>
                                                        </c:if>
                                                        <c:if test="${sessionScope.tipoUsuario != 'empleado'}">
                                                            <form action="./AgregarCarritoCompras" method="POST">
                                                                <input type ="hidden" name="id_producto" value="${pro.getId()}"/>
                                                                <button class="btn btn-success">
                                                                    <i class="fas fa-cart-plus fa-fw"></i>
                                                                </button>
                                                            </form><br>                               
                                                            <form action="./AgregarListaDeseos" method="POST">
                                                                <input type ="hidden" name="id_producto" value="${pro.getId()}"/>
                                                                <button class="btn btn-primary">
                                                                    <i class="fas fa-star fa-fw"></i>
                                                                </button>
                                                            </form>
                                                        </c:if>
                                                    </td>                   
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>                

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
