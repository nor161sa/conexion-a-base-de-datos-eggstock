<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="CSS/administrador.css">
    <title>Recolector</title>
</head>
<body>
    
    <div class="logo-container">
         <h1 class="title">Bienvenido</h1>
    </div>
    
    <div class="logo-container">
        <img class="logo" src="images/logo_granja_huevos_2.png" alt="Logotipo de la Empresa">
    </div>

    <div class="button-container">
        <div class="button" onclick="location.href='usuarios.jsp'">
            <img src="images/Gestion.jpg" alt="usuarios">
            <p>Usuarios</p>
        </div>
        <div class="button" onclick="location.href='inventario.jsp'">
            <img src="images/inventario.jpg" alt="Inventario">
            <p>Inventario</p>
        </div>
        <div class="button" onclick="location.href='produccion.jsp'">
            <img src="images/Produccion.jpg" alt="Producción">
            <p>Producción</p>
        </div>
        <div class="button" onclick="location.href='venta.jsp'">
            <img src="images/Venta de huevos.jpg" alt="Venta">
            <p>Venta</p>
        </div>
    </div>
    
    <p>
        
    </p>
    
    <div class="top-buttons">
        <button onclick="location.reload()">Actualizar</button>
        <button onclick="history.back()">Retroceder</button>
        <button onclick="location.href='index.jsp'">Salir</button>
    </div>
</body>
</html>
