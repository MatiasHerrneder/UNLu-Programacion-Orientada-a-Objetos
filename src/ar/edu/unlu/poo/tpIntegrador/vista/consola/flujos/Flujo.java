package ar.edu.unlu.poo.tpIntegrador.vista.consola.flujos;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.vista.consola.VistaConsola;

public abstract class Flujo {
    protected final VistaConsola vista;
    protected final Controlador controlador;

    protected Flujo(VistaConsola vista, Controlador controlador) {
        this.vista = vista;
        this.controlador = controlador;
    }

    public abstract Flujo input(String input);
}
