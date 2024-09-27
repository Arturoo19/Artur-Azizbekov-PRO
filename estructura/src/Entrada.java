import java.util.Scanner;

public class Entrada {

    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        String nombre; // null
        Integer ano;
        Float altura;
        Boolean experienciaTrabajo;

        System.out.println("Nombre");
        nombre = lectorTeclado.next();
        System.out.println("Cuanto anos tienes");
        ano = lectorTeclado.nextInt();
        System.out.println("Cuanto mides");
        altura = lectorTeclado.nextFloat();
        System.out.println("Tienes experiencia trabajado?");
        experienciaTrabajo = lectorTeclado.nextBoolean();

        System.out.println("Mi nombre es " +nombre +"\ntengo " +ano +"\nmido " +altura
                +"\ntengo experiencia trabajado " +experienciaTrabajo);
        // Mi nombre es ...(Ivan) tengo ...(18) mido ...(184) y tengo experiencia trabajando ...(true)

    }

}