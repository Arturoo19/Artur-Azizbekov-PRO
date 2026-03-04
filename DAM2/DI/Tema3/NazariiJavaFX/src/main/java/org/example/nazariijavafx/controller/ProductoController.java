package org.example.nazariijavafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.nazariijavafx.dao.ProductoDAO;
import org.example.nazariijavafx.model.Producto;

public class ProductoController {

    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtDescripcion;
    @FXML private TextField txtPrecio;

    private ProductoDAO productoDAO;

    public void initialize() {
        productoDAO = new ProductoDAO();
    }

    @FXML
    public void onAgregar() {

        if (txtCodigo.getText().isEmpty() ||
                txtNombre.getText().isEmpty() ||
                txtPrecio.getText().isEmpty()) {

            mostrarAlerta("Campos incompletos");
            return;
        }

        try {
            double precio = Double.parseDouble(txtPrecio.getText());

            Producto producto = new Producto(
                    txtCodigo.getText(),
                    txtNombre.getText(),
                    txtDescripcion.getText(),
                    precio
            );

            if (productoDAO.insertarProducto(producto)) {
                mostrarAlerta("Producto agregado correctamente");
                limpiar();
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Precio inválido");
        }
    }

    @FXML
    public void onIrLista() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/org/example/nazariijavafx/lista-view.fxml"
                    )
            );

            Stage stage = (Stage) txtCodigo.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("No se pudo abrir la lista");
        }
    }

    private void limpiar() {
        txtCodigo.clear();
        txtNombre.clear();
        txtDescripcion.clear();
        txtPrecio.clear();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}