import java.util.Random;
import java.util.Scanner;
public class Ejercicios {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();

    }

    public static void ejercicio1() {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce un numero");
            numeros[i] = scanner.nextInt();
        }
        for (int i = 0; i <= 10; i++) {
            System.out.println("Indice " + i + ":" + numeros[i]);
        }
    }

    public static void ejercicio2() {

        int[] numeros = new int[30];
        int suma = 0;

        for (int i = 0; i < 30; i++) {
            numeros[i] = random.nextInt(0, 10);
            suma += numeros[i];
        }

        System.out.println("Suma de los numeros es:" + suma);
        double media = (float) suma / 30;
        System.out.printf("Media es:%.1f", media);
    }

    public static void ejercicio3() {
        int[] numeros = new int[10];
        for (int i = 9; i >= 0; i--) {
            numeros[i] = scanner.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Indice " + i + ":" + numeros[i]);
        }

        for (int i = 0; i < 10; i++) {
            numeros[i] = scanner.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Indice " + i + ":" + numeros[i]);
        }
    }

    public static void ejercicio4() {
        int[] numeros = new int[20];
        int[] cuadrado = new int[20];
        int[] cubo = new int[20];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(0, 100);
            cuadrado[i] = numeros[i] * numeros[i];
            cubo[i] = numeros[i] * numeros[i] * numeros[i];
        }
        System.out.println("Numero:\tCuadrado:\tCubo:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i] + "\t" + cuadrado[i] + "\t" + cubo[i]);
        }

    }

    public static void ejercicio5() {
        int[] numeros = new int[8];
        for (int i = 0; i < 8; i++) {
            System.out.println("Escribe un numero:");
            numeros[i] = scanner.nextInt();
        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println("Par:" + numeros[i]);
            } else {
                System.out.println("Impar:" + numeros[i]);
            }
        }
    }

    public static void ejercicio6() {
        int[] numeros = new int[20];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(0, 30);
        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == 6) {
                numeros[i] = 8;
            } else if (numeros[i] == 7) {
                numeros[i] = 15;
            } else if (numeros[i] == 20) {
                numeros[i] = 10;
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

    }

    public static void ejercicio7() {
        String[] palabras = new String[10];
        int numeroLetras = 0;
        String palabraMasGrande = "";

        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Escribe una palabra:");
            palabras[i] = scanner.next();
            if (palabras[i].length() > palabraMasGrande.length()) {
                palabraMasGrande = palabras[i];
            }
        }
        for (String item : palabras) {
            numeroLetras += item.length();
        }

        System.out.println("1.Mostrar palabras\n2.Mostrar una palabra aleatoria\n3.Total de letras\n4.Media de letras");
        System.out.println("5.Ver palabra con más letras\n6.Ver palabra con menos letras");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                for (String item : palabras) {
                    System.out.println(item);
                }
                break;
            case 2:
                int palabraRandom = random.nextInt(palabras.length);
                System.out.println("Palabra aleatoria:" + palabras[palabraRandom]);
                break;
            case 3:
                System.out.println("Numero total de letras:" + numeroLetras);
                break;
            case 4:
                double mediaLetras = (double) numeroLetras / palabras.length;
                System.out.println("Media de las palabras:" + mediaLetras);
                break;
            case 5:
                System.out.println("Palabra con mas letras:" + palabraMasGrande);
                break;
            case 6:
                String palabraMasCorta = palabras[0];
                for (String item : palabras) {
                    if (item.length() < palabraMasCorta.length()) {
                        palabraMasCorta = item;
                    }
                }
                System.out.println("Palabra mas corta:" + palabraMasCorta);
                break;
        }
    }

}
