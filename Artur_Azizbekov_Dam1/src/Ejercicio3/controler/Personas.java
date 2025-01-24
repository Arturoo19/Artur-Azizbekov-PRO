package Ejercicio3.controler;

import java.util.ArrayList;
import java.util.Scanner;

public class Personas {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Object[]> listaPersonas = new ArrayList<>();
    Object[] nuevaPersona;

    public void agregarPersona(){
        System.out.println("Escribe el nombre:");
        String nombre = scanner.next();
        System.out.println("Escribe el apellido:");
        String apellido = scanner.next();
        System.out.println("Escribe el telefono:");
        int telefono = scanner.nextInt();
        System.out.println("Escribe el dni:");
        String dni = scanner.next();
        System.out.println("Escribe la disponibilidad(si/no):");
        String disponibilidad = scanner.next();

        nuevaPersona = new Object[]{nombre,apellido,telefono,dni,disponibilidad};

        listaPersonas.add(nuevaPersona);


    }
    public void buscarPersona(){
        System.out.println("Introduce el dni de la persona que quieres encontrar:");
        String personaBuscar = scanner.next();
        for (Object[] item: listaPersonas){
            if (item[3].equals(personaBuscar)){
                System.out.println("Persona encotrada:");
                System.out.println("Nombre:"+item[0]+" Apellido:"+item[1]+" Telefono:"+item[2]+" DNI:"+item[3]);
                return;
            }
        }
        System.out.println("No hemos encotrado la persona con dni:"+personaBuscar);
    }
    public void borrarPerosna(){
        System.out.println("Introduce el dni de la persona que quieres borrar:");
        String personaBorrar = scanner.next();

        for (Object[] item : listaPersonas){
            if (item[3].equals(personaBorrar)){
                System.out.println("Persona borrada:");
                System.out.println("Nombre:"+item[0]);
                listaPersonas.remove(item);
                return;
            }
        }
        System.out.println("No hemos encotrado la persona con dni:"+personaBorrar);
    }
    public void borrarSinDisponibilidad(){
        for (int i = listaPersonas.size()-1; i>=0; i--) {
            if (listaPersonas.get(i)[4].equals("no")){
                System.out.println("Persona eliminada");
                listaPersonas.remove(i);
            }
        }
    }
    public void listarPersonas(){
        System.out.println("Lista de personas:");
        for (Object[] item : listaPersonas){
            System.out.println("Nombre:"+item[0]+" Apellido:"+item[1]+" Telefono:"+item[2]+" DNI:"+item[3]);
        }
    }
}
