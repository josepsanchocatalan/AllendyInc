/**
 * Esta clase representa el modelo de Tarea en el sistema.
 * Proporciona métodos para insertar, eliminar, modificar y recuperar tareas de la base de datos.
 */
package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.DBUtil;
import com.example.allendy.dataSingelton;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TareaModel {

    /**
     * Inserta una nueva tarea en la base de datos.
     *
     * @param t1 La tarea a insertar.
     */
    public static void InsertarTarea(Tarea t1) {
        // Obtener instancias de las clases necesarias
        dataSingelton data = dataSingelton.getInstance();
        AgendaModel am = new AgendaModel();
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        Usuario a = data.getUsuario();
        Agenda Agenda = am.RecuperarAgenda(a.getIdUsuario());

        // Obtener los datos de la tarea
        int id_Agenda = Agenda.getIdAgenda();
        int id_usuario = a.getIdUsuario();
        LocalDate Fecha_Tarea = t1.getFechaTarea();
        LocalDate fecha_Fin = t1.getFechaFin();
        String descripcion = t1.getDescripcionTarea();
        String Tipo = t1.getTipoTarea();
        String Prioridad = t1.getPrioridadTarea();
        String asistentes = t1.getAsistentes();

        try {
            String insertSql = "INSERT INTO allendy.tarea (id_agendaTarea, id_usuarioTarea,fecha_tarea,fecha_fin,descripcion,tipo,asistentes,prioridad ) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insertSql);

            stmt.setInt(1, id_Agenda);
            stmt.setInt(2, id_usuario);
            stmt.setString(3, String.valueOf(Fecha_Tarea));
            stmt.setString(4, String.valueOf(fecha_Fin));
            stmt.setString(5, descripcion);
            stmt.setString(6, Tipo);
            stmt.setString(7, asistentes);
            stmt.setString(8, Prioridad);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una tarea de la base de datos.
     *
     * @param idTarea El ID de la tarea a eliminar.
     */
    public static void EliminarTarea(int idTarea) {
        DBUtil db = new DBUtil();
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = db.getConexion();
            stmt = con.prepareStatement("DELETE FROM allendy.tarea where id_tarea = ?");
            stmt.setInt(1, idTarea);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de los recursos en el bloque finally
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Modifica una tarea en la base de datos.
     *
     * @param t1 La tarea modificada.
     */
    public static void ModificarTarea(Tarea t1) {
        dataSingelton data = dataSingelton.getInstance();
        AgendaModel am = new AgendaModel();
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        Usuario a = data.getUsuario();
        Agenda Agenda = am.RecuperarAgenda(a.getIdUsuario());

        int id_Agenda = Agenda.getIdAgenda();
        int id_usuario = a.getIdUsuario();
        LocalDate Fecha_Tarea = t1.getFechaTarea();
        LocalDate fecha_Fin = t1.getFechaFin();
        String descripcion = t1.getDescripcionTarea();
        String Tipo = t1.getTipoTarea();
        String Prioridad = t1.getPrioridadTarea();
        int nTarea = t1.getIdTarea();

        try {
            String insertSql = "Update allendy.tarea set fecha_tarea =?,fecha_fin = ?,descripcion=?,tipo=?,asistentes=?,prioridad=?  where id_tarea = ?; ";
            PreparedStatement stmt = con.prepareStatement(insertSql);

            stmt.setString(1, String.valueOf(Fecha_Tarea));
            stmt.setString(2, String.valueOf(fecha_Fin));
            stmt.setString(3, descripcion);
            stmt.setString(4, Tipo);
            stmt.setString(5, Tipo);
            stmt.setString(6, Prioridad);
            stmt.setInt(7, nTarea);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recupera una tarea de la base de datos.
     *
     * @param idUsuario El ID del usuario para el que se desea recuperar la tarea.
     * @return La tarea recuperada.
     */
    public Tarea RecuperarTarea(int idUsuario) {
        Tarea tarea = new Tarea();
        DBUtil db = new DBUtil();
        int id_usuario = idUsuario;

        try (Connection con = db.getConexion()) {
            String insertSql = "select * from allendy.tarea where id_usuarioTarea= ? ;";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setString(1, String.valueOf(idUsuario));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String descripcionTarea = rs.getString("descripcion");
                int idtarea = rs.getInt("id_tarea");
                LocalDate fechaInicio = LocalDate.parse(rs.getString("fecha_tarea"));
                LocalDate fechafin = LocalDate.parse(rs.getString("fecha_fin"));
                String Tipo = rs.getString("tipo");
                String Asistentes = rs.getString("asistentes");
                String prioridad = rs.getString("prioridad");

                tarea = new Tarea(descripcionTarea, idtarea, fechaInicio, fechafin, Tipo, Asistentes, prioridad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarea;
    }

    /**
     * Recupera todas las tareas de un usuario.
     *
     * @param idUsuario El ID del usuario.
     * @return Una lista de tareas del usuario.
     */
    public static ArrayList<Tarea> mostrarTareasUsuario(int idUsuario) {
        ArrayList<Tarea> tareasUsuario = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        try {
            stmt = con.prepareStatement("SELECT * FROM allendy.tarea WHERE id_usuarioTarea = ?");
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idTarea1 = rs.getInt("id_tarea");
                LocalDate fechaTarea = rs.getDate("fecha_tarea").toLocalDate();
                LocalDate fechaFin = rs.getDate("fecha_fin").toLocalDate();
                String descripcionTarea = rs.getString("descripcion");
                String tipoTarea = rs.getString("tipo");
                String asistentes = rs.getString("asistentes");
                String prioridadTarea = rs.getString("prioridad");

                Tarea tarea = new Tarea(idTarea1, descripcionTarea, fechaTarea, fechaFin, tipoTarea, prioridadTarea);
                tarea.setAsistentes(asistentes);

                tareasUsuario.add(tarea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tareasUsuario;
    }

    /**
     * Filtra las tareas por tipo.
     *
     * @param tipo El tipo de tarea por el que se desea filtrar.
     * @return Una lista de tareas filtradas por tipo.
     */
    public static ArrayList<Tarea> filtradoTareasTipo(String tipo) {
        ArrayList<Tarea> tareasUsuariofiltradas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        try {
            stmt = con.prepareStatement("SELECT * FROM allendy.tarea WHERE tipo = ?");
            stmt.setString(1, tipo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idTarea1 = rs.getInt("id_tarea");
                LocalDate fechaTarea = rs.getDate("fecha_tarea").toLocalDate();
                LocalDate fechaFin = rs.getDate("fecha_fin").toLocalDate();
                String descripcionTarea = rs.getString("descripcion");
                String tipoTarea = rs.getString("tipo");
                String asistentes = rs.getString("asistentes");
                String prioridadTarea = rs.getString("prioridad");

                Tarea tarea = new Tarea(idTarea1, descripcionTarea, fechaTarea, fechaFin, tipoTarea, prioridadTarea);
                tarea.setAsistentes(asistentes);

                tareasUsuariofiltradas.add(tarea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tareasUsuariofiltradas;
    }

    /**
     * Filtra las tareas por prioridad.
     *
     * @param prioridad La prioridad de tarea por la que se desea filtrar.
     * @return Una lista de tareas filtradas por prioridad.
     */
    public static ArrayList<Tarea> filtradoTareasPrioridad(String prioridad) {
        ArrayList<Tarea> tareasUsuariofiltradas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();

        try {
            stmt = con.prepareStatement("SELECT * FROM allendy.tarea WHERE prioridad = ?");
            stmt.setString(1, prioridad);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idTarea1 = rs.getInt("id_tarea");
                LocalDate fechaTarea = rs.getDate("fecha_tarea").toLocalDate();
                LocalDate fechaFin = rs.getDate("fecha_fin").toLocalDate();
                String descripcionTarea = rs.getString("descripcion");
                String tipoTarea = rs.getString("tipo");
                String asistentes = rs.getString("asistentes");
                String prioridadTarea = rs.getString("prioridad");

                Tarea tarea = new Tarea(idTarea1, descripcionTarea, fechaTarea, fechaFin, tipoTarea, prioridadTarea);
                tarea.setAsistentes(asistentes);

                tareasUsuariofiltradas.add(tarea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tareasUsuariofiltradas;
    }
    /**
     * Filtra las tareas por prioridad.
     *
     * @param idUsuario del cual se desea contar las tareas.
     * @return cuenta  tareas .
     */

    @javafx.fxml.FXML
    public static String ContadorTarea(Integer idUsuario) {

        DBUtil db = new DBUtil();


        Integer idUser = idUsuario;
        String t = "";

        try (Connection con = db.getConexion()) {
            String insertSql = "select count(*) from allendy.tarea where id_usuarioTarea = ?";
            PreparedStatement stmt = con.prepareStatement(insertSql);
            stmt.setInt(1, idUser);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                t = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;

    }




}

