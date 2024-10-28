package com.mycompany.eggstock.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        String url = "jdbc:mysql://localhost:3306/jdbctest";
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            conexion = DriverManager.getConnection(url, "root", "");             

            String sql = "SELECT cargo FROM usuarios WHERE usuario = ? AND contrasena = ?";
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contraseña);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String cargo = rs.getString("cargo");
                request.getSession().setAttribute("usuario", usuario);
                request.getSession().setAttribute("cargo", cargo);

                
                switch (cargo) {
                    case "administrador":
                        response.sendRedirect("administrador.jsp");
                        break;
                    case "clasificador":
                        response.sendRedirect("clasificador.jsp");
                        break;
                    case "recolector":
                        response.sendRedirect("recolector.jsp");
                        break;
                    case "vendedor":
                        response.sendRedirect("vendedor.jsp");
                        break;
                    default:
                        response.sendRedirect("index.jsp");
                        break;
                }
            } else {
            
                response.sendRedirect("index.jsp?error=Usuario o contraseña incorrectos.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, "Error en la conexión a la base de datos: " + ex.getMessage(), ex);
            response.sendRedirect("index.jsp?error=Error en la conexión a la base de datos: " + ex.getMessage());
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
