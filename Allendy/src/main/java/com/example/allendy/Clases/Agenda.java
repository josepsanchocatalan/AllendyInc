package com.example.allendy.Clases;

import java.util.ArrayList;
/**
 * Esta es la clase "Agenda" que representa una agenda con tareas para un usuario.
 */
public class Agenda {

    private Integer IdAgenda;
    private Integer IdUsuarioAgenda;
    private ArrayList<Tarea> TareasAgenda;
    private String NombreAgenda;
    /**
     * Constructor de la clase Agenda.
     * @param idAgenda El ID de la agenda.
     * @param idUsuarioAgenda El ID del usuario asociado a la agenda.
     * @param TareasAgenda La lista de tareas de la agenda.
     * @param nombreAgenda El nombre de la agenda.
     */
    /*constructores*/
    public Agenda(Integer idAgenda, Integer idUsuarioAgenda, ArrayList<Tarea> TareasAgenda, String nombreAgenda) {
        this.IdAgenda = idAgenda;
        this.IdUsuarioAgenda = idUsuarioAgenda;
        this.TareasAgenda = TareasAgenda;
        NombreAgenda = nombreAgenda;
    }
    /**
     * Constructor de la clase Agenda.
     * @param idUsuarioAgenda El ID del usuario asociado a la agenda.
     * @param listaTareas La lista de tareas de la agenda.
     * @param nombreAgenda El nombre de la agenda.
     */
    public Agenda(Integer idUsuarioAgenda, ArrayList<Tarea> listaTareas, String nombreAgenda) {
        this.IdUsuarioAgenda = idUsuarioAgenda;
        this.TareasAgenda = TareasAgenda;
        NombreAgenda = nombreAgenda;
    }
    //Esto es de fran
    /**
     * Constructor de la clase Agenda.
     * @param idUsuarioAgenda El ID del usuario asociado a la agenda.
     * @param nombreAgenda El nombre de la agenda.
     */
    public Agenda(Integer idUsuarioAgenda,  String nombreAgenda) {
        this.IdUsuarioAgenda = idUsuarioAgenda;
        this.NombreAgenda = nombreAgenda;
    }
    /**
     * Constructor de la clase Agenda.
     * @param idAgenda El ID de la agenda.
     * @param idUsuarioAgenda El ID del usuario asociado a la agenda.
     * @param nombreAgenda El nombre de la agenda.
     */
    //Esto es de fran
    public Agenda(Integer idAgenda, Integer idUsuarioAgenda,  String nombreAgenda) {
        this.IdAgenda = idAgenda;
        this.IdUsuarioAgenda = idUsuarioAgenda;
        this.NombreAgenda = nombreAgenda;
    }
    /**
     * Constructor vacío de la clase Agenda.
     */
    public Agenda() {

    }

    /*getters y setters*/
    /**
     * Obtiene el ID de la agenda.
     * @return El ID de la agenda.
     */
    public Integer getIdAgenda() {
        return IdAgenda;
    }
    /**
     * Establece el ID de la agenda.
     * @param idAgenda El nuevo ID de la agenda.
     */
    public void setIdAgenda(Integer idAgenda) {
        this.IdAgenda = idAgenda;
    }
    /**
     * Obtiene el ID del usuario asociado a la agenda.
     * @return El ID del usuario asociado a la agenda.
     */
    public Integer getIdUsuarioAgenda() {
        return IdUsuarioAgenda;
    }
    /**
     * Establece el ID del usuario asociado a la agenda.
     * @param idUsuarioAgenda El nuevo ID del usuario asociado a la agenda.
     */
    public void setIdUsuarioAgenda(Integer idUsuarioAgenda) {
        this.IdUsuarioAgenda = idUsuarioAgenda;
    }
    /**
     * Obtiene el ID del usuario asociado a la agenda.
     * @return El ID del usuario asociado a la agenda.
     */
    public ArrayList<Tarea>  getTareaAgenda() {
        return TareasAgenda;
    }
    /**
     * Establece la lista de tareas de la agenda.
     * @param idTareaAgenda La nueva lista de tareas de la agenda.
     */
    public void setTareaAgenda(ArrayList<Tarea> idTareaAgenda) {
        this.TareasAgenda = idTareaAgenda;
    }
    /**
     * Obtiene el nombre de la agenda.
     * @return El nombre de la agenda.
     */
    public String getNombreAgenda() {
        return NombreAgenda;
    }
    /**
     * Establece el nombre de la agenda.
     * @param nombreAgenda El nuevo nombre de la agenda.
     */
    public void setNombreAgenda(String nombreAgenda) {
        NombreAgenda = nombreAgenda;
    }





}


