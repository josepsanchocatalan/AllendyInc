package com.example.allendy;

import com.example.allendy.Clases.Usuario;

/**
 * Clase singleton para almacenar datos de usuario en la aplicación.
 */
public class dataSingelton {
    private static final dataSingelton instance = new dataSingelton();

    private Usuario usuario;

    /**
     * Devuelve la instancia única de la clase `dataSingelton`.
     *
     * @return La instancia única de la clase.
     */
    public static dataSingelton getInstance(){
        return instance;
    }

    /**
     * Devuelve el objeto `Usuario` almacenado en el singleton.
     *
     * @return El objeto `Usuario`.
     */
    public Usuario getUsuario() {
        return this.usuario;
    }

    /**
     * Establece el objeto `Usuario` en el singleton.
     *
     * @param usuario El objeto `Usuario` a establecer.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
