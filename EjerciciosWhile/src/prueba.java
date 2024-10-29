import java.util.Scanner;
import java.util.Random;
public class prueba {
    static Scanner lectorTeclado = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        ejercicio4();
    }
    public static void ejercicio1(){
        int numeros;
        int paresSuma = 0;
        int impares = 0;
        int contadorNumeros = 0;
        int ceros = 0;
        int contadorPares = 0;
        int contadorImpares = 0;

        do {
            System.out.println("Introduce numero(negativo si quieres terminar)");
            numeros = lectorTeclado.nextInt();
            contadorNumeros++;
            if (numeros%2==0){
                paresSuma+=numeros;
                contadorPares+=1;
            } else {
                impares+=numeros;
                contadorImpares+=1;
            }
            if (numeros==0){
                ceros+=1;
            }
        } while (numeros>=0);
        System.out.println("1-Suma de los numeros pares introducidos\n" +
                "2-Media de los números pares introducidos con dos decimales.\n" +
                "3-Media de los números impares introducidos con dos decimales.\n" +
                "4-Cuántos números hemos introducido.\n" +
                "5-Cuantos números de los introducidos han sido ceros, cuántos han sido pares y cuantos impares.\n" +
                "6.-Salir.");
        int menu = lectorTeclado.nextInt();
        switch (menu){
            case 1:
                System.out.println("Suma de los números pares introducidos es:"+paresSuma);
                break;
            case 2:
                double mediaPares = (float)paresSuma/contadorPares;
                System.out.printf("Media de los números pares :%.2f",mediaPares);
                break;
            case 3:
                double mediaImpares = (float) impares/contadorImpares;
                System.out.printf("Media de los impares:%.2f",mediaImpares);
                break;
            case 4:
                System.out.println("Hemos introducido "+contadorNumeros+" numeros");
                break;
            case 5:
                System.out.println("Hemos introfucido "+ceros+" ceros,"+contadorPares+" pares y "+ contadorImpares+" pares");
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
        }
    }
    public static void ejercicio2(){
        int contador = 0;
        int sumaNotas = 0;
        boolean suspenso = false;
        do {
            System.out.println("Introduce la nota (0-10)");
            int notas = lectorTeclado.nextInt();
            contador++;
            sumaNotas +=notas;
            if (notas<5){
                suspenso = true;
            }
        }while (contador!=20);
        if (suspenso){
            System.out.println("Hay suspenso");
        }
        double mediaNota = (float)sumaNotas/contador;
        System.out.printf("Media de las notas:%.2f",mediaNota);
    }
    public static void ejercicio3(){
        boolean pin = false;
        double saldoDisponible = 0;
        int menu = 0;
        double sacarDinero = 0;

        do {
            System.out.println("1.Ingresar dinero\n2.Sacar dinero\n3.Estado de la cuenta\n4.Salir");
            menu = lectorTeclado.nextInt();
            switch (menu){
                case 1:
                    System.out.println("Inroduce el pin:");
                    int pinIntroducido = lectorTeclado.nextInt();
                    if (pinIntroducido!=1111){
                        System.out.println("Pin incorecto");
                    } else {
                        System.out.println("Ingrese su saldo:");
                        double ingresarDinero = lectorTeclado.nextDouble();
                        if (ingresarDinero<=0){
                            System.out.println("Numero tiene que ser mayor que 0");
                        } else {
                            System.out.println("Saldo introducido con exito");
                            saldoDisponible+=ingresarDinero;
                        }
                    }
                    break;
                case 2:
                    if (saldoDisponible>0){
                        System.out.println("Cuanto quieres sacar dinero?");
                        sacarDinero = lectorTeclado.nextDouble();
                    }
                    if (sacarDinero>saldoDisponible){
                        System.out.println("Imposible sacar dinero");
                    }
                    break;
                case 3:
                    System.out.println("Estado de la cuenta:"+saldoDisponible);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;

            }
        } while(menu!=4);
    }
    public static void ejercicio4(){
        System.out.println("Escribe una palabra:");
        String palabra = lectorTeclado.next();
        String palabraReversa = "";
        if (palabra.length()<=4){
            palabra = palabra.toUpperCase();
            System.out.println("Resultado:"+palabra);
        } else if (palabra.length()<= 8 && palabra.length()>4) {
            palabra = palabra.toLowerCase();
            System.out.println("Resultado:"+palabra);
        } else if (palabra.length()>8 && palabra.length()<=11){
            palabra = palabra.replace('a','á')
                    .replace('e','é')
                    .replace('o','ó')
                    .replace('u','ú')
                    .replace('i','í');
            System.out.println("Resultado:"+palabra);
        } else {
            for (int i=palabra.length()-1; i>=0; i--){
                palabraReversa += palabra.charAt(i);
            }
            System.out.println("Resultado:"+palabraReversa);
        }
    }
}
