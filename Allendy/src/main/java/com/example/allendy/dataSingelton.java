package com.example.allendy;


import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;

public class dataSingelton {
    private static final dataSingelton instance = new dataSingelton();

    private Usuario usuario;



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


}
