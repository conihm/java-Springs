package com.clases;

import java.util.ArrayList;

public class TiendaElectronica {
    private ArrayList<Producto> listaDeProductos;

    public TiendaElectronica() {
        listaDeProductos = new ArrayList<>();
    }

    public boolean agregarProducto(Producto p) {
        if(listaDeProductos.contains(p))
            return false;
        listaDeProductos.add(p);
        return true;
    }

    public String mostrarListaCompleta() {
        int i = 1;
        String lista = "";
        for( Producto p : listaDeProductos) {
            lista += i + ".----\n" +
            p.mostrarInformacion() + "\n***\n";
            i++;
        }
        return lista;
    }

    public Producto buscarProducto(String nombre) {
        for(Producto p : listaDeProductos) {
            if(p.getNombre().equals(nombre))
                return p;
        }
        return null;
    }

    public boolean realizarVenta(int cantidad, String nombreProducto) {
        Producto p = buscarProducto(nombreProducto);
        if(p != null)
            return p.realizarVenta(cantidad);
        return false;
    }
}

