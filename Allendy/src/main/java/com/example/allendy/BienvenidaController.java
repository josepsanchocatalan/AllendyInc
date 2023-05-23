package com.example.allendy;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BienvenidaController {
    @javafx.fxml.FXML
    private Label welcomeText;
    @javafx.fxml.FXML
    private Button botonInicio;
    @javafx.fxml.FXML
    private Button botonRegistro;
    @javafx.fxml.FXML
    private Pane panePrincipal;


    // FUNCION PARA IR AL LOGIN
    public void onAccesInicio(javafx.event.ActionEvent actionEvent) {

        PrincipalController principal = new PrincipalController();
        principal.changeToLogin();

    }
    public void onAccesRegistro(javafx.event.ActionEvent actionEvent) {

        PrincipalController principal = new PrincipalController();
        principal.changeToSignin();

    }
}
