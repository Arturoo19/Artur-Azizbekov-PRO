import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Integer> listaNumeros  = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Utilizando listas");
        System.out.println("El tamano inicial de la lista es:"+listaNumeros.size());
        anadirNumero(50);
        anadirNumero(20);
        anadirNumero(5);
        anadirNumero((int) (Math.random()*21));
        obtenerDatos();

        for (int i = 0; i < 4; i++) {
            System.out.println("Introduce numero");
            int numero = scanner.nextInt();
            leerNumero(numero);
        }
    }

    public static void anadirNumero(int numero){
        listaNumeros.add(numero);
        System.out.println("Numero anadido correctamente");
        System.out.println("Lista actualizada con un size de "+listaNumeros.size());
    }
    public static void obtenerDatos(){
        System.out.println("El ultimo elemento es "+ listaNumeros.getLast());

    }
    public static void leerNumero(int numeroUsuario){
        int numeroUsusario = scanner.nextInt();
        listaNumeros.add(numeroUsusario);
    }

}
