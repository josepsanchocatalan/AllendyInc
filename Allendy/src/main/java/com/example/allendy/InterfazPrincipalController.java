package com.example.allendy;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;


public class InterfazPrincipalController extends LoginController {
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
    private TableView TablaTareas;
    @javafx.fxml.FXML
    private TextArea DescripcionNota;
    @javafx.fxml.FXML
    private TextField NombreNota;
    @javafx.fxml.FXML
    private RadioButton checkTrabajo;
    @javafx.fxml.FXML
    private RadioButton checkOcio;
    @javafx.fxml.FXML
    private RadioButton CheckFamilia;
    @javafx.fxml.FXML
    private RadioButton checkVacaciones;
    @javafx.fxml.FXML
    private TableView tablaNotas;
    @javafx.fxml.FXML
    private Button BotonGuardarNota;
    @javafx.fxml.FXML
    private TableColumn<Nota,String> DescNota;

    private ObservableList<Nota> notas;



    //variables




    //funciones

    @javafx.fxml.FXML
    public void initialize(ActionEvent actionEvent) {
        Calendario.show();
        notas = FXCollections.observableArrayList();
        tablaNotas.setItems(notas);
        DescNota.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));
    }
    @javafx.fxml.FXML
    public void insertar(ActionEvent actionEvent) {
        Nota a = new Nota(DescripcionNota.getText());
        if (!notas.contains(a)) {
            notas.add(a);
            tablaNotas.refresh();
        }
    }

    @javafx.fxml.FXML
    public void OnBotonCrearAgenda(ActionEvent actionEvent) {

        TextInputDialog tid = new TextInputDialog();
        tid.setHeaderText(null);
        tid.setTitle("Insertar nombre Agenda");
        tid.setContentText("");
        tid.showAndWait();
        String nombreAgenda = tid.getDefaultValue();

        LoginController log = new LoginController();
        log.onLoginButton();




    }

    @javafx.fxml.FXML
    public void onBotonEditarAgenda(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void onBotonNuevaTarea(ActionEvent actionEvent) {
        TextInputDialog tid = new TextInputDialog();
        tid.setHeaderText(null);
        tid.setTitle("Insertar nombre Agenda");
        tid.setContentText("");
        tid.showAndWait();








    }

    @javafx.fxml.FXML
    public void onBotonEditarTarea(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onBontonBorrarTarea(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void onBorrarAgenda(ActionEvent actionEvent) {
    }


}
