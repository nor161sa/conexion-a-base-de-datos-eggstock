<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registro de Produccion</title>
        <link rel="stylesheet" type="text/css" href="CSS/produccion.css"/>
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
            <h1 class="title">Registro de produccion</h1>
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
            
            <form action="registrarProduccion" method="post">
                <label for="fecha_recoleccion">Fecha de recoleccion:</label>
                <input type="date" id="fecha_recoleccion" name="fecha_recoleccion" required><br><br>

                <label for="referencia">Referencia:</label>
                <select id="referencia" name="referencia" required>
                    <option value="B">B</option>
                    <option value="A">A</option>
                    <option value="AA">AA</option>   
                    <option value="EXTRA">EXTRA</option>  
                </select><br><br>
                
                <label for="calidad">Calidad:</label>
                <select id="calidad" name="calidad" required>
                    <option value="bueno">Bueno</option>
                    <option value="deteriorado">Deteriorado</option>
                    <option value="dañado">Dañado</option>                    
                </select><br><br>

                <label for="cantidad">Cantidad:</label>
                <input type="number" id="cantidad" name="cantidad" required><br><br>

                <label for="cargo">Cargo:</label>
                <select id="cargo" name="cargo" required>
                    <option value="cuidador">Cuidador</option>
                    <option value="recolector">Recolector</option>               
                </select><br><br>
                
                <label for="observaciones">Observaciones:</label>
                <input type="text" id="observaciones" name="observaciones" required><br><br>
                
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