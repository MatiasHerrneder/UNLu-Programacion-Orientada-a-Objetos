package ar.edu.unlu.poo.tpIntegrador.vista.consola.flujos;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.vista.consola.VistaConsola;

public class FlujoEsperandoTurnoOponente extends Flujo {
    public FlujoEsperandoTurnoOponente(VistaConsola vista, Controlador controlador) {
        super(vista, controlador);
    }

    @Override
    public Flujo input(String input) {
        vista.escribir("Esperando el turno del oponente");
        return this;
    }
}
