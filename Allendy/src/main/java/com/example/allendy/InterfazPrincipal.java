package com.example.allendy;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class InterfazPrincipal {
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


    //variables

    @javafx.fxml.FXML
    public void initialice(ActionEvent actionEvent) {
        Calendario.show();

    }

    @javafx.fxml.FXML
    public void OnBotonCrearAgenda(ActionEvent actionEvent) {




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
