import java.util.Scanner;

public class Entrada {
    static Scanner lectorTeclado = new Scanner(System.in);
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
        final String NOMBRE = "Artur Azizbekov";
        final String DIRRECION = "Plaza de la Mancha";
        final String PISO = "Bajo";
        final String LETRA = "Izquierda";
        final String POBLACION = "Leganes";
        final String PROVINCIA = "Madrid";
        final int POSTAL = 28913;
        final String PAIS = "España";

        System.out.println(NOMBRE);
        System.out.printf("%s, %s-%s\n",DIRRECION,PISO,LETRA);
        System.out.printf("%d, %s, %s\n",POSTAL,POBLACION,PROVINCIA);
        System.out.println(PAIS);

    }
    public static void ejercicio2(){
            String nombre;
            Integer edad;

            System.out.println("ESCRIBE TU NOMBRE COMPLETO");
            nombre = lectorTeclado.nextLine();
            System.out.println("ESCRIBE TU EDAD");
            edad = lectorTeclado.nextInt();

            System.out.println("Te llamas "+ nombre+"\nTienes "+ edad+" años\nPulsa enter para continuar...");
        }
    public static void ejercicio3(){


        System.out.println("Escribe primer numero");
        int n1 = lectorTeclado.nextInt();
        System.out.println("Escribe segundo numero");
        int n2 = lectorTeclado.nextInt();

        int suma = n1 + n2;
        int resta = n1 - n2;
        int multiplicacion = n1 * n2;
        int division = n1 / n2;

        System.out.printf("Suma= %d\nResta= %d\nMultiplicacion= %d\nDivision= %d\n",suma, resta, multiplicacion, division);

        int resto = n1 % n2;
        float division_real = (float)n1 / n2;
        float resto_real = (float)n1 % n2;

        System.out.printf("Resto= %d\nDivision real=%.3f\nResto real=%.3f", resto, division_real,resto_real);
    }
    public static void ejercicio4(){
        float bebida = 1.25f;
        float bocadillo = 2.05f;

        System.out.println("Numero de bebidas: ");
        int bebidas = lectorTeclado.nextInt();
        System.out.println("Numero de bocadillos: ");
        int bocadillos = lectorTeclado.nextInt();

        float coste_bebidas = bebidas * bebida;
        float coste_bocadillos = bocadillos * bocadillo;
        System.out.printf("Numero de bebidas: %d\nNumero de bocadillos:%d\n",bebidas, bocadillos);
        System.out.printf("Coste de las bebidas:%.2f\nCoste de los bocadillos:%.2f\n",coste_bebidas,coste_bocadillos);

        float coste_total = coste_bebidas + coste_bocadillos;
        System.out.println("Coste consumición:"+coste_total);
    }
    public static void ejercicio5(){
        int numero_segundos = 56743;
        int horas = numero_segundos / 3600;
        numero_segundos = numero_segundos%3600;
        int minutos = numero_segundos/60;
        numero_segundos = numero_segundos%60;
        System.out.println("horas: "+horas);
        System.out.println("minutos: "+minutos);
        System.out.println("segundos: "+numero_segundos);
    }
    public static void ejercicio6(){

        System.out.println("Valor de la compra (entre 0.00 y 500.00): ");
        float valor = lectorTeclado.nextFloat();
        System.out.println("IVA (entre 0 y 25%): ");
        int IVA = lectorTeclado.nextInt();

        float compra = valor-(valor*IVA/100);
        float valor_iva = valor - compra;
        System.out.println("Copmra: "+compra);
        System.out.println("IVA: "+ valor_iva);
        System.out.printf("______\n______\n%.2f",valor);



    }
    public static void ejercicio7(){

    }

    }
