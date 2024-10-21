import java.util.Scanner;
public class Prueba {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Elige opcion:");
            System.out.println("1.Opcion añadir\n2.Opcion borrar\n3.Opcion listar\n4.Opcion buscar\n5.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ejecutando opcion 1...");
                    break;
                case 2:
                    System.out.println("Ejecutando opcion 2...");
                    break;
                case 3:
                    System.out.println("Ejecutando opcion 3...");
                    break;
                case 4:
                    System.out.println("Ejecutando opcion 4...");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

        } while(opcion!=5);
    }
}
