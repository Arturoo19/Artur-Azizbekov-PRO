package model;

public class TareaPersonal extends Tarea {
    private String ubicacion;
    private double presupuesto;

    /*@Override
    public void enviarRecordatorio(){
        System.out.println("");
    }*/

    public TareaPersonal(){
    }

    public TareaPersonal(int id, String titulo,String descripcion,int numeroPersonas,Prioridad prioridad ,String ubicacion, double presupuesto){
        super(id, titulo,descripcion,numeroPersonas,prioridad);
        this.ubicacion = ubicacion;
        this.presupuesto = presupuesto;

    }

    public TareaPersonal(int id, String titulo, String descripcion, Prioridad prioritario, int numeroPersonas, String ubicacion) {
        super(id, titulo, descripcion, numeroPersonas,prioritario);
        this.ubicacion = ubicacion;
    }



    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void mostrarDatos(){

    }

    @Override
    public String toString() {
        return super.toString() + "TareaPersonal{" +
                "ubicacion='" + ubicacion + '\'' +
                '}';
    }


}
