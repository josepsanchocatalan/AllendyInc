package com.example.allendy;

import com.example.allendy.Clases.Agenda;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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


    }

    @javafx.fxml.FXML
    public void onBotonCancelarAgendaPop(ActionEvent actionEvent) {
    }
}
