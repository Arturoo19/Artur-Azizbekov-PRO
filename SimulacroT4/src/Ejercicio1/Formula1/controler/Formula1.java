package Ejercicio1.Formula1.controler;

import java.util.*;

public class Formula1 {
    static Scanner scanner = new Scanner(System.in);
    private Hashtable<String,Object[]> listaPilotos;
    private int carrerasRestantes = 7;
    private final int max_pilotos = 10;

    public Formula1(){
        listaPilotos = new Hashtable<>();
    }

    public void agregarPilotos(){
        if (listaPilotos.size()>=max_pilotos){
            System.out.println("No se puede añadir mas personas");
            return;
        }

        System.out.println("Introduce nombre de piloto:");
        String nombre = scanner.next();
        System.out.println("Introduce el bastidor del coche:");
        String bastidor = scanner.next();


        Object[] piloto = new Object[]{nombre,bastidor,0};
        if (listaPilotos.containsKey(bastidor)){
            System.out.println("Ya existe piloto con este bastidor");
        } else{
            listaPilotos.put(bastidor,piloto);
            System.out.println("Añadido nuevo piloto");
        }
    }
    public void actualizarPuntos(){
        if (carrerasRestantes<=0){
            System.out.println("No quedan carreras");
            return;
        }
        if (listaPilotos.isEmpty()){
            System.out.println("No hay pilotos");
            return;
        }
        HashSet<Integer> puntosAsignados = new HashSet<>();
        Random random = new Random();

        for (String item : listaPilotos.keySet()){
            Object[] piloto = listaPilotos.get(item);

            int nuevosPuntos;
            do {
                nuevosPuntos = random.nextInt(1,12);
            } while (puntosAsignados.contains(nuevosPuntos));

            puntosAsignados.add(nuevosPuntos);
            piloto[2] = (int) piloto[2] + nuevosPuntos;
            System.out.println("Piloto: " + piloto[0] + " | Bastidor: " + piloto[1] +
                    " | Puntos obtenidos: " + nuevosPuntos +
                    " | Total acumulado: " + piloto[2]);
        }
        carrerasRestantes--;
        System.out.println("Carrera completada");
    }
    public void mostrarInformacionPiloto(){
        System.out.println("Introduce el bastidor del piloto:");
        String bastidor = scanner.next();

        if (!listaPilotos.containsKey(bastidor)){
            System.out.println("No se encontro un piloto con el bastidor introducido");
            return;
        }
        
        Object[] piloto = listaPilotos.get(bastidor);
        System.out.println("Informacion del pilote");
        System.out.println("Nombre: "+piloto[0]);
        System.out.println("Bastidor: "+piloto[1]);
        System.out.println("Puntos: "+piloto[2]);
    }
    public void mostrarClasificacion(){
        if (listaPilotos.isEmpty()) {
            System.out.println("No hay pilotos registrados.");
            return;
        }

        Hashtable<String, Object[]> copiaPilotos = new Hashtable<>(listaPilotos);

        System.out.println("Clasificación actual del campeonato:");
        int posicion = 1;

        while (!copiaPilotos.isEmpty()) {
            String bastidorMayor = null;
            int maxPuntos = Integer.MIN_VALUE;

            for (String bastidor : copiaPilotos.keySet()) {
                Object[] piloto = copiaPilotos.get(bastidor);
                int puntos = (int) piloto[2];
                if (puntos > maxPuntos) {
                    maxPuntos = puntos;
                    bastidorMayor = bastidor;
                }
            }

            if (bastidorMayor != null) {
                Object[] pilotoMayor = copiaPilotos.get(bastidorMayor);
                System.out.println(posicion + ". Nombre: " + pilotoMayor[0] +
                        " | Bastidor: " + bastidorMayor +
                        " | Puntos: " + pilotoMayor[2]);
                copiaPilotos.remove(bastidorMayor);
                posicion++;
            }
        }
    }
}
