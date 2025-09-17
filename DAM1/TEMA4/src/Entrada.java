public class Entrada {
    public static void main(String[] args) {
        int[] numeros = new int[4];
        System.out.println(numeros.length);
        numeros[3] =7;
        System.out.println(numeros[3]);

        String[] palabras = {"Hola","que","tal"};
        System.out.println(palabras[palabras.length-1]);
        for (int i=0; i < palabras.length;i++){
            System.out.println(palabras[i]);
        }
        for (int i=0;i< numeros.length;i++){
            numeros[i]= (int)(Math.random()*101);
        }
        for (int i=0; i< numeros.length; i++){
            if (i % 2 == 0){
                System.out.println(numeros[i]);
            }
            if (numeros[i]%2 == 0){
                System.out.println(numeros[i]);
            }
        }
        for(int item:numeros){
            System.out.println(item);
        }
    }
}
