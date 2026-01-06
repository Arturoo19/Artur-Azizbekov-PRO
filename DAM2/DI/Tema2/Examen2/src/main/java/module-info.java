module org.example.examen2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires java.sql;
    requires lombok;



    opens org.example.examen2 to javafx.fxml,java.sql;
    exports org.example.examen2;
    exports org.example.examen2.controller;
    opens org.example.examen2.controller to java.sql,javafx.fxml;

    opens org.example.examen2.model to lombok,java.sql;
    exports org.example.examen2.model;
}