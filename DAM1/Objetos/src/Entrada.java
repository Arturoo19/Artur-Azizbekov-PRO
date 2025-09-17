import model.Coche;

public class Entrada {
    public static void main(String[] args) {


        Coche coche3 = new Coche("Opel","Corsa",100);

        Carrera carrera = new Carrera(5,"Cheste");

        carrera.inscribirParticipantes(new Coche("Ford","Focus","y323",234));
        carrera.inscribirParticipantes(new Coche("Seat","Focus","y123",134));
        carrera.desinscribirParticipantes("323");
        carrera.mostrarParticipantes();
        carrera.iniciarCarrera();
        carrera.mostrarClasificacion();
        carrera.mostrarGanador();

    }
}
