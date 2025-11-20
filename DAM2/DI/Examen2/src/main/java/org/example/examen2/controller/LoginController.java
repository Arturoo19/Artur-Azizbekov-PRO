package org.example.examen2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.examen2.dao.UsuarioDAOImp;
import org.example.examen2.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button botonLogin;

    @FXML
    private TextField textFieldCorreo;

    @FXML
    private TextField textFieldPass;

    UsuarioDAOImp usuarioDAOImp;
    ObservableList<Usuario> listaUsuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
        initGUI();
    }

    private void instancias() {
        usuarioDAOImp = new UsuarioDAOImp();
        listaUsuarios = FXCollections.observableArrayList();
    }

    private void initGUI() {}

    private void acciones() {
        botonLogin.setOnAction(new ManejoAction());
    }

    private void alert(String msg, Alert.AlertType type) {
        new Alert(type, msg).show();
    }

    class ManejoAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

            String correo = textFieldCorreo.getText();
            String pass = textFieldPass.getText();

            if (actionEvent.getSource() == botonLogin) {

                if (correo.isEmpty() || pass.isEmpty()) {
                    alert("Faltan datos por introducir", Alert.AlertType.ERROR);
                    return;
                }

                boolean existe = usuarioDAOImp.obtenerUsuario(pass, correo);

                if (existe) {
                    alert("Has entrado correctamente", Alert.AlertType.CONFIRMATION);

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("productos-view.fxml"));
                        Parent root = loader.load();

                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();


                        botonLogin.getScene().getWindow().hide();

                    } catch (IOException e) {
                        alert("Error abriendo la ventana de productos", Alert.AlertType.ERROR);
                        e.printStackTrace();
                    }

                } else {
                    alert("Usuario o contraseña incorrectos", Alert.AlertType.ERROR);
                }
            }
        }
    }
}
