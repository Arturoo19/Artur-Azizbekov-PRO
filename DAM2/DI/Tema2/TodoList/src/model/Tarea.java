package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class Tarea {

    private int id;
    private String titulo, descripcion;
    private boolean  completada;
    private Prioridad prioridad;
    private Persona[] encargados;
    private ArrayList<Encargo> listaTareas;
    private ArrayList<Tarea> tareas;
    private static Scanner scanner = new Scanner(System.in);




    // constructores
    public Tarea() {
        listaTareas = new ArrayList<Encargo>();
        tareas = new ArrayList<>();
    }

    public Tarea( int id, String titulo, String descripcion,
                 int numeroPersonas,Prioridad prioridad) {
        // completada = false;
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        encargados = new Persona[numeroPersonas];
        listaTareas = new ArrayList<Encargo>();
        tareas = new ArrayList<>();
    }

    public Tarea(int id, String titulo, String descripcion, int numeroPersonas) {
        // completada = false;
        // prioritario = false
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        encargados = new Persona[numeroPersonas];
        listaTareas = new ArrayList<Encargo>();
        tareas = new ArrayList<>();
    }



    public void asignarResponsable(Persona persona) {
        for (int i = 0; i < encargados.length; i++) {
            if (encargados[i] == null && !estaDNI(persona.getDni())) {
                encargados[i] = persona;
                System.out.println("Persona agregada correctamente");
                return;
            }
        }
        System.out.println("No hay hueco disponible, tarea completa");
    }
    public void asignarResponsable1(Persona persona){
        for (int i = 0; i < encargados.length-1; i++) {
            if (encargados[i]!=null && !estaDNI1(persona.getDni())){
                encargados[i] = persona;
                return;
            }
        }
    }

    public void eliminarResponsable(String dni) {
        for (int i = 0; i < encargados.length; i++) {
            if (encargados[i] != null && encargados[i].getDni().equalsIgnoreCase(dni)) {
                encargados[i] = null;
                System.out.println("Persona eliminada correctamente");
                return;
            }
        }
        System.out.printf("La persona con DNI %s no está en esta tarea%n", dni);
    }


    public void mostrarResponsables() {
        int numeroHuecos = 0;
        for (Persona persona : encargados) {
            if (persona == null) {
                numeroHuecos++;
            } else {
                System.out.println(persona);
            }
        }

        if (numeroHuecos == encargados.length) {
            System.out.println("No hay resposonsables asignados");
        } else if (numeroHuecos > 0) {
            System.out.printf("Hay %d huecos disponibles%n", numeroHuecos);
        } else {
            System.out.println("Todos los responsables estan ubicados");
        }


    }

    private boolean estaDNI(String dni) {
        for (Persona persona : encargados) {
            if (persona != null && persona.getDni().equalsIgnoreCase(dni)) {
                return true;
            }
        }
        return false;
    }
    private boolean estaDNI1(String dni){
        for (Persona persona: encargados){
            if (persona != null && persona.getDni().equalsIgnoreCase(dni)){
                return true;
            }
        }

        return false;
    }

    private Encargo estaEncargo(int id) {

        for (Encargo encargo : listaTareas) {
            if (encargo.getId() == id) return encargo;
        }
        return null;
    }
    private Encargo estaEncargo1(int id){
        for (Encargo encargo:listaTareas){
            if (encargo.getId()==id) return encargo;
        }
        return null;
    }

    public void agregarEncargo(Encargo encargo) {
        if (estaEncargo(encargo.getId()) != null) {
            System.out.println("Error en el proceso, no se puede agregar");
        } else {
            listaTareas.add(encargo);
            System.out.println("Agregado correctamente");
        }
    }

    public void borrarEncargo(int id) {
        if (estaEncargo(id) != null) {
            listaTareas.remove(estaEncargo(id));
            System.out.println("Borrado correctamente");
        } else {
            System.out.println("No esta en la lista el id especificado");
        }
    }

    public void buscarEncargo(int id) {
        Encargo e = estaEncargo(id);
        if (e != null) {
            System.out.println(e);
        } else {
            System.out.println("No hay encargo con este id");
        }
    }
    public void completarEncargo(int id){
        Encargo encargo = estaEncargo(id);
        if (encargo!= null){
            encargo.setCompletada(true);
            System.out.println("Encargo completado");
        } else {
            System.out.println("No existe encargo con este id");
        }
    }
    public void completarTarea(int id){
        Tarea tarea = estaTarea(id);
        if (tarea!=null){
            tarea.setCompletada(true);
            System.out.println("Tarea completada");
        }else{
            System.out.println("No se puede completar la tarea");
        }

    }

    public void listarEncargos(){
        for (Encargo encargo: listaTareas){
            System.out.println(encargo);
        }
    }
    public void mostrarEncargosCompletados(){
        for (Encargo encargo:listaTareas){
            if (encargo.isCompletada()){
                System.out.println(encargo);
            }
        }
    }
    public void mostrarEncargoIncopletados(){
        for (Encargo encargo:listaTareas){
            if (!encargo.isCompletada()){
                System.out.println(encargo);
            }
        }
    }



    private Tarea estaTarea(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) return tarea;
        }
        return null;
    }

    public void agregarTarea() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Que tarea quieres registrar?");
        System.out.println("1. Tarea Profesional");
        System.out.println("2. Tarea Personal");
        int tipoTarea = scanner.nextInt();

        Tarea nuevaTarea = null;

        switch (tipoTarea) {
            case 1 -> {
                System.out.println("Introduce ID: ");
                int id = scanner.nextInt();
                System.out.println("Introduce titulo: ");
                String titulo = scanner.next();
                System.out.println("Introduce descripcion: ");
                String descripcion = scanner.next();
                System.out.println("Introduce numero personas: ");
                int numPersonas = scanner.nextInt();
                System.out.println("Introduce prioridad (BAJA, MEDIA, ALTA): ");
                Prioridad prioridad = Prioridad.valueOf(scanner.next().toUpperCase());
                Date date = new Date();
                System.out.println("introduce presupuesto:");
                int presupuesto = scanner.nextInt();

                nuevaTarea = new TareaProfesional(id, titulo, descripcion, numPersonas, prioridad, date,presupuesto);

                System.out.println("Quiere añadir responsables ahora? (1.Si/2.No): ");
                int opcionResponsables = scanner.nextInt();
                if (opcionResponsables == 1) {
                    for (int i = 0; i < numPersonas; i++) {
                        System.out.println("Introduce dni: ");
                        String dni = scanner.next();
                        System.out.println("Introduce nombre: ");
                        String nombre = scanner.next();
                        System.out.println("Introduce apellido: ");
                        String apellido = scanner.next();
                        System.out.println("Introduce edad: ");
                        int edad = scanner.nextInt();

                        nuevaTarea.asignarResponsable(new Persona(dni, nombre, apellido, edad));
                    }
                } else {
                    System.out.println("Los responsables se asignaran luego...");
                }
            }

            case 2 -> {
                System.out.println("Introduce ID: ");
                int idPers = scanner.nextInt();
                System.out.println("Introduce titulo: ");
                String tituloPers = scanner.next();
                System.out.println("Introduce descripcion: ");
                String descripcionPers = scanner.next();
                System.out.println("Introduce numero personas: ");
                int numPersonasPers = scanner.nextInt();
                System.out.println("Introduce prioridad (BAJA, MEDIA, ALTA): ");
                Prioridad prioridadPers = Prioridad.valueOf(scanner.next().toUpperCase());
                System.out.println("Introduce ubicacion: ");
                String ubicacion = scanner.next();
                System.out.println("Introduce presupuesto: ");


                nuevaTarea = new TareaPersonal(idPers, tituloPers, descripcionPers, numPersonasPers, prioridadPers, ubicacion);

                System.out.println("Quiere añadir responsables ahora? (1.Si/2.No): ");
                int opcionResponsables = scanner.nextInt();
                if (opcionResponsables == 1) {
                    for (int i = 0; i < numPersonasPers; i++) {
                        System.out.println("Introduce dni: ");
                        String dni = scanner.next();
                        System.out.println("Introduce nombre: ");
                        String nombre = scanner.next();
                        System.out.println("Introduce apellido: ");
                        String apellido = scanner.next();
                        System.out.println("Introduce edad: ");
                        int edad = scanner.nextInt();

                        nuevaTarea.asignarResponsable(new Persona(dni, nombre, apellido, edad));
                    }
                } else {
                    System.out.println("Los responsables se asignaran luego...");
                }
            }
            default -> System.out.println("Opcion incorrecta");
        }
        if (nuevaTarea != null) {
            System.out.println("Quieres añadir subtareas ahora? (1.Si/2.No): ");
            int opcionSubTarea = scanner.nextInt();

            if (opcionSubTarea == 1) {
                System.out.println("Cuantas subtareas quieres añadir? ");
                int cantidadSubTareas = scanner.nextInt();

                for (int i = 0; i < cantidadSubTareas; i++) {
                    System.out.println("Introduce id de subtarea: ");
                    int idSubTarea = scanner.nextInt();
                    System.out.println("Introduce descripcion de subtarea: ");
                    String descripcionSubTarea = scanner.next();

                    nuevaTarea.agregarEncargo(new Encargo(idSubTarea, descripcionSubTarea));
                }
            } else {
                System.out.println("Las subtareas se añadiran luego...");
            }
        }

        if (nuevaTarea != null) {
            if (estaTarea(nuevaTarea.getId()) != null) {
                System.out.println("Error en el proceso, ya existe tarea con este ID");
            } else {
                tareas.add(nuevaTarea);
                System.out.println("Agregado correctamente");
            }
        }
    }
    public void modificarTarea(int id) {
        if (estaTarea(id) != null) {
            Tarea tarea = estaTarea(id);
            int opcionTarea;

            do {
                System.out.println("\n--- Menu de modificacion ---");
                System.out.println("1. Modificar tarea Profesional");
                System.out.println("2. Modificar tarea Personal");
                System.out.println("0. Volver");
                System.out.print("Elige opcion: ");
                opcionTarea = scanner.nextInt();

                switch (opcionTarea) {
                    case 1 -> {
                        if (!(tarea instanceof TareaProfesional tareaProfesional)) {
                            System.out.println("La tarea con id " + id + " no es Profesional.");
                            break;
                        }
                        int opcion;
                        do {
                            System.out.println("\n--- Modificacion Tarea Profesional ---");
                            System.out.println("1. Cambiar titulo");
                            System.out.println("2. Cambiar descripcion");
                            System.out.println("3. Cambiar prioridad");
                            System.out.println("4. Añadir responsable");
                            System.out.println("5. Eliminar responsable");
                            System.out.println("6. Añadir subtarea");
                            System.out.println("7. Eliminar subtarea");
                            System.out.println("8. Cambiar presupuesto");
                            System.out.println("0. Volver");
                            System.out.print("Elige opcion: ");
                            opcion = scanner.nextInt();

                            switch (opcion) {
                                case 1 -> {
                                    System.out.println("Escribe nuevo titulo:");
                                    tareaProfesional.setTitulo(scanner.next());
                                    System.out.println("Titulo actualizado.");
                                }
                                case 2 -> {
                                    System.out.println("Escribe nueva descripcion:");
                                    tareaProfesional.setDescripcion(scanner.next());
                                    System.out.println("Descripcion actualizada.");
                                }
                                case 3 -> {
                                    System.out.println("Escribe nueva prioridad BAJA,MEDIA,ALTA:");
                                    Prioridad prioridad = Prioridad.valueOf(scanner.next().toUpperCase());
                                    tareaProfesional.setPrioridad(prioridad);
                                    System.out.println("Prioridad actualizada.");
                                }
                                case 4 -> {
                                    System.out.println("Introduce dni: ");
                                    String dni = scanner.next();
                                    System.out.println("Introduce nombre: ");
                                    String nombre = scanner.next();
                                    System.out.println("Introduce apellido: ");
                                    String apellido = scanner.next();
                                    System.out.println("Introduce edad: ");
                                    int edad = scanner.nextInt();
                                    tareaProfesional.asignarResponsable(new Persona(dni, nombre, apellido, edad));
                                }
                                case 5 -> {
                                    System.out.println("Introduce dni del responsable:");
                                    tareaProfesional.eliminarResponsable(scanner.next());
                                    System.out.println("Responsable eliminado.");
                                }
                                case 6 -> {
                                    System.out.println("Introduce id de subtarea: ");
                                    int idSub = scanner.nextInt();
                                    System.out.println("Introduce descripcion de subtarea: ");
                                    String descSub = scanner.next();
                                    tareaProfesional.agregarEncargo(new Encargo(idSub, descSub));
                                }
                                case 7 -> {
                                    System.out.println("Introduce id de la subtarea a eliminar: ");
                                    tareaProfesional.borrarEncargo(scanner.nextInt());
                                }
                                case 8 -> {
                                    System.out.println("Introduce nuevo presupuesto: ");
                                    tareaProfesional.setPresupuesto(scanner.nextInt());
                                    System.out.println("Presupuesto actualizado.");
                                }
                                case 0 -> System.out.println("Volviendo al menu principal...");
                                default -> System.out.println("Opcion no valida.");
                            }
                        } while (opcion != 0);
                    }

                    case 2 -> {
                        if (!(tarea instanceof TareaPersonal tareaPersonal)) {
                            System.out.println("La tarea con id " + id + " no es Personal.");
                            break;
                        }
                        int opcion;
                        do {
                            System.out.println("\n--- Modificacion Tarea Personal ---");
                            System.out.println("1. Cambiar titulo");
                            System.out.println("2. Cambiar descripcion");
                            System.out.println("3. Cambiar prioridad");
                            System.out.println("4. Añadir responsable");
                            System.out.println("5. Eliminar responsable");
                            System.out.println("6. Añadir subtarea");
                            System.out.println("7. Eliminar subtarea");
                            System.out.println("8. Cambiar ubicacion");
                            System.out.println("0. Volver");
                            System.out.print("Elige opcion: ");
                            opcion = scanner.nextInt();

                            switch (opcion) {
                                case 1 -> {
                                    System.out.println("Escribe nuevo titulo:");
                                    tareaPersonal.setTitulo(scanner.next());
                                    System.out.println("Titulo actualizado.");
                                }
                                case 2 -> {
                                    System.out.println("Escribe nueva descripcion:");
                                    tareaPersonal.setDescripcion(scanner.next());
                                    System.out.println("Descripcion actualizada.");
                                }
                                case 3 -> {
                                    System.out.println("Escribe nueva prioridad BAJA,MEDIA,ALTA:");
                                    Prioridad prioridad = Prioridad.valueOf(scanner.next().toUpperCase());
                                    tareaPersonal.setPrioridad(prioridad);
                                    System.out.println("Prioridad actualizada.");
                                }
                                case 4 -> {
                                    System.out.println("Introduce dni: ");
                                    String dni = scanner.next();
                                    System.out.println("Introduce nombre: ");
                                    String nombre = scanner.next();
                                    System.out.println("Introduce apellido: ");
                                    String apellido = scanner.next();
                                    System.out.println("Introduce edad: ");
                                    int edad = scanner.nextInt();
                                    tareaPersonal.asignarResponsable(new Persona(dni, nombre, apellido, edad));
                                }
                                case 5 -> {
                                    System.out.println("Introduce dni del responsable:");
                                    tareaPersonal.eliminarResponsable(scanner.next());
                                    System.out.println("Responsable eliminado.");
                                }
                                case 6 -> {
                                    System.out.println("Introduce id de subtarea: ");
                                    int idSub = scanner.nextInt();
                                    System.out.println("Introduce descripcion de subtarea: ");
                                    String descSub = scanner.next();
                                    tareaPersonal.agregarEncargo(new Encargo(idSub, descSub));
                                }
                                case 7 -> {
                                    System.out.println("Introduce id de la subtarea a eliminar: ");
                                    tareaPersonal.borrarEncargo(scanner.nextInt());
                                }
                                case 8 -> {
                                    System.out.println("Introduce nueva ubicacion: ");
                                    tareaPersonal.setUbicacion(scanner.next());
                                    System.out.println("Ubicacion actualizada.");
                                }
                                case 0 -> System.out.println("Volviendo al menu principal...");
                                default -> System.out.println("Opcion no valida.");
                            }
                        } while (opcion != 0);
                    }

                    case 0 -> System.out.println("Saliendo de modificacion...");
                    default -> System.out.println("Opcion no valida.");
                }

            } while (opcionTarea != 0);

        } else {
            System.out.println("No existe tarea con ese ID.");
        }
    }



    public void listarTareas() {
        for (Tarea tarea: tareas) {
            System.out.println(tarea);
        }
    }

    public void listarTareasCompletadas(){
        for (Tarea tarea : tareas) {
            if(tarea.isCompletada()){
                System.out.println(tarea);
            }
        }
    }

    public void listarTareasNoCompletadas(){
        for (Tarea tarea : tareas) {
            if(!tarea.isCompletada()){
                System.out.println(tarea);
            }
        }
    }






    public boolean borrarEncargo1(int id) {
        return listaTareas.remove(estaEncargo(id));
    }


    public Persona[] getEncargados() {
        return encargados;
    }

    public void setEncargados(Persona[] encargados) {
        this.encargados = encargados;
    }

    public ArrayList<Encargo> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ArrayList<Encargo> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Prioridad isPrioritario() {
        return prioridad;
    }

    public void setPrioritario(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioritario=" + prioridad +
                ", completada=" + completada +
                "\n, encargados=" + Arrays.toString(encargados) +
                "\n, listaTareas=" + listaTareas+
                '}';
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }
}


// creamos un encargo.
// Los encargos tienen una propiedad llamada descripcion,
// una propiedad llamda id y una propiedad llamada completa