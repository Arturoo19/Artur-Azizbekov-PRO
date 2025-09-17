import java.util.Scanner;
public class EjercicioTres {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Escribe precio de coche: ");
        int precio = lectorTeclado.nextInt();

        System.out.println("En cuantos plazos vas a pagar: ");
        int plazos= lectorTeclado.nextInt();

        int resultado = precio/plazos;
        System.out.printf("Vas a pagar el coche de %d en %d meses, con un total de %d€ cada plazo",precio,plazos,resultado);

    }
}
