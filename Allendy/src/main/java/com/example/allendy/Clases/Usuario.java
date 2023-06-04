package com.example.allendy.Clases;

import java.util.HashMap;

/**
 * Clase que representa a un usuario.
 */
public class Usuario {

    private Integer IdUsuario;
    private String Nombre;
    private String NickName;
    private String Email;
    private String Password;
    private String Rol;

    /**
     * Constructor de Usuario con los parámetros de nickname, email y password.
     *
     * @param nickName Nickname del usuario
     * @param email    Email del usuario
     * @param password Contraseña del usuario
     */
    public Usuario(String nickName, String email, String password) {
        this.Email = email;
        this.NickName = nickName;
        this.Password = password;
    }

    /**
     * Constructor de Usuario con todos los parámetros.
     *
     * @param nombre   Nombre del usuario
     * @param nickName Nickname del usuario
     * @param password Contraseña del usuario
     * @param email    Email del usuario
     * @param rol      Rol del usuario
     */
    public Usuario(String nombre, String nickName, String password, String email, String rol) {
        Nombre = nombre;
        NickName = nickName;
        Email = email;
        Password = password;
        Rol = rol;
    }

    /**
     * Constructor vacío de Usuario.
     */
    public Usuario() {
    }

    /**
     * Constructor de Usuario con todos los parámetros.
     *
     * @param idUsuario ID del usuario
     * @param nombre    Nombre del usuario
     * @param nickname  Nickname del usuario
     * @param password  Contraseña del usuario
     * @param email     Email del usuario
     * @param rol       Rol del usuario
     */
    public Usuario(int idUsuario, String nombre, String nickname, String password, String email, String rol) {
        this.IdUsuario = idUsuario;
        Nombre = nombre;
        NickName = nickname;
        Email = email;
        Password = password;
        Rol = rol;
    }

    /**
     * Obtiene el rol del usuario.
     *
     * @return Rol del usuario
     */
    public String getRol() {
        return Rol;
    }

    /**
     * Establece el rol del usuario.
     *
     * @param rol Rol del usuario
     */
    public void setRol(String rol) {
        Rol = rol;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return ID del usuario
     */
    public Integer getIdUsuario() {
        return IdUsuario;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param idUsuario ID del usuario
     */
    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre Nombre del usuario
     */
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    /**
     * Obtiene el nickname del usuario.
     *
     * @return Nickname del usuario
     */
    public String getNickName() {
        return NickName;
    }

    /**
     * Establece el nickname del usuario.
     *
     * @param nickName Nickname del usuario
     */
    public void setNickName(String nickName) {
        NickName = nickName;
    }

    /**
     * Obtiene el email del usuario.
     *
     * @return Email del usuario
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Establece el email del usuario.
     *
     * @param email Email del usuario
     */
    public void setEmail(String email) {
        Email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password Contraseña del usuario
     */
    public void setPassword(String password) {
        Password = password;
    }


}
