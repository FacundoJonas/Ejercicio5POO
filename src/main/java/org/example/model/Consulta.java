package org.example.model;

public final class Consulta extends Prestacion {

    private double honorarios;

    public Consulta(EmpresaPrestadora empresaPrestadora, String detalle, Asociado asociado) {
        super(empresaPrestadora, detalle, asociado);
    }

    @Override
    public double getCosto() {
        short adicional = this.getAsociado().getEdad() < 21 ? (short) 5 : 15;
        return honorarios + adicional;
    }
}
