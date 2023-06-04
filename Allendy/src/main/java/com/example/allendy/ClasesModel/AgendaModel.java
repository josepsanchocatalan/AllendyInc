package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Modelo de datos para la clase Agenda.
 */
public class AgendaModel {

    /**
     * Inserta una nueva agenda en la base de datos.
     *
     * @param a1 Agenda a insertar
     */
    public static void InsertarAgenda(Agenda a1) {
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        Integer iduserAg = a1.getIdUsuarioAgenda();
        String nombre = a1.getNombreAgenda();

        try {
            String insertSql = "INSERT INTO allendy.Agenda (id_usuarioAgenda, NombreAgenda) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setInt(1, iduserAg);
            stmt.setString(2, nombre);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una agenda de la base de datos.
     *
     * @param a1 Agenda a eliminar
     * @return true si la eliminación es exitosa, false en caso contrario
     */
    public boolean EliminarAgenda(Agenda a1) {
        boolean verificacion = false;

        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        try {
            String query = "";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verificacion;
    }

    /**
     * Modifica una agenda existente en la base de datos.
     *
     * @param a1 Agenda a modificar
     */
    public static void ModificarAgenda(Agenda a1) {
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        Integer iduserAg = a1.getIdUsuarioAgenda();
        String nombre = a1.getNombreAgenda();

        try {
            String query = "UPDATE allendy.Agenda SET NombreAgenda = ? WHERE id_agendaAgenda = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(2, iduserAg);
            stmt.setString(1, nombre);

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recupera una agenda de la base de datos dado un ID de usuario.
     *
     * @param idUsuario ID del usuario
     * @return La agenda recuperada, o una instancia vacía si no se encuentra
     */
    public Agenda RecuperarAgenda(int idUsuario) {
        Agenda nuevaAgenda = new Agenda();

        DBUtil db = new DBUtil();

        try (Connection con = db.getConexion()) {
            String insertSql = "SELECT * FROM allendy.Agenda WHERE id_usuarioAgenda = ?";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setString(1, String.valueOf(idUsuario));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Integer id_Agenda = rs.getInt(1);
                Integer id_usuario = rs.getInt(2);
                String nombre = rs.getString(3);

                nuevaAgenda = new Agenda(id_Agenda, id_usuario, nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nuevaAgenda;
    }
}
