package com.example.allendy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

    @javafx.fxml.FXML
    private TextField correoElectronico;
    @javafx.fxml.FXML
    private TextField password;
    @javafx.fxml.FXML
    private Button botonRegistrar;
    @javafx.fxml.FXML
    private Button OlvidoContrasenya;
    @javafx.fxml.FXML
    private Label welcomeText;

    @javafx.fxml.FXML
    public void onLoginButton(ActionEvent actionEvent) {
        String mail = correoElectronico.getText();
        String pasword = password.getText();

        Usuario u1 = new Usuario(null, mail, pasword);
        UsuarioModel b = new UsuarioModel();

        if (b.ComprobarUsuarioLogin(u1) == true){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Estas en la database");
            alert.setHeaderText("Estas en la database");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("noestas en la database");
            alert.setHeaderText("noestas en la database");
            alert.showAndWait();
        }

    }
    //Esta funcion sierve para cargar la pagina signin y cerrar la actual
    @javafx.fxml.FXML
    public void onVueltaSignIn(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Signin.fxml"));

            Parent root = loader.load();

            SigninController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.botonRegistrar.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
