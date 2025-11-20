module org.example.pizzeria {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    requires lombok;
    requires java.sql;




    opens org.example.pizzeria to javafx.fxml,java.sql;
    exports org.example.pizzeria;
    exports org.example.pizzeria.controller;
    opens org.example.pizzeria.controller to java.sql,javafx.fxml;


    opens org.example.pizzeria.model to lombok,java.sql;

    exports org.example.pizzeria.model;
}