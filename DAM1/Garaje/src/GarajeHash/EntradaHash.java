package GarajeHash;

import Garaje.controler.Garaje;
import GarajeHash.controler.GarajeHash;

import java.util.Scanner;

public class EntradaHash {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido");
        GarajeHash garaje = new GarajeHash();
        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1.Añadir coche\n2.Listar coches\n3.Buscar coche");
            System.out.println("4.Mostrar costes\n5.Eliminar coche\n6.Vaciar garaje");
            System.out.println("7.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    garaje.agregarCoche();
                    break;
                case 2:
                    garaje.listarCoches();
                    break;
                case 3:
                    garaje.buscarCoche();
                    break;
                case 4:
                    garaje.mostrarCostes();
                    break;
                case 5:
                    garaje.eliminarCoche();
                    break;
                case 6:
                    garaje.vaciarLista();
                    break;
                case 7:
                    System.out.println("Saliendo de programa...");
                    break;
            }
        } while (opcion!=7);
    }
}
