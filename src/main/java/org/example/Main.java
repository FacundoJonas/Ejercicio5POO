package org.example;

import org.example.controller.MedicinaPrepagaController;

public class Main {
    public static void main(String[] args) {
        var controller = MedicinaPrepagaController.getInstance();

        controller.darDeAltaAsociado((short) 20);

    }
}