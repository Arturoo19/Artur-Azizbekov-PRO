package agendaHash.controler;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class AgendaHash {
    static Scanner scanner = new Scanner(System.in);

    private Hashtable<String, Object[]> listaAgenda;

    public AgendaHash() {
        listaAgenda = new Hashtable<>();
    }

    public void agregarPersoans() {
        System.out.println("Escribe su nombre:");
        String nombre = scanner.next();
        System.out.println("Escribe apellido:");
        String apellido = scanner.next();
        System.out.println("Escribe su telefono:");
        int telefono = scanner.nextInt();
        System.out.println("Escribe su DNI:");
        String dni = scanner.next();
        Object[] usuario = new Object[]{nombre, apellido, telefono, dni};
        listaAgenda.put(dni, usuario);

    }

    public void mostrarUsuarios() {
        if (listaAgenda.isEmpty()) {
            System.out.println("La lista de personas está vacía.");
            return;
        }

        Enumeration<Object[]> usuarios = listaAgenda.elements();
        while (usuarios.hasMoreElements()) {
            Object[] usuario = usuarios.nextElement();
            System.out.println("DNI: "+usuario[3]);
            System.out.println("Nombre:"+ usuario[0]);
            System.out.println("Apellido:"+ usuario[1]);
            System.out.println("Telefono:"+ usuario[2]);
        }
    }

    public void buscarPersona() {
        System.out.println("Escribe DNI de la persona que qieres encotrar:");
        String personaBuscar = scanner.next();
        Object[] persona = listaAgenda.get(personaBuscar);

        if (persona != null){
            System.out.println("Persona encotrada:");
            System.out.println("Nombre: "+persona[0] + ", Apellido: " + persona[1] + ", telefono:"+persona[2]);
        } else {
            System.out.println("No se encotro ninguna persona con el Dni: "+personaBuscar);
        }
    }
    public void eliminarPersona(){
        System.out.println("Escribe DNI de la persona que qieres encotrar:");
        String personaEliminar = scanner.next();

        if (listaAgenda.remove(personaEliminar) != null){
            System.out.println("Persona eliminada correctamente");
        } else {
            System.out.println("No se encotro ninguna persona con el dni:"+personaEliminar);
        }
    }

}
