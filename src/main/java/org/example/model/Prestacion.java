package org.example.model;

import java.util.Calendar;
import java.util.Date;

public abstract class Prestacion {

    private Date fechaDeCreacion;
    private EmpresaPrestadora empresaPrestadora;

    private Asociado asociado;

    private String detalle;

    public Prestacion(EmpresaPrestadora empresaPrestadora, String detalle, Asociado asociado) {
        this.empresaPrestadora = empresaPrestadora;
        this.fechaDeCreacion = Calendar.getInstance().getTime();
        this.detalle = detalle;
        this.asociado = asociado;
    }

    public abstract double getCosto();

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public EmpresaPrestadora getEmpresaPrestadora() {
        return empresaPrestadora;
    }

    public void setEmpresaPrestadora(EmpresaPrestadora empresaPrestadora) {
        this.empresaPrestadora = empresaPrestadora;
    }

    public Asociado getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociado asociado) {
        this.asociado = asociado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
