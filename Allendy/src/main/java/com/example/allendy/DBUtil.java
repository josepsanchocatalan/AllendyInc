package com.example.allendy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de utilidad para manejar la conexión y cierre de la base de datos.
 */
public class DBUtil {
    private Connection con;
    private String cadenaConexion = "jdbc:mysql://localhost:3307/allendy";
    private String nombreUsuario = "root";
    private String password = "Allendy2023";

    /**
     * Obtiene una conexión a la base de datos.
     *
     * @return La conexión establecida.
     */
    public Connection getConexion() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.con = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
            if (con != null) {
                System.out.println("Conexion exitosa");
            }
            return this.con;
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Cierra la conexión a la base de datos.
     */
    public void cerrarConexion() {
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
