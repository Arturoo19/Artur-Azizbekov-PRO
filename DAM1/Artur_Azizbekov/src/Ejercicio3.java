import java.util.Scanner;
public class Ejercicio3 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Tipo de cafe(espsesso,latte,capuchino):");
        String tipoCafe = lectorTeclado.next();

        System.out.println("Cantidad de azucar:");
        int cantidadAzucar = lectorTeclado.nextInt();

        System.out.println("Tamaño de cafe(pequeño,mediano,grande)");
        String tamano = lectorTeclado.next();

        System.out.printf("Preparando un %s de tamaño %s con %d cucharaditas de azucar" ,tipoCafe,tamano,cantidadAzucar);


    }
}
