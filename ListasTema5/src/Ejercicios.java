import java.util.ArrayList;
import java.util.Random;

public class Ejercicios {
    static Random random = new Random();

    private static ArrayList<String> listaPalabras  = new ArrayList<>();
    private static ArrayList<Integer> listaNumeros  = new ArrayList<>();

    public static void main(String[] args) {
        /*for (int i = 0; i < 10; i++) {
            anadirPalabra("Palabra"+(i+1));
        }

        imprimirPalabras();*/

        ejercicio2();
        hacerSuma();
    }
    public static void ejercicio2(){
        for (int i = 0; i < 20; i++) {
            numerosAleatorios(random.nextInt(0,100));
        }
    }
    public static void anadirPalabra(String palabra){
        listaPalabras.add(palabra);
        System.out.println("Palabra anadido correctamente");
    }
    public static void imprimirPalabras(){
        for(String item:listaPalabras){
            System.out.println(item);
        }
    }
    public static void imprimirArrayList(ArrayList<Object> lista){
        
    }
    public static void numerosAleatorios(int numero){
        listaNumeros.add(numero);

    }
    public static void hacerSuma(){
        int suma = 0;
        for (int numero : listaNumeros) {
            suma += numero;
        }
        System.out.println("Suma es:"+suma);
    }
    public static void ejercicio3(){
        rellenarArray(listaNumeros);
    }
    public static void rellenarArray(ArrayList<Integer> lista){
        for (int i = 0; i < 20; i++) {
            lista.add((int) Math.random()*21);
        }
    }


}
