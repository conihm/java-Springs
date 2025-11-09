package com.clases;
import java.util.ArrayList;
import java.util.List;
import com.interfaces.Auditable;
import com.interfaces.Validable;

public class Inventario implements Validable, Auditable {

    private List<Producto> productos;
    private List<String> acciones;

    public Inventario(List<Producto> productos) {
        this.productos = productos;
        this.acciones = new ArrayList<String>();
    }

    public String listarInventario() {
        String lista = "";
        for(Producto p : productos) {
            lista += p.toString();
        }
        return lista;
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

    public boolean eliminarProducto(Producto producto) {
        for(Producto p : productos) {
            if(producto != null && p.getIdProducto().equals(producto.getIdProducto())) {
                productos.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public void registraAccion(String accion) {
        acciones.add(accion);  
        System.out.println("AUDITORÍA [Inventario]: " + accion);
    }

    public void imprimirAcciones() {
        System.out.println("--AUDITORÍA--");
        for(String a : acciones) {
            System.out.println("-->" + a + "\n");
        }
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
