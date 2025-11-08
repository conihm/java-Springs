package com.clases;

import com.interfaces.Validable;

public class Producto implements Validable {
    
    private String idProducto, nombre;
    private double precio;

    public Producto(String idProducto, String nombre, double precio){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public boolean validarInformacion() {
        if (this.idProducto == null || this.idProducto.isEmpty()) {
            System.out.println("VALIDACIÓN FALLIDA (Producto): El ID está vacío.");
            return false;
        }
        if (this.nombre == null || this.nombre.isEmpty()) {
            System.out.println("VALIDACIÓN FALLIDA (Producto): El nombre está vacío.");
            return false;
        }
        if (this.precio <= 0) {
            System.out.println("VALIDACIÓN FALLIDA (Producto): El precio debe ser positivo.");
            return false;
        }
        
        System.out.println("VALIDACIÓN EXITOSA (Producto): " + this.nombre);
        return true; // Si pasó todas las pruebas
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
