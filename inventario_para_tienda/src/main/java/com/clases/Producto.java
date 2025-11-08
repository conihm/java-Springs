package com.clases;

import java.util.Objects;

public abstract class Producto {
    
    private String nombre;
    private int precio;
    private int cantidadDisponible;

    public Producto(String n, int p) {
        nombre = n;
        precio = p;
        cantidadDisponible = 0;
    }

    public Producto(String n, int p, int c) {
        this(n, p);
        cantidadDisponible = c;
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
        return other.getNombre().equals(other.getNombre());
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