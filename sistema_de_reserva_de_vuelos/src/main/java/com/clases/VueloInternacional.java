package com.clases;

public class VueloInternacional extends Vuelo {
    
    private double impuestoInternacional;

    public VueloInternacional(String numeroVuelo, String origen, String destino, double duracion, double impuestoInternacional) {
        super(numeroVuelo, origen, destino, duracion);
        this.impuestoInternacional = impuestoInternacional;
    }

    @Override
    public double calcularPrecio(double valorBase) {
        return valorBase + impuestoInternacional;
    }

    @Override
    public void mostrarInformacionDeVuelo() {
        super.mostrarInformacionDeVuelo();
        System.out.println("Impuesto Internacional: " + impuestoInternacional + "\n");
    }     

}
