package com.example.allendy;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class principalController {
    @javafx.fxml.FXML
    private Label welcomeText;
    @javafx.fxml.FXML
    private Button botonInicio;
    @javafx.fxml.FXML
    private Button botonRegistro;
    @javafx.fxml.FXML
    private Pane panePrincipal;

    public void onAccesInicio(javafx.event.ActionEvent actionEvent) {

        try {
            Pane inicio = FXMLLoader.load(getClass().getResource("login.fxml"));
            this.panePrincipal.getChildren().setAll(inicio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void onAccesRegistro(javafx.event.ActionEvent actionEvent) {

        try {
            Pane registro = FXMLLoader.load(getClass().getResource("registro.fxml"));
            this.panePrincipal.getChildren().setAll(registro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
