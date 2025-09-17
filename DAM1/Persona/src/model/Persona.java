package model;

import java.util.ArrayList;

public class Persona {
    private String nombre,apellido,dni;
    private int edad;
    private double peso,altura;

    private ArrayList<Object[]> listapersona;

    public Persona(String nombre,String apellido,String dni,int edad, double peso, double altura){
        this.nombre= nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        listapersona = new ArrayList<>();
    }
    public Persona(String nombre,String apellido,String dni){
        this.nombre= "sin definir";
        this.apellido = "sin definir";
        this.dni = "sin definir";
    }
    public Persona(String nombre,String apellido,String dni,int edad){
        this.nombre= nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }
    public void mostarDatos(){
        System.out.printf("Nombre:%s"+
                "\nApellido:%s"+
                "\nDNI:%s"+
                "\nAltura:%.2f"+
                "\nPeso:%-2f"+
                "\nEdad:%d",nombre,apellido,dni,altura,peso,edad);

    }
    public Persona() {
        this.nombre = "Sin definir";
        this.apellido = "Sin definir";
        this.dni = "Sin definir";
        this.edad = 0;
        this.peso = 0;
        this.altura = 0;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
