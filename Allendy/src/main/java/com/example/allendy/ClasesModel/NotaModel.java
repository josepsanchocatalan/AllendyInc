package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Nota;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.DBUtil;
import com.example.allendy.dataSingelton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotaModel {

    @javafx.fxml.FXML
    public static  void InsertarNota(Nota n1){
        boolean verificacion = false;

        DBUtil db = new DBUtil();
        Connection con = db.getConexion();


        Integer idUser= n1.getIdUsuarioNota().getIdUsuario();
        String nombre= n1.getNombre();
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
    public static void EliminarNota(Integer id) {
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        Integer idNota = id;
        try {
            String insertSql = "DELETE FROM allendy.notas where IdNota = ?";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setInt(1, idNota);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void ModificarNota(Nota n1){
            DBUtil db = new DBUtil();
            Connection con = db.getConexion();
            Integer idNota= n1.getIdNota();
            String nombre = n1.getNombre();
            String descripcion = n1.getDescripcion();

            try {
                String insertSql = "UPDATE allendy.notas SET Nombre = ?, Descripcion = ? where Id=?";
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



    public static ArrayList<Nota> mostrarNotasUsuario(Usuario usuario) throws SQLException {
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        // Consulta SQL modificada para obtener solo las notas del usuario
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



}
