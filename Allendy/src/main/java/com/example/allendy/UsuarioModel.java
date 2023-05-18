package com.example.allendy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioModel {

    public boolean InsertarUsuario(Usuario u1){
        boolean verificacion = false;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection("","","");

            String query = "";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return verificacion;
    }
    public boolean EliminarUsuario(Usuario u1){
        boolean verificacion = false;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection("","","");

            String query = "";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return verificacion;
    }
    public boolean ModificarUsuario(Usuario u1){
        boolean verificacion = false;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection("","","");

            String query = "";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return verificacion;
    }
    public boolean RecuperarUsuario(Usuario u1){
        boolean verificacion = false;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection("","","");

            String query = "";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return verificacion;
    }

}
