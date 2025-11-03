package org.example.formulario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    private String nombre,correo,localizacion;
    private int edad;
    private boolean desponibilidad;


    public Usuario(String nombre, String correo, String localizacion, String genero, int edad, boolean disponibilidad) {
    }
}
