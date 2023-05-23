package com.example.allendy;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalController {

    @javafx.fxml.FXML
    private Pane rootPane;

    public void initialize(){

        changeToBienvenida();

    }

    public void changeToLogin(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void changeToSignin(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("Signin.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void changeToBienvenida(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("Bienvenida.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
