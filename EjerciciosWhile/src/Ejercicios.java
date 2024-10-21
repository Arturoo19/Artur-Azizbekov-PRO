import javax.xml.transform.Source;
import java.util.Scanner;
import java.util.Random;
public class Ejercicios {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        ejercicio6();
        ejercicio7();
    }
    public static void ejercicio1(){
        //int num = scanner.nextInt();
        int num;
        int suma = 0;
        do {
            System.out.println("Introduce un numero:");
            num = scanner.nextInt();
            if (num > 0) {
                suma += num;
            }
        } while (num!=0);
        System.out.println("Suma:"+suma);
    }
    public static void ejercicio2() {
        System.out.println("Escribe primero numero");
        int numero1 = scanner.nextInt();
        System.out.println("Escribe segundo numero");
        int numero2 = scanner.nextInt();
    }
    public static void ejercicio3(){
        int mayorNumero = 0;
        int numero;
        do {
            numero = random.nextInt(0,100);
            System.out.println("Numero aleatorio es:"+numero);
            if (numero>mayorNumero){
                mayorNumero=numero;
            }
        } while (numero!=0);
        System.out.println();
    }
    public static void ejercicio4(){
        Scanner scanner = new Scanner(System.in);
        int numero;
        do {
            System.out.print("Introduce un número entero no negativo: ");
            numero = scanner.nextInt();
        } while (numero < 0);
         String binario = Integer.toBinaryString(numero);
         String octal = Integer.toOctalString(numero);
         String hexadecimal = Integer.toHexString(numero).toUpperCase(); // Para mayúsculas en hexadecimal
         System.out.println("El número en binario es: " + binario);
         System.out.println("El número en octal es: " + octal);
         System.out.println("El número en hexadecimal es: " + hexadecimal);
    }
    public static void ejercicio5(){
        int numeroAleatorio = random.nextInt(1,20);
        int numeroUsuario;
        int intentos = 0;
        do {
            System.out.println("Adivina numero:");
            numeroUsuario = scanner.nextInt();
            intentos++;
            if (numeroAleatorio==numeroUsuario){
                System.out.println("Has adivinado con "+intentos+" intentos");
            }
        } while(numeroUsuario != numeroAleatorio);
    }
    public static void ejercicio6(){
        
    }
    public static void ejercicio7(){
        int opcion;
        do {
            System.out.println("Elige opcion:");
            System.out.println("1.Opcion añadir\n2.Opcion borrar\n3.Opcion listar\n4.Opcion buscar\n5.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ejecutando opcion 1...");
                    break;
                case 2:
                    System.out.println("Ejecutando opcion 2...");
                    break;
                case 3:
                    System.out.println("Ejecutando opcion 3...");
                    break;
                case 4:
                    System.out.println("Ejecutando opcion 4...");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

        } while(opcion!=5);
    }
    public static void ejercicio8(){

    }

}
