package ar.edu.unlu.poo.tpIntegrador.vista;

import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;

public interface IVista {
    void iniciar();
    void mostrarDisparo(EstadoDisparo estado, boolean disparoFuePropio);
    void jugarTurno();
    void colocarBarcos();
    void comienzoDePartida();
    void finDeLaPartida(boolean ganada);
    void volverAJugar();
    void partidaGuardada(boolean accionPropia);
    void partidaCargada(boolean accionPropia);
}
