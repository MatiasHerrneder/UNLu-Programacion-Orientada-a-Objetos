package ar.edu.unlu.poo.tpIntegrador.modelo.interfaces;

import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;

public interface ITablero {
    EstadoDisparo getEstadoPos(int x, int y);
    int getTamanio();
}
