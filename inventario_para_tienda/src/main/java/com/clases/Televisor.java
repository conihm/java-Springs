package com.clases;

public class Televisor extends ProductoElectrodomestico {
    
    private String tamañoPantalla;
    private String resolucion;

    public Televisor(String n, int p, String t, String r) {
        super(n, p);
        tamañoPantalla = t;
        resolucion = r;
    }
    
    public Televisor(String n, int p, int c, String t, String r) {
        super(n, p, c);
        tamañoPantalla = t;
        resolucion = r;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "\n" +
        "Tamaño de pantalla: " + tamañoPantalla + "\n" +
        "Resolución: " + resolucion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public String getTamañoPantalla() {
        return tamañoPantalla;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public void setTamañoPantalla(String tamañoPantalla) {
        this.tamañoPantalla = tamañoPantalla;
    }
}