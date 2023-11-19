package ar.edu.unlu.poo.tpIntegrador.modelo.enumerados;

import ar.edu.unlu.poo.tpIntegrador.modelo.records.EventoSegunJugador;

import java.io.Serializable;

public record EventoCargarPartida(EventoSegunJugador evento, int idJugadorSiguienteTurno) implements Serializable {
}
