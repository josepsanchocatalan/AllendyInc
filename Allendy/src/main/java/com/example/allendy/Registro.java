package com.example.allendy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Registro {

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

        try {
            Pane vueltaInicio = FXMLLoader.load(getClass().getResource("login.fxml"));
            this.paneRegistro.getChildren().setAll(vueltaInicio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void onRegistroButton(ActionEvent actionEvent) {
        String correo = correoElectronico.getText();
        String nCompleto = nombreCompleto.getText();
        String nUsuario = nombreUsuario.getText();
        String pass = password.getText();
        Usuario a = new Usuario(nCompleto,nUsuario,pass,correo,"user");
        UsuarioModel.InsertarUsuario(a);
    }
    
}
