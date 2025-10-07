package model;

import java.util.ArrayList;

public class PlataformaJuegos {
    //логіка вся і методи

    private ArrayList<Videojuego> listaVideojuegos;

    public PlataformaJuegos() {
        this.listaVideojuegos = new ArrayList<>();
    }



    public void agregarJuego(Videojuego videojuego){
        listaVideojuegos.add(videojuego);
        System.out.println("Videojuego agregado");

    }
    public void eliminarJuego(Videojuego videojuego){
        listaVideojuegos.remove(videojuego);
    }

    public void mostrarJuegos(){
        for (Videojuego videojuego:listaVideojuegos){
            System.out.println(videojuego);
        }
    }

    public void filtrarPorClasificacionEdad(String clasificacion) {
        System.out.println("Juegos con clasificación: " + clasificacion);
        for (Videojuego v : listaVideojuegos) {
            if (v.getClasificacionEdad().equalsIgnoreCase(clasificacion)) {
                System.out.println(v);
            }
        }
    }

    public void calcularPrecioTotal(){
        double precio = 0;
        for (Videojuego videojuego:listaVideojuegos){
            precio += videojuego.getPrecio();
        }
    }



    public ArrayList<Videojuego> getListaVideojuegos() {
        return listaVideojuegos;
    }

    public void setListaVideojuegos(ArrayList<Videojuego> listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
    }
}
