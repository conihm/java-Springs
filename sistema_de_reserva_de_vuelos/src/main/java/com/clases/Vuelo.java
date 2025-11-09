package com.clases;

public abstract class Vuelo {

    private String numeroVuelo, origen, destino;
    private double duracion;

    public Vuelo(String numeroVuelo, String origen, String destino, double duracion) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
    }

    public abstract double calcularPrecio(double valorBase);
    public void mostrarInformacionDeVuelo() {
        System.out.println("Número de vuelo: " + numeroVuelo + "\n" +
        "Origen: " + origen + "\n" +
        "Destino: " + destino + "\n" +
        "Duración: " + duracion + "\n");
    };

    public String getDestino() {
        return destino;
    }

    public double getDuracion() {
        return duracion;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

}
