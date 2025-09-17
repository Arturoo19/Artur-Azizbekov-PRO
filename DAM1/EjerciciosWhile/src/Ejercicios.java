import javax.xml.transform.Source;
import java.util.Scanner;
import java.util.Random;
public class Ejercicios {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        //ejercicio1();
        ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
        ejercicio9();
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
        int menor;
        if (numero2>numero1){
            menor = numero1;
        }else {
            menor=numero2;
        }
        boolean finalizacion = false;
        int mayorComun=1;
        do {
            for (int i=1;i<=menor;i++){
                if (numero2 % i == 0 && numero1 % i == 0){
                    mayorComun=i;
                }

                if (i==menor){
                    finalizacion=true;
                }
            }
        }while(!finalizacion);
        System.out.println("Mayor comun de dos numeros es:"+mayorComun);
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
        int record =Integer.MAX_VALUE;
        int numeroAleatorio = random.nextInt(1,20);
        int numeroUsuario;
        int intentos = 0;
        boolean seguirJugar = true;
        do {

            System.out.println("Adivina numero:");
            numeroUsuario = scanner.nextInt();
            intentos++;
            if (numeroAleatorio==numeroUsuario){
                System.out.println("Has adivinado con "+intentos+" intentos");
                if (intentos<record){
                    record=intentos;
                    System.out.println("Has superado el record de intentos!");
                }
                System.out.println("Quieres seguir jugar?(s/n)");
                char opcionUsuario = scanner.next().toLowerCase().charAt(0);
                if (opcionUsuario=='n'){
                    seguirJugar=false;
                } else {
                    numeroAleatorio = random.nextInt(1,20);
                    intentos=0;
                }
            }
        } while(seguirJugar);
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
        int opcion;
        do {
            System.out.println("Bienvenido a la aplicación de calculos:");
            System.out.println("Introduce operando uno");
            int num1=scanner.nextInt();
            System.out.println("Introduce operando dos:");
            int num2=scanner.nextInt();
            System.out.println("1.Sumar\n2.Restar\n3.Multiplicar\n4.Dividir\n5.Modulo\n6.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    int suma = num1+num2;
                    System.out.println("El resultado de la operación es "+suma);
                    break;
                case 2:
                    int resta = num1-num2;
                    System.out.println("El resultado de la operación es "+resta);
                    break;
                case 3:
                    double multaplicar = num1*num2;
                    System.out.printf("El resultado de la operación es:%.2f",multaplicar);
                    break;
                case 4:
                    double dividir = (float) num1/num2;
                    System.out.printf("El resultado de la operación es:%.2f",dividir);
                    break;
                case 5:
                    int modulo = num1%num2;
                    System.out.println("El resultado de la operación es "+modulo);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
            }
        } while(opcion!=5);
    }
    public static void ejercicio9(){
        
    }

}
