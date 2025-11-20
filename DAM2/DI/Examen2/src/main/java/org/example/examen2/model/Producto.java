package org.example.examen2.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Producto {
    private int id,precio;
    private String nombreProducto,categoria;


}
