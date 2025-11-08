package com.clases;

import java.util.List;

import com.interfaces.Auditable;
import com.interfaces.Validable;

public class Inventario implements Validable, Auditable {

    private List<Producto> productos;

    public Inventario(List<Producto> productos) {
        this.productos = productos;
    }

    public boolean agregarProducto(Producto producto) {
        for(Producto p : productos) {
            if(p.getIdProducto().equals(producto.getIdProducto()))
                return false;
        }
        productos.add(producto);
        return true;
    }

    public Producto buscarProducto(String idProducto) {
        for(Producto p : productos) {
            if(p.getIdProducto().equals(idProducto)) {
                return p;
            }
        }
        return null;
    }

    public Producto eliminarProducto(Producto producto) {
        for(Producto p : productos) {
            if(p.getIdProducto().equals(producto.getIdProducto())) {
                productos.remove(p);
                return p;
            }
        }
        return null;
    }

    @Override
    public void registraAccion(String accion) {
        System.out.println("AUDITORÍA [Inventario]: " + accion);
    }

    @Override
    public boolean validarInformacion() {
        System.out.println("\n--- VALIDANDO INVENTARIO COMPLETO ---");
        boolean inventarioValido = true;
        
        if (this.productos == null) {
            System.out.println("VALIDACIÓN FALLIDA (Inventario): La lista de productos es nula.");
            return false;
        }
        
        for (Producto p : this.productos) {
            if (!p.validarInformacion()) { // Re-utilizamos la validación de cada producto
                inventarioValido = false;
            }
        }
        
        if (inventarioValido) {
            System.out.println("--- INVENTARIO VALIDADO CORRECTAMENTE ---");
        } else {
            System.out.println("--- INVENTARIO CONTIENE DATOS INVÁLIDOS ---");
        }
        return inventarioValido;
    }
    

}
