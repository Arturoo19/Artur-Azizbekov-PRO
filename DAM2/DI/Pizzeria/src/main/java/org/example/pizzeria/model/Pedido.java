package org.example.pizzeria.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pedido {
    private int id;
    private String nombreCliente;
    private int telefono;
    private Pizza pizza;
    private boolean servido;

    public Pedido(List<Pedido> pedidos, String nombre, String telefono, Pizza pizzaCompleta) {
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", id=" + id +
                ", pizza=" + pizza +
                '}';
    }
}
