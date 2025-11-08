package com.clases;

public class Gerente extends Empleado {
    private double bono;

    public Gerente(String n, int id, double s, double bono) {
        super(n, id, s);
        this.bono = bono;
    }

    @Override
    public double salarioTotal() {
        return getSalarioBase() + bono;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "\n" +
        "Bono: " + bono;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }
}
