package com.clases;

public class Director extends Gerente {
    private double acciones;

    public Director(String n, int id, double s, double b, double a) {
        super(n, id, s, b);
        acciones = a;
    }

    @Override
    public double salarioTotal() {
        // TODO Auto-generated method stub
        return super.salarioTotal() + acciones;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "\n" +
        "Acciones: " + acciones;
    }

    public double getAcciones() {
        return acciones;
    }

    public void setAcciones(double acciones) {
        this.acciones = acciones;
    }
}




