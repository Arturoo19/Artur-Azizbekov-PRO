package org.example.nazariijavafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.example.nazariijavafx.dao.ProductoDAO;
import org.example.nazariijavafx.model.Producto;

public class ListaController {

    @FXML
    private ListView<Producto> listViewProductos;

    private ProductoDAO productoDAO;

    public void initialize() {
        productoDAO = new ProductoDAO();
        listViewProductos.getItems().addAll(productoDAO.obtenerProductos());
    }
}