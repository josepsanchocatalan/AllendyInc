package com.example.allendy;

import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.AgendaModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class crearAgendaController {
    @javafx.fxml.FXML
    private Button botonCrearAgenda;
    @javafx.fxml.FXML
    private TextField nombreAgenda;
    @javafx.fxml.FXML
    private Button botonCancelarCAgenda;


    dataSingelton data = dataSingelton.getInstance();

    Usuario a = data.getUsuario();
    ArrayList<Tarea> ListaTareas=new ArrayList<Tarea>();
    String NombreAgenda=nombreAgenda.getText();

    @javafx.fxml.FXML
    public void onBotonCrearAgendaPop(ActionEvent actionEvent) {
        Agenda NuevaAgenda = new Agenda(a.getIdUsuario(),ListaTareas,NombreAgenda );
        DBUtil db=new DBUtil();
        AgendaModel b= new AgendaModel();
        data.setAgenda(NuevaAgenda);

        b.InsertarAgenda(NuevaAgenda);
        dataSingelton data = dataSingelton.getInstance();

        Usuario a = data.getUsuario();
        ArrayList<Tarea> ListaTareas=new ArrayList<Tarea>();
        String NombreAgenda=nombreAgenda.getText();

    }

    @javafx.fxml.FXML
    public void onBotonCancelarAgendaPop(ActionEvent actionEvent) {
    }
}
