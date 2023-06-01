package com.example.allendy;

import com.example.allendy.Clases.Agenda;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.AgendaModel;


public class editarAgendaController {
    @javafx.fxml.FXML
    private Button botonEditarAgenda;
    @javafx.fxml.FXML
    private TextField editarNombreAgenda;
    @javafx.fxml.FXML
    private Button botonCancelarEAgenda;

    @javafx.fxml.FXML
    public void onBotonEditarAgendaPopUp(ActionEvent actionEvent) {
        AgendaModel am =new AgendaModel();

        dataSingelton data = dataSingelton.getInstance();
        Usuario usser=data.getUsuario();
        Agenda a=am.RecuperarAgenda(usser.getIdUsuario());
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
