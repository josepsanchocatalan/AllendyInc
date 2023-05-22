package com.example.allendy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Agenda {

    private Integer IdAgenda;
    private Integer IdUsuarioAgenda;
    private Integer IdTareaAgenda;
    private String NombreAgenda;

    /*constructores*/
    public Agenda() {
    }

    public Agenda(Integer idAgenda, Integer idUsuarioAgenda, Integer idTareaAgenda, String nombreAgenda) {
        this.IdAgenda = idAgenda;
        this.IdUsuarioAgenda = idUsuarioAgenda;
        this.IdTareaAgenda = idTareaAgenda;
        NombreAgenda = nombreAgenda;
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

    public Integer getIdTareaAgenda() {
        return IdTareaAgenda;
    }

    public void setIdTareaAgenda(Integer idTareaAgenda) {
        this.IdTareaAgenda = idTareaAgenda;
    }

    public String getNombreAgenda() {
        return NombreAgenda;
    }

    public void setNombreAgenda(String nombreAgenda) {
        NombreAgenda = nombreAgenda;
    }

    /*funciones*/



}
