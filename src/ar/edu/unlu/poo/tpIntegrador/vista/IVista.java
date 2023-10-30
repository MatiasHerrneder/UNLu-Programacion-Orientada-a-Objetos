package ar.edu.unlu.poo.tpIntegrador.vista;

import ar.edu.unlu.poo.tpIntegrador.modelo.EstadoDisparo;

public interface IVista {
    void iniciar();
    void mostrarDisparo(EstadoDisparo estado, boolean disparoFuePropio);
    void jugarTurno(boolean turnoPropio);
    void colocarBarcos();
    void comienzoDePartida();
}
