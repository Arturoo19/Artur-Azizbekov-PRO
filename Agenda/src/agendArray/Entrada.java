package agendArray;

import agendArray.controler.Agenda;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido");
        Agenda agenda = new Agenda();
        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1.Agregar persona\n2.Buscar persona\n3.Borrar persona");
            System.out.println("4.Listar personas");
            System.out.println("5.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    agenda.agregarPersona();
                    break;
                case 2:
                    agenda.busacarPersona();
                    break;
                case 3:
                    agenda.borrarPersona();
                    break;
                case 4:
                    agenda.listarPersonas();
                    break;
                case 5:
                    System.out.println("Saliendo de programa...");
                    break;
            }
        } while (opcion!=5);
    }
}
