package com.example.allendy;

import java.sql.*;

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
    public boolean ComprobarUsuarioRegistro(Usuario u1) {
        String nickname = u1.getNickName();
        String correo = u1.getEmail();
        boolean verificacion = false;

        DBUtil db = new DBUtil();



        try (Connection con = db.getConexion()){
            String insertSql = "select count(*) as resultado from allendy.usuarios where nickname = ? and mail = ?";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setString(1, nickname);
            stmt.setString(2, correo);


            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int rowsAffected = rs.getInt(1);
                if (rowsAffected != 0) {
                    verificacion = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verificacion;
    }

    public boolean ComprobarUsuarioLogin(Usuario u1) {
        String correo = u1.getEmail();
        String pass = u1.getPassword();
        boolean verificacion = false;

        DBUtil db = new DBUtil();



        try (Connection con = db.getConexion()){
            String insertSql = "select count(*) as resultado from allendy.usuarios where mail = ? and passsword = ?";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setString(1, correo);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();
            correo=rs.getString(5);
            if (rs.next()) {
                int rowsAffected = rs.getInt(1);
                if (rowsAffected != 0) {
                    verificacion = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verificacion;
    }



}
