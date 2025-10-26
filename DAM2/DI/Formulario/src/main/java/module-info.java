module org.example.formulario {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens org.example.formulario to javafx.fxml;
    exports org.example.formulario;
}