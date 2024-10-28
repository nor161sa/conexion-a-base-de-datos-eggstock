<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="CSS/administrador.css">
    <title>Administrador</title>
</head>
<body>

    <div class="logo-container">
        <h1 class="title">Bienvenido</h1>
    </div>

    <div class="logo-container">
        <img class="logo" src="images/logo_granja_huevos_2.png" alt="Logotipo de la Empresa">
    </div>

    <div class="button-container">
        <div class="button" onclick="location.href = 'usuarios.jsp'">
            <img src="images/Gestion.jpg" alt="usuarios">
            <p>Usuarios</p>
        </div>
        <div class="button" onclick="location.href = 'inventario.jsp'">
            <img src="images/inventario.jpg" alt="Inventario">
            <p>Inventario</p>
        </div>
        <div class="button" onclick="location.href = 'produccion.jsp'">
            <img src="images/Produccion.jpg" alt="Producción">
            <p>Producción</p>
        </div>
        <div class="button" onclick="location.href = 'venta.jsp'">
            <img src="images/Venta de huevos.jpg" alt="Venta">
            <p>Venta</p>
        </div>
    </div>

    <div class="top-buttons">
        <button onclick="location.reload()" class="circle-button" title="Actualizar la página">
            <img src="images/boton de actualizar.jpg" alt="Actualizar" class="button-icon">
        </button>
        <button onclick="history.back()" class="circle-button" title="Regresar a la página anterior">
            <img src="images/boton retroceder.jpg" alt="Regresar" class="button-icon">
        </button>
        <button onclick="location.href = 'index.jsp'" class="circle-button" title="Ir a la página de inicio">
            <img src="images/boton de inicio.jpg" alt="Inicio" class="button-icon">
        </button>
    </div>
    
</body>
</html>
