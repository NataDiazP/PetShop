<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <a href="#" class="btn btn-primary">Generar datos ficticios</a>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">
                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                        <div class="card-footer">
                            <a href="#" class="btn btn-primary">Generar datos ficticios TXT</a>
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
