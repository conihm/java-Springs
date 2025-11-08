package com.clases;

public abstract class ProductoElectrodomestico {
    
    private String nombre;
    private int precio;
    private int cantidadDisponible;

    public ProductoElectrodomestico(String n, int p) {
        nombre = n;
        precio = p;
        cantidadDisponible = 0;
    }

    public ProductoElectrodomestico(String n, int p, int c) {
        this(n, p);
        cantidadDisponible = c;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre + "\n" +
        "Precio: " + precio + "\n" +
        "Cantidad disponbile: " + cantidadDisponible;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}