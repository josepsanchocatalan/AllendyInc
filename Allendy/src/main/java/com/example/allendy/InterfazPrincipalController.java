package com.example.allendy;


import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Nota;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.AgendaModel;
import com.example.allendy.ClasesModel.NotaModel;
import com.example.allendy.ClasesModel.TareaModel;
import com.example.allendy.ClasesModel.UsuarioModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.scene.text.*;
import java.lang.annotation.ElementType;
import java.util.List;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InterfazPrincipalController {

    private ObservableList<Nota> notas;
    private ObservableList<Tarea> tareas;


    //variables
    dataSingelton data = dataSingelton.getInstance();

    Usuario a = data.getUsuario();


    TareaModel tm= new TareaModel();
    Tarea nuevaTarea=tm.RecuperarTarea(a.getIdUsuario());

    AgendaModel am=new AgendaModel();
    Agenda nuevaAgenda =am.RecuperarAgenda(a.getIdUsuario());

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
    private TableColumn idnota;
    @FXML
    private TextField idborrarnota;
    @FXML
    private TableColumn idtarea;
    @FXML
    private TableColumn tipotarea;
    @FXML
    private TableColumn prioridadtarea;
    @FXML
    private Text notasCreadas;
    @FXML
    private int contador = 0;


    //funciones


    @FXML
    public void initialize() {

        Calendario.show();
        notas = FXCollections.observableArrayList();
        tablaNotas.setItems(notas);
        idnota.setCellValueFactory(new PropertyValueFactory<>("IdNota"));
        nombreNota.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        descripcionNota.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));

        tareas = FXCollections.observableArrayList();
        TablaTareas.setItems(tareas);

        idtarea.setCellValueFactory(new PropertyValueFactory<>("idTarea"));
        descTarea.setCellValueFactory(new PropertyValueFactory<>("descripcionTarea"));
        fechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaTarea"));
        fechaFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
        tipotarea.setCellValueFactory(new PropertyValueFactory<>("tipoTarea"));
        prioridadtarea.setCellValueFactory(new PropertyValueFactory<>("prioridadTarea"));


        mostrarNotasUsuario();
        mostrarTareasUsuario();

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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @javafx.fxml.FXML
    public void datepickerFuncion(ActionEvent actionEvent) {

        LocalDate FechaSelected = Calendario.getValue();

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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void onBontonBorrarTarea(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Advertencia");
        alert.setContentText("Seguro quieres borrar la Tarea?");
        alert.showAndWait();

        ButtonType resultado = alert.getResult();

        if (alert.getResult() == ButtonType.OK) {
            t.EliminarTarea(nuevaTarea);
        }

    }

    @javafx.fxml.FXML
    public void onBotonGuardraNota(ActionEvent actionEvent) {
        Nota a = new Nota(data.getUsuario(), NombreNota.getText(), DescNota.getText());
        if (!notas.contains(a)) {
            notas.add(a);
            tablaNotas.refresh();
        }

        Usuario idUser = data.getUsuario();
        String nombre = NombreNota.getText();
        String desc = DescNota.getText();

        Nota n1 = new Nota(idUser, nombre, desc);
        NotaModel.InsertarNota(n1);

        contador++;

        notasCreadas.setText(String.valueOf(contador));

        mostrarNotasUsuario();
    }


    @javafx.fxml.FXML
    public void onBorrarAgenda(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Advertencia");
        alert.setContentText("Seguro quieres borrar la Agenda?");
        alert.showAndWait();

        ButtonType resultado = alert.getResult();

        if (alert.getResult() == ButtonType.OK) {
            am.EliminarAgenda(nuevaAgenda);
        }

    }


    @FXML
    public void onButtonBorrarNota(ActionEvent actionEvent) {
        Integer id = Integer.valueOf(idborrarnota.getText());
        NotaModel.EliminarNota(id);
        mostrarNotasUsuario();
    }


    @FXML
    public void mostrarNotasUsuario() {
        try {
            // Obtén las notas del usuario desde el modelo de notas
            ArrayList<Nota> notasUsuario = NotaModel.mostrarNotasUsuario(a);

            // Limpia la lista actual de notas
            notas.clear();

            // Agrega las notas del usuario a la lista
            notas.addAll(notasUsuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void mostrarTareasUsuario() {
        // Obtén las tareas del usuario desde el modelo de tareas
        ArrayList<Tarea> tareasUsuario = TareaModel.mostrarTareasUsuario(a.getIdUsuario());
        // Limpia la lista actual de tareas
        tareas.clear();
        // Agrega las tareas del usuario a la lista
        tareas.addAll(tareasUsuario);
         // Obtén el usuario actual de alguna manera
    }

    public void onFiltrarPor(ActionEvent actionEvent) {
    }

    public void onBotonAlonsista(ActionEvent actionEvent) {
    }
}


