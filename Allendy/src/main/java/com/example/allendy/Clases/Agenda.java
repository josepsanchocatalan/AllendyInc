package com.example.allendy.Clases;

import java.util.ArrayList;

public class Agenda {

    private Integer IdAgenda;
    private Integer IdUsuarioAgenda;
    private ArrayList<Tarea> TareasAgenda;
    private String NombreAgenda;

    /*constructores*/
    public Agenda(Integer idAgenda, Integer idUsuarioAgenda, ArrayList<Tarea> TareasAgenda, String nombreAgenda) {
        this.IdAgenda = idAgenda;
        this.IdUsuarioAgenda = idUsuarioAgenda;
        this.TareasAgenda = TareasAgenda;
        NombreAgenda = nombreAgenda;
    }
    public Agenda(Integer idUsuarioAgenda, ArrayList<Tarea> listaTareas, String nombreAgenda) {
        this.IdUsuarioAgenda = idUsuarioAgenda;
        this.TareasAgenda = TareasAgenda;
        NombreAgenda = nombreAgenda;
    }
    public Agenda() {

    }


    /*getters y setters*/

    public Integer getIdAgenda() {
        return IdAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.IdAgenda = idAgenda;
    }

    public Integer getIdUsuarioAgenda() {
        return IdUsuarioAgenda;
    }

    public void setIdUsuarioAgenda(Integer idUsuarioAgenda) {
        this.IdUsuarioAgenda = idUsuarioAgenda;
    }

    public ArrayList<Tarea>  getTareaAgenda() {
        return TareasAgenda;
    }

    public void setTareaAgenda(ArrayList<Tarea> idTareaAgenda) {
        this.TareasAgenda = idTareaAgenda;
    }

    public String getNombreAgenda() {
        return NombreAgenda;
    }

    public void setNombreAgenda(String nombreAgenda) {
        NombreAgenda = nombreAgenda;
    }

    /*funciones*/



}


