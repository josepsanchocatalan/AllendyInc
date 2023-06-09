package com.example.allendy;

import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.UsuarioModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador para la funcionalidad de registro de usuarios.
 */
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

    /**
     * Acción ejecutada al hacer clic en el botón de registro.
     *
     * @param actionEvent El evento de acción generado por el botón.
     */
    @javafx.fxml.FXML
    public void onRegistroButton(ActionEvent actionEvent) {
        String correo = correoElectronico.getText();
        String nCompleto = nombreCompleto.getText();
        String nUsuario = nombreUsuario.getText();
        String pass = password.getText();
        String pass2 = passwordYes.getText();

        if (pass.equals(pass2)) {
            Usuario u1 = new Usuario(nUsuario,correo, null);
            UsuarioModel um1 = new UsuarioModel();

            if(Terminos.isSelected()) {

                if (um1.ComprobarUsuarioRegistro(u1)){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setTitle("Advertencia");
                    alert.setContentText("El usuario ya está registrado");
                    alert.showAndWait();

                } else {
                    Usuario a = new Usuario(nCompleto,nUsuario,pass,correo,"user");
                    UsuarioModel.InsertarUsuario(a);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Información");
                    alert.setContentText("Usuario registrado exitosamente");
                    alert.showAndWait();

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

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Advertencia");
                alert.setContentText("Debes aceptar los términos y condiciones");
                alert.showAndWait();
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Advertencia");
            alert.setContentText("Las contraseñas deben coincidir");
            alert.showAndWait();
        }
    }

    /**
     * Carga la página de inicio de sesión y cierra la página actual.
     *
     * @param actionEvent El evento de acción generado por el botón.
     */
    @javafx.fxml.FXML
    public void onVueltaLogin(ActionEvent actionEvent) {
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
