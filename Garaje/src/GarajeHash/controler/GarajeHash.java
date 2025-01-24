package GarajeHash.controler;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class GarajeHash {
    static Scanner scanner = new Scanner(System.in);

    private Hashtable<String,Object[]> listaCoches;

    public GarajeHash(){
        listaCoches = new Hashtable<>();
    }

    public void agregarCoche(){
        String marca = scanner.next();
        String modelo = scanner.next();
        int costeReparacion = scanner.nextInt();
        String matricula = scanner.next();

        Object[] coches = new Object[]{marca,modelo,costeReparacion,matricula};
        if (listaCoches.containsKey(matricula)){
            System.out.println("Ya existe coche con esta matricula");
        } else {
            listaCoches.put(matricula,coches);
            System.out.println("Coche agragado con exito");
        }
    }
    public void getCoches(String matricula){
        if (listaCoches.containsKey(matricula)){
            Object[] cocheEncontrado = listaCoches.get(matricula);
            System.out.println(cocheEncontrado[3].toString());
        }

    }

    public void eliminarCoche(){
        System.out.println("Escribe la matricula de coche que qieres eliminar:");
        String cocheEliminar = scanner.next();

        if (listaCoches.remove(cocheEliminar) != null){
            System.out.println("Coche eliminado correctamente");
        } else {
            System.out.println("No se encotro ningun coche con la matricula:"+cocheEliminar);
        }

    }
    public void buscarCoche(){
        System.out.println("Escribe la matricula de coche que quieres encotrar:");
        String cocheBuscar = scanner.next();
        Object[] coche = listaCoches.get(cocheBuscar);

        if (coche != null){
            System.out.println("Coche encotrado:");
            System.out.println("Matricula:"+coche[3]+"Marca:"+coche[0]);
        }

    }

    public void modificarCoche(String matricula){
        Object[] coche = listaCoches.get(matricula);
        coche[3] = Integer.valueOf(coche[3].toString()) + 20000;
    }
    public void recorrerCochesKey(){
        Enumeration<String> keys = listaCoches.keys();
        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            getCoches(key);
        }
    }
    public void recorrerCoshesElement(){
        Enumeration<Object[]> coches = listaCoches.elements();
        while (coches.hasMoreElements()){
            Object[] coche = coches.nextElement();
            getCoches(coche[1].toString());
        }
    }
    public void mostrarCostes(){
        if (listaCoches.isEmpty()) {
            System.out.println("No hay coches en el garaje.");
            return;
        }

        System.out.println("Costes de reparación de los coches:");
        Enumeration<Object[]> costes = listaCoches.elements();
        while (costes.hasMoreElements()){
            Object[] coste = costes.nextElement();
            System.out.println("Matricula: "+coste[3]+", Coste de reparacion:"+coste[2]);
        }
    }
    public void listarCoches(){
        if (listaCoches.isEmpty()){
            System.out.println("No hay coches");
            return;
        }
        System.out.println("Lista de coches:");
        Enumeration<Object[]> coches = listaCoches.elements();
        while (coches.hasMoreElements()){
            Object[] coche = coches.nextElement();
            System.out.println("Matricula:"+coche[3]+"Marca:"+coche[0]+"Modelo:"+coche[1]+"Coste reparacion:"+coche[2]);
        }
    }

    public void vaciarLista(){
        listaCoches.clear();
    }


}
