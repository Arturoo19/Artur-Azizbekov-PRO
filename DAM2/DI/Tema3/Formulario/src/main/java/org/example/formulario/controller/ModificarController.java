
package org.example.formulario.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.formulario.model.Usuario;

import java.util.Optional;

public class ModificarController {

    @FXML private TextField modificarNombre;
    @FXML private TextField modificarCorreo;
    @FXML private TextField tfGenero;
    @FXML private TextField tfEdad;
    @FXML private TextField modificarLocalizacion;

    @FXML private Button btnGuardar;
    @FXML private Button btnCancelar;

    private Usuario usuario;          // copia a editar
    private Usuario resultado = null;
    private FormController formController;// se rellena si pulsan Guardar

    @FXML
    private void initialize() {
        btnGuardar.setOnAction(e -> {
            // Validaciones mínimas (opcional)
            if (modificarNombre.getText().isEmpty() || modificarCorreo.getText().isEmpty()) {
                // podrías mostrar un alerta
                return;
            }

            usuario.setNombre(modificarNombre.getText());
            usuario.setCorreo(modificarCorreo.getText());
            usuario.setGenero(tfGenero.getText());
            try {
                usuario.setEdad(Integer.parseInt(tfEdad.getText()));
            } catch (NumberFormatException ex) {
                // si hay error de número, no guardamos
                return;
            }
            usuario.setLocalizacion(modificarLocalizacion.getText());

            resultado = usuario;
            ((Stage) btnGuardar.getScene().getWindow()).close();
        });

        btnCancelar.setOnAction(e ->
                ((Stage) btnCancelar.getScene().getWindow()).close()
        );
    }

    // recibe el usuario a editar (mejor una copia)
    public void setUsuario(Usuario u) {

    }

    public Optional<Usuario> getResultado() {
        return Optional.ofNullable(resultado);
    }

    public void setFormController(FormController controller) {
        this.formController = controller;
    }
}
