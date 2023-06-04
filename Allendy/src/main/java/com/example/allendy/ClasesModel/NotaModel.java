package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Nota;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotaModel {

    /**
     * Inserta una nueva nota en la base de datos.
     *
     * @param n1 Nota a insertar
     */
    public static void InsertarNota(Nota n1) {
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        Integer idUser = n1.getIdUsuarioNota().getIdUsuario();
        String nombre = n1.getNombre();
        String descripcion = n1.getDescripcion();

        try {
            String insertSql = "INSERT INTO allendy.notas (IdUsuarioNota, Nombre, Descripcion) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setInt(1, idUser);
            stmt.setString(2, nombre);
            stmt.setString(3, descripcion);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una nota de la base de datos dado su ID.
     *
     * @param id ID de la nota a eliminar
     */
    public static void EliminarNota(Integer id) {
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        Integer idNota = id;

        try {
            String insertSql = "DELETE FROM allendy.notas WHERE IdNota = ?";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setInt(1, idNota);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Modifica una nota existente en la base de datos.
     *
     * @param n1 Nota a modificar
     */
    public static void ModificarNota(Nota n1) {
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        Integer idNota = n1.getIdNota();
        String nombre = n1.getNombre();
        String descripcion = n1.getDescripcion();

        try {
            String insertSql = "UPDATE allendy.notas SET Nombre = ?, Descripcion = ? WHERE IdNota = ?";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setInt(3, idNota);
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recupera todas las notas de un usuario de la base de datos.
     *
     * @param usuario Usuario del cual se obtienen las notas
     * @return Lista de notas del usuario
     * @throws SQLException si ocurre un error de SQL
     */
    public static ArrayList<Nota> mostrarNotasUsuario(Usuario usuario) throws SQLException {
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        String query = "SELECT * FROM notas WHERE IdUsuarioNota = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, usuario.getIdUsuario());
        ResultSet rs = stmt.executeQuery();

        ArrayList<Nota> notasUsuario = new ArrayList<>();

        while (rs.next()) {
            Nota nota = new Nota();
            nota.setNombre(rs.getString("Nombre"));
            nota.setDescripcion(rs.getString("Descripcion"));
            nota.setIdNota(rs.getInt("IdNota"));
            notasUsuario.add(nota);
        }

        return notasUsuario;
    }

    /**
     * Obtiene el contador de notas para un usuario específico.
     *
     * @param idUsuario ID del usuario
     * @return Contador de notas como una cadena de texto
     */
    public static String ContadorNota(Integer idUsuario) {
        DBUtil db = new DBUtil();
        Integer idUser = idUsuario;
        String n = "";

        try (Connection con = db.getConexion()) {
            String insertSql = "SELECT COUNT(*) FROM allendy.notas WHERE IdUsuarioNota = ?";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setInt(1, idUser);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                n = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    /**
     * Recupera una nota de la base de datos dado un ID de usuario.
     *
     * @param idUsuario ID del usuario
     * @return La nota recuperada
     */
    public Nota RecuperarNota(int idUsuario) {
        Nota nota = new Nota();
        DBUtil db = new DBUtil();

        try (Connection con = db.getConexion()) {
            String insertSql = "SELECT * FROM allendy.notas WHERE IdUsuarioNota = ?";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setString(1, String.valueOf(idUsuario));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nuevoNombre = rs.getString("Nombre");
                String nuevaDesc = rs.getString("Descripcion");

                nota = new Nota(nuevoNombre, nuevaDesc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nota;
    }
}
