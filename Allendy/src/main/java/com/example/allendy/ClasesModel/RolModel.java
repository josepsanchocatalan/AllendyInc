package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Rol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RolModel {

    public boolean InsertarRol(Rol r1){
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
    public boolean EliminarRol(Rol r1){
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
    public boolean ModificarRol(Rol r1){
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
    public boolean RecuperarRol(Rol r1){
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
