package agendaHash;

import agendaHash.controler.AgendaHash;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AgendaHash agenda = new AgendaHash();
        System.out.println("Escribe su nombre:");
        String nombre = scanner.next();
        System.out.println("Escribe apellido:");
        String apellido = scanner.next();
        System.out.println("Escribe su telefono:");
        int telefono = scanner.nextInt();
        System.out.println("Escribe su DNI:");
        String dni = scanner.next();


    }
}
