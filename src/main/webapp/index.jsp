<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/login.css"/>
        <title>Inicio de sesión</title>
    </head>
    <body>
        <div class="logo">
            <img class="img" src="images/logo_granja_huevos_2.png" alt="logotipo granja villa juli"/>
        </div>
        <div class="form">
            <form class="container" action="login" method="post"> 
                <h1 class="title"><%= new String("Inicio de sesion").toUpperCase() %></h1>

                <div class="inputs">
                    <input
                        class="input"
                        type="text"
                        name="usuario"
                        placeholder="Usuario"
                    />
                    <input
                        class="input2"
                        type="password"
                        name="contraseña"
                        placeholder="Contraseña"
                    />
                </div>



                <div class="btn-container">
                    <input class="btn" type="submit" value="Ingresar" />
                </div>

               
                <%
                    String errorMessage = request.getParameter("error");
                    if (errorMessage != null) {
                        out.println("<div class='error'>" + errorMessage + "</div>");
                    }
                %>
            </form>
        </div>
    </body>
</html>
