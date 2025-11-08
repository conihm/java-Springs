package com;

import com.clases.Director;
import com.clases.Empleado;
import com.clases.Gerente;

public class Main {
    public static void main(String[] args) {
        
        Empleado[] empleados = new Empleado[3];
        empleados[0] = new Empleado("coni", 1234, 100);
        empleados[1] = new Gerente("rami", 3456, 1000, 50);
        empleados[2] = new Director("viki", 5678, 1200, 50, 300);

        for(Empleado e : empleados) {
            System.out.println(e.mostrarInformacion() + "\n");
            System.out.println("***\n");
        }     
    }
}