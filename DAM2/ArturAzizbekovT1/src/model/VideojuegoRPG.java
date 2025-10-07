package model;

public class VideojuegoRPG extends Videojuego{
    private boolean mundoAbierto;
    private int horasHistoriaPrincipal;

    public VideojuegoRPG(String titulo, String desarollador, String clasificacionEdad, int anoLanzamiento, double precio) {
        super(titulo, desarollador, clasificacionEdad, anoLanzamiento, precio);
    }

    public VideojuegoRPG(String titulo, String desarollador, String clasificacionEdad, int anoLanzamiento, double precio, boolean mundoAbierto, int horasHistoriaPrincipal) {
        super(titulo, desarollador, clasificacionEdad, anoLanzamiento, precio);
        this.mundoAbierto = mundoAbierto;
        this.horasHistoriaPrincipal = horasHistoriaPrincipal;
    }

    @Override
    public void calcularPrecioFinal(){
        double precio = super.getPrecio();
        if (mundoAbierto){
            precio *= ((super.getPrecio()*15)/100);
            super.setPrecio(precio);
            System.out.println("Ahora precio es:"+precio);
        }
        if (horasHistoriaPrincipal>=10){
            precio *= (((precio*2)/100)* horasHistoriaPrincipal/2);
        }
        super.setPrecio(precio);
    }

    public boolean isMundoAbierto() {
        return mundoAbierto;
    }

    public void setMundoAbierto(boolean mundoAbierto) {
        this.mundoAbierto = mundoAbierto;
    }

    public int getHorasHistoriaPrincipal() {
        return horasHistoriaPrincipal;
    }

    public void setHorasHistoriaPrincipal(int horasHistoriaPrincipal) {
        this.horasHistoriaPrincipal = horasHistoriaPrincipal;
    }
}
