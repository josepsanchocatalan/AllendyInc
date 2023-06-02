package com.example.allendy;

import com.example.allendy.Clases.Nota;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.NotaModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class editarNotaController {
    @javafx.fxml.FXML
    private Button botonEditarNota;
    @javafx.fxml.FXML
    private TextField editarNombreNota;
    @javafx.fxml.FXML
    private Button botonCancelarNotaPopUp;
    @javafx.fxml.FXML
    private TextField idNota;
    @javafx.fxml.FXML
    private TextArea nuevaDescripcion;

    @javafx.fxml.FXML
    public void onBotonEditarNotaPop(ActionEvent actionEvent) {
        NotaModel nm = new NotaModel();
        dataSingelton data = dataSingelton.getInstance();
        Usuario a = data.getUsuario();
        Nota nuevaNota = nm.RecuperarNota(a.getIdUsuario());
        String nombre = editarNombreNota.getText();
        String descripcion = nuevaDescripcion.getText();
        nuevaNota.setNombre(nombre);
        nuevaNota.setDescripcion(descripcion);
        nm.ModificarNota(nuevaNota);
        Stage myStage = (Stage) this.botonEditarNota.getScene().getWindow();
        myStage.close();
    }

    @javafx.fxml.FXML
    public void onBotonCancelarNotaPop(ActionEvent actionEvent) {
        Stage myStage = (Stage) this.botonCancelarNotaPopUp.getScene().getWindow();
        myStage.close();
    }
}
