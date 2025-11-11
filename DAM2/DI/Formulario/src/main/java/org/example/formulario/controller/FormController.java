
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.formulario.HelloApplication;
import org.example.formulario.dao.UsuarioDAOImp;
import org.example.formulario.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private Button buttonDetalle;
    @FXML
    private MenuItem menuEliminar, menuDetalle, menuLista;

    @FXML
    private Button buttonAgregar;

    @FXML
    private Button buttonEliminar;

    @FXML
    private Button buttonModificar;

    @FXML
    private CheckBox checkDisponibilidad;

    @FXML
    private ComboBox<Integer> comboEdad;

    @FXML
    private BorderPane panelGeneral;

    @FXML
    private GridPane parteDerecha;

    @FXML
    private ListView<Usuario> listViewUsuarios;

    @FXML
    private RadioButton radioFemenino;

    @FXML
    private RadioButton radioMasculino;

    @FXML
    private TextField textfieldCorreo;

    @FXML
    private TextField textfieldLocalizacion;

    @FXML
    private TextField textfieldNombre;

    @FXML
    private ToggleButton toggleLista;

    private ToggleGroup grupoGenero;

    private ObservableList<Integer> listaEdades;
    private ObservableList<Usuario> listaUsuarios;
    private UsuarioDAOImp usuarioDAOImp;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        initGUI();
        acciones();

    }

    private void acciones() {
        buttonDetalle.setOnAction(new ManejoActions());
        buttonAgregar.setOnAction(new ManejoActions());
        buttonEliminar.setOnAction(new ManejoActions());
        menuEliminar.setOnAction(new ManejoActions());
        menuLista.setOnAction(new ManejoActions());
        menuDetalle.setOnAction(new ManejoActions());
        buttonModificar.setOnAction(new ManejoActions());

        checkDisponibilidad.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                System.out.println("Venimos de:" + oldValue);
                System.out.println("Estamos en:" + newValue);
                buttonAgregar.setDisable(!newValue);
            }
        });


        toggleLista.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    panelGeneral.setRight(parteDerecha);
                } else {
                    panelGeneral.setRight(null);
                }

            }
        });
    }

    private void instancias() {
        usuarioDAOImp = new UsuarioDAOImp();
        grupoGenero = new ToggleGroup();
        grupoGenero.getToggles().addAll(radioMasculino, radioFemenino);
        listaEdades = FXCollections.observableArrayList();
        listaUsuarios = FXCollections.observableArrayList(usuarioDAOImp.obtenerUsuarios());
        for (int i = 18; i < 91; i++) {
            listaEdades.add(i);
        }

    }

    private void limpiarDatos() {
        textfieldNombre.clear();
        textfieldCorreo.clear();
        textfieldLocalizacion.clear();
        checkDisponibilidad.setSelected(false);
        grupoGenero.selectToggle(null);
        comboEdad.getSelectionModel().select(-1);
    }

    private void initGUI() {
        listViewUsuarios.setItems(listaUsuarios);
        comboEdad.setItems(listaEdades);
        buttonAgregar.setDisable(!checkDisponibilidad.isSelected());
        if (toggleLista.isSelected()) {
            panelGeneral.setRight(parteDerecha);
        } else {
            panelGeneral.setRight(null);
        }

    }

    public void actualizarUsuario(Usuario u) {
        listViewUsuarios.refresh();
        System.out.println("Contestacion realizada con exito");

    }

    private Usuario estaUsuario(String correo) {

        for (Usuario item : listaUsuarios) {
            if (item.getCorreo().equalsIgnoreCase(correo)) {
                return item;
            }
        }

        return null;
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

                    Usuario usuario = new Usuario(
                            nombre, correo, localizacion, genero, edad, disponibilidad
                    );
                    boolean fallo;
                    try {
                        usuarioDAOImp.insertarUsuario(usuario);
                        listaUsuarios.add(usuario);

                    } catch (SQLException e){
                        fallo = true;
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Insercion incorrecta");
                        alert.show();

                    }

                    /*
                    if (estaUsuario(correo) != null) {

                        System.out.println("El usuario ya esta en la lista");
                    } else {

                        listaUsuarios.add(usuario);
                        System.out.println("Usuario agregado correctamente");
                        limpiarDatos();
                    }*/
                }

                // limpiar todos los datso
            }
            else if (actionEvent.getSource() == buttonDetalle || actionEvent.getSource() == menuDetalle ) {
                int posicionSeleccionada = listViewUsuarios.getSelectionModel().getSelectedIndex();
                if (posicionSeleccionada != -1) {
                    Usuario usuario = listViewUsuarios.getSelectionModel().getSelectedItem();
                    Stage ventanaDetalle = new Stage();
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("detalle-view.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                        DialogoController dialogoController = loader.getController();
                        dialogoController.setUsuario(usuario);
                        dialogoController.setFormController(FormController.this);
                        Scene scene = new Scene(root);
                        ventanaDetalle.setScene(scene);
                        ventanaDetalle.initModality(Modality.APPLICATION_MODAL);
                        ventanaDetalle.setTitle("Ventana detalle");
                        ventanaDetalle.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else if (actionEvent.getSource() == buttonEliminar || actionEvent.getSource() == menuEliminar) {
                if (listViewUsuarios.getSelectionModel().getSelectedIndex() != -1) {
                    usuarioDAOImp.borrarUsuarios(listViewUsuarios.getSelectionModel().getSelectedItem().getNombre());
                    listaUsuarios.remove(listViewUsuarios.getSelectionModel().getSelectedIndex());
                } else {
                    System.out.println("No hay nada seleccionado");
                    Stage ventanaDialogo = new Stage();
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("dialogo-view.fxml"));
                        Scene scene = new Scene(loader.load());
                        ventanaDialogo.setScene(scene);
                        ventanaDialogo.setTitle("Confirmacion");
                        ventanaDialogo.setResizable(false);
                        ventanaDialogo.initModality(Modality.APPLICATION_MODAL);
                        ventanaDialogo.showAndWait();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
            else if (actionEvent.getSource() == menuLista){
                toggleLista.setSelected(!toggleLista.isSelected());
            } else if (actionEvent.getSource() == buttonModificar) {
                int posicionSeleccionada = listViewUsuarios.getSelectionModel().getSelectedIndex();
                if (posicionSeleccionada != -1) {
                    Usuario usuario = listViewUsuarios.getSelectionModel().getSelectedItem();
                    Stage ventanaModificar = new Stage();
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("modificar-view.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                        ModificarController modificarController = loader.getController();
                        modificarController.setUsuario(usuario);
                        modificarController.setFormController(FormController.this);


                        ventanaModificar.setScene(new Scene(root));
                        ventanaModificar.initModality(Modality.APPLICATION_MODAL);
                        ventanaModificar.setTitle("Modificar usuario");
                        ventanaModificar.showAndWait();

                        listViewUsuarios.refresh();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("⚠️ No hay usuario seleccionado");
                }
            }



        }
    }
}