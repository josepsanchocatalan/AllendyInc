package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Usuario;
import com.example.allendy.DBUtil;

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
            String insertSql = "INSERT INTO allendy.usuarios ( nombre, nickname, password, mail, rol) VALUES (?, ?, ?, ?,?)";
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
        Boolean verificacion = false;
        String nickname = u1.getNickName();
        String correo = u1.getEmail();

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


        try (Connection con = db.getConexion()) {
            String insertSql = "select count(*) as resultado from allendy.usuarios where mail = ? and password = ?";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setString(1, correo);
            stmt.setString(2, pass);


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


    public Usuario recuperarUsuario(String correo) {
        Usuario a = new Usuario();

        DBUtil db = new DBUtil();

        int id_usuario=0;
        String nombre="";
        String nickname="";
        String password="";
        String email="";
        String rol="";

        try (Connection con = db.getConexion()){
            String insertSql = "select * from allendy.usuarios where mail = ? ;";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setString(1, correo);



            ResultSet rs = stmt.executeQuery();
            //boolean ultimo = rs.last();
            rs.next();
            if (true)
            {
                id_usuario = rs.getInt(1);
                nombre = rs.getString(2);
                nickname = rs.getString(3);
                password = rs.getString(4);
                email = rs.getString(5);
                rol = rs.getString(6);
                a = new Usuario(id_usuario,nombre,nickname,password,email,rol);
            }
            else {
                a = null;
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

        return a;
    }



}
