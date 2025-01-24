import model.Persona;

import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Persona persona = new Persona();

        System.out.println("Escribe el nombre:");
        String nombre = scanner.next();
        System.out.println("Escribe el apellido:");
        String apellido = scanner.next();
        System.out.println("Escribe el dni:");
        String dni = scanner.next();
        System.out.println("Escribe edad:");
        int edad = scanner.nextInt();
        System.out.println("Escribe el peso:");
        double peso = scanner.nextDouble();
        System.out.println("Escribe la altura:");
        double altura = scanner.nextDouble();

        persona = new Persona(nombre,apellido,dni,edad,peso,altura);

        persona = new Persona("Olek","Hushtyk","a212",17,85.0,189);
        persona.mostarDatos();

    }
}
