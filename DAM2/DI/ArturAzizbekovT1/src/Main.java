import model.PlataformaJuegos;
import model.Videojuego;
import model.VideojuegoAccion;
import model.VideojuegoEstrategia;

public class Main {
    public static void main(String[] args) {
        PlataformaJuegos plataformaJuegos = new PlataformaJuegos();

        plataformaJuegos.agregarJuego(new VideojuegoAccion("titulo","Artur","jovenes",12,1212.0));
        plataformaJuegos.agregarJuego(new VideojuegoEstrategia("titulo","Artur","mayores",11,100.0,1,10));
        plataformaJuegos.mostrarJuegos();

    }
}
