import java.util.Scanner;
public class Ejercicio4 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce su nombre y apellido:");
        String nombre = lectorTeclado.nextLine();

        System.out.println("Sueldo que espere recibir:");
        int sueldo = lectorTeclado.nextInt();

        System.out.println("Su edad:");
        int edad = lectorTeclado.nextInt();

        System.out.println("Introduce el dia de su cumpleaños:");
        int diaDeCumple = lectorTeclado.nextInt();

        System.out.println("Tiene carné de conducir(true/false):");
        boolean carnet = lectorTeclado.hasNext();

        boolean opcion1 = edad<50 && sueldo<40000 && carnet;
        boolean opcion2 = edad>45 && sueldo<20000 && diaDeCumple%2==0;
        boolean resumen = opcion2 || opcion1;

        System.out.printf("Con los datos introducidos, el candidato cuyo nombre es %s" +
                "tiene como resolución:%b",nombre, resumen);
    }
}
