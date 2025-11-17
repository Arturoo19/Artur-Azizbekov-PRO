package org.example.pizzeria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pizza {
    private String nombre;
    private String size;
    private double precio;




    @Override
    public String toString() {
        return nombre;
    }
}
