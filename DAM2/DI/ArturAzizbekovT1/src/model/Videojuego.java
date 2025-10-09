package model;

abstract public class Videojuego {
    private String titulo,desarollador,clasificacionEdad;
    private int anoLanzamiento;
    private double precio;


    public Videojuego() {
    }

    public Videojuego(String titulo, String desarollador, String clasificacionEdad, int anoLanzamiento, double precio) {
        this.titulo = titulo;
        this.desarollador = desarollador;
        this.clasificacionEdad = clasificacionEdad;
        this.anoLanzamiento = anoLanzamiento;
        this.precio = precio;
    }


    public void calcularPrecioFinal(){}



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarollador() {
        return desarollador;
    }

    public void setDesarollador(String desarollador) {
        this.desarollador = desarollador;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public int getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public void setAnoLanzamiento(int anoLanzamiento) {
        this.anoLanzamiento = anoLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", desarollador='" + desarollador + '\'' +
                ", clasificacionEdad='" + clasificacionEdad + '\'' +
                ", anoLanzamiento=" + anoLanzamiento +
                ", precio=" + precio +
                '}';
    }
}
