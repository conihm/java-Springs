package com.clases;

public class VueloCarga extends Vuelo {
    
    private double pesoCarga;
    private double tarifaKilogramo;

    public VueloCarga(String numeroVuelo, String origen, String destino, double duracion, double pesoCarga, double tarifaKilogramo) {
        super(numeroVuelo, origen, destino, duracion);
        this.pesoCarga = pesoCarga;
        this.tarifaKilogramo = tarifaKilogramo;
    }

    @Override
    public double calcularPrecio(double valorBase) {
        return valorBase + tarifaKilogramo * pesoCarga;
    }

    @Override
    public void mostrarInformacionDeVuelo() {
        super.mostrarInformacionDeVuelo();
        System.out.println("Tarifa por kilogramo: " + tarifaKilogramo + "\n" +
        "Peso de la carga: " + pesoCarga + "\n");
    }

}
