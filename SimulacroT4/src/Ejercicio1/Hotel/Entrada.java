package Ejercicio1.Hotel;

import Ejercicio1.Hotel.controler.Hotel;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        int opcion;
        do {
            System.out.println("1.Registrar reservas");
            System.out.println("2.Cancelar reservas");
            System.out.println("3.Mostrar reservas actuales");
            System.out.println("4.Ordenar reservas");
            System.out.println("5.Salir del programa");
            System.out.println("Elige la opcion:");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    hotel.registrarReservas();
                    break;
                case 2:
                    hotel.cancelarReserva();
                    break;
                case 3:
                    hotel.mostrarReservas();
                    break;
                case 4:
                    hotel.reservasOrdenadas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion!=5);
    }

}


