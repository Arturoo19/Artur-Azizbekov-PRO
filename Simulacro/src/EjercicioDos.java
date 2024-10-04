import java.util.Scanner;
public class EjercicioDos {
    static Scanner lectotTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nombre del jugador 1: ");
        String nombre1 = lectotTeclado.next();
        System.out.println("Numeros de jugador 1: ");
        int jugadores1 = lectotTeclado.nextInt();
        System.out.println("Presupuesto de jugador 1: ");
        int presuuesto1 = lectotTeclado.nextInt();

        System.out.println("Nombre del jugador 2: ");
        String nombre2 = lectotTeclado.next();
        System.out.println("Numeros de jugador 2: ");
        int jugadores2 = lectotTeclado.nextInt();
        System.out.println("Presupuesto de jugador 2: ");
        int presuuesto2 = lectotTeclado.nextInt();

        System.out.println("Nombre del jugador 3: ");
        String nombre3 = lectotTeclado.next();
        System.out.println("Numeros de jugador 3: ");
        int jugadores3 = lectotTeclado.nextInt();
        System.out.println("Presupuesto de jugador 3: ");
        int presuuesto3 = lectotTeclado.nextInt();

        boolean condicion1 = jugadores1 ==11;
        System.out.println("1. El primer participante tiene 11 jugadores:"+condicion1);
        boolean condicion2 = jugadores2 %2 ==0;
        System.out.println("2. El segundo participante tiene jugadores pares:"+condicion2);
        boolean condicion3 = presuuesto3>0;
        System.out.println("3. El tercer participante tiene presupuesto positivo:"+condicion3);
        boolean condicion4 = (presuuesto1>0&&presuuesto2>0&&presuuesto3>0&&condicion1&&jugadores3==11&&jugadores2==11);
        System.out.println("4. La liga está preparada para empezar:"+condicion4);

    }
}
