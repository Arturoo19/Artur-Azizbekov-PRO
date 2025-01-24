package Ejercicio2.controler;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Alumnos {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    private ArrayList<Object[]> listaAlumnos = new ArrayList<>();
    int numAlumnos;

    public void agregarAlumnos(){
        System.out.println("Introduce el numero de alumnos:");
        numAlumnos = scanner.nextInt();

        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("Introduce el nombre de alumno "+(i+1));
            String nombre = scanner.next();
            //int nota = random.nextInt(0,10);
            Object[] alumno = new Object[]{nombre};
            listaAlumnos.add(alumno);
        }
    }
    public void calificarAlumnos(){
        for (int i = 0; i < numAlumnos; i++) {
            int nota = random.nextInt(0,10);
            Object[] notas  = new Object[]{nota};
            listaAlumnos.add(notas);
        }
    }

    public void verSuspensos(){
        for(Object[] item : listaAlumnos){
            if ((int) item[1] <=4){
                System.out.println("Nombre:"+item[0]+" Nota:"+item[1]);
            }
        }
    }
    public void verCalificaciones(){
        System.out.println("Alumnos:");
        for (Object[] item : listaAlumnos){
            System.out.println("Nombre:"+item[0]+ " Nota:"+item[1]);
        }
    }

}
