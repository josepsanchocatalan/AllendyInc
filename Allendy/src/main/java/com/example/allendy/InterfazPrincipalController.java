package com.example.allendy;


import com.example.allendy.Clases.Agenda;
import com.example.allendy.Clases.Nota;
import com.example.allendy.Clases.Tarea;
import com.example.allendy.Clases.Usuario;
import com.example.allendy.ClasesModel.AgendaModel;
import com.example.allendy.ClasesModel.NotaModel;
import com.example.allendy.ClasesModel.TareaModel;
import com.example.allendy.ClasesModel.UsuarioModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.scene.text.*;
import java.lang.annotation.ElementType;
import java.util.List;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InterfazPrincipalController {

    private ObservableList<Nota> notas;
    private ObservableList<Tarea> tareas;


    //variables
    dataSingelton data = dataSingelton.getInstance();

    Usuario a = data.getUsuario();


    TareaModel tm= new TareaModel();
    Tarea nuevaTarea=tm.RecuperarTarea(a.getIdUsuario());

    AgendaModel am=new AgendaModel();
    Agenda nuevaAgenda =am.RecuperarAgenda(a.getIdUsuario());

    TareaModel t=new TareaModel();

    ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
    @javafx.fxml.FXML
    private DatePicker Calendario;
    @javafx.fxml.FXML
    private Button BotonCrearAgenda;
    @javafx.fxml.FXML
    private Button BotonEditarAgenda;
    @javafx.fxml.FXML
    private Button BotonBorrarAgenda;
    @javafx.fxml.FXML
    private Button BotonNuevaTarea;
    @javafx.fxml.FXML
    private Button botonEditarTarea;
    @javafx.fxml.FXML
    private Button BotonBorrarTarea;
    @javafx.fxml.FXML
    private TextArea DescNota;
    @javafx.fxml.FXML
    private Button BotonGuardarNota;
    @javafx.fxml.FXML
    private TableView tablaNotas;
    @javafx.fxml.FXML
    private TextField NombreNota;
    @javafx.fxml.FXML
    private TableView TablaTareas;
    @javafx.fxml.FXML
    private TableColumn nombreNota;
    @javafx.fxml.FXML
    private TableColumn descripcionNota;
    @javafx.fxml.FXML
    private Button botonBorrar;
    @FXML
    private TableColumn descTarea;
    @FXML
    private TableColumn fechaInicio;
    @FXML
    private TableColumn fechaFin;
    @FXML
    private TableColumn idnota;
    @FXML
    private TextField idborrarnota;
    @FXML
    private TableColumn idtarea;
    @FXML
    private TableColumn tipotarea;
    @FXML
    private TableColumn prioridadtarea;
    @FXML
    private Text notasCreadas;
    @FXML
    private Text nombreUsuario;
    @FXML
    private Text agendasCreadas;
    @FXML
    private Text tareasCreadas;
    @FXML
    private TableView tablaAgenda;
    @FXML
    private TableColumn columnaAgenda;
    @FXML
    private TableColumn columnaNombre;
    @FXML
    private Button botonAlonsista;
    @FXML
    private ComboBox filtrarTipo;
    @FXML
    private ComboBox filtrarPrioridad;
    @FXML
    private Button botonRestaurar;

    @FXML
    private Button asd;


    //funciones


    @FXML
    public void initialize() {

        Calendario.show();
        notas = FXCollections.observableArrayList();
        tablaNotas.setItems(notas);
        idnota.setCellValueFactory(new PropertyValueFactory<>("IdNota"));
        nombreNota.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        descripcionNota.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));

        tareas = FXCollections.observableArrayList();
        TablaTareas.setItems(tareas);

        idtarea.setCellValueFactory(new PropertyValueFactory<>("idTarea"));
        descTarea.setCellValueFactory(new PropertyValueFactory<>("descripcionTarea"));
        fechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaTarea"));
        fechaFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
        tipotarea.setCellValueFactory(new PropertyValueFactory<>("tipoTarea"));
        prioridadtarea.setCellValueFactory(new PropertyValueFactory<>("prioridadTarea"));

        String nickName = a.getNickName();
        nombreUsuario.setText(a.getNickName());

        Usuario idUser = data.getUsuario();
        Integer iduser = Integer.valueOf(idUser.getIdUsuario());
        notasCreadas.setText(NotaModel.ContadorNota(iduser));
        tareasCreadas.setText(TareaModel.ContadorTarea(iduser));

        mostrarNotasUsuario();
        mostrarTareasUsuario();

        filtrarTipo.getItems().add("");
        filtrarTipo.getItems().add("Trabajo");
        filtrarTipo.getItems().add("Ocio");
        filtrarTipo.getItems().add("Familia");

        filtrarPrioridad.getItems().add("");
        filtrarPrioridad.getItems().add("Alta");
        filtrarPrioridad.getItems().add("Media");
        filtrarPrioridad.getItems().add("Baja");






    }


    @Deprecated
    public void insertar(ActionEvent actionEvent) {
        Nota nota = new Nota(DescNota.getText());
        if (!notas.contains(nota)) {
            notas.add(nota);
            tablaNotas.refresh();
        }

    }

    @FXML
    public void OnBotonCrearAgenda(ActionEvent actionEvent) {

        try {
            FXMLLoader loaderAgenda = new FXMLLoader(getClass().getResource("crearAgenda.fxml"));

            Parent rootAgenda = loaderAgenda.load();

            crearAgendaController controller = loaderAgenda.getController();

            Scene scene = new Scene(rootAgenda);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onBotonEditarAgenda(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarAgenda.fxml"));

            Parent root = loader.load();

            editarAgendaController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void onBotonNuevaTarea(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("crearTarea.fxml"));

            Parent root = loader.load();

            crearTareraPopController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            mostrarTareasUsuario();

           stage.setOnHiding(event-> {
               mostrarTareasUsuario();
           });

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @javafx.fxml.FXML
    public void datepickerFuncion(ActionEvent actionEvent) {

        LocalDate FechaSelected = Calendario.getValue();

    }

    @javafx.fxml.FXML
    public void onBotonEditarTarea(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editarTarea.fxml"));

            Parent root = loader.load();

            editarTareaController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();
            stage.setOnHiding(event-> {
                mostrarTareasUsuario();
            });

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void onBontonBorrarTarea(ActionEvent actionEvent) {
        TareaModel tm = new TareaModel();
        TextInputDialog dialogoTexto = new TextInputDialog("numero de la Tarea");
        dialogoTexto.setTitle("Borrar Tarea");
        dialogoTexto.setHeaderText("Introduzca el numero de tarea para borrarla");
        dialogoTexto.setContentText("numero de Tarea");
        dialogoTexto.showAndWait();

        int idTarea= Integer.parseInt(dialogoTexto.getResult());

        tm.EliminarTarea(idTarea);

            mostrarTareasUsuario();


    }

    @javafx.fxml.FXML
    public void onBotonGuardraNota(ActionEvent actionEvent) {
        Nota a = new Nota(data.getUsuario(), NombreNota.getText(), DescNota.getText());
        if (!notas.contains(a)) {
            notas.add(a);
            tablaNotas.refresh();
        }

        Usuario idUser = data.getUsuario();
        String nombre = NombreNota.getText();
        String desc = DescNota.getText();


        Nota n1 = new Nota(idUser, nombre, desc);
        NotaModel.InsertarNota(n1);


        Integer iduser = Integer.valueOf(idUser.getIdUsuario());

        notasCreadas.setText(NotaModel.ContadorNota(iduser));

        mostrarNotasUsuario();
    }


    @javafx.fxml.FXML
    public void onBorrarAgenda(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Advertencia");
        alert.setContentText("Seguro quieres borrar la Agenda?");
        alert.showAndWait();

        ButtonType resultado = alert.getResult();

        if (alert.getResult() == ButtonType.OK) {
            am.EliminarAgenda(nuevaAgenda);
        }

    }


    @FXML
    public void onButtonBorrarNota(ActionEvent actionEvent) {
        Integer id = Integer.valueOf(idborrarnota.getText());
        NotaModel.EliminarNota(id);
        mostrarNotasUsuario();
    }


    @FXML
    public void mostrarNotasUsuario() {
        try {
            // Obtén las notas del usuario desde el modelo de notas
            ArrayList<Nota> notasUsuario = NotaModel.mostrarNotasUsuario(a);

            // Limpia la lista actual de notas
            notas.clear();

            // Agrega las notas del usuario a la lista
            notas.addAll(notasUsuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void  mostrarTareasUsuario() {
        // Obtén las tareas del usuario desde el modelo de tareas
        ArrayList<Tarea> tareasUsuario = TareaModel.mostrarTareasUsuario(a.getIdUsuario());
        // Limpia la lista actual de tareas
        tareas.clear();
        // Agrega las tareas del usuario a la lista
        tareas.addAll(tareasUsuario);
         // Obtén el usuario actual de alguna manera
    }



    public void onFiltrarPor(ActionEvent actionEvent) {

    }
    @FXML
    public void onBotonAlonsista(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Allendy Corp");
        a.setContentText("Allendy es una aplicación de escritorio enfocada en las redes sociales, en la que puedes crear agendas y dentro de ellas poner tareas, objetivos e incluso organizar eventos como una boda. Esta aplicación te permite hacer una agenda más enfocada al trabajo y otra más personal. Podrás compartir, editar y borrar tareas, así como ver los objetivos de los demás usuarios que tengan el perfil en público.");
        a.show();
    }


    @FXML
    public void onFiltrarTipo(ActionEvent actionEvent) {
        String TipoFiltrado= (String) filtrarTipo.getValue();

        TareaModel tm=new TareaModel();
        ArrayList <Tarea> tareasFiltrado=tm.filtradoTareasTipo(TipoFiltrado);
        // Limpia la lista actual de tareas
        tareas.clear();
        // Agrega las tareas del usuario a la lista
        tareas.addAll(tareasFiltrado);
        // Obtén el usuario actual de alguna manera


    }

    @FXML
    public void onFiltrarPrioridad(ActionEvent actionEvent) {
        String PrioridadFiltrado= (String) filtrarPrioridad.getValue();
        TareaModel tm=new TareaModel();
        ArrayList <Tarea> tareasFiltradasTipo=tm.filtradoTareasPrioridad(PrioridadFiltrado);


        // Limpia la lista actual de tareas
        tareas.clear();
        // Agrega las tareas del usuario a la lista
        tareas.addAll(tareasFiltradasTipo);
        // Obtén el usuario actual de alguna manera
    }

    @FXML
    public void OnbotonRestaurar(ActionEvent actionEvent) {

        mostrarTareasUsuario();

        filtrarTipo.setValue("");
        filtrarPrioridad.setValue("");

    }

    @FXML
    public void onASDbutton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editarNota.fxml"));

            Parent root = loader.load();

            editarNotaController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnHiding(event-> {
                mostrarNotasUsuario();
            });

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


