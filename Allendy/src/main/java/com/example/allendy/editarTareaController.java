package com.example.allendy;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.AgendaModel;
import com.example.allendy.ClasesModel.TareaModel;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

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
    private RadioButton prioridadMedia;
    @javafx.fxml.FXML
    private RadioButton prioridadBaja;
    @javafx.fxml.FXML
    private RadioButton checkTrabajoPop;
    @javafx.fxml.FXML
    private RadioButton checkOcioPop;
    @javafx.fxml.FXML
    private RadioButton CheckFamiliaPop;
    @javafx.fxml.FXML
    private ToggleGroup TipoTarea;
    @javafx.fxml.FXML
    private ToggleGroup prioridad;
    @javafx.fxml.FXML
    private TextField idNtarea;

    /**
     * Maneja el evento del botón "Editar Tarea".
     *
     * @param actionEvent El evento de acción generado por el botón.
     */
    @javafx.fxml.FXML
    public void onBotonEditarTareaPop(ActionEvent actionEvent) {
        TareaModel tm = new TareaModel();
        dataSingelton data = dataSingelton.getInstance();
        AgendaModel am =new AgendaModel();
        Usuario a = data.getUsuario();
        Agenda agenda = am.RecuperarAgenda(a.getIdUsuario());
        Tarea nuevaTarea = tm.RecuperarTarea(a.getIdUsuario());

        LocalDate FechaInicio = editarFechaTarea.getValue();
        LocalDate FechaFinal = editarFechaFinTarea.getValue();
        String Descripcion = editarNombreTarea.getText();
        String ntarea = idNtarea.getText();

        String TipoTarea;
        String Prioridad;

        if (CheckFamiliaPop.isSelected()) {
            TipoTarea = "Familia";
        } else if (checkOcioPop.isSelected()) {
            TipoTarea = "Ocio";
        } else if (checkTrabajoPop.isSelected()) {
            TipoTarea = "Trabajo";
        } else {
            TipoTarea = null;
        }

        if (prioridadAlta.isSelected()) {
            Prioridad = "Alta";
        } else if (prioridadMedia.isSelected()) {
            Prioridad = "Media";
        } else if (prioridadBaja.isSelected()) {
            Prioridad = "Baja";
        } else {
            Prioridad = null;
        }

        nuevaTarea.setFechaTarea(editarFechaTarea.getValue());
        nuevaTarea.setFechaFin(editarFechaFinTarea.getValue());
        nuevaTarea.setPrioridadTarea(Prioridad);
        nuevaTarea.setTipoTarea(TipoTarea);
        nuevaTarea.setDescripcionTarea(Descripcion);
        nuevaTarea.setIdTarea(Integer.valueOf(ntarea));
        tm.ModificarTarea(nuevaTarea);

        Stage myStage = (Stage) this.botonEditarTarea.getScene().getWindow();
        myStage.close();
    }

    /**
     * Maneja el evento del botón "Cancelar Tarea".
     *
     * @param actionEvent El evento de acción generado por el botón.
     */
    @javafx.fxml.FXML
    public void onBotonCancelarETareaPop(ActionEvent actionEvent) {
        Stage myStage = (Stage) this.botonCancelarTareaPopUp.getScene().getWindow();
        myStage.close();
    }
}
