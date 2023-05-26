package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgendaModel {

    //Funcion insertar agenda
    public boolean InsertarAgenda(Agenda a1){
        boolean verificacion = false;
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        try {


            String query = "";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return verificacion;
    }

    //Funcion eliminar agenda/
    public boolean EliminarAgenda(Agenda a1){
        boolean verificacion = false;

        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        try {

            String query = "";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return verificacion;
    }

    //Funcion modificar agenda
    public boolean ModificarAgenda(Agenda a1){
        boolean verificacion = false;


        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        try {


            String query = "";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return verificacion;
    }

    //Funcion recuperar agenda
    public boolean RecuperarAgenda(Agenda a1){
        boolean verificacion = false;

        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        try {

            String query = "";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return verificacion;
    }
}
