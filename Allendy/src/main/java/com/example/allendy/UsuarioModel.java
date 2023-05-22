package com.example.allendy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioModel {

    public static void InsertarUsuario(Usuario a){

        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        String password= a.getPassword();
        String correo= a.getEmail();
        String nombre = a.getNombre();
        String nick = a.getNickName();
        String rol =a.getRol();

        try {
            String insertSql = "INSERT INTO allendy.usuarios ( nombre, nickname, passsword, mail, rol) VALUES (?, ?, ?, ?,?)";
            PreparedStatement stmt = con.prepareStatement(insertSql);

            stmt.setString(1, nombre);
            stmt.setString(2, nick);
            stmt.setString(3, password);
            stmt.setString(4, correo);
            stmt.setString(5,rol);
            stmt.execute();
            int rowsAffected = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public boolean EliminarUsuario(Usuario u1){
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
    public boolean ModificarUsuario(Usuario u1){
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
    public boolean RecuperarUsuario(Usuario u1){
        String password= u1.getPassword();
        String correo= u1.getEmail();
        boolean verificacion = false;

        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        try {


            String insertSql = "select * from usuario where password=? and correo=? ";
            PreparedStatement stmt = con.prepareStatement(insertSql);


            stmt.setString(1, password);
            stmt.setString(2, correo);

            stmt.execute();
            int rowsAffected = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verificacion;
    }

}
