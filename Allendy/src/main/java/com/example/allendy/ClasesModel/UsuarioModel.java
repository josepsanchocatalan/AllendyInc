package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Usuario;
import com.example.allendy.DBUtil;
import com.example.allendy.dataSingelton;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase que representa el modelo de datos para la clase Usuario.
 */
public class UsuarioModel {

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param a El objeto Usuario a insertar.
     */
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

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param u1 El objeto Usuario a eliminar.
     * @return true si el usuario fue eliminado exitosamente, false en caso contrario.
     */
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

    /**
     * Modifica un usuario en la base de datos.
     *
     * @param u1 El objeto Usuario modificado.
     * @return true si el usuario fue modificado exitosamente, false en caso contrario.
     */
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

    /**
     * Comprueba si un usuario ya está registrado en la base de datos.
     *
     * @param u1 El objeto Usuario a comprobar.
     * @return true si el usuario está registrado, false en caso contrario.
     */
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

    /**
     * Comprueba las credenciales de inicio de sesión de un usuario.
     *
     * @param u1 El objeto Usuario con las credenciales a comprobar.
     * @return true si las credenciales son válidas, false en caso contrario.
     */
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

    /**
     * Recupera un usuario de la base de datos basado en su correo electrónico.
     *
     * @param correo El correo electrónico del usuario a recuperar.
     * @return El objeto Usuario recuperado, o null si no se encontró ningún usuario.
     */
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

    /**
     * Recupera una lista de correos electrónicos de todos los usuarios, excepto el usuario activo.
     *
     * @return Una lista de correos electrónicos de los usuarios.
     */
    public ArrayList<String> recuperarCorreos(){
        ArrayList<String> correos = new ArrayList<String>();
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        PreparedStatement stmt = null;

        dataSingelton data = dataSingelton.getInstance();
        Usuario a = data.getUsuario();
        String usuarioActivo = a.getEmail();

        try {
            stmt = con.prepareStatement("select * from allendy.usuarios");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                if (usuarioActivo.equals(rs.getString("mail"))){
                } else {
                    correos.add(rs.getString("mail"));
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return correos;
    }
}
