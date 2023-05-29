package com.example.allendy;


import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Nota;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.NotaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;


public class InterfazPrincipalController {

    private ObservableList<Nota> notas;
    private ObservableList<Tarea> tareas;


    //variables
    dataSingelton data = dataSingelton.getInstance();

    Usuario a = data.getUsuario();

    Agenda nuevaAgenda = new Agenda();

    ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
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
    private RadioButton checkPrioridadAlta;
    @javafx.fxml.FXML
    private RadioButton checkPrioridadMedia;
    @javafx.fxml.FXML
    private RadioButton CheckPrioridadBAja;
    @javafx.fxml.FXML
    private ToggleGroup prioridad;
    @javafx.fxml.FXML
    private ToggleGroup TipoTarea;
    @javafx.fxml.FXML
    private TableColumn nombreNota;
    @javafx.fxml.FXML
    private TableColumn descripcionNota;
    @javafx.fxml.FXML
    private Button botonBorrar;
    @FXML
    private TableColumn descTarea;
    @FXML
    private TableColumn fechaInicio;
    @FXML
    private TableColumn fechaFin;
    @FXML
    private TableColumn hecho;
    @FXML
    private TableColumn asistentes;
    @FXML
    private TableColumn nTarea;


    //funciones

    @FXML
    public void initialize() {
        Calendario.show();
        notas = FXCollections.observableArrayList();
        tablaNotas.setItems(notas);
        nombreNota.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        descripcionNota.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));

        tareas = FXCollections.observableArrayList();
        TablaTareas.setItems(tareas);
        nTarea.setCellValueFactory(new PropertyValueFactory<>("Tarea"));
        descTarea.setCellValueFactory(new PropertyValueFactory<>("Descripción"));
        fechaInicio.setCellValueFactory(new PropertyValueFactory<>("Fecha Inicio"));
        fechaFin.setCellValueFactory(new PropertyValueFactory<>("Fecha Fin"));
        hecho.setCellValueFactory(new PropertyValueFactory<>("Hecho"));
        asistentes.setCellValueFactory(new PropertyValueFactory<>("Asistentes"));


    }

    @FXML
    public void insertar(ActionEvent actionEvent) {
        Nota nota = new Nota(DescNota.getText());
        if (!notas.contains(nota)) {
            notas.add(nota);
            tablaNotas.refresh();
        }

    }

    @FXML
    public void OnBotonCrearAgenda(ActionEvent actionEvent) {




    }

    @FXML
    public void onBotonEditarAgenda(ActionEvent actionEvent) {


    }

    @FXML
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
        Nota a = new Nota(data.getUsuario(),NombreNota.getText(),DescNota.getText());
        if (!notas.contains(a)) {
            notas.add(a);
            tablaNotas.refresh();
        }


        Usuario idUser = data.getUsuario();
        String nombre = NombreNota.getText();
        String desc = DescNota.getText();

        Nota n1 = new Nota(idUser,nombre,desc);
        NotaModel.InsertarNota(n1);
    }







    @javafx.fxml.FXML
    public void onBorrarAgenda(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void onButtonBorrarNota(ActionEvent actionEvent) {

    }
}


