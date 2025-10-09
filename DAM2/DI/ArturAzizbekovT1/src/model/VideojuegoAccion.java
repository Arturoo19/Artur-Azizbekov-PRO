package model;

public class VideojuegoAccion extends Videojuego{
    private int  nivelViolencia;
    private boolean modoMultijugador;

    public VideojuegoAccion(String titulo, String desarollador, String clasificacionEdad, int anoLanzamiento, double precio) {
        super(titulo, desarollador, clasificacionEdad, anoLanzamiento, precio);
    }

    public VideojuegoAccion(String titulo, String desarollador, String clasificacionEdad, int anoLanzamiento, double precio, int nivelViolencia, boolean modoMultijugador) {
        super(titulo, desarollador, clasificacionEdad, anoLanzamiento, precio);
        this.nivelViolencia = nivelViolencia;
        this.modoMultijugador = modoMultijugador;
    }


    @Override
    public void calcularPrecioFinal(){
        double precio = super.getPrecio();
        if (nivelViolencia>3){
            precio = ((super.getPrecio()*5)/100);
            super.setPrecio(precio);
            System.out.println("Ahora precio es:"+precio);
        } else if (nivelViolencia>3 && modoMultijugador){
            precio = ((super.getPrecio()*30)/100);
            super.setPrecio(precio);
            System.out.println("Ahora precio es:"+precio);

        }else if (modoMultijugador) {
            precio = ((super.getPrecio()*10)/100);
            super.setPrecio(precio);
            System.out.println("Ahora precio es:"+precio);
        }
    }



    public int getNivelViolencia() {
        return nivelViolencia;
    }

    public void setNivelViolencia(int nivelViolencia) {
        this.nivelViolencia = nivelViolencia;
    }

    public boolean isModoMultijugador() {
        return modoMultijugador;
    }

    public void setModoMultijugador(boolean modoMultijugador) {
        this.modoMultijugador = modoMultijugador;
    }
}
