package com.example.allendy;

<<<<<<< HEAD:Allendy/src/main/java/com/example/allendy/InterfazPrincipalController.java
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
=======
import javafx.scene.control.*;
>>>>>>> RamaFRan:Allendy/src/main/java/com/example/allendy/InterfazPrincipal.java

public class InterfazPrincipalController {
    @javafx.fxml.FXML
    private DatePicker Calendario;
    @javafx.fxml.FXML
    private Button BotonCrearAgenda;
    @javafx.fxml.FXML
    private Button BotonEditarAgenda;
    @javafx.fxml.FXML
    private Button BotonBorrarAgenda;
    @javafx.fxml.FXML
    private Button BotonNuevaTarea;
    @javafx.fxml.FXML
    private Button botonEditarTarea;
    @javafx.fxml.FXML
    private Button BotonBorrarTarea;
    @javafx.fxml.FXML
    private CheckBox checkTrabajo;
    @javafx.fxml.FXML
    private CheckBox checkOcio;
    @javafx.fxml.FXML
    private CheckBox CheckFamilia;
    @javafx.fxml.FXML
    private CheckBox checkVacaciones;
    @javafx.fxml.FXML
    private TableView TablaTareas;

<<<<<<< HEAD:Allendy/src/main/java/com/example/allendy/InterfazPrincipalController.java
=======




    //variables




    //funciones
>>>>>>> RamaFRan:Allendy/src/main/java/com/example/allendy/InterfazPrincipal.java
    @javafx.fxml.FXML
    public void initialice(ActionEvent actionEvent) {
        Calendario.show();
    }

    @javafx.fxml.FXML
    public void OnBotonCrearAgenda(ActionEvent actionEvent) {
<<<<<<< HEAD:Allendy/src/main/java/com/example/allendy/InterfazPrincipalController.java
=======


        Agenda a = new Agenda();
        UsuarioModel b = new UsuarioModel();





        TextInputDialog tid = new TextInputDialog();
        tid.setHeaderText(null);
        tid.setTitle("Insertar");
        tid.setContentText("Introduce un valor");
        tid.showAndWait();
        String nombreAgenda = tid.getDefaultValue();






>>>>>>> RamaFRan:Allendy/src/main/java/com/example/allendy/InterfazPrincipal.java
    }

    @javafx.fxml.FXML
    public void onBotonEditarAgenda(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onBotonNuevaTarea(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onBotonEditarTarea(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onBontonBorrarTarea(ActionEvent actionEvent) {
    }
}
