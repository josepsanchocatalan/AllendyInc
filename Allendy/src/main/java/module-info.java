module com.example.allendy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;


    opens com.example.allendy to javafx.fxml;
    exports com.example.allendy;
    exports com.example.allendy.Clases;
    opens com.example.allendy.Clases to javafx.fxml;
    exports com.example.allendy.ClasesModel;
    opens com.example.allendy.ClasesModel to javafx.fxml;
}