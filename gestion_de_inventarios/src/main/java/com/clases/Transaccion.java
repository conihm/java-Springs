package com.clases;

import com.interfaces.Auditable;

public class Transaccion implements Auditable {

    private String idTransaccion, tipo;
    private double monto;

    public Transaccion(String idTransaccion, String tipo, double monto) {
        this.idTransaccion = idTransaccion;
        this.tipo = tipo;
        this.monto = monto;
    }

    @Override
    public void registraAccion(String accion) {
        
        
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
