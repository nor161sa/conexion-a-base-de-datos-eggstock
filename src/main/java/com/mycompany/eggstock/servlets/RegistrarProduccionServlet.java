/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

/**
 *
 * @author Familia
 */
@WebServlet(name = "RegistrarProduccionServlet", urlPatterns = {"/registrarProduccion"})
public class RegistrarProduccionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fechaRecoleccion = request.getParameter("fecha_recoleccion");
        String referencia = request.getParameter("referencia");
        String calidad = request.getParameter("calidad");
        String cantidadStr = request.getParameter("cantidad");
        String cargo = request.getParameter("cargo");
        String observaciones = request.getParameter("observaciones");

        String url = "jdbc:mysql://localhost:3306/jdbctest";
        String user = "root";
        String password = "";

        Connection conexion = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conexion = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(RegistrarProduccionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sql = "INSERT INTO Produccion (Fecha_recoleccion, Referencia, Calidad, Cantidad, Cargo, Observaciones) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = conexion.prepareStatement(sql);

            // Validación y conversión de fecha
            if (fechaRecoleccion != null && !fechaRecoleccion.isEmpty()) {
                try {
                    preparedStatement.setDate(1, java.sql.Date.valueOf(fechaRecoleccion));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Formato de fecha incorrecto. Usa el formato AAAA-MM-DD.", e);
                }
            } else {
                throw new IllegalArgumentException("Fecha de recolección es requerida.");
            }

           
            preparedStatement.setString(2, referencia);
            preparedStatement.setString(3, calidad);

            
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                preparedStatement.setInt(4, cantidad);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Cantidad debe ser un número entero.", e);
            }

            preparedStatement.setString(5, cargo);
            preparedStatement.setString(6, observaciones);

          
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                request.getSession().setAttribute("mensaje", "Registro exitoso.");
                response.sendRedirect("produccion.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }

        } catch (ClassNotFoundException | SQLException | IllegalArgumentException ex) {
            Logger.getLogger(RegistrarProduccionServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("error.jsp");
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
