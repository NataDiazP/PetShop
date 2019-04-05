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

        <title>${mensajes["header_text"]} - ${mensajes["commentary"]}</title>

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
                    <!-- Formulario-->
                    <div class="card-header">
                        <i class="fas fa-comments"></i>
                        Comentario
                    </div>
                    <div class="card card-register mx-auto mt-5">
                        <div class="card-body">
                            <form method="POST" action="./ComentarController">
                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input name="nombre" id="nombre" class="form-control" placeholder="${nombreComentar}" autofocus="autofocus" readonly>
                                        <label for="nombre">${nombreComentar}</label>
                                        <input name="id_producto" type="hidden" value="${idComentar}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input name="comentario" id="comentario" class="form-control" placeholder="${mensajes["commentary"]}" required="required">
                                        <label for="comentario">${mensajes["commentary"]}</label>
                                    </div>
                                </div>
                                <input class="btn btn-primary btn-block" type="submit" value="${mensajes["comment"]}" />
                            </form>
                        </div>
                    </div>
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
