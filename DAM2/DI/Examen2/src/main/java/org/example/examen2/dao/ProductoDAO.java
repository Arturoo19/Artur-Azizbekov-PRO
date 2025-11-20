package org.example.examen2.dao;

import org.example.examen2.model.Producto;

import java.sql.SQLException;
import java.util.List;

public interface ProductoDAO {
    void insertarProducto(Producto producto) throws SQLException;
    List<Producto> obtenerProductos();
}
