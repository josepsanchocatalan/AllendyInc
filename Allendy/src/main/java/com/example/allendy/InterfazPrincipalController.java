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


public class InterfazPrincipalController extends LoginController {

    private ObservableList<Nota> notas;


    //variables
    dataSingelton data=dataSingelton.getInstance();

    Usuario a = data.getUsuario();

    Agenda nuevaAgenda= new Agenda();

    ArrayList<Tarea> listaTareas=new ArrayList<Tarea>();
    @javafx.fxml.FXML
    private Button botonEditarNota;
    @javafx.fxml.FXML
    private TextField editarNombreNota;
    @javafx.fxml.FXML
    private Button botonCancelarNotaPopUp;


    //funciones

    @Deprecated
    public void initialice(ActionEvent actionEvent) {
        Calendario.show();
        notas = FXCollections.observableArrayList();
        tablaNotas.setItems(notas);
        DescNota.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));
    }
    @Deprecated
    public void insertar(ActionEvent actionEvent) {
        Nota nota = new Nota(DescripcionNota.getText());
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

    @Deprecated
    public void onBotonEditarTarea(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onBontonBorrarTarea(ActionEvent actionEvent) {


    }

    @Deprecated
    public void onBorrarAgenda(ActionEvent actionEvent) {
    }


    @Deprecated
    public void onBotonCancelarETarea(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onBotonCrearAgenda(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onBotonCancelarCAgenda(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onBotonEditarAgenda(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onBotonCancelarEAgenda(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onBotonEditarNota(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onBotonCancelarNotaPopUp(ActionEvent actionEvent) {
    }
}
