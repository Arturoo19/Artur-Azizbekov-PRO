import java.util.Scanner;

public class EjercicioUno {
    static Scanner lectorTeclado =new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Escribe su nombre: ");
        String nombre = lectorTeclado.next();

        System.out.println("Escribe su apellido: ");
        String apellido = lectorTeclado.next();

        System.out.println("Escribe su edad: ");
        int edad = lectorTeclado.nextInt();

        System.out.println("Escribe su peso: ");
        float peso = lectorTeclado.nextFloat();

        System.out.println("Escribe su altura: ");
        float altura = lectorTeclado.nextFloat();

        System.out.println("Escribe su sexo(M/F): ");
        char sexo = lectorTeclado.next().charAt(0);

        float imc = calculoIMC(peso,altura);
        System.out.printf("Hola %s tu IMC teniendo en cuenta tu altura de %.2fcm y tu peso de %.2fkg," +
                " tiene un valor de %.2f\n",nombre,altura,peso,imc);
    }
    public static float calculoIMC(float peso, float altura){
        return (float) (peso/Math.pow(altura,2));
    }
}
