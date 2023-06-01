package com.example.allendy.Clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tarea extends Agenda {
    private Integer idTarea;
    private LocalDate fechaTarea;
    private LocalDate fechaFin;
    private String tipoTarea;
    private String descripcionTarea;
    private String asistentes;
    private String prioridadTarea;

    public Tarea(Integer idAgenda, Integer idUsuarioAgenda, ArrayList<Tarea> TareasAgenda, String nombreAgenda, Integer idTarea, LocalDate fechaTarea, LocalDate fechaFin, String tipoTarea, String descripcionTarea, String asistentes, String prioridadTarea) {
        super(idAgenda, idUsuarioAgenda, TareasAgenda, nombreAgenda);
        this.idTarea = idTarea;
        this.fechaTarea = fechaTarea;
        this.fechaFin = fechaFin;
        this.tipoTarea = tipoTarea;
        this.descripcionTarea = descripcionTarea;
        this.asistentes = asistentes;
        this.prioridadTarea = prioridadTarea;
    }

    public Tarea(Integer idAgenda, Integer idUsuarioAgenda, ArrayList<Tarea> TareasAgenda, String nombreAgenda,
                 LocalDate fechaTarea, LocalDate fechaFin, String tipoTarea, String descripcionTarea,
                 boolean checkTarea, String organizadorTarea, String prioridadTarea) {
        super(idAgenda, idUsuarioAgenda, TareasAgenda, nombreAgenda);
        this.fechaTarea = fechaTarea;
        this.fechaFin = fechaFin;
        this.tipoTarea = tipoTarea;
        this.descripcionTarea = descripcionTarea;
        this.prioridadTarea = prioridadTarea;
    }

    public Tarea() {
    }

    public Tarea(int idTarea1, String descripcionTarea, LocalDate fechaTarea, LocalDate fechaFin, String tipoTarea, String prioridadTarea) {
        this.idTarea = idTarea1;
        this.fechaTarea = fechaTarea;
        this.fechaFin = fechaFin;
        this.tipoTarea = tipoTarea;
        this.descripcionTarea = descripcionTarea;
        this.prioridadTarea = prioridadTarea;
    }

    public Tarea(String descripcion, int idtarea, LocalDate fechaInicio, LocalDate fechafin, String tipo, String asistente, String prioridad) {
        idTarea = idtarea;
        fechaTarea = fechaInicio;
        fechaFin = fechafin;
        tipoTarea = tipo;
        descripcionTarea = descripcion;
        asistentes=asistente;
        prioridadTarea = prioridad;
    }

    /*Getters y setters*/

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public LocalDate getFechaTarea() {
        return fechaTarea;
    }

    public void setFechaTarea(LocalDate fechaTarea) {
        this.fechaTarea = fechaTarea;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public String getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(String asistentes) {
        this.asistentes = asistentes;
    }

    public String getPrioridadTarea() {
        return prioridadTarea;
    }

    public void setPrioridadTarea(String prioridadTarea) {
        this.prioridadTarea = prioridadTarea;
    }

    /*funciones */
    private boolean CrearTarea(){
        boolean verificacion = false;
        return verificacion;
    }
    private boolean BorrarTarea(){
        boolean verificacion = false;
        return verificacion;
    }
    private boolean EditarTarea(){
        boolean verificacion = false;
        return verificacion;
    }
    private boolean CompartirTarea(){
        boolean verificacion = false;
        return verificacion;
    }
}
