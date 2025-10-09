package model;

public class TareaGenerica extends Tarea{

    String dato;

    public TareaGenerica() {

    }

    public TareaGenerica(int id, String titulo, String descripcion, Prioridad prioritario, int numeroPersonas, String dato) {
        super(id,titulo, descripcion, numeroPersonas,prioritario);
        this.dato = dato;
    }

    /*public TareaGenerica(int id, String titulo, String descripcion, int numeroPersonas, String dato) {
        super(id, titulo, descripcion, numeroPersonas);
        this.dato = dato;
    }*/

    /*@Override
    public void enviarRecordatorio() {
        System.out.println("Aviso de manera generica");
    }*/

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }


}