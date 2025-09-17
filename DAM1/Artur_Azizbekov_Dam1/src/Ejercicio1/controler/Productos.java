package Ejercicio1.controler;

import java.util.ArrayList;
import java.util.Scanner;

public class Productos {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Object[]> listaProductos = new ArrayList<>();

    public void agregarProductos(){
        System.out.println("Escribe el nombre de producto:");
        String nombre = scanner.next();
        System.out.println("Escribe el precio de producto:");
        double precio = scanner.nextDouble();
        Object[] producto = new Object[]{nombre,precio};
        for (Object[] item : listaProductos){
            if (item[0].equals(nombre)){
                System.out.println("Ya existe este producto");
                return;
            }
        }
        listaProductos.add(producto);


    }
    public void listarProductos(){
        for (Object[] item : listaProductos){
            System.out.println("Nombre:"+item[0]+" Precio:"+item[1]);
        }
    }
    public void precioMinimo(){
        System.out.println("Introduce el precio minimo:");
        double precioIntroducido = scanner.nextDouble();
        for (Object[] item: listaProductos) {
            if ((double)item[1] <= precioIntroducido){
                System.out.println("Nombre:"+item[0]+ " Precio:"+item[1]);
            }
        }
    }
    //Lista el contenido del arraylist con precios de menos a mayor
    public void sortarProductos(){
        listaProductos.sort((p1,p2) -> {
            double precio1 = (double) p1[1];
            double precio2 = (double) p2[1];
            return Double.compare(precio1,precio2);
        } );
    }

}
