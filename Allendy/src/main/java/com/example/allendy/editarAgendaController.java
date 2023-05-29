package com.example.allendy;

import com.example.allendy.Clases.Agenda;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class editarAgendaController {
    @javafx.fxml.FXML
    private Button botonEditarAgenda;
    @javafx.fxml.FXML
    private TextField editarNombreAgenda;
    @javafx.fxml.FXML
    private Button botonCancelarEAgenda;

    @javafx.fxml.FXML
    public void onBotonEditarAgendaPopUp(ActionEvent actionEvent) {
        dataSingelton data = dataSingelton.getInstance();
        Agenda a= data.getAgenda();
        a.setNombreAgenda(editarNombreAgenda.getText());

        Stage myStage = (Stage) this.botonEditarAgenda.getScene().getWindow();
        myStage.close();


    }

    @javafx.fxml.FXML
    public void onBotonCancelarAgendaPop(ActionEvent actionEvent) {
        Stage myStage = (Stage) this.botonCancelarEAgenda.getScene().getWindow();
        myStage.close();
    }
}
