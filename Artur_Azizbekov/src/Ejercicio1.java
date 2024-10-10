import java.util.Scanner;
public class Ejercicio1 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce el nombre y apellido:");
        String nombre = lectorTeclado.nextLine();

        System.out.println("Introduce cantidad de dinero:");
        int dinero = lectorTeclado.nextInt();

        System.out.println("Introduce el precio de play5:");
        int precioPlay5 = lectorTeclado.nextInt();

        System.out.println("Introduce el precio de iPhone15:");
        int precioiPhone15 = lectorTeclado.nextInt();

        System.out.println("Introduce el iva actual:");
        float iva = lectorTeclado.nextInt();

        float play_con_iva = precioPlay5-(precioPlay5*iva/100);
        float iPhone_con_iva = precioPlay5-(precioPlay5*iva/100);

        boolean comprarPlay = dinero>play_con_iva;
        boolean comprariPhone = dinero>iPhone_con_iva;
        System.out.println("Te puedes comprar la play:"+comprarPlay);
        System.out.println("Te puedes comprar la iphone:"+comprariPhone);

        boolean total =  dinero>(play_con_iva+iPhone_con_iva);
        System.out.println("Te puedes comprar las dos cosas:"+total);
        System.out.println(play_con_iva);
    }
}
