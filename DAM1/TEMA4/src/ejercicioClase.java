import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class ejercicioClase {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        ejercicio7();
        //ejercicio9();
    }
    public static void ejercicio1(){
        int[] numero = new int[5];
        int suma = 0;
        double media = 0;
         for (int i=0; i<5; i++){
             numero[i]= scanner.nextInt();
             numero[i] = numero[i] *2;
             suma += numero[i];
         }
        for (int item:numero){
            System.out.println(item);
        }
        media = (float) suma/5;
        System.out.println("Suma:"+suma);
        System.out.println("Media:"+media);
    }
    public static void ejercicio2(){
        System.out.println("Escribe la longitud de array:");
        int longitudArray = scanner.nextInt();
        int[] numeros = new int[longitudArray];

        for (int i=0; i<numeros.length; i++){
            System.out.println("Introduce valor:");
            numeros[i] = scanner.nextInt();

        }

        int numeroMasgrande = numeros[0];
        int numeroMasPeqeno = numeros[0];

        for (int i=0; i<numeros.length; i++){
            if (numeros[i]>numeroMasgrande){
                numeroMasgrande = numeros[i];
            }
            if (numeros[i]<numeroMasPeqeno){
                numeroMasPeqeno = numeros[i];
            }
        }
        System.out.println("Numero mayor:"+numeroMasgrande);
        System.out.println("Numero menor:"+numeroMasPeqeno);

    }
    public static void ejercicio3(){
        System.out.println("Introduce longitud de arrays:");
        int longitud = scanner.nextInt();
        int[] array1 = new int[longitud];
        int[] array2 = new int[longitud];
        int[] array3 = new int[longitud];

        for (int i = 0; i < longitud; i++) {
            array1[i] = random.nextInt(0,100);
            array2[i] = random.nextInt(0,100);
        }
        for (int i = 0; i < array3.length; i++) {
            array3[i] = array1[i] + array2[i];
            System.out.println(array3[i]);
        }
    }
    public static void ejercicio4(){
        System.out.println("Longitud de array:");
        int longitud = scanner.nextInt();
        int[] numeros = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            System.out.println("Introduce valor de array:");
            numeros[i] = scanner.nextInt();
        }
        int ultimoElemnto = numeros[longitud-1];

        for (int i = longitud-1 ; i > 0; i--) {
            numeros[i] = numeros[i-1];
        }
        numeros[0] = ultimoElemnto;
        for(int item: numeros){
            System.out.println(item);
        }
    }
    public static void ejercicio5(){
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i;
            System.out.print(numeros[i] + ", ");
        }
        System.out.println(" ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]%2==0){
                numeros[i]+=1;
            } else {
                numeros[i] -=1;
            }
            System.out.print(numeros[i] + ", ");
        }
        System.out.println(" ");
        /*for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]<5 && numeros[i] >0){
                numeros[i] *= 2;
            }
            System.out.print(numeros[i] + ", ");
        }
        System.out.println(" ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] += random.nextInt(-5,5);
            System.out.print(numeros[i] + ", ");
        }
        System.out.println(" ");
        int ultimoElemento = numeros[numeros.length-1];
        for (int i = 0; i < numeros.length-1; i++) {
            numeros[i] = numeros[i+1];
        }
        numeros[0] = ultimoElemento;

        for (int i = 0; i < numeros.length - 1; i+=2) {
            int temp = numeros[i];
            numeros[i] = numeros[i+1];
            numeros[i+1] = temp;
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + ", ");
        }*/
        System.out.println(" ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.print(numeros[i] + ", ");
        }
        System.out.println(" ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]%2 == 0){
                System.out.println("Primero numero par es:"+numeros[i]);
                break;
            }
        }
        for (int i = numeros.length-1; i > 0; i--) {
            if (numeros[i]%2!=0){
                System.out.println("Ultimo numero impar es: "+numeros[i]);
                break;
            }
        }
    }
    public static void ejercicio6(){
        int numeroMaximo;

        System.out.println("Introduce la longitud de array: ");
        int longitud = scanner.nextInt();
        int[] array1 = new int[longitud];

        do {
            System.out.println("Introduce el numero maximo: ");
            numeroMaximo = scanner.nextInt();
        }while (numeroMaximo <= longitud);

        for (int i = 0; i < longitud; i++) {
            array1[i] = i +1;
        }
        for (int item : array1) {
            System.out.println(item);
        }
    }
    public static void ejercicio7(){
        char[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s',
                't','u','v','w','x','y','z'};
        System.out.println("Cuantas palabras quieres guardar:");
        int longitudPalabras = scanner.nextInt();
        String[] palabras = new String[longitudPalabras];
        for (int i = 0; i < longitudPalabras; i++) {
            System.out.println("Cual es la longitud de palabra "+(i+1)+":");
            int longitudPalabra = scanner.nextInt();

            for (int j = 0; j < longitudPalabra; j++) {
                char letraAleatoria = letras[random.nextInt(letras.length)];
            }

        }
        System.out.println("Las palabras generadas son:");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println((i + 1) + ". " + palabras[i]);
        }
    }
    public static void ejercicio8(){}
    public static void ejercicio9(){
        int opcion;
        int[] numeros = null;
        do {
            System.out.println("1.Crear un array de números enteros con n posiciones pedidas.");
            System.out.println("2.Rellenar el array creado con números aleatorios.");
            System.out.println("3.Rellenar el array creado con números pedidos por consola.");
            System.out.println("4.Ordenar el array de mayor a menor");
            System.out.println("5.Clonar el array");
            System.out.println("6.Mover izq");
            System.out.println("7.Mover derecha");
            System.out.println("8.Mover por pares");
            System.out.println("9.Invertir");
            System.out.println("10.Imprimir");
            System.out.println("11.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Vas a generar el array");
                    System.out.println("Cuantas posiciones quieres reservar");
                    int posiciones = scanner.nextInt();
                    numeros = new int[posiciones];
                    System.out.println("Creado correctamente");
                    break;
                case 2:
                    if (numeros!=null){
                        for (int i = 0; i < numeros.length; i++) {
                            numeros[i] = random.nextInt(0,20);
                        }
                    } else {
                        System.out.println("Inicia el array antes");
                    }
                    break;
                case 3:
                    if (numeros!=null){
                        for (int i = 0; i < numeros.length; i++) {
                            System.out.println("Introduce el numero de la posicion "+i);
                            numeros[i] = scanner.nextInt();
                        }
                    } else {
                        System.out.println("Inicia el array antes");
                    }
                    break;
                case 4:
                    Arrays.sort(numeros);
                    break;
                case 5:
                    System.out.println("Cual es la nueva longitud del array");
                    int nuevaLongitud = scanner.nextInt();
                    numeros  = Arrays.copyOf(numeros,nuevaLongitud);
                    break;
                case 6:
                    if (numeros!=null){
                        System.out.println("Vas a rotar a izquierda");
                        int temp = numeros[0];
                        for (int i = 0; i < numeros.length - 1; i++) {
                            numeros[i] = numeros[i+1];
                        }
                        numeros[numeros.length-1] = temp;
                    } else {
                        System.out.println("No se puede rotar");
                    }
                    break;
                case 7:
                    if (numeros!=null){
                        int temporal = numeros[numeros.length-1];
                        System.out.println("Vas a rotar a derecha");
                        for (int i = numeros.length - 1; i > 0; i--) {
                            numeros[i] = numeros[i-1];
                        }
                        numeros[0] = temporal;

                    } else {
                        System.out.println("No se puede rotar");
                    }
                    break;
                case 8:
                    if (numeros!=null){
                        for (int i = 0; i < numeros.length; i+=2) {
                            int temporal = numeros[i];
                            numeros[i] = numeros[i+1];
                            numeros[i+1] = temporal;
                        }
                    } else {
                        System.out.println("El elemento es nulo");
                    }
                    break;
                case 9:
                    if (numeros!=null){
                        for (int i = 0; i < numeros.length/2; i++) {
                            int temporal = numeros[i];
                            numeros[i] = numeros[numeros.length-1-i];
                            numeros[numeros.length-1-i] = temporal;
                        }
                    } else{
                        System.out.println("Es nulo");
                    }
                    break;
                case 10:
                    if (numeros!=null){
                        for (int item :numeros){
                            System.out.print(item+" ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("No se ha inicializado");
                    }
                    break;
                case 11:
                    System.out.println("Saliendo..");
                    break;
            }
        } while (opcion!=11);
    }
}
