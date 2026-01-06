package org.example.pizzeria.dao;

import org.example.pizzeria.model.Pedido;

import java.sql.SQLException;
import java.util.List;

public interface PedidoDAO {
    void insertarPedido(Pedido pedido) throws SQLException;
    List<Pedido> obtenerPedidos();
    List<Pedido> obtenerPedidosPendientes() throws SQLException;
    void marcarServido(int idPedido) throws SQLException;
    Pedido obtenerPedidoPorId(int idPedido) throws SQLException;


}
