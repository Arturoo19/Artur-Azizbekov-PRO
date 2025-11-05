module org.example.formulario {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    requires lombok;

    opens org.example.formulario to javafx.fxml;
    exports org.example.formulario;
    exports org.example.formulario.controller;
    opens org.example.formulario.controller to javafx.fxml;

    opens org.example.formulario.model to lombok;
    exports org.example.formulario.model;
}
