package Garaje.controler;

import java.util.ArrayList;
import java.util.Scanner;

public class Garaje {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Object[]> listaCoches = new ArrayList<>();

    public void anadirCoches(String marca, String modelo, int costeReparacion, String matricula){
        Object[] coche = new Object[]{marca,modelo,costeReparacion,matricula};

        for (Object[] item : listaCoches) {
            if (item[3].equals(matricula)) {
                System.out.println("Ya existe un coche con esta matrícula: " + matricula);
                return;
            }
        }

        if (listaCoches.size()<5){
            listaCoches.add(coche);
        } else {
            System.out.println("No hay mas plazas");
        }

    }

    public void mostrarCoches(){
        for (Object[] coche : listaCoches){
            System.out.println(coche[0]+" - "+coche[1]+" - "+coche[3]);
        }
        if (listaCoches.isEmpty()){
            System.out.println("Garaje esta vacio");
        }
    }
    public void  mostrarCostes(){
        for (Object[] coche : listaCoches){
            System.out.println(coche[2]+"$");
        }
    }

    public void listarCoches(){
        ArrayList<Object[]> cochesOrdenados = new ArrayList<>(listaCoches);

        cochesOrdenados.sort((coche1, coche2) -> ((String) coche1[0]).compareToIgnoreCase((String) coche2[0]));

        System.out.println("Coches en el garaje ordenados por marca:");
        for (Object[] coche : cochesOrdenados){
            System.out.println("Marca: " + coche[0] + ", Modelo: " + coche[1] + ", CV: " + coche[2] + ", Matrícula: " + coche[3]);
        }
    }
    public void encontrarCoche(){
        System.out.println("Escribe la matricula de coche que quieres encontrar:");
        String cocheBuscado = scanner.next();
        boolean encontrado = false;

        for (Object[] item : listaCoches) {
            if (item[3].equals(cocheBuscado)) {
                System.out.println("Coche encontrado:");
                System.out.println("Marca: " + item[0] + ", Modelo: " + item[1] + ", Coste: " + item[2] + ", Matrícula: " + item[3]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún coche con la matrícula: " + cocheBuscado);
        }
    }
    public void eliminarCoche(){
        System.out.println("Escribe la matricula de coche que quieres eliminar:");
        String cocheBuscado = scanner.next();
        boolean encontrado = false;

        for (int i = 0; i < listaCoches.size(); i++) {
            Object[] coche = listaCoches.get(i);

            if (coche[3].equals(cocheBuscado)) {
                System.out.println("Coche eliminado: Marca: " + coche[0] + ", Modelo: " + coche[1] + ", Matrícula: " + coche[3]);
                listaCoches.remove(i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún coche con la matrícula: " + cocheBuscado);
        }
    }
    public void vaciarLista(){
        listaCoches.clear();
    }


}
