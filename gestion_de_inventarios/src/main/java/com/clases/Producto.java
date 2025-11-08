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
    public void validarInformacion() {
       
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
