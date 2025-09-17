package Ejercicio1;

import Ejercicio1.controler.Productos;

import java.util.Scanner;

public class Entrada1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Productos productos = new Productos();

        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Agregar producto\n2.Listar productos\n3.Precio minimo de productos");
            System.out.println("4.Listar de menor a mayor\n5.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    productos.agregarProductos();
                    break;
                case 2:
                    productos.listarProductos();
                    break;
                case 3:
                    productos.precioMinimo();
                    break;
                case 4:
                    productos.sortarProductos();
                    break;
                case 5:
                    System.out.println("Saliendo..");
                    break;
            }
        } while(opcion!=5);

    }
}
