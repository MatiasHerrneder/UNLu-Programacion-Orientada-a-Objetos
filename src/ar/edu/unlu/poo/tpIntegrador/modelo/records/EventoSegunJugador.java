package ar.edu.unlu.poo.tpIntegrador.modelo.records;

import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.IUsuario;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.Eventos;

import java.io.Serializable;

public record EventoSegunJugador(Eventos evento, IUsuario usuario) implements Serializable {
}
