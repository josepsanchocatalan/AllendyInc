package com.example.allendy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SigninController {

    @javafx.fxml.FXML
    private TextField password;
    @javafx.fxml.FXML
    private TextField correoElectronico;
    @javafx.fxml.FXML
    private TextField nombreCompleto;
    @javafx.fxml.FXML
    private TextField nombreUsuario;
    @javafx.fxml.FXML
    private TextField passwordYes;
    @javafx.fxml.FXML
    private Button botonRegistrar;
    @javafx.fxml.FXML
    private CheckBox Terminos;
    @javafx.fxml.FXML
    private Button botonYaRegistrado;
    @javafx.fxml.FXML
    private Label welcomeText;
    @javafx.fxml.FXML
    private Pane paneRegistro;


    public void vueltaLoguin(javafx.event.ActionEvent actionEvent) {

        PrincipalController principal = new PrincipalController();
        principal.changeToLogin();

    }

    public void onRegistroButton(ActionEvent actionEvent) {
        String correo = correoElectronico.getText();
        String nCompleto = nombreCompleto.getText();
        String nUsuario = nombreUsuario.getText();
        String pass = password.getText();
        Usuario a = new Usuario(nCompleto,nUsuario,pass,correo,"user");


    }
}
