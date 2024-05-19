package org.example.model;

import java.time.Instant;
import java.util.*;

public final class PrestacionHandler {

    private final List<Asociado> asociados;
    private final List<Prestador> prestadores;
    private final List<Consulta> consultas;
    private final List<Internacion> internaciones;
    private final List<ReciboDePago> recibos;
    private final List<EmpresaPrestadora> empresasPrestadoras;

    private static PrestacionHandler INSTANCE;

    private PrestacionHandler() {
        asociados = new ArrayList<>();
        prestadores = new ArrayList<>();
        consultas = new ArrayList<>();
        internaciones = new ArrayList<>();
        recibos = new ArrayList<>();
        empresasPrestadoras = new ArrayList<>();
    }

    public static PrestacionHandler getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PrestacionHandler();
        }
        return INSTANCE;
    }

    public void darDeAltaAsociado(short edad) {
        Asociado asociado = new Asociado(edad);
        this.asociados.add(asociado);
    }

    public void darDeAltaPrestador() {
        Prestador prestador = new Prestador((new Random()).nextInt(1000, 2000));
        this.prestadores.add(prestador);
    }

    public void cargarPrestacionConsultaMedica(String empresaPrestadora, String detalle, int idAsociado) {
        Optional<Asociado> candidato = buscarAsociado(idAsociado);

        if(candidato.isEmpty()) {
            System.out.println("No se encontró el asociado");
            return;
        }

        Consulta consulta = new Consulta(buscarEmpresa(empresaPrestadora), detalle, candidato.get());
        consultas.add(consulta);
    }

    public void cargarPrestacionDeInternacion(String empresaPrestadora, String detalle, int idAsociado) {
        Optional<Asociado> candidato = buscarAsociado(idAsociado);

        if(candidato.isEmpty()) {
            System.out.println("No se encontró el asociado");
            return;
        }

        Internacion internacion = new Internacion(buscarEmpresa(empresaPrestadora), detalle, candidato.get());
        internaciones.add(internacion);
    }

    public void generarReciboDePago(String inicio, String fin, int idPrestador) {
        Date fechaDeInicio = Date.from(Instant.parse(inicio));
        Date fechaDeFin = Date.from(Instant.parse(inicio));

        Optional<Prestador> recurso = buscarPrestador(idPrestador);
        Prestador prestador;
        if(recurso.isEmpty()) {
            prestador = new Prestador(idPrestador);
            this.prestadores.add(prestador);
        } else {
            prestador = recurso.get();
        }

        List<Prestacion> prestaciones = new ArrayList<>();
        prestaciones.addAll(this.consultas);
        prestaciones.addAll(this.internaciones);

        ReciboDePago reciboDePago = new ReciboDePago(fechaDeInicio, fechaDeFin, prestador, prestaciones);
        recibos.add(reciboDePago);
    }

    private EmpresaPrestadora buscarEmpresa(String empresaPrestadora) {
        EmpresaPrestadora candidata = new EmpresaPrestadora(empresaPrestadora);
        for(int i = 0; i < this.empresasPrestadoras.size(); i++) {
            if(this.empresasPrestadoras.get(i).equals(candidata)) {
                return this.empresasPrestadoras.get(i);
            }
        }
        this.empresasPrestadoras.add(candidata);
        return candidata;
    }

    private Optional<Prestador> buscarPrestador(int idPrestador) {
        for(int i = 0; i < this.prestadores.size(); i++) {
            if(this.prestadores.get(i).getId() == idPrestador) {
                return Optional.of(this.prestadores.get(i));
            }
        }
        return Optional.empty();
    }

    private Optional<Asociado> buscarAsociado(int idAsociado) {
        Asociado candidato = null;
        for(Asociado asociado : asociados) {
            if(asociado.getId() == idAsociado) {
                candidato = asociado;
                break;
            }
        }
        if(Objects.isNull(candidato)) {
            return Optional.empty();
        }
        return Optional.of(candidato);
    }

}
