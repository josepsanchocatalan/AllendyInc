package com.example.allendy;

import java.util.ArrayList;
import java.util.Date;

public class Tarea extends Agenda {

    private Integer IdTarea;
    private Agenda IdAgendaTarea;
    private Usuario IdUsuarioTarea;
    private Date FechaTarea;
    private Date FechaFin;
    private System TipoTarea;
    private String DescripcionTarea;
    private boolean CheckTarea;
    private ArrayList<Usuario> Asistentes;
    private Date OrganizadorTarea;
    private String PrioridadTarea;

    /*constructores*/

    public Tarea() {
    }

    public Tarea(Integer idTarea, Agenda idAgendaTarea, Usuario idUsuarioTarea, Date fechaTarea, Date fechaFin, System tipoTarea, String descripcionTarea, boolean checkTarea, ArrayList<Usuario> asistentes, Date organizadorTarea, String prioridadTarea) {
        IdTarea = idTarea;
        IdAgendaTarea = idAgendaTarea;
        IdUsuarioTarea = idUsuarioTarea;
        FechaTarea = fechaTarea;
        FechaFin = fechaFin;
        TipoTarea = tipoTarea;
        DescripcionTarea = descripcionTarea;
        CheckTarea = checkTarea;
        Asistentes = asistentes;
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

    public Agenda getIdAgendaTarea() {
        return IdAgendaTarea;
    }

    public void setIdAgendaTarea(Agenda idAgendaTarea) {
        IdAgendaTarea = idAgendaTarea;
    }

    public Usuario getIdUsuarioTarea() {
        return IdUsuarioTarea;
    }

    public void setIdUsuarioTarea(Usuario idUsuarioTarea) {
        IdUsuarioTarea = idUsuarioTarea;
    }

    public Date getFechaTarea() {
        return FechaTarea;
    }

    public void setFechaTarea(Date fechaTarea) {
        FechaTarea = fechaTarea;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }

    public System getTipoTarea() {
        return TipoTarea;
    }

    public void setTipoTarea(System tipoTarea) {
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

    public Date getOrganizadorTarea() {
        return OrganizadorTarea;
    }

    public void setOrganizadorTarea(Date organizadorTarea) {
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
