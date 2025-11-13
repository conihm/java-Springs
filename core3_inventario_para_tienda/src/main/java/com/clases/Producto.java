package com.clases;
import java.util.Objects;

public abstract class Producto {
    
    private String nombre;
    private double precio;
    private int cantidadDisponible;


    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        cantidadDisponible = 0;
    }

    public Producto(String nombre, double precio, int cantidadDisponible) {
        this(nombre, precio);
        this.cantidadDisponible = cantidadDisponible;
    }

    public boolean realizarVenta(int cantidad) {
        if(cantidad > cantidadDisponible)
            return false;
        cantidadDisponible -= cantidad;
        return true;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre + "\n" +
        "Precio: " + precio + "\n" +
        "Cantidad disponbile: " + cantidadDisponible;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        return other.getNombre().equalsIgnoreCase(nombre);
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}