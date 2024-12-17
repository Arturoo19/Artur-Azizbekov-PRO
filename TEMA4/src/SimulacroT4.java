
import java.util.Random;
import java.util.Scanner;

public class SimulacroT4 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int opcion;
        double total = 0;
        do {
            System.out.println("1.Realizar pedido\n2.Servir pedido\n3.Mostrar pedidos pendientes\n");
            System.out.println("4.Mostraar caja");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Object[] pedidosPendientes = new Object[5];
                    System.out.println("Como te llamas?");
                    String nombre = scanner.nextLine();

                    pedidosPendientes[1] = nombre;
                    int id =;

                    System.out.println("Introduce tu telefono:");
                    int telefono = scanner.nextInt();

                    int cantidad = scanner.nextInt();
                    String[] ingredientes = new String[cantidad];


                    if (cantidad < 1) {
                        System.out.println("Cantidad tiene que ser mayor que uno");
                    } else {
                        int menu;
                        System.out.println("Elige igredientes:");
                        System.out.println("1.Lomo(0,20$)\n2.Tomate(0,20$)\n3.Ketchup(0,15$)\n4.Mayonesa(0,15$)\n" +
                                "5.Terminar");
                        for (int i = 0; i < cantidad; i++) {

                            menu = scanner.nextInt();
                            switch (menu){
                                case 1:
                                    total+=0.20;
                                    System.out.println("Has añadido lomo");
                                    ingredientes[i] = "Lomo";
                                    break;
                                case 2:
                                    total+=0.20;
                                    System.out.println("Has añadido tomate");
                                    ingredientes[i] = "Tomate";
                                    break;
                                case 3:
                                    total+=0.15;
                                    System.out.println("Has añadido Ketchup");
                                    ingredientes[i] = "Ketchup";
                                    break;
                                case 4:
                                    total+=0.15;
                                    System.out.println("Has añadido mayonesa");
                                    ingredientes[i] = "Mayonesa";

                                    break;
                                case 5:
                                    System.out.println("Saliendo...");
                                    break;
                            }
                        }
                    }
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Saliendo de progrma...");
                    break;
            }
        } while (opcion!=5);

    }

}
