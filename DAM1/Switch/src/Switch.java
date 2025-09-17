import java.util.Scanner;
public class Switch {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio4();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
        //ejercicio9();
        //ejercicio10();
    }
    public static void ejercicio1(){
        System.out.println("Introduce el numero:");
        int numero = lectorTeclado.nextInt();

        switch (numero){
            case 1:
                System.out.println("Es el lunes");
                break;
            case 2:
                System.out.println("Es martes");
                break;
            case 3:
                System.out.println("Es miercoles");
                break;

        }
    }
    public static void ejercicio2() {
        char letra = lectorTeclado.next().charAt(0);
        switch (letra) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(letra + " es una vocal.");
                break;
            default:
                System.out.println(letra + " es una consonante.");
        }
    }
    public static void ejercicio3(){
        int numero = lectorTeclado.nextInt();
        int resto = numero%2;

        switch (resto)
        {
            case 0:
                System.out.println("Es par");
                break;
            default:
                System.out.println("es impar");
        }
    }
    public static void ejercicio4(){
        int mes = lectorTeclado.nextInt();
        switch (mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tiene 31 dias");
                break;
            case 2:
                System.out.println("Tiene 28 dias");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tiene 30 dias");
                break;

        }
    }
    public static void ejercicio6(){
        System.out.println("Ingesa un numero de 1 a 4:");
        int numero = lectorTeclado.nextInt();

        switch (numero){
            case 1:
                System.out.println("Opcion1 seleccionada");
                break;
            case 2:
                System.out.println("Opcion2 seleccionasa");
                break;
            case 3:
                System.out.println("Opcion3 seleccionada");
                break;
            case 4:
                System.out.println("Opcion4 seleccionada");
                break;

        }
    }
    public static void ejercicio7(){
        System.out.println("Ingrese una nota de 1 al 5:");
        int numero = lectorTeclado.nextInt();

        switch (numero){
            case 1,2:
                System.out.println("Suspenso");
                break;
            case 3:
                System.out.println("Aprobado");
                break;
            case 4:
                System.out.println("Notable");
                break;
            case 5:
                System.out.println("Sobresaliente");
                break;
        }
    }
    public static void ejercicio8(){
        System.out.println("Ingresa primer numero");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Ingresa segundo numero");
        int numero2 = lectorTeclado.nextInt();

        System.out.println("Ingresa una operacion matematica(+,-,*,/)");
        char operacion = lectorTeclado.next().charAt(0);
        int resultado=0;
        switch (operacion){
            case '+':
                resultado=numero1+numero2;
                break;
            case '-':
                resultado=numero1-numero2;
                break;
            case '*':
                resultado=numero1*numero2;
                break;
            case '/':
                resultado=numero1/numero2;
                break;
        }
        System.out.println("Resultado es:"+resultado);

    }
    public static void ejercicio9(){
        System.out.println("Ingrese un numero de 1 al 12:");
        int estacion = lectorTeclado.nextInt();
        switch (estacion){
            case 1,2,12:
                System.out.println("Invierno");
                break;
            case 3,4,5:
                System.out.println("Primavera");
                break;
            case 6,7,8:
                System.out.println("Verano");
                break;
            case 9,10,11:
                System.out.println("Otoño");
                break;
        }
    }
    public static void ejercicio10(){
        System.out.println("Ingrese el codigo del producto");
        int codigo = lectorTeclado.nextInt();

        switch (codigo){
            case 1:
                System.out.println("Con el codigo 1 tenemos Samsung s24 con el precio 800$");
                break;
            case 2:
                System.out.println("Con el codigo 2 tenemos Play5 con precio 500$");
                break;
            case 3:
                System.out.println("Con el codigo 3 tenemos iPhone 16 con el precio 800");
                break;
        }

    }
}
