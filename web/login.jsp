<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %> <!-- Esto es para poder usar los atributos que estan en la session aqui adentro en el jsp-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>${mensajes["header_text"]}</title>

        <!-- Bootstrap core CSS-->
        <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="fonts/fontawesome-free/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

    </head>

    <body class="bg-dark">
        
        <!-- Container de inicio de sesion --> 
        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">${mensajes["login"]}</div>
                <div class="card-body">
                    
                    <c:if test="${!empty mensajeError}">
                        <div class="alert alert-danger" role="alert">
                            ${mensajeError}
                        </div>
                    </c:if>
                        
                    <form method="POST" action="./login">
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="email" name= "correo" id="inputEmail" class="form-control" placeholder="Correo electronico" required="required">
                                <label for="inputEmail">${mensajes["email"]}</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="password" name= "password" id="inputPassword" class="form-control" placeholder="Password" required="required">
                                <label for="inputPassword">${mensajes["password"]}</label>
                            </div>
                        </div>
                        <input class="btn btn-primary btn-block" type="submit" value="${mensajes["login"]}" />
                    </form>
                </div>
            </div>
        </div>
          
        <!-- Container de Registro -->
        <c:if test="${sessionScope.tipoUsuario == 'cliente'}"> <!-- Accedo al tipo de usuario almacenado en sesion para saber si le muestro o no el register-->
            <div class="container">
                <div class="card card-login mx-auto mt-5">
                    <div class="card-header">${mensajes["register"]}</div>
                    <div class="card-body">


                        <form method="POST" action="./register">
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" name= "nombre" id= "inputName" class="form-control" placeholder="Nombre" required="required">
                                    <label for="inputName">${mensajes["name"]}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" name= "telefono" id = "inputPhone" class="form-control" placeholder="Nombre" required="required">
                                    <label for="inputPhone">${mensajes["phone"]}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="text" name= "direccion" id = "inputAdress" class="form-control" placeholder="Nombre" required="required">
                                    <label for="inputAdress">${mensajes["address"]}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="email" name= "correo" id = "inputEmailReg" class="form-control" placeholder="Correo electronico" required="required">
                                    <label for="inputEmailReg">${mensajes["email"]}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-label-group">
                                    <input type="password" name= "password" id = "inputPasswordReg" class="form-control" placeholder="Password" required="required">
                                    <label for="inputPasswordReg">${mensajes["password"]}</label>
                                </div>
                            </div>
                            <input class="btn btn-primary btn-block" type="submit" value="${mensajes["register"]}" />
                            <c:if test="${!empty mensajeErrorRegistro}">
                                <br><div class="alert alert-danger" role="alert">
                                    ${mensajeErrorRegistro}
                                    </div>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </c:if>

        <!-- Bootstrap core JavaScript-->
        <script src="js/jquery/jquery.min.js"></script>
        <script src="js/bootstrap/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="js/jquery-easing/jquery.easing.min.js"></script>

    </body>

</html>
