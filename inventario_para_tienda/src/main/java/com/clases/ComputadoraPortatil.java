package com.clases;

public class ComputadoraPortatil extends ProductoElectrodomestico {
    private String marca,  memoriaRAM;
    private int numeroSerie;

    public ComputadoraPortatil(String n, int p, String m, String me, int num) {
        super(n, p);
        marca = m;
        memoriaRAM = me;
        numeroSerie = num;
    }

    public ComputadoraPortatil(String n, int p, String m, String me, int num, int c) {
        super(n, p, c);
        marca = m;
        memoriaRAM = me;
        numeroSerie = num;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "\n" +
        "Marca: " + marca + "\n" + 
        "Memoria RAM: " + memoriaRAM + "\n" + 
        "Número de serie: " + numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMemoriaRAM(String memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}
