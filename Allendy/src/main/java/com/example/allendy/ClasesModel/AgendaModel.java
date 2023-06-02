package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;import com.example.allendy.Clases.Usuario;
import com.example.allendy.dataSingelton;
import java.sql.ResultSet;
import java.util.ArrayList;


public class AgendaModel {

    //Funcion insertar agenda
    public static void InsertarAgenda(Agenda a1){

        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        Integer iduserAg= a1.getIdUsuarioAgenda();
        String nombre = a1.getNombreAgenda();

        try {
            String insertSql = "INSERT INTO allendy.Agenda ( id_usuarioAgenda,NombreAgenda) VALUES ( ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setInt(1, iduserAg);
            stmt.setString(2, nombre);

            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

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
    public static void ModificarAgenda(Agenda a1){

        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        Integer iduserAg= a1.getIdUsuarioAgenda();
        String nombre = a1.getNombreAgenda();

        try {
            String query = "Update allendy.Agenda set NombreAgenda =?  where id_agendaAgenda = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(2, iduserAg);
            stmt.setString(1, nombre);

            stmt.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    //Funcion recuperar agenda
    public Agenda RecuperarAgenda(int idUsuario){
        Agenda nuevaAgenda=new Agenda();

        DBUtil db = new DBUtil();

        // Integer id_usuario=a.getIdUsuario();


        try (Connection con = db.getConexion()){
            String insertSql = "select * from allendy.Agenda where id_usuarioAgenda= ? ;";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setString(1, String.valueOf(idUsuario));


            ResultSet rs = stmt.executeQuery();
            //boolean ultimo = rs.last();

            while (rs.next())
            {
                Integer id_Agenda = rs.getInt(1);
                Integer id_usuario = rs.getInt(2);
                String nombre = rs.getString(3);

                nuevaAgenda= new Agenda(id_Agenda,id_usuario,nombre);
            }

            /*
            if (rowsAffected == 1) {
                a = new Usuario(id_usuario,nombre,nickname,password,email,rol);
            }
           if (rs.next()) {
                int rowsAffected = rs.getInt(1);

                if (rowsAffected == 1) {
                    a = new Usuario(id_usuario,nombre,nickname,password,email,rol);
                }else {
                    a=null;
                }
            }*/

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nuevaAgenda;
    }

}
