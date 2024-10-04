import java.util.Scanner;

public class Ejercicio5 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Valor altura: ");
        int altura = lectorTeclado.nextInt();
        System.out.println("Valor base: ");
        int base = lectorTeclado.nextInt();


        System.out.println("Escribe primer lado del triangulo: ");
        int lado1 = lectorTeclado.nextInt();
        System.out.println("Escribe segundo lado del triangulo: ");
        int lado2 = lectorTeclado.nextInt();
        System.out.println("Escribe tercero lado del triangulo: ");
        int lado3 = lectorTeclado.nextInt();

        float area = calculo(base,altura);
        System.out.printf("El área del triángulo con base %d y altura %d es %.1f\n",base,altura,area);
        boolean isosceles = (lado1==lado2 || lado2==lado3 || lado3==lado1);
        System.out.println("El triángulo es isósceles:"+isosceles);
        boolean equilatero = (lado1 == lado2 && lado1 == lado3);
        System.out.println("El triángulo es equilátero:"+ equilatero);

        System.out.println("Escribe radio: ");
        int radio = lectorTeclado.nextInt();

        double areaCirculo=calculoArea(radio);
        System.out.printf("El área del círculo es %.3f", areaCirculo);

    }
    public static float calculo( float base,float altura){
        return (base*altura)/2;
    }
    public static double calculoArea(double radio){
        return Math.PI * radio*radio;
    }
}
