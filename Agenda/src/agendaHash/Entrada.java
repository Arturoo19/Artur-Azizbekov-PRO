package agendaHash;

import agendaHash.controler.AgendaHash;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Bienvenido");
        AgendaHash agendaHash = new AgendaHash();
        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1.Agregar persona\n2.Buscar persona\n3.Borrar persona");
            System.out.println("4.Listar personas\n 5.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    agendaHash.agregarPersoans();
                    break;
                case 2:
                    agendaHash.buscarPersona();
                    break;
                case 3:
                    agendaHash.eliminarPersona();
                    break;
                case 4:
                    agendaHash.mostrarUsuarios();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (opcion!=5);




    }
}
