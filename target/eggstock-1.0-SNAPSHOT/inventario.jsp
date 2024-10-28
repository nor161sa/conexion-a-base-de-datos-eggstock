<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registro de Inventario</title>
        <link rel="stylesheet" type="text/css" href="CSS/inventario.css"/>
    </head>
    <body>
        <div class="header">
            <h1 class="title1">Bienvenido</h1>
            <img src="images/logo_granja_huevos_2.png" alt="Logo" class="logo">
        </div>

        <div class="button-container">

            <button onclick="location.reload()" class="circle-button" title="Actualizar la página">
                <img src="images/boton de actualizar.jpg" alt="Actualizar" class="button-icon">
            </button>
            <button onclick="history.back()" class="circle-button" title="Regresar a la página anterior">
                <img src="images/boton retroceder.jpg" alt="Regresar" class="button-icon">
            </button>
        </div>


        <div class="form-container">
            <h1 class="title">Registrar Inventario</h1>
            <%
                String mensaje = (String) request.getSession().getAttribute("mensaje");
                if (mensaje != null) {
            %>
            <div class="mensaje">
                <p><%= mensaje%></p>
            </div>
            <%
                    request.getSession().removeAttribute("mensaje");
                }
            %>
            <form action="registrarInventario.jsp" method="post">
                <label for="id_entrega">ID Entrega:</label>
                <input type="text" id="id_entrega" name="id_entrega" required><br><br>

                <label for="tipo_huevo">Tipo de Huevo:</label>
                <select id="tipo_huevo" name="tipo_huevo" required>
                    <option value="blanco">Blanco</option>
                    <option value="amarillo">Amarillo</option>
                </select><br><br>

                <label for="fecha">Fecha:</label>
                <input type="date" id="fecha" name="fecha" required><br><br>

                <label for="ubicacion">Ubicación:</label>
                <input type="text" id="ubicacion" name="ubicacion" required><br><br>

                <label for="referencia">Referencia:</label>
                <select id="referencia" name="referencia">
                    <option value="B">B</option>
                    <option value="A">A</option>
                    <option value="AA">AA</option>
                    <option value="AAA">AAA</option>
                </select><br><br>

                <input type="submit" value="Registrar">
            </form>
        </div>
        <div class="button-container">
            <button onclick="location.href = 'index.jsp'" class="circle-button" title="Ir a la página de inicio">
                <img src="images/boton de inicio.jpg" alt="Inicio" class="button-icon">
            </button>
        </div>
    </body>
</html>
