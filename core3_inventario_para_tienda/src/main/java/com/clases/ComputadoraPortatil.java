package com.clases;

public class ComputadoraPortatil extends Producto {
    private String marca,  numeroSerie;
    private int memoriaRAM;

    public ComputadoraPortatil(String nombre, double precio, String marca, int memoriaRAM, String numeroSerie) {
        super(nombre, precio);
        this.marca = marca;
        this.memoriaRAM = memoriaRAM;
        this.numeroSerie = numeroSerie;
    }

     public ComputadoraPortatil(String nombre, double precio, String marca, int memoriaRAM, String numeroSerie, int cantidadDisponible) {
        super(nombre, precio, cantidadDisponible);
        this.marca = marca;
        this.memoriaRAM = memoriaRAM;
        this.numeroSerie = numeroSerie;
    }

    @Override
    public String mostrarInformacion() {
        return getClass().getSimpleName() + "\n" + 
        super.mostrarInformacion() + "\n" +
        "Marca: " + marca + "\n" + 
        "Memoria RAM: " + memoriaRAM + "\n" + 
        "Número de serie: " + numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMemoriaRAM(int memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}