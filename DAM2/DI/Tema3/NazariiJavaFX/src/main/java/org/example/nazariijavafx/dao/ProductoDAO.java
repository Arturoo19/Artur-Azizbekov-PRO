package org.example.nazariijavafx.dao;

import org.example.nazariijavafx.database.DBConnection;
import org.example.nazariijavafx.database.SchemaDB;
import org.example.nazariijavafx.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private Connection connection;

    public ProductoDAO() {
        connection = DBConnection.getConnection();
    }

    public boolean insertarProducto(Producto producto) {

        String sql = "INSERT INTO " + SchemaDB.TBL_PRODUCTOS +
                " (" + SchemaDB.COL_CODIGO + ", " +
                SchemaDB.COL_NOMBRE + ", " +
                SchemaDB.COL_DESCRIPCION + ", " +
                SchemaDB.COL_PRECIO + ") VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());

            int filas = ps.executeUpdate();

            System.out.println("Filas insertadas: " + filas);

            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Producto> obtenerProductos() {

        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + SchemaDB.TBL_PRODUCTOS;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                lista.add(new Producto(
                        rs.getInt(SchemaDB.COL_ID),
                        rs.getString(SchemaDB.COL_CODIGO),
                        rs.getString(SchemaDB.COL_NOMBRE),
                        rs.getString(SchemaDB.COL_DESCRIPCION),
                        rs.getDouble(SchemaDB.COL_PRECIO)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}