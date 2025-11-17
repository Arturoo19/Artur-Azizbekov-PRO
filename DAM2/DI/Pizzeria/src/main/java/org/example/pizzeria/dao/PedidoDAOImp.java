package org.example.pizzeria.dao;

import org.example.pizzeria.database.DBConection;
import org.example.pizzeria.database.SchemaDB;
import org.example.pizzeria.model.Pedido;
import org.example.pizzeria.model.Pizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImp implements PedidoDAO{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PedidoDAOImp(){
        connection = DBConection.getConnection();
    }

    @Override
    public void insertarPedido(Pedido pedido) throws SQLException {
        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)",
                SchemaDB.TAB_NAME,
                SchemaDB.COL_NOMBRE,
                SchemaDB.COL_TELEFONO,
                SchemaDB.COL_PIZZA
                );
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,pedido.getNombreCliente());
        preparedStatement.setInt(2,pedido.getTelefono());
        preparedStatement.setString(3, String.valueOf(pedido.getPizza()));
        preparedStatement.execute();
    }

    @Override
    public List<Pedido> obtenerPedido() {
        List<Pedido> lista = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM "+SchemaDB.TAB_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String nombre = resultSet.getString(SchemaDB.COL_NOMBRE);
                int telefono = resultSet.getInt(SchemaDB.COL_TELEFONO);
                //Pizza pizza = new Pizza(nombrePizza, "", 0);

                //Pedido pedido = new Pedido(nombre,telefono,pizza);
                //lista.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query");
        }

        return lista;
    }

    @Override
    public int borrarPedido(String nombre) {
        return 0;
    }
    public int obtenerSiguienteId() {
        try {
            String sql = "SELECT MAX(" + SchemaDB.COL_ID + ") AS max FROM " + SchemaDB.TAB_NAME;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("max") + 1;
            }
        } catch (SQLException ignored) {}

        return 1; // primera vez
    }
}
