package com;

import java.util.ArrayList;
import com.clases.Inventario;
import com.clases.Producto;
import com.clases.Transaccion;

public class Main {
    public static void main(String[] args) {

        // --- Instancias de Productos (5) ---
        Producto[] productos = new Producto[5];
        productos[0] = new Producto("P100", "Laptop Gamer", 1500.0);
        productos[1] = new Producto("P101", "Mouse Óptico", 45.50);
        productos[2] = new Producto("P102", "Teclado Mecánico", 120.0);
        
        //Producto válido pero con código repetido
        productos[3] = new Producto("P102", "Monitor 4K", 700.0);
        
        // Producto inválido para probar la interfaz Validable
        productos[4] = new Producto("", "Silla Gamer", -200.0); // ID vacío y precio negativo

        // --- Instancias de Transacciones (4) ---
        Transaccion[] transacciones = new Transaccion[4];
        transacciones[0] = new Transaccion("T-001", "Compra", 2365.50); // Compra de p1, p2, p3, p4
        transacciones[1] = new Transaccion("T-002", "Venta", 1500.0);  // Venta de p1
        transacciones[2] = new Transaccion("T-003", "Venta", 45.50);   // Venta de p2
        transacciones[3] = new Transaccion("T-004", "Ajuste de Stock", 0.0);

        // --- Instancia de Inventario (1) ---
        // Se inicializa con una lista de productos vacía
        Inventario miInventario = new Inventario(new ArrayList<>());
        miInventario.registraAccion("Inventario Creado");

        // ------------------
        // Validación de los productos creados
        for(Producto p : productos) {
            System.out.println(p.validarInformacion() + "\n***\n");
        }
        System.out.println();
        miInventario.registraAccion("Validación de productos");

        // ------------------
        // Agregar los productos válidos
        for(int i = 0; i < productos.length; i++) {
            if(productos[i].validarInformacion()) {
                if(miInventario.agregarProducto(productos[i]))
                    System.out.println("Agregado con éxito");
                else
                    System.out.println("No es posbile agregar. ID ya existe");
            }
            System.out.println();
        }
        miInventario.registraAccion("Agregación de productos validados");


         // ------------------
        // Revisión de inventario
        System.out.println(miInventario.listarInventario());

        // ------------------
        // Eliminación de productos
        String IdProductoAEliminar = "IDFalso";
        Producto p = miInventario.buscarProducto(IdProductoAEliminar);
        if(miInventario.eliminarProducto(p))
            System.out.println("Producto eliminado con éxito");
        else 
            System.out.println("Producto no existe");
        miInventario.registraAccion("Eliminación de productos");
        System.out.println();        
        
        IdProductoAEliminar = "P102";
        p = miInventario.buscarProducto(IdProductoAEliminar);
        if(miInventario.eliminarProducto(p))
            System.out.println("Producto eliminado con éxito");
        else 
            System.out.println("Producto no existe");
        miInventario.registraAccion("Eliminación de productos");
        System.out.println();

        
        // ------------------
        // Revisión de inventario
        System.out.println(miInventario.listarInventario());

        // Cierre: mostrar registro de acciones
        miInventario.imprimirAcciones();
    }
}
