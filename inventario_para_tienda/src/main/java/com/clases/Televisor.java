package com.clases;

public class Televisor extends Producto {
    
    private int tamañoPantalla;
    private String resolucion;

    public Televisor(String nombre, double precio, int tamañoPantalla, String resolucion) {
        super(nombre, precio);
        this.tamañoPantalla = tamañoPantalla;
        this.resolucion = resolucion;
    }
    
    public Televisor(String nombre, double precio, int tamañoPantalla, String resolucion, int cantidadDisponible) {
        super(nombre, precio, cantidadDisponible);
        this.tamañoPantalla = tamañoPantalla;
        this.resolucion = resolucion;
    }

    @Override
    public String mostrarInformacion() {
        return getClass().getSimpleName() + "\n" + 
        super.mostrarInformacion() + "\n" +
        "Tamaño de pantalla: " + tamañoPantalla + "\n" +
        "Resolución: " + resolucion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public int getTamañoPantalla() {
        return tamañoPantalla;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public void setTamañoPantalla(int tamañoPantalla) {
        this.tamañoPantalla = tamañoPantalla;
    }
}