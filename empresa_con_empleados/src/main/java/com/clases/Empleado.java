package com.clases;

import java.util.Objects;

public class Empleado {

    private String nombre;
    private int id;
    private double salarioBase;


    public Empleado(String n, int id, double s) {
        nombre = n;
        this.id = id;
        salarioBase = s;
    }

    public double salarioTotal() {
        return salarioBase * 160;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre + "\n" +
        "ID: " + id + "\n" +
        "Salario base: " + salarioBase + "\n" +
        "Salario total: " + salarioTotal();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }   

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != getClass())
            return false;
        Empleado other = (Empleado) obj;
            return other.id == this.id;
    }

}

