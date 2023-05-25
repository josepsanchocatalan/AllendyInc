package com.example.allendy;


public class UsuarioHolder {

    private Usuario usuario;
public static final UsuarioHolder INSTANCE = new UsuarioHolder();

public static UsuarioHolder getInstance(){
    return INSTANCE;
}
}
