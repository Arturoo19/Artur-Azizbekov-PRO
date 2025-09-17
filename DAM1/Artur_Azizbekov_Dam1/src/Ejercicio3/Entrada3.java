package Ejercicio3;

import Ejercicio1.controler.Productos;
import Ejercicio3.controler.Personas;

import java.util.Scanner;

public class Entrada3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Personas personas = new Personas();

        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Agregar persona\n2.Buscar persona\n3.Borrar persona");
            System.out.println("4.Borrar sin disponibilidad\n5.Listar personas\n6.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    personas.agregarPersona();
                    break;
                case 2:
                    personas.buscarPersona();
                    break;
                case 3:
                    personas.borrarPerosna();
                    break;
                case 4:
                    personas.borrarSinDisponibilidad();
                    break;
                case 5:
                    personas.listarPersonas();
                    break;
                case 6:
                    System.out.println("Saliendo..");
                    break;
            }
        } while(opcion!=6);

    }
}
