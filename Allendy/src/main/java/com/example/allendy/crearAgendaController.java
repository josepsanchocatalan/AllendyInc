package com.example.allendy;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.AgendaModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Controlador para la creación de una nueva agenda.
 */
public class crearAgendaController {
    @javafx.fxml.FXML
    private Button botonCrearAgenda;
    @javafx.fxml.FXML
    private TextField nombreAgenda;
    @javafx.fxml.FXML
    private Button botonCancelarCAgenda;

    dataSingelton data = dataSingelton.getInstance();

    Usuario a = data.getUsuario();
    ArrayList<Tarea> ListaTareas = new ArrayList<Tarea>();

    /**
     * Maneja el evento del botón "Crear Agenda".
     *
     * @param actionEvent El evento de acción generado por el botón.
     */
    @javafx.fxml.FXML
    public void onBotonCrearAgendaPop(ActionEvent actionEvent) {

        AgendaModel b = new AgendaModel();

        dataSingelton data = dataSingelton.getInstance();

        Usuario a = data.getUsuario();
        String NombreAgenda = nombreAgenda.getText();
        Agenda NuevaAgenda = new Agenda(a.getIdUsuario(), NombreAgenda);
        b.InsertarAgenda(NuevaAgenda);

        Stage myStage = (Stage) this.botonCrearAgenda.getScene().getWindow();
        myStage.close();
    }

    /**
     * Maneja el evento del botón "Cancelar Agenda".
     *
     * @param actionEvent El evento de acción generado por el botón.
     */
    @javafx.fxml.FXML
    public void onBotonCancelarAgendaPop(ActionEvent actionEvent) {
        Stage myStage = (Stage) this.botonCancelarCAgenda.getScene().getWindow();
        myStage.close();
    }
}
