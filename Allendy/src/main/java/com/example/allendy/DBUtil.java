package com.example.allendy;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class DBUtil {
    private Connection con;
    private  String cadenaConexion = "jdbc:mysql://10.51.1.45:3307/allendy";
    private  String nombreUsuario = "root";
    private  String password = "Allendy2023";

    public Connection getConexion() {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.con = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
            if(con!=null){
                System.out.println("Conexion exitosa");
            }
            return this.con;
        } catch (SQLException e) {
            System.out.println("error"+e.getMessage());
            e.printStackTrace();

        }
        return null;
    }

    public void cerrarConexion() {
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}