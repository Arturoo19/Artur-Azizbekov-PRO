module org.example.nazariijavafx {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.nazariijavafx to javafx.fxml;
    opens org.example.nazariijavafx.controller to javafx.fxml;

    exports org.example.nazariijavafx;
    exports org.example.nazariijavafx.controller;
}