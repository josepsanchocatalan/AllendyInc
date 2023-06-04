package com.example.allendy.Clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La clase Tarea representa una tarea en una aplicación de programación.
 * Esta clase extiende la clase Agenda y proporciona diversas propiedades y métodos relacionados con las tareas.
 */
public class Tarea extends Agenda {

    private Integer idTarea; // ID de la tarea
    private LocalDate fechaTarea; // Fecha de inicio de la tarea
    private LocalDate fechaFin; // Fecha de finalización de la tarea
    private String tipoTarea; // Tipo de tarea
    private String descripcionTarea; // Descripción de la tarea
    private String asistentes; // Asistentes de la tarea
    private String prioridadTarea; // Prioridad de la tarea

    /**
     * Construye un objeto Tarea con los parámetros especificados.
     *
     * @param idAgenda          ID de la agenda asociada con la tarea
     * @param idUsuarioAgenda   ID del usuario asociado con la agenda
     * @param TareasAgenda      Lista de tareas asociadas a la agenda
     * @param nombreAgenda      Nombre de la agenda
     * @param idTarea           ID de la tarea
     * @param fechaTarea        Fecha de inicio de la tarea
     * @param fechaFin          Fecha de finalización de la tarea
     * @param tipoTarea         Tipo de tarea
     * @param descripcionTarea  Descripción de la tarea
     * @param asistentes        Asistentes de la tarea
     * @param prioridadTarea    Prioridad de la tarea
     */
    public Tarea(Integer idAgenda, Integer idUsuarioAgenda, ArrayList<Tarea> TareasAgenda,
                 String nombreAgenda, Integer idTarea, LocalDate fechaTarea, LocalDate fechaFin,
                 String tipoTarea, String descripcionTarea, String asistentes, String prioridadTarea) {
        super(idAgenda, idUsuarioAgenda, TareasAgenda, nombreAgenda);
        this.idTarea = idTarea;
        this.fechaTarea = fechaTarea;
        this.fechaFin = fechaFin;
        this.tipoTarea = tipoTarea;
        this.descripcionTarea = descripcionTarea;
        this.asistentes = asistentes;
        this.prioridadTarea = prioridadTarea;
    }

    /**
     * Construye un objeto Tarea con los parámetros especificados.
     * Este constructor no incluye el ID de la tarea.
     *
     * @param idAgenda          ID de la agenda asociada con la tarea
     * @param idUsuarioAgenda   ID del usuario asociado con la agenda
     * @param TareasAgenda      Lista de tareas asociadas a la agenda
     * @param nombreAgenda      Nombre de la agenda
     * @param fechaTarea        Fecha de inicio de la tarea
     * @param fechaFin          Fecha de finalización de la tarea
     * @param tipoTarea         Tipo de tarea
     * @param descripcionTarea  Descripción de la tarea
     * @param checkTarea        Indica si la tarea está marcada o no
     * @param organizadorTarea  Organizador de la tarea
     * @param prioridadTarea    Prioridad de la tarea
     */
    public Tarea(Integer idAgenda, Integer idUsuarioAgenda, ArrayList<Tarea> TareasAgenda,
                 String nombreAgenda, LocalDate fechaTarea, LocalDate fechaFin, String tipoTarea,
                 String descripcionTarea, boolean checkTarea, String organizadorTarea, String prioridadTarea) {
        super(idAgenda, idUsuarioAgenda, TareasAgenda, nombreAgenda);
        this.fechaTarea = fechaTarea;
        this.fechaFin = fechaFin;
        this.tipoTarea = tipoTarea;
        this.descripcionTarea = descripcionTarea;
        this.prioridadTarea = prioridadTarea;
    }

    /**
     * Constructor vacío para la clase Tarea.
     */
    public Tarea() {
    }

