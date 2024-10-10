import java.util.Scanner;
public class Switch {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        ejercicio4();
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
}
