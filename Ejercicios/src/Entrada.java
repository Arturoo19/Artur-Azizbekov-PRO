import java.util.Scanner;

public class Entrada {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejetcicio8();
        //ejercicio9();
        //ejercicio10();
        //ejercicio11();
        //ejercicio12();
        //ejercicio13();
        //ejercicio14();
        ejercicio15();
    }

    public static void ejercicio1() {
        final String NOMBRE = "Artur Azizbekov";
        final String DIRRECION = "Plaza de la Mancha";
        final String PISO = "Bajo";
        final String LETRA = "Izquierda";
        final String POBLACION = "Leganes";
        final String PROVINCIA = "Madrid";
        final int POSTAL = 28913;
        final String PAIS = "España";

        System.out.println(NOMBRE);
        System.out.printf("%s, %s-%s\n", DIRRECION, PISO, LETRA);
        System.out.printf("%d, %s, %s\n", POSTAL, POBLACION, PROVINCIA);
        System.out.println(PAIS);

    }

    public static void ejercicio2() {
        String nombre;
        Integer edad;

        System.out.println("ESCRIBE TU NOMBRE COMPLETO");
        nombre = lectorTeclado.nextLine();
        System.out.println("ESCRIBE TU EDAD");
        edad = lectorTeclado.nextInt();

        System.out.println("Te llamas " + nombre + "\nTienes " + edad + " años\nPulsa enter para continuar...");
    }

    public static void ejercicio3() {


        System.out.println("Escribe primer numero");
        int n1 = lectorTeclado.nextInt();
        System.out.println("Escribe segundo numero");
        int n2 = lectorTeclado.nextInt();

        int suma = n1 + n2;
        int resta = n1 - n2;
        int multiplicacion = n1 * n2;
        int division = n1 / n2;

        System.out.printf("Suma= %d\nResta= %d\nMultiplicacion= %d\nDivision= %d\n", suma, resta, multiplicacion, division);

        int resto = n1 % n2;
        float division_real = (float) n1 / n2;
        float resto_real = (float) n1 % n2;

        System.out.printf("Resto= %d\nDivision real=%.3f\nResto real=%.3f", resto, division_real, resto_real);
    }

    public static void ejercicio4() {
        float bebida = 1.25f;
        float bocadillo = 2.05f;

        System.out.println("Numero de bebidas: ");
        int bebidas = lectorTeclado.nextInt();
        System.out.println("Numero de bocadillos: ");
        int bocadillos = lectorTeclado.nextInt();

        float coste_bebidas = bebidas * bebida;
        float coste_bocadillos = bocadillos * bocadillo;
        System.out.printf("Numero de bebidas: %d\nNumero de bocadillos:%d\n", bebidas, bocadillos);
        System.out.printf("Coste de las bebidas:%.2f\nCoste de los bocadillos:%.2f\n", coste_bebidas, coste_bocadillos);

        float coste_total = coste_bebidas + coste_bocadillos;
        System.out.println("Coste consumición:" + coste_total);
    }

    public static void ejercicio5() {
        int numero_segundos = 56743;
        int horas = numero_segundos / 3600;
        numero_segundos = numero_segundos % 3600;
        int minutos = numero_segundos / 60;
        numero_segundos = numero_segundos % 60;
        System.out.println("horas: " + horas);
        System.out.println("minutos: " + minutos);
        System.out.println("segundos: " + numero_segundos);
    }

    public static void ejercicio6() {

        System.out.println("Valor de la compra (entre 0.00 y 500.00): ");
        float valor = lectorTeclado.nextFloat();
        System.out.println("IVA (entre 0 y 25%): ");
        int IVA = lectorTeclado.nextInt();

        float compra = valor - (valor * IVA / 100);
        float valor_iva = valor - compra;
        System.out.println("Copmra: " + compra);
        System.out.println("IVA: " + valor_iva);
        System.out.printf("______\n______\n%.2f", valor);


    }

    public static void ejercicio7() {
        System.out.println("Escribe un radio entero: ");
        int radio = lectorTeclado.nextInt();
        double longitud = 2 * Math.PI * radio;
        System.out.println("Longitud de la circunferencia: " + longitud);
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("Area de circulo: " + area);
    }

    public static void ejetcicio8() {
        System.out.println("Escribe grados centirgados: ");
        float centigrados_teclado = lectorTeclado.nextFloat();

        float kelvin = centigrados_teclado + 273.15f;
        float farenheit = (9 * centigrados_teclado) / 5 + 32;
        System.out.printf("Farenheit:%.2f Kelvin:%.2f\n", farenheit, kelvin);

        System.out.println("Escribe grados farenheit: ");
        float farenheit_teclado = lectorTeclado.nextFloat();
        float centigrados = (5 * (farenheit_teclado - 32)) / 9;
        float kelvin1 = (5 * (farenheit_teclado - 32)) / 9 + 273.15f;
        System.out.printf("Centigrados:%.2f Kelvin:%.2f\n", centigrados, kelvin1);


        System.out.println("Escribe grados kelvin: ");
        float kelvin_teclado = lectorTeclado.nextFloat();
        float centigrados1 = kelvin_teclado - 273.15f;
        float farenheit1 = (9 * (kelvin_teclado - 273.15f)) / 5 + 32;
        System.out.printf("Centigrados:%.2f Farenheit:%.2f", centigrados1, farenheit1);
    }

    public static void ejercicio9() {
        System.out.println("Introduce el precio de las bebidas:");
        float bebida = lectorTeclado.nextFloat();
        System.out.println("Introduce el presio de los bocadillos:");
        float bocadillo = lectorTeclado.nextFloat();
        System.out.println("Cuantas bebidas quereis?");
        int bebidas = lectorTeclado.nextInt();
        System.out.println("Cuantos bocadillos quereis?");
        int bocadillos = lectorTeclado.nextInt();
        float precioBebida = (float) bebida * bebidas;
        float precioBocadillos = (float) bocadillo * bocadillos;
        float precioTotal = precioBocadillos + precioBebida;
        System.out.printf("ATRIBUTO\t\tCANTIDAD\tPRECIO\t\tCOSTE\n");
        System.out.println("=====================================================");
        System.out.printf("Bebida\t\t\t\t%d\t\t%.2f\t\t%.2f\n", bebidas, bebida, precioBebida);
        System.out.printf("Bocadillo\t\t\t%d\t\t%.2f\t\t%.2f\n", bocadillos, bocadillo, precioBocadillos);
        System.out.println("                                        ============");
        System.out.println("Precio total:                             " + precioTotal);
        System.out.println("________________________________________________________");

    }

    public static void ejercicio10() {
        System.out.println("Escribe decenas de mil: ");
        int decenasMil = lectorTeclado.nextInt();

        System.out.println("Escribe unidades de mil: ");
        int unidadesMil = lectorTeclado.nextInt();

        System.out.println("Escribe centenas : ");
        int centenas = lectorTeclado.nextInt();

        System.out.println("Escribe decenas: ");
        int decenas = lectorTeclado.nextInt();

        System.out.println("Escribe unidades: ");
        int unidades = lectorTeclado.nextInt();

        int numero = decenasMil * 10000 + unidadesMil * 1000 + centenas * 100 + decenas * 10 + unidades;
        System.out.println("Numero introducido: " + numero);
    }

    public static void ejercicio11() {
        System.out.println("Intoduce el numero:");
        int numero = lectorTeclado.nextInt();
        boolean par = (numero % 2 == 0);
        boolean mayor = (numero > 50);
        System.out.printf("Es par: %b\nMayor que 50: %b",par,mayor);
    }
    public static void ejercicio12(){
        System.out.println("Escribe la primera cadena: ");
        String cadena1 = lectorTeclado.nextLine();
        System.out.println("Escribe la segunda cadena: ");
        String cadena2 = lectorTeclado.nextLine();

        boolean iguales = cadena1.equals(cadena2);;
        System.out.printf("Son iguales:%b\n",iguales);

        boolean menor = (cadena1.length()<cadena2.length());
        System.out.printf("La primera es menor que segunda:%b\n",menor);

        boolean distintas = !iguales;
        System.out.printf("Son distintas:%b",distintas);
    }
    public static void ejercicio13(){
        System.out.println("Escribe un número entre 0 y 9: ");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Escribe un número entre 0 y 9: ");
        int numero2 = lectorTeclado.nextInt();

        boolean condicion1 = (numero1%2 ==0 && numero2%2 !=0);
        System.out.println("El primero es par y el segundo impar:"+condicion1);
        boolean condicion2 = (numero2*2<=numero1 && numero1<8);
        System.out.println("El primero es superior al doble del segundo e inferior a 8:"+condicion2);
        boolean condicion3 = (numero1==numero2) || ((numero1-numero2)<2);
        System.out.println("Son iguales o la diferencia entre el primero y el segundo es menor que 2:"+condicion3);
    }
    public static void ejercicio14(){
        System.out.println("Escribe edad entre 0 y 100: ");
        int edad = lectorTeclado.nextInt();
        System.out.println("Escribe su  nivel de estudios entre 0 y 10: ");
        int estudios = lectorTeclado.nextInt();
        System.out.println("Escribe sus ingresos entre 0 y 25000 ");
        int ingresos = lectorTeclado.nextInt();

        boolean condicion = edad>40 && (estudios>=5 && estudios<=8)&&(ingresos>=15000);
        System.out.println("Mas de 40 años y estudios entre 5 y 8 y gana menos de 15000: "+condicion);
    }
    public static void ejercicio15(){
        System.out.println("Introduzca un numero entero:");
        int numero = lectorTeclado.nextInt();
        int a = numero += 5;
        int b = numero -= 3;
        int c = numero *= 10;
        int d = numero /= 2;
        System.out.printf("Incrementar 5 unidades: %d\nDecrementar 3 unidades: %d\n" +
                "Multiplicar por 10: %d\nDividir por 2: %d",a,b,c,d);
    }
}
