package Ejercicio1.Formula1;

import Ejercicio1.Formula1.controler.Formula1;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Formula1 formula1 = new Formula1();
        int opcion;
        do {
            System.out.println("1.agregar piloto");
            System.out.println("2.Actualizar puntos");
            System.out.println("3.Mostrar informacion de un piloto");
            System.out.println("4.Mostrar clasificación:");
            System.out.println("5.Salir del programa");
            System.out.println("Elige la opcion:");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    formula1.agregarPilotos();
                    break;
                case 2:
                    formula1.actualizarPuntos();
                    break;
                case 3:
                    formula1.mostrarInformacionPiloto();
                    break;
                case 4:
                    formula1.mostrarClasificacion();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion!=5);
    }
}
