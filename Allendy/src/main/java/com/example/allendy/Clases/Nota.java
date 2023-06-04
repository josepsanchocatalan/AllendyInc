package com.example.allendy.Clases;

/**
 * Esta es la clase "Nota" que representa una nota con un nombre, descripción y propietario.
 */
public class Nota {

    private Integer IdNota;
    private Usuario IdUsuarioNota;
    private String Nombre;
    private String Descripcion;

    /**
     * Constructor de la clase Nota.
     * @param idNota El ID de la nota.
     * @param nuevoNombre El nuevo nombre de la nota.
     * @param nuevaDesc La nueva descripción de la nota.
     */
    public Nota(Integer idNota ,String nuevoNombre, String nuevaDesc) {
        this.Nombre = nuevoNombre;
        this.Descripcion = nuevaDesc;
        this.IdNota = idNota;
    }

    /**
     * Constructor de la clase Nota.
     * @param nuevoNombre El nuevo nombre de la nota.
     * @param nuevaDesc La nueva descripción de la nota.
     */
    public Nota(String nuevoNombre, String nuevaDesc) {
        this.Nombre = nuevoNombre;
        this.Descripcion = nuevaDesc;
    }

    /**
     * Obtiene la descripción de la nota.
     * @return La descripción de la nota.
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * Establece la descripción de la nota.
     * @param descripcion La nueva descripción de la nota.
     */
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    /**
     * Constructor vacío de la clase Nota.
     */
    public Nota() {
    }

    /**
     * Constructor de la clase Nota.
     * @param idNota El ID de la nota.
     * @param idUsuarioNota El usuario propietario de la nota.
     * @param nombre El nombre de la nota.
     * @param descripcion La descripción de la nota.
     */
    public Nota(Integer idNota, Usuario idUsuarioNota, String nombre, String descripcion) {
        IdNota = idNota;
        IdUsuarioNota = idUsuarioNota;
        Nombre = nombre;
        Descripcion = descripcion;
    }

    /**
     * Constructor de la clase Nota.
     * @param idUsuarioNota El usuario propietario de la nota.
     * @param nombre El nombre de la nota.
     * @param descripcion La descripción de la nota.
     */
    public Nota (Usuario idUsuarioNota, String nombre, String descripcion){
        IdUsuarioNota = idUsuarioNota;
        Nombre = nombre;
        Descripcion = descripcion;
    }

    /**
     * Constructor de la clase Nota.
     * @param idNota El ID de la nota.
     * @param idUsuarioNota El usuario propietario de la nota.
     * @param nombre El nombre de la nota.
     */
    public Nota(Integer idNota, Usuario idUsuarioNota, String nombre) {
        IdNota = idNota;
        IdUsuarioNota = idUsuarioNota;
        Nombre = nombre;
    }

    /**
     * Constructor de la clase Nota.
     * @param text La descripción de la nota.
     */
    public Nota(String text) {
        Descripcion = text;
    }

    /**
     * Obtiene el ID de la nota.
     * @return El ID de la nota.
     */
    public Integer getIdNota() {
        return IdNota;
    }

    /**
     * Establece el ID de la nota.
     * @param idNota El nuevo ID de la nota.
     */
    public void setIdNota(Integer idNota) {
        IdNota = idNota;
    }

    /**
     * Obtiene el usuario propietario de la nota.
     * @return El usuario propietario de la nota.
     */
    public Usuario getIdUsuarioNota() {
        return IdUsuarioNota;
    }

    /**
     * Establece el usuario propietario de la nota.
     * @param idUsuarioNota El nuevo usuario propietario de la nota.
     */
    public void setIdUsuarioNota(Usuario idUsuarioNota) {
        IdUsuarioNota = idUsuarioNota;
    }

    /**
     * Obtiene el nombre de la nota.
     * @return El nombre de la nota.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Establece el nombre de la nota.
     * @param nombre El nuevo nombre de la nota.
     */
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    /**
     * Crea una nueva nota.
     * @return true si la nota se crea exitosamente, false de lo contrario.
     */
    private boolean CrearNota(){
        boolean verificacion = false;
        return verificacion;
    }

    /**
     * Borra la nota actual.
     * @return true si la nota se borra exitosamente, false de lo contrario.
     */
    private boolean BorrarNota(){
        boolean verificacion = false;
        return verificacion;
    }

    /**
     * Edita la nota actual.
     * @return true si la nota se edita exitosamente, false de lo contrario.
     */
    private boolean EditarNota(){
        boolean verificacion = false;
        return verificacion;
    }

    /**
     * Comparte la nota actual.
     * @return true si la nota se comparte exitosamente, false de lo contrario.
     */
    private boolean CompartirNota(){
        boolean verificacion = false;
        return verificacion;
    }

    /**
     * Verifica si dos objetos Nota son iguales.
     * @param o El objeto a comparar.
     * @return true si los objetos son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object o) {

        Nota other = (Nota) o;

        if(this == other)
            return true;
        if(other == null)
            return false;

        if(this.Nombre.equals(other.Nombre) &&
                this.Descripcion.equals(other.Descripcion))
        {
            return true;
        }
        else {
            return false;
        }
    }

}
