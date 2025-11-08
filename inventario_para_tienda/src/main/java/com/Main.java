package com;

import javax.imageio.plugins.tiff.TIFFDirectory;

import com.clases.ComputadoraPortatil;
import com.clases.Producto;
import com.clases.Televisor;
import com.clases.TiendaElectronica;

public class Main {
    public static void main(String[] args) {
        
        Producto[] inventarioInicial = {
            new ComputadoraPortatil("Laptop Pro", 1299.99, "Apple", 16, "SN-MACPRO123", 10),
            new ComputadoraPortatil("Notebook Gamer", 1550.00, "Asus ROG", 32, "SN-ROG559Z", 5),
            new ComputadoraPortatil("Ultrabook Zen", 899.90, "Asus", 16, "SN-ZENBOOK45", 15),
            new ComputadoraPortatil("Portátil de Oficina", 650.00, "Dell", 8, "SN-DELL-LAT1", 20),
            new ComputadoraPortatil("Chromebook Slim", 349.50, "HP", 4, "SN-HP-CHROME2", 25),

            new Televisor("Smart TV QLED 55\"", 890.00, 55, "4K UHD", 8),
            new Televisor("Televisor OLED 65\"", 1800.00, 65, "4K UHD Premium", 4),
            new Televisor("Smart TV Básico 42\"", 420.00, 42, "1080p Full HD", 12),
            new Televisor("Televisor Pequeño 32\"", 230.00, 32, "720p HD", 18),
            new Televisor("Pantalla Gigante 8K", 4500.00, 85, "8K Ultra HD", 2)
        };  

        for(Producto p : inventarioInicial) {
            System.out.println(p.mostrarInformacion() + "\n***\n");
        }

        
        System.out.println("+++++++++++++++\n");
        //CREAR INSTANCIA TIENDA
        TiendaElectronica tienda = new TiendaElectronica();

        System.out.println("+++++++++++++++\n");
         //AGREGAR LOS PRODUCTOS A LA TIENDA
        for(Producto p : inventarioInicial) {
            System.out.println(tienda.agregarProducto(p) ? "Agregado con éxito" : "No pudo agregarse");
        }

        System.out.println("+++++++++++++++\n");
         //REALIZAR VENTAS
        for(Producto p : inventarioInicial) {
            System.out.println(tienda.agregarProducto(p) ? "Agregado con éxito" : "No pudo agregarse");
        }

    }

    /*
Realiza algunas ventas y verifica que la cantidad disponible de los productos se actualice correctamente.
Muestra todos los productos disponibles en el inventario para verificar que se agregaron correctamente.
     */
}