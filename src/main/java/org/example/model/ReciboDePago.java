package org.example.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class ReciboDePago {

    private final Date inicioDelPeriodo;
    private final Date finDelPeriodo;
    private final Date fechaDeGeneracion;
    private final Prestador prestador;

    private final List<? extends Prestacion> prestaciones;

    private double montoTotal;

    public ReciboDePago(Date inicioDelPeriodo,
                        Date finDelPeriodo,
                        Prestador prestador,
                        List<? extends Prestacion> prestaciones) {
        this.inicioDelPeriodo = inicioDelPeriodo;
        this.finDelPeriodo = finDelPeriodo;
        this.fechaDeGeneracion = Calendar.getInstance().getTime();
        this.prestador = prestador;
        this.prestaciones = prestaciones;

        for(Prestacion prestacion : prestaciones) {
            this.montoTotal += prestacion.getCosto();
        }

    }

    @Override
    public String toString() {
        return "ReciboDePago{" +
                "inicioDelPeriodo=" + inicioDelPeriodo +
                ", finDelPeriodo=" + finDelPeriodo +
                ", fechaDeGeneracion=" + fechaDeGeneracion +
                ", prestador=" + prestador +
                ", prestaciones=" + prestaciones +
                ", montoTotal=" + montoTotal +
                '}';
    }
}
