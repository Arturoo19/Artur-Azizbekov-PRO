
public class EjercicioCuantro {
    public static void main(String[] args) {
        double precio = 30000.0;
        double cuotaMensual = 5000.0;
        double interes = 3.5;

        double interesAmaunt = precio*(interes/100);
        System.out.printf("El interés pagado %.1f en el primer mes es de %.0f %.1f de %.1f\n"
                ,interes,interesAmaunt,interes,precio);
        precio -= cuotaMensual;
        interes+=3.5;

        double interesAmaunt1 = precio*(interes/100);
        System.out.printf("El interés pagado %.1f en el segundo mes es de %.0f %.1f de %.1f\n"
                ,interes,interesAmaunt1,interes,precio);
        precio -= cuotaMensual;
        interes+=3.5;

        double interesAmaunt2 = precio*(interes/100);
        System.out.printf("El interés pagado %.1f en el tercer mes es de %.0f %.1f de %.1f\n"
                ,interes,interesAmaunt2,interes,precio);
        precio -= cuotaMensual;
        interes+=3.5;

        double interesAmaunt3 = precio*(interes/100);
        System.out.printf("El interés pagado %.1f en el cuarto mes es de %.0f %.1f de %.1f\n"
                ,interes,interesAmaunt,interes,precio);
        precio -= cuotaMensual;
        interes+=3.5;

        double interesAmaunt4 = precio*(interes/100);
        System.out.printf("El interés pagado %.1f en el quinto mes es de %.0f %.1f de %.1f\n"
                ,interes,interesAmaunt,interes,precio);
        precio -= cuotaMensual;
        interes+=3.5;

        double interesAmaunt5 = precio*(interes/100);
        System.out.printf("El interés pagado %.1f en el sexto mes es de %.0f %.1f de %.1f\n"
                ,interes,interesAmaunt,interes,precio);
    }
}
