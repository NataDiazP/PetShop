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

    <title>Petshop</title>

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
   
    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="index.html">Start Bootstrap</a>

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
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-bell fa-fw"></i>
            <span class="badge badge-danger">9+</span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-envelope fa-fw"></i>
            <span class="badge badge-danger">7</span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="#">Settings</a>
            <a class="dropdown-item" href="#">Activity Log</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
          </div>
        </li>
      </ul>

    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <%@ include file="sidebar.jsp" %>

      <div id="content-wrapper">

        <div class="container-fluid">
          <!-- Formulario-->
         <!-- c:if test="${sessionScope.tipoUsuario == 'empleado'}" -->
          <div class="card-header">
              <i class="fas fa-table"></i>
              Agrega un Producto</div>
          <div class="card card-register mx-auto mb-5">
                        <div class="card-body">
                            <form method="POST" action="./MainProducts">
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
                <!--/c:if-->


          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-table"></i>
              Productos Disponibles en Petshop</div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Producto</th>
                      <th>Descripcion</th>
                      <th>Valor</th>
                      <th>Cantidad en inventario</th>
                      <th>Accion</th>
                      
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
                                    <form action="./AgregarListaDeseos" method="POST">
                                        <input type ="hidden" name="id_producto" value="${pro.getId()}"/>
                                        <button class="btn btn-primary">${mensajes["add_to_wish_list"]}</button>
                                    </form><br>
                                    <form action="./AgregarCarritoCompras" method="POST">
                                        <input type ="hidden" name="id_producto" value="${pro.getId()}"/>
                                        <button class="btn btn-success">${mensajes["add_to_cart"]}</button>
                                    </form>                               

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