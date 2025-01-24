import model.Coche;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;

public class Carrera {
    private Random random = new Random();
    private Coche ganador;
    private int vueltas;
    private String nombre;
    private ArrayList<Coche> participantes;

    public Carrera(int vueltas,String nombre){
        this.vueltas = vueltas;
        this.nombre = nombre;
        participantes = new ArrayList<>();
    }


    public void inscribirParticipantes(Coche coche){

        if (participantes.size()==8){
            System.out.println("Error no hay mas sitios");
            return;
        }

        if (coche.getCv()>300){
            System.out.println("Error: No se permiten coches con más de 300 CV.");
            return;
        }
        for (Coche participante : participantes) {
            if (participante.getMatricula().equalsIgnoreCase(coche.getMatricula())) {
                System.out.println("Error: Ya existe un coche con esta matrícula.");
                return;
            }
        }
        participantes.add(coche);
        System.out.println("Coche inscrito correctamente");
    }
    public void desinscribirParticipantes(String matricula){
        boolean eliminado = false;
        for (int i = participantes.size()-1; i >= 0; i--) {
            if (participantes.get(i).getMatricula().equalsIgnoreCase(matricula)){
                participantes.remove(i);
                System.out.println("Coche eliminado:"+matricula);
                eliminado = true;
                break;
            }
        }
        if (!eliminado){
            System.out.println("No se encontro coche con "+matricula+" matricula");
        }
        participantes.removeIf(new Predicate<Coche>() {
            @Override
            public boolean test(Coche coche) {
                return coche.getMatricula().equalsIgnoreCase(matricula);

            }
        });
    }
    public void mostrarParticipantes(){
        for (Coche coche: participantes){
            System.out.println("Coche "+coche.getMarca() +" "+coche.getModelo()+" con matricula "+coche.getMatricula());
        }
    }
    public void iniciarCarrera(){
        for (int i = 0; i < 8; i++) {
            System.out.println("Vuelta "+(i+1));
            for (Coche coche: participantes){
                int kmRecorrido = random.nextInt(50,75);
                coche.setKm(coche.getKm()+kmRecorrido);
                System.out.println(coche.getMarca()+" ha recorrido "+kmRecorrido+" Total:"+coche.getKm()+" km");
            }
        }


    }
    public void mostrarClasificacion(){
        participantes.sort(new Comparator<Coche>() {
            @Override
            public int compare(Coche o1, Coche o2) {
                if (o1.getKm()>o2.getKm()){
                    return -1;
                } else if (o1.getKm()<o2.getKm()) {
                    return 1;
                }
                return 0;
            }
        });
        for (Coche coche: participantes){
            System.out.println("Coche "+coche.getMarca() +" "+coche.getModelo()+" con matricula "+coche.getMatricula()
                            +". "+coche.getKm()+" Km recorrido");
        }
    }

    public void mostrarGanador(){
        participantes.sort(new Comparator<Coche>() {
            @Override
            public int compare(Coche o1, Coche o2) {
                if (o1.getKm()>o2.getKm()){
                    return -1;
                } else if (o1.getKm()<o2.getKm()) {
                    return 1;
                }
                return 0;
            }
        });
        ganador = participantes.get(0);
        System.out.println("El ganador de la carrera es:");
        System.out.println("Coche: " + ganador.getMarca() + " " + ganador.getModelo() +
                " con matrícula " + ganador.getMatricula() +
                " y " + ganador.getKm() + " km recorridos.");
    }

    public Coche getGanador() {
        return ganador;
    }

    public void setGanador(Coche ganador) {
        this.ganador = ganador;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Coche> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Coche> participantes) {
        this.participantes = participantes;
    }

    public static void main(String[] args) {


        /*listaCoches.add(new Coche("Ford","Focus","Plata"));
        listaCoches.add(new Coche("Seat","Ibiza","Blanco"));
        for (Coche coche : listaCoches){
            coche.mostrarDatos();
            System.out.println();
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("Escribe marca de coche:");
            String marca = scanner.next();
            System.out.println("Escribe modelo de coche:");
            String modelo = scanner.next();
            System.out.println("Escribe cv de coche:");
            int cv = scanner.nextInt();
            System.out.println("Escribe matricula de coche:");
            String matricula = scanner.next();
            listaCoches.add(new Coche(marca,modelo,matricula,cv));
            
        }
        System.out.println("Escribe cuantas vueltas quieres:");
        int vueltas  = scanner.nextInt();
        for (int i = 0; i < vueltas; i++) {
            System.out.println("Vuelta " + (i + 1) + ":");
            for (Coche coche: listaCoches){
                int kmRecorrido = random.nextInt(50,75);
                coche.setKm(coche.getKm()+kmRecorrido);
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " ha recorrido " + kmRecorrido
                        + " km. Total: " + coche.getKm() + " km.");
            }
        }

        listaCoches.sort(new Comparator<Coche>() {
            @Override
            public int compare(Coche o1, Coche o2) {
                if (o1.getKm() > o2.getKm()){
                    return 1;
                } else if (o1.getKm() < o2.getKm()) {
                    return -1;
                }
                return 0;
            }
        });
        for (Coche coche : listaCoches){
            System.out.printf("Marca:%s Modelo:%s Matricula:%s",coche.getMarca(),coche.getModelo(),coche.getMatricula());
        }*/

        /*Un coche tiene un atributo KM,
        los cuales pueden decir la distanaia que ha recorrido un coche
        Para poder hacer una carrera, es necesario que se pida por consola
        los datos de 6 participantes, donde se debe indicar marca, madela,
        matricula, cv
        Una vez indicados todos los participantes, es necesario indicar cuantas
        vueltas consta la carrera
        Una vez indica el no de vueltas, la carrera comienza. Para ello en cada vuelta
        cada coche recorre un numero de km aleatorio (50-75)
        Una vez se terminan las vueltas el sistema mostrara:


        El ganado es el cache XXXX XXXX XXXXX
        La clasificacion final es.
        1- XXXX XXXX*/

    }
}
