package com.example.allendy.ClasesModel;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.DBUtil;
import com.example.allendy.dataSingelton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class TareaModel {

    public static void InsertarTarea(Tarea t1) {

        dataSingelton data = dataSingelton.getInstance();
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        Usuario a = data.getUsuario();
        Agenda Agenda = data.getAgenda();

// llamar para recuperar datos
        int id_Agenda = Agenda.getIdAgenda();
        int id_usuario = a.getIdUsuario();
        LocalDate Fecha_Tarea = t1.getFechaTarea();
        LocalDate fecha_Fin = t1.getFechaFin();
        String descripcion = t1.getDescripcionTarea();
        String Tipo = t1.getTipoTarea();
        String Prioridad = t1.getPrioridadTarea();
        boolean hecho = t1.isCheckTarea();


        try {
//Aqui falta poner los datos que hemos llamado antes
            String insertSql = "INSERT INTO allendy.tareas (id_tarea, id_agendaTarea, id_usuarioTarea,fecha_tarea,fecha_fin,descripcion,tipo,check,asistentes ) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insertSql);

            //cambiar campos a los de la tabla

            stmt.setInt(2, id_Agenda);
            stmt.setInt(3, id_usuario);
            stmt.setString(4, String.valueOf(Fecha_Tarea));
            stmt.setString(5, String.valueOf(fecha_Fin));
            stmt.setString(6, descripcion);
            stmt.setString(7, Tipo);
            stmt.setString(8, String.valueOf(hecho));
            stmt.setString(9, Prioridad);
//Aqui tambien

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public boolean EliminarTarea(Tarea t1) {
        boolean verificacion = false;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/allendy", "allendy", "allendy");

            String query = "";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verificacion;
    }

    public static void ModificarTarea(Tarea t1) {
        dataSingelton data = dataSingelton.getInstance();
        DBUtil db = new DBUtil();
        Connection con = db.getConexion();
        Usuario a = data.getUsuario();
        Agenda Agenda = data.getAgenda();

// llamar para recuperar datos
        int id_Agenda = Agenda.getIdAgenda();
        int id_usuario = a.getIdUsuario();
        LocalDate Fecha_Tarea = t1.getFechaTarea();
        LocalDate fecha_Fin = t1.getFechaFin();
        String descripcion = t1.getDescripcionTarea();
        String Tipo = t1.getTipoTarea();
        String Prioridad = t1.getPrioridadTarea();
        boolean hecho = t1.isCheckTarea();


        try {
//Aqui falta poner los datos que hemos llamado antes
            String insertSql = "Update Table allendy.tareas (id_tarea, id_agendaTarea, id_usuarioTarea,fecha_tarea,fecha_fin,descripcion,tipo,check,asistentes ) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insertSql);

            //cambiar campos a los de la tabla

            stmt.setInt(2, id_Agenda);
            stmt.setInt(3, id_usuario);
            stmt.setString(4, String.valueOf(Fecha_Tarea));
            stmt.setString(5, String.valueOf(fecha_Fin));
            stmt.setString(6, descripcion);
            stmt.setString(7, Tipo);
            stmt.setString(8, String.valueOf(hecho));
            stmt.setString(9, Prioridad);
//Aqui tambien

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
