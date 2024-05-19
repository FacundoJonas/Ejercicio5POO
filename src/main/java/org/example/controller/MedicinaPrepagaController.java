package org.example.controller;

import org.example.model.PrestacionHandler;

public final class MedicinaPrepagaController {

    private final PrestacionHandler prestacionHandler;

    private static MedicinaPrepagaController instance;

    private MedicinaPrepagaController() {
        this.prestacionHandler = PrestacionHandler.getInstance();
    }

    public static MedicinaPrepagaController getInstance() {
        if(instance == null) {
            instance = new MedicinaPrepagaController();
        }
        return instance;
    }

    public void darDeAltaAsociado(short edad) {
        prestacionHandler.darDeAltaAsociado(edad);
    }

    public void darDeAltaPrestador() {
        prestacionHandler.darDeAltaPrestador();
    }

    public void cargarPrestacionConsultaMedica(String empresaPrestadora, String detalle, int idAsociado) {
        prestacionHandler.cargarPrestacionConsultaMedica(empresaPrestadora, detalle, idAsociado);
    }

    public void cargarPrestacionDeInternacion(String empresaPrestadora, String detalle, int idAsociado) {
        prestacionHandler.cargarPrestacionDeInternacion(empresaPrestadora, detalle, idAsociado);
    }

    public void generarReciboDePago(String inicio, String fin, int idPrestador) {
        prestacionHandler.generarReciboDePago(inicio, fin, idPrestador);
    }

}
