package com.clases;

public class VueloDomestico extends Vuelo {
    
    private double descuento;

    public VueloDomestico(String numeroVuelo, String origen, String destino, double duracion, double descuento) {
        super(numeroVuelo, origen, destino, duracion);
        this.descuento = descuento;
    }

    @Override
    public double calcularPrecio(double valorBase) {
        return valorBase - descuento * valorBase;
    }

    @Override
    public void mostrarInformacionDeVuelo() {
        System.out.println("Número de vuelo: " + getNumeroVuelo() + "\n" +
        "Origen: " + getOrigen() + "\n" +
        "Destino: " + getOrigen() + "\n" +
        "Duración: " + getDuracion() + "\n" +
        "Descuento: " + descuento);
    }
    
}

/*
para calcular el precio de un vuelo doméstico teniendo en cuenta el descuento aplicado.
 */