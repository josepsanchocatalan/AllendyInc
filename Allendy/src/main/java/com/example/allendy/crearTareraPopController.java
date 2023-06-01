package com.example.allendy;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.TareaModel;
import com.example.allendy.InterfazPrincipalController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import com.example.allendy.ClasesModel.AgendaModel;
import com.example.allendy.ClasesModel.UsuarioModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static com.example.allendy.ClasesModel.TareaModel.mostrarTareasUsuario;


public class crearTareraPopController {
    @javafx.fxml.FXML
    private Button botonCrearTarea;
    @javafx.fxml.FXML
    private Button botonCancelarTarea;
    @javafx.fxml.FXML
    private DatePicker FechaTarea;
    @javafx.fxml.FXML
    private DatePicker FechaFin;
    @javafx.fxml.FXML
    private RadioButton prioridadAltaCrear;
    @javafx.fxml.FXML
    private ToggleGroup prioridad;
    @javafx.fxml.FXML
    private RadioButton prioridadMediaCrear;
    @javafx.fxml.FXML
    private RadioButton prioridadBajaCrear;
    @javafx.fxml.FXML
    private RadioButton checkTrabajoPop;
    @javafx.fxml.FXML
    private RadioButton checkOcioPop;
    @javafx.fxml.FXML
    private RadioButton CheckFamiliaPop;

    dataSingelton data = dataSingelton.getInstance();
    @javafx.fxml.FXML
    private TextField nombreTarea;
    @javafx.fxml.FXML
    private ToggleGroup TipoTarea;
    @javafx.fxml.FXML
    private ComboBox comboBoxEmails;

    boolean primeraVez;
    InterfazPrincipalController actualziar;

    public void initialize(){
      //  primeraVez = true;
        UsuarioModel um = new UsuarioModel();
        ObservableList<String> correos = FXCollections.observableArrayList();
        correos.setAll(um.recuperarCorreos());
        comboBoxEmails.setItems(correos);
    }



    @javafx.fxml.FXML
    public void onBotonCrearTareaPop(ActionEvent actionEvent) {
        AgendaModel am= new AgendaModel();
        TareaModel tm=new TareaModel();
        Usuario a = data.getUsuario();
        Agenda agenda = am.RecuperarAgenda(a.getIdUsuario());

        TareaModel t = new TareaModel();
        data = dataSingelton.getInstance();
        ArrayList<Tarea> ListaTareas = mostrarTareasUsuario(a.getIdUsuario());
        LocalDate FechaInicio = FechaTarea.getValue();
        LocalDate FechaFinal = FechaFin.getValue();
        String Descripcion = nombreTarea.getText();
        String asistente = "";

        String TipoTarea;
        String Prioridad;

        if (CheckFamiliaPop.isSelected()) {
            TipoTarea = "famila";
        } else if (checkOcioPop.isSelected()) {
            TipoTarea = "Ocio";

        } else if (checkTrabajoPop.isSelected()) {
            TipoTarea = "Trabajo";
        } else {
            TipoTarea = null;
        }

        if (prioridadAltaCrear.isSelected()) {
            Prioridad = "Alta";
        } else if (prioridadMediaCrear.isSelected()) {
            Prioridad = "media";

        } else if (prioridadBajaCrear.isSelected()) {
            Prioridad = "baja";
        } else {
            Prioridad = null;
        }

        if(comboBoxEmails.getValue() != null){
            asistente = comboBoxEmails.getValue().toString();
        }

        Tarea nuevaTarea = new Tarea(agenda.getIdAgenda(), a.getIdUsuario(), ListaTareas, agenda.getNombreAgenda(), FechaInicio, FechaFinal, TipoTarea, Descripcion, false, asistente, Prioridad);
        ListaTareas.add(nuevaTarea);
        t.InsertarTarea(nuevaTarea);



        Stage myStage = (Stage) this.botonCrearTarea.getScene().getWindow();
        myStage.close();


            InterfazPrincipalController actualziar = new InterfazPrincipalController();
            //actualziar = new InterfazPrincipalController();

            //primeraVez = false;


        actualziar.mostrarTareasUsuario();

    }

    @javafx.fxml.FXML
    public void onBotonCancelarTareaPop(ActionEvent actionEvent) {
        Stage myStage = (Stage) this.botonCancelarTarea.getScene().getWindow();
        myStage.close();
    }
}