    /**
     * Construye un objeto Tarea con los parámetros especificados.
     *
     * @param idTarea           ID de la tarea
     * @param descripcionTarea  Descripción de la tarea
     * @param fechaTarea        Fecha de inicio de la tarea
     * @param fechaFin          Fecha de finalización de la tarea
     * @param tipoTarea         Tipo de tarea
     * @param prioridadTarea    Prioridad de la tarea
     */
    public Tarea(int idTarea1, String descripcionTarea, LocalDate fechaTarea, LocalDate fechaFin,
                 String tipoTarea, String prioridadTarea) {
        this.idTarea = idTarea1;
        this.fechaTarea = fechaTarea;
        this.fechaFin = fechaFin;
        this.tipoTarea = tipoTarea;
        this.descripcionTarea = descripcionTarea;
        this.prioridadTarea = prioridadTarea;
    }

    /**
     * Construye un objeto Tarea con los parámetros especificados.
     *
     * @param descripcion      Descripción de la tarea
     * @param idtarea          ID de la tarea
     * @param fechaInicio      Fecha de inicio de la tarea
     * @param fechafin         Fecha de finalización de la tarea
     * @param tipo             Tipo de tarea
     * @param asistente        Asistentes de la tarea
     * @param prioridad        Prioridad de la tarea
     */
    public Tarea(String descripcion, int idtarea, LocalDate fechaInicio, LocalDate fechafin,
                 String tipo, String asistente, String prioridad) {
        idTarea = idtarea;
        fechaTarea = fechaInicio;
        fechaFin = fechafin;
        tipoTarea = tipo;
        descripcionTarea = descripcion;
        asistentes = asistente;
        prioridadTarea = prioridad;
    }

    /* Getters y setters */

    /**
     * Obtiene el ID de la tarea.
     *
     * @return El ID de la tarea
     */
    public Integer getIdTarea() {
        return idTarea;
    }

    /**
     * Establece el ID de la tarea.
     *
     * @param idTarea El ID de la tarea a establecer
     */
    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    /**
     * Obtiene la fecha de inicio de la tarea.
     *
     * @return La fecha de inicio de la tarea
     */
    public LocalDate getFechaTarea() {
        return fechaTarea;
    }

    /**
     * Establece la fecha de inicio de la tarea.
     *
     * @param fechaTarea La fecha de inicio de la tarea a establecer
     */
    public void setFechaTarea(LocalDate fechaTarea) {
        this.fechaTarea = fechaTarea;
    }

    /**
     * Obtiene la fecha de finalización de la tarea.
     *
     * @return La fecha de finalización de la tarea
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de finalización de la tarea.
     *
     * @param fechaFin La fecha de finalización de la tarea a establecer
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el tipo de la tarea.
     *
     * @return El tipo de la tarea
     */
    public String getTipoTarea() {
        return tipoTarea;
    }

    /**
     * Establece el tipo de la tarea.
     *
     * @param tipoTarea El tipo de la tarea a establecer
     */
    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    /**
     * Obtiene la descripción de la tarea.
     *
     * @return La descripción de la tarea
     */
    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    /**
     * Establece la descripción de la tarea.
     *
     * @param descripcionTarea La descripción de la tarea a establecer
     */
    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    /**
     * Obtiene los asistentes de la tarea.
     *
     * @return Los asistentes de la tarea
     */
    public String getAsistentes() {
        return asistentes;
    }

    /**
     * Establece los asistentes de la tarea.
     *
     * @param asistentes Los asistentes de la tarea a establecer
     */
    public void setAsistentes(String asistentes) {
        this.asistentes = asistentes;
    }

    /**
     * Obtiene la prioridad de la tarea.
     *
     * @return La prioridad de la tarea
     */
    public String getPrioridadTarea() {
        return prioridadTarea;
    }

    /**
     * Establece la prioridad de la tarea.
     *
     * @param prioridadTarea La prioridad de la tarea a establecer
     */
    public void setPrioridadTarea(String prioridadTarea) {
        this.prioridadTarea = prioridadTarea;
    }
}

