module com.example.allendy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.allendy to javafx.fxml;
    exports com.example.allendy;
}