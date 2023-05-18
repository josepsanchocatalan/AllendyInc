package com.example.allendy;

import java.util.HashMap;

public class Usuario {

    private Integer IdUsuario;
    private String Nombre;
    private String NickName;
    private String Email;
    private String Password;

    private HashMap<Usuario, Rol> Rol;

/*  constructores */

    public Usuario(Integer idUsuario, String nombre, String nickName, String email, String password, HashMap<Usuario, com.example.allendy.Rol> rol) {
        IdUsuario = idUsuario;
        Nombre = nombre;
        NickName = nickName;
        Email = email;
        Password = password;
        Rol = rol;
    }

    /* getters y setters*/
    public Usuario() {
    }

    public HashMap<Usuario, com.example.allendy.Rol> getRol() {
        return Rol;
    }

    public void setRol(HashMap<Usuario, com.example.allendy.Rol> rol) {
        Rol = rol;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    /* funciones */
    private boolean Loguin(){
        boolean verificacion = false;
        return verificacion;
    }
    private boolean registro(){
        boolean verificacion = false;
        return verificacion;
    }
    private boolean cambiarPassword(){
        boolean verificacion = false;
        return verificacion;
    }
    private boolean BorrarUsuario(){
        boolean verificacion = false;
        return verificacion;
    }
}
