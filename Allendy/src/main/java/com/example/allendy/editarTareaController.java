package com.example.allendy;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.TareaModel;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class editarTareaController {
    @javafx.fxml.FXML
    private Button botonEditarTarea;
    @javafx.fxml.FXML
    private TextField editarNombreTarea;
    @javafx.fxml.FXML
    private Button botonCancelarTareaPopUp;
    @javafx.fxml.FXML
    private DatePicker editarFechaTarea;
    @javafx.fxml.FXML
    private DatePicker editarFechaFinTarea;
    @javafx.fxml.FXML
    private RadioButton prioridadAlta;
    @javafx.fxml.FXML
    private ToggleGroup editarPrioridad;
    @javafx.fxml.FXML
    private RadioButton prioridadMedia;
    @javafx.fxml.FXML
    private RadioButton prioridadBaja;
    @javafx.fxml.FXML
    private RadioButton checkTrabajoPop;
    @javafx.fxml.FXML
    private ToggleGroup Tipo;
    @javafx.fxml.FXML
    private RadioButton checkOcioPop;
    @javafx.fxml.FXML
    private RadioButton CheckFamiliaPop;


    @javafx.fxml.FXML
    public void onBotonEditarTareaPop(ActionEvent actionEvent) {


        TareaModel t=new TareaModel();
        dataSingelton data = dataSingelton.getInstance();

        Tarea nuevaTarea=data.getTarea();


        Agenda agenda = data.getAgenda();
        Usuario a = data.getUsuario();

        LocalDate FechaInicio=editarFechaTarea.getValue();
        LocalDate FechaFinal=editarFechaFinTarea.getValue();
        String Descripcion=editarNombreTarea.getText();

        String TipoTarea;
        String Prioridad;

        if(CheckFamiliaPop.isSelected()){
            TipoTarea="famila";
        } else if (checkOcioPop.isSelected()) {
            TipoTarea="Ocio";

        }else if(checkTrabajoPop.isSelected()){
            TipoTarea="Trabajo";
        }else{
            TipoTarea=null;
        }

        if(prioridadAlta.isSelected()){
            Prioridad="Alta";
        } else if (prioridadMedia.isSelected()) {
            Prioridad="media";

        }else if(prioridadBaja.isSelected()){
            Prioridad="baja";
        }else{
            Prioridad=null;
        }

        nuevaTarea.setFechaTarea(editarFechaTarea.getValue());
        nuevaTarea.setFechaFin(editarFechaFinTarea.getValue());
        nuevaTarea.setPrioridadTarea(Prioridad);
        nuevaTarea.setTipoTarea(TipoTarea);
        nuevaTarea.setDescripcionTarea(Descripcion);
        t.ModificarTarea(nuevaTarea);

        Stage myStage = (Stage) this.botonEditarTarea.getScene().getWindow();
        myStage.close();
    }

    @javafx.fxml.FXML
    public void onBotonCancelarETareaPop(ActionEvent actionEvent) {
        Stage myStage = (Stage) this.botonCancelarTareaPopUp.getScene().getWindow();
        myStage.close();
    }
}
