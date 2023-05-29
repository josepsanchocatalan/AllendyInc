package com.example.allendy.Clases;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Tarea extends Agenda {


    private Integer IdTarea;
    private LocalDate FechaTarea;
    private LocalDate FechaFin;
    private String TipoTarea;
    private String DescripcionTarea;
    private boolean CheckTarea;
    private ArrayList<Usuario> Asistentes;
    private String OrganizadorTarea;
    private String PrioridadTarea;


    /*constructores*/

    public Tarea(Integer idAgenda, Integer idUsuarioAgenda, ArrayList<Tarea>  TareasAgenda, String nombreAgenda, Integer idTarea, LocalDate fechaTarea, LocalDate fechaFin, String tipoTarea, String descripcionTarea, boolean checkTarea, ArrayList<Usuario> asistentes, String organizadorTarea, String prioridadTarea) {
        super(idAgenda, idUsuarioAgenda, TareasAgenda, nombreAgenda);
        IdTarea = idTarea;
        FechaTarea = fechaTarea;
        FechaFin = fechaFin;
        TipoTarea = tipoTarea;
        DescripcionTarea = descripcionTarea;
        CheckTarea = checkTarea;
        Asistentes = asistentes;
        OrganizadorTarea = organizadorTarea;
        PrioridadTarea = prioridadTarea;
    }

    public Tarea(Integer idAgenda, Integer idUsuarioAgenda, ArrayList<Tarea>  TareasAgenda, String nombreAgenda, LocalDate fechaTarea, LocalDate fechaFin, String tipoTarea, String descripcionTarea, boolean checkTarea, String organizadorTarea, String prioridadTarea) {
        super(idAgenda, idUsuarioAgenda, TareasAgenda, nombreAgenda);

        FechaTarea = fechaTarea;
        FechaFin = fechaFin;
        TipoTarea = tipoTarea;
        DescripcionTarea = descripcionTarea;
        CheckTarea = checkTarea;

        OrganizadorTarea = organizadorTarea;
        PrioridadTarea = prioridadTarea;
    }






    /*Getters y setters*/

    public Integer getIdTarea() {
        return IdTarea;
    }

    public void setIdTarea(Integer idTarea) {
        IdTarea = idTarea;
    }

    public LocalDate getFechaTarea() {
        return FechaTarea;
    }

    public void setFechaTarea(LocalDate fechaTarea) {
        FechaTarea = fechaTarea;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }

    public String getTipoTarea() {
        return TipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        TipoTarea = tipoTarea;
    }

    public String getDescripcionTarea() {
        return DescripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        DescripcionTarea = descripcionTarea;
    }

    public boolean isCheckTarea() {
        return CheckTarea;
    }

    public void setCheckTarea(boolean checkTarea) {
        CheckTarea = checkTarea;
    }

    public ArrayList<Usuario> getAsistentes() {
        return Asistentes;
    }

    public void setAsistentes(ArrayList<Usuario> asistentes) {
        Asistentes = asistentes;
    }

    public String getOrganizadorTarea() {
        return OrganizadorTarea;
    }

    public void setOrganizadorTarea(String organizadorTarea) {
        OrganizadorTarea = organizadorTarea;
    }

    public String getPrioridadTarea() {
        return PrioridadTarea;
    }

    public void setPrioridadTarea(String prioridadTarea) {
        PrioridadTarea = prioridadTarea;
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
