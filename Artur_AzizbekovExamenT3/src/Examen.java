import java.util.Scanner;
import java.util.Random;
public class Examen {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        ejercicio4();
    }
    public static void ejercicio1(){
        System.out.println("Introduce primer numero:");
        int numero1 = scanner.nextInt();
        System.out.println("Introduce segundo numero:");
        int numero2 = scanner.nextInt();
        if (numero1<0 || numero2<0){
            System.out.println("No se puede realizar operacion");
        } else {
            System.out.println("1.Sumar\n2.Restar\n3.Dividir\n4.Multiplicar");
            int menu = scanner.nextInt();
            switch (menu){
                case 1:
                    int suma = numero1+numero2;
                    System.out.println("Resultado de la suma es:"+suma);
                    break;
                case 2:
                    int resta = numero1-numero2;
                    System.out.println("Resultado de la resta es:"+resta);
                    break;
                case 3:
                    double divicion = (float) numero1/numero2;
                    System.out.printf("Resultado de la divicion es:%.2f",divicion);
                    break;
                case 4:
                    int multiplicacion = numero1*numero2;
                    System.out.println("Resultado de la multiplicacion es:"+multiplicacion);
                    break;
            }

        }
    }
    public static void ejercicio2(){
        System.out.println("Introduce un numero:");
        int numeroUsuario = scanner.nextInt();
        int numeroMasGrande = 0;
        int numeroMasPequeno = 100;
        int suma = 0;

        for (int i=0; i<10; i++){
            int numeroGenerados = random.nextInt(0,100);
            suma+= numeroGenerados;
            if (numeroGenerados > numeroMasGrande){
                numeroMasGrande = numeroGenerados;
            }
            if (numeroGenerados<numeroMasPequeno){
                numeroMasPequeno=numeroGenerados;
            }
            if (numeroGenerados==numeroUsuario){
                System.out.println("Usuario ha ganado en loteria");
            }

        }
        System.out.println("Numero mas grande:"+numeroMasGrande);
        System.out.println("Numero mas pequeño:"+numeroMasPequeno);
        double medioGenerado = (float) suma/10;
        System.out.printf("Numero medio generado:%.2f\n",medioGenerado);
        System.out.println("Suma de los numero generados:"+suma);

    }
    public static void ejercicio3(){
        int clave = 1111;
        int intentos=0;
        boolean ganado = false;
        int intentosMaximo = 3;

        do {
            System.out.println("Introduce el numero:");
            int numeroUsuario = scanner.nextInt();
            intentos++;
            if (numeroUsuario==clave){
                System.out.println("Perfecto, la caja ha sido abierta");
                ganado = true;
            } else if (intentos>=1 && intentos<4) {
                System.out.println("Intento fallido, prueba de nuevo");
            } else if (intentos >= intentosMaximo) {
                System.out.println("Lo siento, caja bloqueada");
                ganado = true;
            }
        } while (!ganado);

    }
    public static void ejercicio4(){
        boolean finalizarBase = false;
        do {
            System.out.println("Itroduce el numero:");
            int numero = scanner.nextInt();
            String resultado = "";


            if (numero <=0){
                System.out.println("Numero tiene que ser positivo, lo siento");
            } else {
                System.out.println("1.Base2\n2.Base8\n3.Base16\n4.Salir");
                int menu = scanner.nextInt();
                boolean finalizacion = false;
                switch (menu){
                    case 1:
                        do {
                            if (numero%2==0){
                                resultado = "0" + resultado;
                                numero = numero/2;
                            } else {
                                resultado = "1" + resultado;
                                numero = numero/2;
                            }
                            if (numero<=1){
                                resultado = "1" +resultado;
                                finalizacion=true;
                            }
                        } while (!finalizacion);
                        System.out.println(resultado);
                        break;
                    case 2:
                        do {
                            if (numero%8==0){
                                resultado = "0" + resultado;
                                numero = numero/8;
                            } else {
                                resultado = "1" + resultado;
                                numero = numero/8;
                            }
                            if (numero<=8){
                                resultado ="1" + resultado;
                                finalizacion=true;
                            }
                        } while (!finalizacion);
                        System.out.println(resultado);
                        break;
                    case 3:
                        do {
                            if (numero%16==0){
                                resultado = "0" + resultado;
                                numero = numero/16;
                            } else {
                                resultado = "1" +resultado;
                                numero = numero/16;
                            }
                            if (numero<=16){
                                resultado ="1" +resultado;
                                finalizacion=true;
                            }
                        } while (!finalizacion);
                        System.out.println(resultado);
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        finalizarBase=true;
                        break;
                }
            }
        } while(!finalizarBase);
    }
}
