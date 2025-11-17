package org.example.pizzeria.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.example.pizzeria.dao.PedidoDAOImp;
import org.example.pizzeria.model.Pedido;
import org.example.pizzeria.model.Pizza;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML private Button botonDetalle;
    @FXML private Button botonMostrarPendientes;
    @FXML private Button botonPedido;
    @FXML private Button botonServir;

    @FXML private ComboBox<Pizza> comboPizza;
    @FXML private ListView<Pedido> listViewPedidos;

    @FXML private GridPane parteDerecha;

    @FXML private RadioButton radioFamiliar;
    @FXML private RadioButton radioMediana;
    @FXML private RadioButton radioPequenia;

    @FXML private TextField textNombre;
    @FXML private TextField textTelefono;

    @FXML private Text textTitulo;

    private ToggleGroup grupoSizePizza;
    private ObservableList<Pizza> listaPizzas;
    private ObservableList<Pedido> listaPedidos;

    private PedidoDAOImp pedidoDAOImp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void instancias() {
        pedidoDAOImp = new PedidoDAOImp();

        grupoSizePizza = new ToggleGroup();
        grupoSizePizza.getToggles().addAll(radioFamiliar, radioMediana, radioPequenia);

        // cargar pedidos desde DAO
        listaPedidos = FXCollections.observableArrayList(pedidoDAOImp.obtenerPedido());

        // pizzas iniciales
        listaPizzas = FXCollections.observableArrayList(
                new Pizza("Barbacoa", "", 0),
                new Pizza("Hawaiana", "", 0),
                new Pizza("Jamón y queso", "", 0),
                new Pizza("Cuatro quesos", "", 0)
        );
    }

    private void initGUI() {
        comboPizza.setItems(listaPizzas);
        listViewPedidos.setItems(listaPedidos);
    }

    private void acciones() {
        botonPedido.setOnAction(new ManejoActions());
        botonServir.setOnAction(new ManejoActions());
        botonMostrarPendientes.setOnAction(new ManejoActions());
        botonDetalle.setOnAction(new ManejoActions());
    }

    private double calcularPrecio(String tipoPizza, String size) {
        return switch (tipoPizza) {
            case "Barbacoa" ->
                    size.equals("Familiar") ? 15 : size.equals("Mediana") ? 12 : 7;
            case "Hawaiana" ->
                    size.equals("Familiar") ? 13 : size.equals("Mediana") ? 10 : 5;
            case "Jamón y queso" ->
                    size.equals("Familiar") ? 10 : size.equals("Mediana") ? 8 : 4;
            case "Cuatro quesos" ->
                    size.equals("Familiar") ? 17 : size.equals("Mediana") ? 13 : 8;
            default -> 0;
        };
    }

    private void limpiarDatos() {
        textNombre.clear();
        textTelefono.clear();
        grupoSizePizza.selectToggle(null);
        comboPizza.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    class ManejoActions implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            if (e.getSource() == botonPedido) {

                if (textNombre.getText().isEmpty() ||
                        textTelefono.getText().isEmpty() ||
                        comboPizza.getValue() == null ||
                        grupoSizePizza.getSelectedToggle() == null) {

                    mostrarAlerta("Error", "Rellena todos los campos.", Alert.AlertType.ERROR);
                    return;
                }

                String nombre = textNombre.getText();
                String telefono = textTelefono.getText();
                Pizza pizzaBase = comboPizza.getValue();

                RadioButton rb = (RadioButton) grupoSizePizza.getSelectedToggle();
                String size = rb.getText();

                double precio = calcularPrecio(pizzaBase.getNombre(), size);

                Pizza pizzaCompleta = new Pizza(pizzaBase.getNombre(), size, precio);

                Pedido nuevoPedido = new Pedido(
                        pedidoDAOImp.obtenerPedido(),
                        nombre,
                        telefono,
                        pizzaCompleta
                );

                try {
                    pedidoDAOImp.insertarPedido(nuevoPedido);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                listaPedidos.add(nuevoPedido);

                mostrarAlerta("Éxito", "Pedido añadido correctamente.", Alert.AlertType.INFORMATION);

                limpiarDatos();
            }

            // -------------------- BOTON SERVIR PEDIDO -----------------------
            if (e.getSource() == botonServir) {
                Pedido seleccionado = listViewPedidos.getSelectionModel().getSelectedItem();

                if (seleccionado == null) {
                    mostrarAlerta("Error", "Selecciona un pedido.", Alert.AlertType.ERROR);
                    return;
                }

                if (seleccionado.isServido()) {
                    mostrarAlerta("Info", "Este pedido ya está servido.", Alert.AlertType.INFORMATION);
                    return;
                }

                seleccionado.setServido(true);
                pedidoDAOImp.actualizarPedido(seleccionado);
                listViewPedidos.refresh();

                mostrarAlerta("Éxito", "Pedido servido.", Alert.AlertType.INFORMATION);
            }

            // -------------------- BOTON MOSTRAR PENDIENTES -----------------------
            if (e.getSource() == botonMostrarPendientes) {
                ObservableList<Pedido> pendientes =
                        listaPedidos.filtered(p -> !p.isServido());

                listViewPedidos.setItems(pendientes);
            }

            // -------------------- BOTON DETALLE -----------------------
            if (e.getSource() == botonDetalle) {
                Pedido seleccionado = listViewPedidos.getSelectionModel().getSelectedItem();

                if (seleccionado == null) {
                    mostrarAlerta("Error", "Selecciona un pedido.", Alert.AlertType.ERROR);
                    return;
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Detalle del Pedido");
                alert.setHeaderText("Información del pedido");

                alert.setContentText(
                        "ID: " + seleccionado.getId() + "\n" +
                                "Nombre: " + seleccionado.getNombre() + "\n" +
                                "Teléfono: " + seleccionado.getTelefono() + "\n" +
                                "Pizza: " + seleccionado.getPizza().getNombre() + "\n" +
                                "Tamaño: " + seleccionado.getPizza().getTamaño() + "\n" +
                                "Precio: " + seleccionado.getPizza().getPrecio() + " €\n" +
                                "Estado: " + (seleccionado.isServido() ? "SERVIDO" : "PENDIENTE")
                );

                alert.showAndWait();
            }
        }
    }
}
