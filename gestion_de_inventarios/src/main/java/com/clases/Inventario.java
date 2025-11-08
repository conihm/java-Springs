package com.clases;

import java.util.List;

import com.interfaces.Auditable;

public class Inventario implements Auditable, Validable {

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
            

    }

    

    
    

}
