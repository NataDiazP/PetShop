<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Petshop</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/heroic-features.css" rel="stylesheet">

    </head>

    <body>

        <%@ include file="header.jsp" %>

        <!-- Page Content -->
        <div class="container">

            <!-- Jumbotron Header -->
            <div class="jumbotron my-4">
                <h1 class="display-3">¡Bienvenido a Petshop!</h1>
                <p class="lead">Algún texto?</p>
            </div>

            <!-- Page Features -->
            <div class="row text-center">

                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">
                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                        <div class="card-footer">
                            <form action="./index" method="GET">
                                <input type ="hidden" name="datos" value="datosFicticios"/>
                                <button class="btn btn-primary">Generar datos ficticios</button>
                            </form>
                            <c:if test="${!empty mensajeErrorDatosFicticios}">
                                <br>
                                <div class="alert alert-danger" role="alert">
                                    ${mensajeErrorDatosFicticios}
                                </div>
                            </c:if>
                            <c:if test="${!empty mensajeExitoDatosFicticios}">
                                <br>
                                <div class="alert alert-success" role="alert">
                                    ${mensajeExitoDatosFicticios}
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">
                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                        <div class="card-footer">
                            <form action="./index" method="GET">
                                <input type ="hidden" name="datos" value="datosFicticiosTXT"/>
                                <button class="btn btn-primary">Generar datos ficticios TXT</button>
                            </form>
                            <c:if test="${!empty mensajeErrorDatosFicticiosTXT}">
                                <br>
                                <div class="alert alert-danger" role="alert">
                                    ${mensajeErrorDatosFicticios}
                                </div>
                            </c:if>
                            <c:if test="${!empty mensajeExitoDatosFicticiosTXT}">
                                <br>
                                <div class="alert alert-success" role="alert">
                                    ${mensajeExitoDatosFicticiosTXT}
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">
                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                        <div class="card-footer">
                            <a href="./login?usuario=empleado" class="btn btn-primary">Empleados</a>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">
                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                        <div class="card-footer">
                            <a href="./login?usuario=cliente" class="btn btn-primary">Clientes</a>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

        <%@ include file="footer.jsp" %>

        <!-- Bootstrap core JavaScript -->
        <script src="js/jquery/jquery.min.js"></script>

    </body>

</html>
