package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.DBUtil;
import com.example.allendy.dataSingelton;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;import com.example.allendy.Clases.Nota;

public class TareaModel {

    public static void InsertarTarea(Tarea t1) {
        dataSingelton data = dataSingelton.getInstance();
        AgendaModel am = new AgendaModel();
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        Usuario a = data.getUsuario();
        Agenda Agenda = am.RecuperarAgenda(a.getIdUsuario());

// llamar para recuperar datos
        int id_Agenda = Agenda.getIdAgenda();
        int id_usuario = a.getIdUsuario();
        LocalDate Fecha_Tarea = t1.getFechaTarea();
        LocalDate fecha_Fin = t1.getFechaFin();
        String descripcion = t1.getDescripcionTarea();
        String Tipo = t1.getTipoTarea();
        String Prioridad = t1.getPrioridadTarea();
        String asistentes = t1.getAsistentes();


        try {
//Aqui falta poner los datos que hemos llamado antes
            String insertSql = "INSERT INTO allendy.tarea (id_agendaTarea, id_usuarioTarea,fecha_tarea,fecha_fin,descripcion,tipo,asistentes,prioridad ) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insertSql);

            //cambiar campos a los de la tabla

            stmt.setInt(1, id_Agenda);
            stmt.setInt(2, id_usuario);
            stmt.setString(3, String.valueOf(Fecha_Tarea));
            stmt.setString(4, String.valueOf(fecha_Fin));
            stmt.setString(5, descripcion);
            stmt.setString(6, Tipo);
            stmt.setString(7, asistentes);
            stmt.setString(8, Prioridad);


//Aqui tambien

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


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


    public static void ModificarTarea(Tarea t1) {
        dataSingelton data = dataSingelton.getInstance();
        AgendaModel am = new AgendaModel();
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        Usuario a = data.getUsuario();
        Agenda Agenda = am.RecuperarAgenda(a.getIdUsuario());

// llamar para recuperar datos
        int id_Agenda = Agenda.getIdAgenda();
        int id_usuario = a.getIdUsuario();
        LocalDate Fecha_Tarea = t1.getFechaTarea();
        LocalDate fecha_Fin = t1.getFechaFin();
        String descripcion = t1.getDescripcionTarea();
        String Tipo = t1.getTipoTarea();
        String Prioridad = t1.getPrioridadTarea();
        int nTarea = t1.getIdTarea();

        try {
//Aqui falta poner los datos que hemos llamado antes
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

        return tarea;
    }


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
                //int idAgenda = rs.getInt("id_agendaTarea");
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
                //int idAgenda = rs.getInt("id_agendaTarea");
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
    public static ArrayList<Tarea> filtradoTareasPrioridad (String prioridad) {
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
                //int idAgenda = rs.getInt("id_agendaTarea");
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



