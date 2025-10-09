import model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /*Tarea tarea = new Tarea("Practica DI",
                "Esta practica de DI es hacer un programa todolist",
                true,
                4);



        tarea.asignarResponsable (new Persona("Nombre","apellido","123b",15));
        tarea.asignarResponsable (new Persona("Nombre","apellido","123b",15));
        tarea.asignarResponsable (new Persona("Nombre","apellido","123b",15));
        tarea.asignarResponsable (new Persona("Hola","Apellido","123d",19));


        tarea.eliminarResponsable("123b");
        tarea.agregarEncargo(new Encargo(1,"dssds"));
        tarea.agregarEncargo(new Encargo(1,"dssds"));
        //tarea.buscarEncargo(1);
        tarea.listarEncargos();
        TareaPersonal tareaPersonal = new TareaPersonal(1,"Tarea2","descr",1,"alcorcon",100);
        TareaProfesional tareaProfesional = new TareaProfesional();

        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(tareaPersonal);
        tareas.add(tareaProfesional);*/

        //Date date = new Date();
        Tarea tarea = new Tarea();
        int cantidadSubTareas, idSubTarea;





        int opcion;
        int opcionTarea;
        int opcionResponsables;
        int opcionSubTarea;

        do {
            System.out.println("Elige la opcion: ");
            System.out.println("1.Registrar una tarea");
            System.out.println("2.Modificar tarea");
            System.out.println("3.Listar tareas");
            System.out.println("4.Completar tarea");
            System.out.println("5.Listar completas");
            System.out.println("6.Liistar incompletas");
            System.out.println("0.Salir de la aplicacion...");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    tarea.agregarTarea();
                    break;
                case 2:
                    System.out.println("Introduce id de tarea que quieres modificar:");
                    int idModificar = scanner.nextInt();
                    tarea.modificarTarea(idModificar);
                    break;
                case 3:
                    tarea.listarTareas();
                    break;
                case 4:
                    System.out.println("Introduce id de tarea:");
                    int idTarea = scanner.nextInt();
                    tarea.completarTarea(idTarea);
                    break;
                case 5:
                    tarea.listarTareasCompletadas();
                    break;
                case 6:
                    tarea.listarTareasNoCompletadas();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
            }
        } while (opcion != 0);

    }

}
