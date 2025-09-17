package Ejercicio2;

import Ejercicio2.controler.Alumnos;

import java.util.Scanner;
import java.util.SortedMap;

public class Entrada2 {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Alumnos alumnos = new Alumnos();
        alumnos.agregarAlumnos();
        System.out.println("Quieres calificar?(si/no)");
        String respuesta = scanner.next();
        if (respuesta.equals("si")){
            alumnos.calificarAlumnos();
        }

        int opcion;
        do {
            System.out.println("1.Ver suspensos\n2.Ver calificaciones\n3.Salir..");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    alumnos.verSuspensos();
                    break;
                case 2:
                    alumnos.verCalificaciones();
                    break;
                case 3:
                    System.out.println("Saliendo..");
                    break;
            }
        } while (opcion!=3);
    }
}
