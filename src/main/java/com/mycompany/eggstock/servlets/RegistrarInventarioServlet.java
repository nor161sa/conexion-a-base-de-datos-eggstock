package com.mycompany.eggstock.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "RegistrarInventarioServlet", urlPatterns = {"/registrarInventario.jsp"})
public class RegistrarInventarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idEntrega = request.getParameter("id_entrega");
        String tipoHuevo = request.getParameter("tipo_huevo");
        String fecha = request.getParameter("fecha");
        String ubicacion = request.getParameter("ubicacion");
        String referencia = request.getParameter("referencia");

        String url = "jdbc:mysql://localhost:3306/jdbctest"; // Cambia según sea necesario
        String user = "root"; // Cambia según tu configuración
        String password = ""; // Cambia según tu configuración

        Connection conexion = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO inventario (Id_entrega, Tipo_huevo, Fecha, Ubicacion, Referencia) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, idEntrega);
            preparedStatement.setString(2, tipoHuevo);
            preparedStatement.setDate(3, java.sql.Date.valueOf(fecha));
            preparedStatement.setString(4, ubicacion);
            preparedStatement.setString(5, referencia);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
            // Después de guardar exitosamente en la base de datos
                request.getSession().setAttribute("mensaje", "Registro exitoso.");
            // Redirigir a inventario.jsp
                response.sendRedirect("inventario.jsp");
            } else {
                // Fallo en el registro
                response.sendRedirect("error.jsp"); // Cambia a la página de error deseada
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrarInventarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("error.jsp"); // Cambia a la página de error deseada
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
