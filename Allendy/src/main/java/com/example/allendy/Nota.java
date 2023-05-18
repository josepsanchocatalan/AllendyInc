package com.example.allendy;

public class Nota {

    private Integer IdNota;
    private Usuario IdUsuarioNota;
    private String Nombre;

    /*constructor*/
    public Nota() {
    }

    public Nota(Integer idNota, Usuario idUsuarioNota, String nombre) {
        IdNota = idNota;
        IdUsuarioNota = idUsuarioNota;
        Nombre = nombre;
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
}
