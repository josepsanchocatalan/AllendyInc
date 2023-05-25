package com.example.allendy;

import java.util.ArrayList;

public class Agenda {

    private Integer IdAgenda;
    private Integer IdUsuarioAgenda;
    private Tarea[] TareasAgenda;
    private String NombreAgenda;

    /*constructores*/
    public Agenda(Integer idAgenda, Integer idUsuarioAgenda, Tarea[] TareasAgenda, String nombreAgenda) {
        this.IdAgenda = idAgenda;
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

    public Tarea[] getIdTareaAgenda() {
        return TareasAgenda;
    }

    public void setIdTareaAgenda(Tarea[] idTareaAgenda) {
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
