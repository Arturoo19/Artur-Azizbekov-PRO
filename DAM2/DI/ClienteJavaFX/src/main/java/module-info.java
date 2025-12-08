module org.example.clientejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.clientejavafx to javafx.fxml;
    exports org.example.clientejavafx;
}