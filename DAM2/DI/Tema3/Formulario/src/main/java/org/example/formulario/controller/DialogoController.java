package org.example.formulario.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.formulario.model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoController implements Initializable {
    @FXML
    private Label textoEdad;

    @FXML
    private Label textoGenero;

    @FXML
    private Label textoLocalizacion;

    @FXML
    private Label textoMail;
    @FXML
    private Button botonContestar;

    private FormController formController;

    @FXML
    private Label textoNombre;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonContestar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Pulsado al contestar");
                formController.actualizarUsuario(null);
            }
        });
    }

    public void setFormController(FormController controller){
        this.formController = controller;
    }

    public void setUsuario(Usuario usuario){
        textoGenero.setText(usuario.getGenero());
        textoNombre.setText(usuario.getNombre());
        textoEdad.setText(String.valueOf(usuario.getEdad()));
        textoMail.setText(usuario.getCorreo());
        textoLocalizacion.setText(usuario.getLocalizacion());
    }

}
