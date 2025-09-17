import com.sun.security.jgss.GSSUtil;

import java.io.FilterOutputStream;
import java.util.Scanner;
import java.util.Random;
public class Ejercicios {
    static Scanner lectorTeclado = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
        //ejercicio9();
        //ejercicio10();
        //ejercicio11();
        //ejercicio12();
        //ejercicio13();
        //ejercicio15();
        ejercicio16();
    }
    public static void ejercicio1(){
        System.out.println("Introduce cuantos numeros quieres introducir");
        int numeros = lectorTeclado.nextInt();
        double suma = 0;

        if (numeros<=0){
            numeros=10;
        }
        for (int i=0;i<numeros;i++){
            System.out.println("Introduce numero:");
            int temperatura = lectorTeclado.nextInt();
            suma += temperatura;
        }
        double media = suma/numeros;
        System.out.printf("La media es:%.2f",media);
    }
    public static void ejercicio2(){
        System.out.println("Introduce numero");
        int numero = lectorTeclado.nextInt();

        for (int i=0; i<11;i++){
            System.out.printf("%d * %d=%d\n",numero,i,numero*i);
        }
    }
    public static void ejercicio3(){
        for (int i=1; i<11;i++){
            for (int n=1;n<11;n++){
                int multiplicacion=i*n;
                System.out.printf("%d * %d= %d\n",i,n,multiplicacion);
            }
        }
    }
    public static void ejercicio4(){
        System.out.println("Escribe desde que numero quieres multiplicar:");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Escribe hasta que numero quieres multiplicar:");
        int numero2 = lectorTeclado.nextInt();

        for (int i=numero1; i<=numero2;i++){
            for (int n=1;n<10;n++){
                int multiplicacion=i*n;
                System.out.printf("%d * %d= %d\n",i,n,multiplicacion);
            }
        }
    }
    public static void ejercicio5(){
        System.out.println("Introduca la base");
        int base = lectorTeclado.nextInt();
        System.out.println("Introduce exponente");
        int exponente = lectorTeclado.nextInt();
        double resultado = 1;

        if (base==0 && exponente==0){
            System.out.println("Error");
        } else if (exponente==0) {
            System.out.println(1);
        } else {
            for (int i = 1; i <= exponente; i++) {
                resultado *= base;
            }
            System.out.println(resultado);
        }
    }
    public static void ejercicio6(){
        System.out.println("Introduce primer numero:");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Introduce segundo numero:");
        int numero2 = lectorTeclado.nextInt();
        for (int i=numero1;i<=numero2;i++){
            if (i%2==0){
                System.out.println(i);
            }
        }

    }
    public static void ejercicio7(){
        System.out.println("Introduce cuantas veces quieres simular lanzamiento de un dado:");
        int dadoVeces = lectorTeclado.nextInt();
        if (dadoVeces<=0){
            dadoVeces = 100;
        }
        for (int i=0;i<dadoVeces;i++){
            int resultado = random.nextInt(1,6);
            System.out.println("Resultado de un dado es:"+resultado);
        }
    }
    public static void ejercicio8(){
        double positivos = 0;
        int cantidadPositivos=0;
        int cantidadCeros = 0;
        double negativos = 0;
        int cantidadNegativos=0;
        for (int i=0;i<10;i++){
            System.out.println("Escribe un numero:");
            int numero = lectorTeclado.nextInt();
            if (numero>0){
                positivos+=numero;
                cantidadPositivos++;
            } else if (numero==0) {
                cantidadCeros++;
            } else {
                negativos+=numero;
                cantidadNegativos++;
            }

        }
        System.out.println("Cantidad de ceros:"+cantidadCeros);
        double mediaPositivos = positivos/cantidadPositivos;
        System.out.printf("Media de positivos:%.2f\n",mediaPositivos);
        double mediaNegativos = negativos/cantidadNegativos;
        System.out.printf("Media de negativos:%.2f",mediaNegativos);

    }
    public static void ejercicio9(){
        int sumaSueldos = 0;
        int mayoresDe1000 = 0;

        for (int i=0;i<10;i++){
            System.out.println("Introduce sueldo:");
            int sueldo = lectorTeclado.nextInt();
            sumaSueldos+=sueldo;
            if (sueldo>1000){
                mayoresDe1000++;
            }
        }
        double media = (double) sumaSueldos /10;
        System.out.println("Suma sueldos:"+sumaSueldos);
        System.out.println("Media sueldos:"+media);
        System.out.println("Cuantos mayores de 1000:"+mayoresDe1000);
    }
    public static void ejercicio10(){
        int aprobados = 0;
        int suspendidos = 0;
        int condicionados = 0;
        for (int i=0;i<6;i++){
            System.out.println("Intoduce nota:");
            int nota = lectorTeclado.nextInt();
            if (nota>4){
                aprobados++;
            } else if (nota==4) {
                condicionados++;
            } else {
                suspendidos++;
            }
        }
        System.out.println("Aprobados:"+aprobados);
        System.out.println("Condicionados"+condicionados);
        System.out.println("Suspendidos"+suspendidos);
    }
    public static void ejercicio11(){
        System.out.println("Escribe tamaño de cuadrado:");
        int lado = lectorTeclado.nextInt();
        for (int i=0;i<lado;i++){
            for (int j=0; j<lado; j++){
                System.out.print("+");
            }
            System.out.println();
        }
    }
    public static void ejercicio12(){
        System.out.println("Escribe tamaño de cuadrado:");
        int lado = lectorTeclado.nextInt();
        for (int i=0;i<lado;i++){
            for (int j=0; j<lado; j++){
                if (i==0|| i == lado-1|| j==0||j==lado-1){
                    System.out.print("-");
                }else {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }
    public static void  ejercicio13(){
        System.out.println("Introduce una palabra: ");
        String palabra = lectorTeclado.next().toLowerCase();
        String letra = "";

        for (int i = palabra.length() -1; i >= 0; i--) {
            letra += palabra.charAt(i);
        }
        System.out.println("Palabra inversa es: "+letra);
        boolean palabraIgual = palabra.equals(letra);
        System.out.println(palabraIgual);
    }
    public static void ejercicio15(){
        int numero = random.nextInt(1,30);
        int intentos = 0;
        boolean ganador=false;
        for (int i=0;i<10;i++){

            System.out.println("Adivina el numero desde 1 hasta 30:");
            int numeroUsuario = lectorTeclado.nextInt();
            intentos++;
            if (numeroUsuario == numero) {
                System.out.println("Has adivinado con:"+intentos+" intentos");
                ganador=true;
                break;
            }
        }
        if (!ganador){
            System.out.println("Lo siento, has agotado todos los intentos");
        }

    }
    public static void ejercicio16(){
        System.out.println("Intruduce un numero entre 1 y 20:");
        int numero = lectorTeclado.nextInt();
        int suma = 1;

        for (int i=0; i<numero; i++){
            suma += suma *i;
        }
        System.out.println(suma);
    }

}
