package com.example.allendy.Clases;

import java.util.HashMap;

public class Usuario {

    private Integer IdUsuario;
    private String Nombre;
    private String NickName;
    private String Email;
    private String Password;
    private String Rol;

/*  constructores */

    public Usuario(String nickName, String email, String password) {
        this.Email = email;
        this.NickName = nickName;
        this.Password = password;
    }

    public Usuario( String nombre, String nickName, String password, String email,String rol) {
        Nombre = nombre;
        NickName = nickName;
        Email = email;
        Password = password;
        Rol = rol;
    }


    public Usuario() {
    }


    public Usuario(int idUsuario, String nombre, String nickname, String password, String email, String rol) {
        this.IdUsuario= idUsuario;
        Nombre = nombre;
        NickName = nickname;
        Email = email;
        Password = password;
        Rol = rol;
    }
    /* getters y setters*/

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
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
