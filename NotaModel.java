package com.example.allendy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotaModel {

    public boolean InsertarNota(Nota n1){
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
    public boolean EliminarNota(Nota n1){
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
    public boolean ModificarNota(Nota n1){
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
    public boolean RecuperarNota(Nota n1){
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
