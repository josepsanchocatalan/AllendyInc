package com.example.allendy;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class InicioSesion {

    @javafx.fxml.FXML
    private TextField correoElectronico;
    @javafx.fxml.FXML
    private TextField password;
    @javafx.fxml.FXML
    private Button botonRegistrar;
    @javafx.fxml.FXML
    private Button OlvidoContrasenya;
    @javafx.fxml.FXML
    private Button BotonNoRegistrado;
    @javafx.fxml.FXML
    private Label welcomeText;
    private Pane pane;
    @javafx.fxml.FXML
    private Pane paneInicio;


    public void onLoginButton(javafx.event.ActionEvent actionEvent) {
        String mail= correoElectronico.getText();
        String pasword= password.getText();

        Usuario a = new Usuario(mail,pasword);
        UsuarioModel b= new UsuarioModel();

        b.RecuperarUsuario(a);
    }

    public void vueltaSignIn(javafx.event.ActionEvent actionEvent) {

        try {
            Pane vueltaRegistro = FXMLLoader.load(getClass().getResource("registro.fxml"));
            this.pane.getChildren().setAll(vueltaRegistro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
