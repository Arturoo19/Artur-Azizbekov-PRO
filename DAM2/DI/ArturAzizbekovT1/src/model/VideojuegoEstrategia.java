package model;

public class VideojuegoEstrategia extends Videojuego{
    private int complejidad,duracionPartida;

    public VideojuegoEstrategia(String titulo, String desarollador, String clasificacionEdad, int anoLanzamiento, double precio) {
        super(titulo, desarollador, clasificacionEdad, anoLanzamiento, precio);
    }

    public VideojuegoEstrategia(String titulo, String desarollador, String clasificacionEdad, int anoLanzamiento, double precio, int complejidad, int duracionPartida) {
        super(titulo, desarollador, clasificacionEdad, anoLanzamiento, precio);
        this.complejidad = complejidad;
        this.duracionPartida = duracionPartida;
    }

    @Override
    public void calcularPrecioFinal(){
        double precio = getPrecio();
        if (complejidad>0){
            precio = ((super.getPrecio()+3)/100)*complejidad;
            super.setPrecio(precio);

            System.out.println("Ahora precio es:"+precio);
        }
    }


    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public int getDuracionPartida() {
        return duracionPartida;
    }

    public void setDuracionPartida(int duracionPartida) {
        this.duracionPartida = duracionPartida;
    }
}
