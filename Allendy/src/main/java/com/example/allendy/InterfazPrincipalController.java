package com.example.allendy;


import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Nota;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;


public class InterfazPrincipalController {

    private ObservableList<Nota> notas;


    //variables
    dataSingelton data=dataSingelton.getInstance();

    Usuario a = data.getUsuario();

    Agenda nuevaAgenda= new Agenda();

    ArrayList<Tarea> listaTareas=new ArrayList<Tarea>();
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
    private TextArea DescNota;
    @javafx.fxml.FXML
    private Button BotonGuardarNota;
    @javafx.fxml.FXML
    private TableView tablaNotas;
    @javafx.fxml.FXML
    private TextField NombreNota;
    @javafx.fxml.FXML
    private TableView TablaTareas;
    @javafx.fxml.FXML
    private RadioButton checkTrabajo;
    @javafx.fxml.FXML
    private RadioButton checkOcio;
    @javafx.fxml.FXML
    private RadioButton CheckFamilia;
    @javafx.fxml.FXML
    private RadioButton checkVacaciones;


    //funciones

    @Deprecated
    public void initialice(ActionEvent actionEvent) {
        Calendario.show();
        notas = FXCollections.observableArrayList();
        tablaNotas.setItems(notas);
        tablaNotas.setRowFactory(new PropertyValueFactory<>("Descripcion"));
    }
    @Deprecated
    public void insertar(ActionEvent actionEvent) {
        Nota nota = new Nota(DescNota.getText());
        if (!notas.contains(nota)) {
            notas.add(nota);
            tablaNotas.refresh();
        }

    }

    @Deprecated
    public void OnBotonCrearAgenda(ActionEvent actionEvent) {

       // nuevaAgenda=new Agenda(a.getIdUsuario(),nombreAgenda, listaTareas,);






    }

    @Deprecated
    public void onBotonEditarAgenda(ActionEvent actionEvent) {


    }

    @Deprecated
    public void onBotonNuevaTarea(ActionEvent actionEvent) {
        TextInputDialog tid = new TextInputDialog();
        tid.setHeaderText(null);
        tid.setTitle("Insertar nombre Agenda");
        tid.setContentText("");
        tid.showAndWait();

    }

    @javafx.fxml.FXML
    public void datepickerFuncion(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onBotonEditarTarea(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onBontonBorrarTarea(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onBotonGuardraNota(ActionEvent actionEvent) {
    }


