package org.example.model;

public final class Internacion extends Prestacion {

    private double gastos;
    private double gastosMateriales;

    public Internacion(EmpresaPrestadora empresaPrestadora, String detalle, Asociado asociado) {
        super(empresaPrestadora, detalle, asociado);
    }

    @Override
    public double getCosto() {
        short adicional = this.getAsociado().getEdad() < 21 ? (short) 5 : 15;
        return gastos + gastosMateriales + adicional;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public double getGastosMateriales() {
        return gastosMateriales;
    }

    public void setGastosMateriales(double gastosMateriales) {
        this.gastosMateriales = gastosMateriales;
    }
}
