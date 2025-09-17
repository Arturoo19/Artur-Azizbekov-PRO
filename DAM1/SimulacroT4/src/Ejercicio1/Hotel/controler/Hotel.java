package Ejercicio1.Hotel.controler;

import java.util.*;

public class Hotel {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Object[]> listaReservas = new ArrayList<>();

    public void registrarReservas(){
        System.out.println("Escribe numero de la habitacion:");
        int numeroHabitacion = scanner.nextInt();
        System.out.println("Escribe el nombre de huesped:");
        String nombre = scanner.next();
        System.out.println("Escribe el telefono de huesped:");
        int telefono = scanner.nextInt();
        System.out.println("Escribe el dni del huesped:");
        String dni = scanner.next();
        System.out.println("Escribe el numero de personas que se alojan:");
        int numPersonas = scanner.nextInt();

        Object[] hotel = new Object[]{numeroHabitacion,nombre,telefono,dni,numPersonas};
        for (Object[] item : listaReservas){
            if (item[3].equals(dni)){
                System.out.println("Ya existe la reserva con este dni, vuelve mas tarde");
                return;
            }
        }
        listaReservas.add(hotel);
        System.out.println("Confirmado");
    }
    public void cancelarReserva(){
        System.out.println("Escribe su dni:");
        String dni = scanner.next();
        boolean encotrado = false;

        for (Object[] item : listaReservas){
            if (item[3].equals(dni)){
                System.out.println("Tu reserva se ha cancelado");
                encotrado = true;
                listaReservas.remove(item);
                break;
            }
        }
        if (!encotrado){
            System.out.println("No hay reservas con este dni:"+dni);
        }
    }
    public void mostrarReservas(){
        System.out.println("Mostramos reservas:");
        for (Object[] item : listaReservas){
            System.out.println("Numero de habitacion:"+item[0]+" Nombre de huesped:" + item[1]+ " Dni:"+item[3]+
                    " Numero de huesped:"+item[4]);
        }
    }
    public void reservasOrdenadas(){
        Collections.sort(listaReservas, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                if (Integer.valueOf(o1[4].toString()) > Integer.valueOf(o2[4].toString())){
                    return -1;
                } else if (Integer.valueOf(o1[4].toString()) < Integer.valueOf(o2[4].toString())) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("Ordenado con exito!");
    }
}
