package org.example.model;

public final class Asociado {

    private static int siguienteIdAAsignar = 0;

    private int id;

    private short edad;

    public Asociado(short edad) {
        this.id = siguienteIdAAsignar;
        siguienteIdAAsignar++;
        this.edad = edad;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
