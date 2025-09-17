package agendArray.controler;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Object[]> listaPersonas = new ArrayList<>();

    public void agregarPersona(){
        String nombre;
        String apellido;
        int telefono;
        String dni;

        System.out.println("Escribe su nombre:");
        nombre = scanner.next();
        System.out.println("Escribe su apellido:");
        apellido = scanner.next();
        System.out.println("Escribe su Telefono:");
        telefono = scanner.nextInt();
        System.out.println("Escribe su DNI:");
        dni = scanner.next();

        Object[] personas = new Object[]{nombre,apellido,telefono,dni};
        listaPersonas.add(personas);

    }
    public void busacarPersona(){
        System.out.println("Escribe dni de persona que quieres encontrar:");
        String personaBuscada = scanner.next();
        boolean encontradao = false;

        for (Object[] item : listaPersonas){
            if (item[3].equals(personaBuscada)){
                System.out.println("Persona encotrada:");
                System.out.println("Nombre:"+item[0]+" Apellido:"+item[1]+" Telefono:"+item[2]+" DNI:"+item[3]);
                encontradao = true;
            }
        }
        if (!encontradao){
            System.out.println("No hemos encotrado la persona en la lista");
        }
    }
    public void borrarPersona(){
        System.out.println("Escribe dni de la persona que quieres borrar:");
        String personaBorrar = scanner.next();
        boolean encotrado = false;

        for (int i = 0; i < listaPersonas.size(); i++) {
            Object[] persona = listaPersonas.get(i);

            if (persona[3].equals(personaBorrar)){
                System.out.println("Persona con dni:"+persona[3]+" borrada");
                listaPersonas.remove(i);
                encotrado = true;
                break;
            }
        }
        if (!encotrado){
            System.out.println("No hemos encotrado la persona en la lista");
        }

    }
    public void listarPersonas(){
        if (listaPersonas.isEmpty()){
            System.out.println("La lista de personas esta vacia");
            return;
        }
        System.out.println("Listado de personas:");
        for (Object[] item : listaPersonas){
            System.out.println("Nombre: "+item[0]+
                    " Apellido: "+item[1]+
                    " Telefono: "+ item[2]+
                    " DNI:"+item[3]);

        }
    }

}
