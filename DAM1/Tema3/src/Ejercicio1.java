import java.util.Scanner;
public class Ejercicio1 {
    static Scanner lectorteclado = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        ejercicio3();
    }
    public static void ejercicio1(){
        System.out.println("Escribe un entero:");
        int a = lectorteclado.nextInt();
        String s=null;
        if (a % 2 == 0) {
            s = "es par";
        }
        System.out.println(s);
    }
    public static void ejercicio2(){
        System.out.println("Escribe un entero:");
        int a = lectorteclado.nextInt();
        if (a%2==0){
            a+=1;
        } else if (a<10){
            a-=1;
        } else if (a<100) {
            a*=2;
            a-=1;
        } else {
            a=0;
        }
        System.out.println("El valor de es:"+a);
    }
    public static void ejercicio3(){
        System.out.println("Escribe un entero:");
        int a = lectorteclado.nextInt();
        if (a<10){
            if (a<0){
                System.out.println("Es negativo");
            } else if (a<10) {
                System.out.println("un digito");
            }
        } else if (a<99) {
            System.out.println("dos digitos");
        } else {
            System.out.println("tres digitos");
        }
    }
}
