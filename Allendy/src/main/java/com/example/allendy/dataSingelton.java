package com.example.allendy;


import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;

public class dataSingelton {
    private static final dataSingelton instance = new dataSingelton();

    private Usuario usuario;

    private Agenda agenda;

    private Tarea tarea;


    //getters y setters

    public static dataSingelton getInstance(){
        return instance;

    }


    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

}
