package ar.edu.unlu.poo.tpIntegrador.vista.consola.flujos;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.vista.consola.VistaConsola;

public class FlujoFinDePartida extends Flujo {
    boolean esperandoOtroJugador = false;
    public FlujoFinDePartida(VistaConsola vista, Controlador controlador, boolean ganador) {
        super(vista, controlador);
        if (ganador) vista.escribir("HAS GANADO LA PARTIDA");
        else vista.escribir("HAS PERDIDO LA PARTIDA");
        vista.escribir("Presione enter para volver a jugar...");
    }

    @Override
    public Flujo input(String input) {
        if (!esperandoOtroJugador) {
            controlador.voverAJugar();
            esperandoOtroJugador = true;
            return null;
        }
        else vista.escribir("Esperando al otro jugador...");
        return this;
    }
}
