import java.util.Random;
import java.util.Scanner;

public class ejerciciosMultidimensionales {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] numeros = new int[5][random.nextInt(2,6)];
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = random.nextInt(0,10);
            }
        }
        imprimirArray(numeros);

        for (int i = 0; i < 8; i++) {
            System.out.println("Introduce valor que quieres restar:");
            int numeroUsuario = scanner.nextInt();
            for (int k = 0; k < numeros.length; k++) {
                for (int j = 0; j < numeros[k].length; j++) {
                    numeros[k][j]-=numeroUsuario;
                }
            }
            imprimirArray(numeros);
        }


    }
    public static void imprimirArray(int[][] array){
        for (int[] row: array){
            for (int element : row) {
                System.out.print(element+"\t");
            }
            System.out.println();
        }
    }
}
