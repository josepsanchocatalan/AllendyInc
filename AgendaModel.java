package com.example.allendy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgendaModel {

    public boolean InsertarAgenda(Agenda a1){
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
    public boolean EliminarAgenda(Agenda a1){
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
    public boolean ModificarAgenda(Agenda a1){
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
    public boolean RecuperarAgenda(Agenda a1){
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
