package com.example.allendy;


import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Nota;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.AgendaModel;
import com.example.allendy.ClasesModel.NotaModel;
import com.example.allendy.ClasesModel.TareaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InterfazPrincipalController {

    private ObservableList<Nota> notas;
    private ObservableList<Tarea> tareas;


    //variables
    dataSingelton data = dataSingelton.getInstance();

    Usuario a = data.getUsuario();

    Agenda nuevaAgenda = data.getAgenda();

    Tarea nuevaTarea= data.getTarea();

    AgendaModel b=new AgendaModel();

    TareaModel t=new TareaModel();

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

    @Deprecated
    public void insertar(ActionEvent actionEvent) {
        Nota nota = new Nota(DescNota.getText());
        if (!notas.contains(nota)) {
            notas.add(nota);
            tablaNotas.refresh();
        }

    }

    @FXML
    public void OnBotonCrearAgenda(ActionEvent actionEvent) {

        try {
            FXMLLoader loaderAgenda = new FXMLLoader(getClass().getResource("crearAgenda.fxml"));

            Parent rootAgenda = loaderAgenda.load();

            crearAgendaController controller = loaderAgenda.getController();

            Scene scene = new Scene(rootAgenda);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null,ex);
        }
    }

    @FXML
    public void onBotonEditarAgenda(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarAgenda.fxml"));

            Parent root = loader.load();

            editarAgendaController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null,ex);
        }

    }

    @FXML
    public void onBotonNuevaTarea(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("crearTarea.fxml"));

            Parent root = loader.load();

            crearTareraPopController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null,ex);
        }

    }

    @javafx.fxml.FXML
    public void datepickerFuncion(ActionEvent actionEvent) {

        LocalDate FechaSelected=Calendario.getValue();

    }

    @javafx.fxml.FXML
    public void onBotonEditarTarea(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editarTarea.fxml"));

            Parent root = loader.load();

            editarTareaController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null,ex);
        }
    }

    @javafx.fxml.FXML
    public void onBontonBorrarTarea(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Advertencia");
        alert.setContentText("Seguro quieres borrar la Agenda?");
        alert.showAndWait();

        ButtonType resultado=alert.getResult();

        if (alert.getResult() == ButtonType.OK) {
            t.EliminarTarea(nuevaTarea);
        }

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


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Advertencia");
        alert.setContentText("Seguro quieres borrar la Agenda?");
        alert.showAndWait();

        ButtonType resultado=alert.getResult();

        if (alert.getResult() == ButtonType.OK) {
            b.EliminarAgenda(nuevaAgenda);
      }

    }


    @javafx.fxml.FXML
    public void onButtonBorrarNota(ActionEvent actionEvent) {

    }
}


