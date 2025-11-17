module org.example.pizzeria {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    requires lombok;
    requires java.sql;
    requires java.desktop;

    opens org.example.pizzeria to javafx.fxml,java.sql;


    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    //opens org.example.pizzeria to javafx.fxml,lombok,java.sql;
    exports org.example.pizzeria;
}