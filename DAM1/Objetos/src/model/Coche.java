package model;

import java.util.Random;
import java.util.Scanner;

public class Coche {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    //propiedades
    private String marca, modelo, matricula, bastidor, color;
    private double precio;
    private int cv,par,km;

    //contructores
    public Coche(){
        matricula = "sin definir";
        marca = "sin definir";
        modelo = "sin definir";
        bastidor = "sin definir";
        color = "sin definir";
    }
    public Coche(String marca, String modelo, int cv){
        this.marca = marca;
        this.cv = cv;
        this.modelo = modelo;
        this.par =(int) Math.pow(cv*2,2);

    }

    public Coche(String marca, String modelo, String matricula, int cv){
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
    }

    //metodos
    public void mostrarDatos(){
        System.out.println("La marca es:"+this.marca);
        System.out.println("El modelo es:"+this.modelo);
        System.out.println("Los cv son:"+this.cv);
        System.out.println("El par es:"+this.par);
        System.out.println("El color es:"+this.color);
        System.out.println("El n bastidor es:"+this.bastidor);
        System.out.println("La matricula es:"+this.matricula);
        System.out.println("El precio es:"+this.precio);
        System.out.println("Los km son:"+this.km);
    }

    //metodos especiales
    public String getMarca(){
        return this.marca;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }
}
