import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EjerciciosExamen {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
    }
    public static void ejercicio1(){
        //Arrays.sort(numeros);
        int[] numeros = new int[15];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(0,15);

        }
        for (int item:numeros){
            System.out.print(item+" ");
        }
        System.out.println();

        Arrays.sort(numeros);
        for (int item:numeros){
            System.out.print(item+" ");
        }
        System.out.println();

        System.out.print("Numeros en posiciones pares:");
        for (int i = 0; i < numeros.length; i++) {
            if (i%2==0){
                System.out.print(numeros[i]+" ");
            }
        }

        System.out.println();
        System.out.print("Numeros pares:");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]%2==0){
                System.out.print(numeros[i]+" ");
            }
        }

    }
    public static void ejercicio2(){
        System.out.println("Escribe longitud:");
        int longitud = scanner.nextInt();
        int[] numeros = new int[longitud];
        int pares = 0;
        int impares = 0;

        for (int i = 0; i < longitud; i++) {
            numeros[i] = random.nextInt(0,20);
            if (numeros[i]%2==0){
                pares++;
            } else {
                impares++;
            }
        }

        int ultimo = numeros[longitud-1];
        int primero = numeros[0];
        System.out.println("Elemento mas grande:"+ultimo);
        System.out.println("Elemento mas pequeño:"+primero);

        System.out.println("Elementos pares:"+pares);
        System.out.println("Elementos impares"+impares);

        int numeroUsuario = scanner.nextInt();
        int contadorNumeros = 0;
        for (int i = 0; i < longitud; i++) {
            if (numeros[i]==numeroUsuario){
                contadorNumeros++;
            }
        }
        System.out.println("Mostar repeticiones:"+contadorNumeros);
    }
    public static void ejercicio3(){
        int[] numeros = new int[20];

        int opcion;

        do {
            System.out.println("1.Registrar posiciones\n2.Elegir un elemento\n3.Mostrar el array");
            System.out.println("4.Mostar el array ordenado\n5.Mover el array a la izquierda");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.println("Numero de posicion "+i+":");
                        numeros[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Elige posicion de un array:");
                    int posicionUsuario = scanner.nextInt();
                    System.out.println("Numero de tu posicion:"+numeros[posicionUsuario]);
                    break;
                case 3:
                    for (int item:numeros){
                        System.out.print(item+" ");
                    }
                    System.out.println();
                    break;
                case 4:
                    Arrays.sort(numeros);
                    System.out.println("Numeros ordenados:");
                    for (int item:numeros){
                        System.out.print(item+" ");
                    }
                    System.out.println();
                    break;
                case 5:
                    int primerElemento = numeros[0];
                    for (int i = 0; i < numeros.length - 1; i++) {
                        numeros[i] = numeros[i+1];

                    }
                    numeros[numeros.length-1] = primerElemento;
                    for (int item:numeros){
                        System.out.print(item+" ");
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion!=6);
    }
    public static void ejercicio4(){
        int opcion;
        Object[] informacion = new Object[10];
        String[] nombre = new String[10];
        String[] appelido = new String[10];
        int[] telefono = new int[10];
        do {
            System.out.println("1.Agregar persona\n2.Buscar persona\n3.Listar personas\n4.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Esctibe su nombre:");
                    nombre[0] = scanner.nextLine();

                    appelido[0] = scanner.nextLine();
                    telefono[0] = scanner.nextInt();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo..");
                    break;
            }

        } while (opcion!=4);
    }
}
