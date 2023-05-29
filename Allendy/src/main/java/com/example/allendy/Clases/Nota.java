package com.example.allendy.Clases;

public class Nota {

    private Integer IdNota;
    private Usuario IdUsuarioNota;
    private String Nombre;

    private String Descripcion;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    /*constructor*/
    public Nota() {
    }
    public Nota(Integer idNota, Usuario idUsuarioNota, String nombre, String descripcion) {
        IdNota = idNota;
        IdUsuarioNota = idUsuarioNota;
        Nombre = nombre;
        Descripcion = descripcion;
    }
    public Nota (Usuario idUsuarioNota, String nombre, String descripcion){
        IdUsuarioNota = idUsuarioNota;
        Nombre = nombre;
        Descripcion = descripcion;
    }
    public Nota(Integer idNota, Usuario idUsuarioNota, String nombre) {
        IdNota = idNota;
        IdUsuarioNota = idUsuarioNota;
        Nombre = nombre;
    }

    public Nota(String text) {
    Descripcion=text;
    }

    /*Getters y setters*/
    public Integer getIdNota() {
        return IdNota;
    }

    public void setIdNota(Integer idNota) {
        IdNota = idNota;
    }

    public Usuario getIdUsuarioNota() {
        return IdUsuarioNota;
    }

    public void setIdUsuarioNota(Usuario idUsuarioNota) {
        IdUsuarioNota = idUsuarioNota;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    /*funciones*/
    private boolean CrearNota(){
        boolean verificacion = false;
        return verificacion;
    }
    private boolean BorrarNota(){
        boolean verificacion = false;
        return verificacion;
    }
    private boolean EditarNota(){
        boolean verificacion = false;
        return verificacion;
    }
    private boolean CompartirNota(){
        boolean verificacion = false;
        return verificacion;
    }
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
