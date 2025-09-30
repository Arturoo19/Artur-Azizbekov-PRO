package model;

import java.util.Date;

public class TareaProfesional extends Tarea{

    private Date fechaLimite;
    private double presupuesto;

    /*@Override
    public void enviarRecordatorio(){
        for (Persona persona : getEncargados()) {
            if (persona!=null){
                System.out.printf("%s dice hacer %d ejercicios\n",persona.getNombre(),getListaTareas().size());
            }
        }
    }*/


    public TareaProfesional(){}

    public TareaProfesional(int id,String titulo, String descripcion, int numeroPersonas, Prioridad prioridad, Date fechaLimite, int presupuesto) {
        super(id,titulo, descripcion, numeroPersonas,prioridad);
        this.fechaLimite = fechaLimite;
        this.presupuesto = presupuesto;
    }



    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    @Override
    public String toString() {
        return super.toString() + "TareaProfesional{" +
                ", fechaLimite=" + fechaLimite +
                '}';
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
}
