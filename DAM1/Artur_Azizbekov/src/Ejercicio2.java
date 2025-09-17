import java.util.Scanner;

public class Ejercicio2 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        int numeroLoteria = (int)(Math.random() * 9000) + 1000;


        System.out.println("Introduce un número entre 1000 y 9999:");
        int numeroUsuario = lectorTeclado.nextInt();

        int unidadesLoteria = numeroLoteria % 10;
        int decenasLoteria = (numeroLoteria / 10) % 10;
        int centenasLoteria = (numeroLoteria / 100) % 10;
        int millaresLoteria = numeroLoteria / 1000;

        int unidadesUsuario = numeroUsuario % 10;
        int decenasUsuario = (numeroUsuario / 10) % 10;
        int centenasUsuario = (numeroUsuario / 100) % 10;
        int millaresUsuario = numeroUsuario / 1000;

        boolean aciertaUnidades = unidadesLoteria == unidadesUsuario;
        boolean aciertaDecenas = decenasLoteria == decenasUsuario;
        boolean aciertaCentenas = centenasLoteria == centenasUsuario;
        boolean aciertaMillares = millaresLoteria == millaresUsuario;
        boolean aciertaTodos = aciertaUnidades && aciertaDecenas && aciertaCentenas && aciertaMillares;

        System.out.println("Número de la lotería: " + numeroLoteria);
        System.out.println("Has acertado las unidades: " + aciertaUnidades);
        System.out.println("Has acertado las decenas: " + aciertaDecenas);
        System.out.println("Has acertado las centenas: " + aciertaCentenas);
        System.out.println("Has acertado los millares: " + aciertaMillares);
        System.out.println("Has acertado todos: " + aciertaTodos);

    }
}
