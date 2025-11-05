package org.example.formulario.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.formulario.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private Button buttonAgregar;

    @FXML
    private Button buttonDetalle;

    @FXML
    private Button buttonEliminar;

    @FXML
    private CheckBox checkDisponibilidad;

    @FXML
    private ComboBox<Integer> comboEdad;

    @FXML
    private BorderPane panelGeneral;
    @FXML
    private ListView<Usuario> listViewUsuario;

    @FXML
    private GridPane parteDerecha;

    @FXML
    private RadioButton radioFemenino;

    @FXML
    private RadioButton radioMasculino;

    @FXML
    private TextField textfieldNombre;

    @FXML
    private TextField textfieldCorreo;

    @FXML
    private TextField textfieldLocalizacion;

    @FXML
    private ToggleButton toggleLista;

    private ToggleGroup grupoGenero;

    private ObservableList<Integer> listaEdades;
    private ObservableList<Usuario> listaUsuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {
        buttonAgregar.setOnAction(new ManejoActions());
        buttonEliminar.setOnAction(new ManejoActions());
        checkDisponibilidad.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldValue, Boolean newValue) {
                buttonAgregar.setDisable(!newValue);

            }
        });
        toggleLista.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean aBoolean, Boolean t1) {
                if (t1) {
                    panelGeneral.setRight(parteDerecha);
                } else {
                    panelGeneral.setRight(null);
                }
            }
        });
    }

    private void instancias() {
        grupoGenero = new ToggleGroup();
        grupoGenero.getToggles().addAll(radioMasculino, radioFemenino);
        listaEdades = FXCollections.observableArrayList();
        listaUsuarios = FXCollections.observableArrayList();
        for (int i = 18; i < 91; i++) {
            listaEdades.add(i);
        }
    }

    private void initGUI() {
        listViewUsuario.setItems(listaUsuarios);
        comboEdad.setItems(listaEdades);
        buttonAgregar.setDisable(!checkDisponibilidad.isSelected());
        if (toggleLista.isSelected()) {
            panelGeneral.setRight(parteDerecha);
        } else {
            panelGeneral.setRight(null);
        }
    }
    private Usuario estaUsuario(String correo) {

        for (Usuario item : listaUsuarios) {
            if (item.getCorreo().equalsIgnoreCase(correo)) {
                return item;
            }
        }

        return null;
    }
    private void limpiarDatos() {
        textfieldNombre.clear();
        textfieldCorreo.clear();
        textfieldLocalizacion.clear();
        checkDisponibilidad.setSelected(false);
        grupoGenero.selectToggle(null);
        comboEdad.getSelectionModel().select(-1);
    }

    class ManejoActions implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == buttonAgregar) {


                if (!textfieldNombre.getText().isEmpty()
                        && !textfieldCorreo.getText().isEmpty()
                        && !textfieldLocalizacion.getText().isEmpty()
                        && grupoGenero.getSelectedToggle() != null
                        && comboEdad.getSelectionModel().getSelectedItem() >= 0
                ) {
                    String nombre = textfieldNombre.getText();
                    String correo = textfieldCorreo.getText();
                    String localizacion = textfieldLocalizacion.getText();
                    String genero = ((RadioButton) grupoGenero.getSelectedToggle()).getText();
                    boolean disponibilidad = checkDisponibilidad.isSelected();
                    int edad = comboEdad.getSelectionModel().getSelectedItem();

                    if (estaUsuario(correo) != null) {

                        System.out.println("El usuario ya esta en la lista");
                    } else {
                        Usuario usuario = new Usuario(
                                nombre, correo, localizacion, genero, edad, disponibilidad
                        );
                        listaUsuarios.add(usuario);
                        System.out.println("Usuario agregado correctamente");
                        limpiarDatos();
                    }

                }


                // limpiar todos los datso
            }
            else if (actionEvent.getSource() == buttonDetalle) {
                int posicionSeleccionada = listViewUsuario.getSelectionModel().getSelectedIndex();
                Usuario usuarioSeleccionado = listViewUsuario.getSelectionModel().getSelectedItem();
                System.out.println("La posicion seleccionada es "+posicionSeleccionada);
                System.out.println("El elemento seleccionado es "+usuarioSeleccionado.getCorreo());
            }
            else if (actionEvent.getSource() == buttonEliminar) {

                if (listViewUsuario.getSelectionModel().getSelectedIndex() != -1){
                    listaUsuarios.remove(listViewUsuario.getSelectionModel().getSelectedIndex());
                } else {
                    System.out.println("no hay nada selecionado");
                    Stage ventanaDialogo = new Stage();
                    try {
                        FXMLLoader loader = new FXMLLoader(FormController.this.getClass().getResource("dialogo-view.fxml"));
                        Scene scene = new Scene(loader.load());
                        ventanaDialogo.setScene(scene);
                        ventanaDialogo.setTitle("Confirmacion");
                        ventanaDialogo.setResizable(false);
                        ventanaDialogo.show();
                    } catch (IOException e){
                        throw new RuntimeException(e);
                    }

                    ventanaDialogo.show();
                }
            }
        }
    }
}