package com.example.allendy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Label welcomeText;
    @javafx.fxml.FXML
    private Pane rootPane;
    @javafx.fxml.FXML
    private Button vueltaLogin;

    @javafx.fxml.FXML
    public void onRegistroButton(ActionEvent actionEvent) {
        String correo = correoElectronico.getText();
        String nCompleto = nombreCompleto.getText();
        String nUsuario = nombreUsuario.getText();
        String pass = password.getText();
        Usuario a = new Usuario(nCompleto,nUsuario,pass,correo,"user");
        UsuarioModel.InsertarUsuario(a);
    }
    //Esta funcion sirve para cargar la pagina loguin y cerrar la actual
    @javafx.fxml.FXML
    public void onVueltaLoguin(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));

            Parent root = loader.load();

            LoginController controller = loader.getController();

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
