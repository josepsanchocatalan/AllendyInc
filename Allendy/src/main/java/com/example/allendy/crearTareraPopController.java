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
import java.util.Date;

public class crearTareraPopController {
    @javafx.fxml.FXML
    private Button botonCrearTarea;
    @javafx.fxml.FXML
    private TextField DescripcionTarea;
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
    @javafx.fxml.FXML
    private ToggleGroup Tipo;








    @javafx.fxml.FXML
    public void onBotonCrearTareaPop(ActionEvent actionEvent) {


        TareaModel t=new TareaModel();
        dataSingelton data = dataSingelton.getInstance();
        Agenda agenda = data.getAgenda();
        Usuario a = data.getUsuario();
        ArrayList<Tarea> ListaTareas=agenda.getTareaAgenda();
        LocalDate FechaInicio=FechaTarea.getValue();
        LocalDate FechaFinal=FechaFin.getValue();
        String Descripcion=DescripcionTarea.getText();


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

        if(prioridadAltaCrear.isSelected()){
            Prioridad="Alta";
        } else if (prioridadMediaCrear.isSelected()) {
            Prioridad="media";

        }else if(prioridadBajaCrear.isSelected()){
            Prioridad="baja";
        }else{
            Prioridad=null;
        }

        Tarea nuevaTarea=new Tarea(agenda.getIdAgenda(), a.getIdUsuario(),ListaTareas,agenda.getNombreAgenda(),FechaInicio,FechaFinal,TipoTarea,Descripcion,false,a.getEmail(),Prioridad);
        ListaTareas.add(nuevaTarea);
        t.InsertarTarea(nuevaTarea);

        Stage myStage = (Stage) this.botonCrearTarea.getScene().getWindow();
        myStage.close();
    }

    @javafx.fxml.FXML
    public void onBotonCancelarTareaPop(ActionEvent actionEvent) {
        Stage myStage = (Stage) this.botonCancelarTarea.getScene().getWindow();
        myStage.close();
    }
}
