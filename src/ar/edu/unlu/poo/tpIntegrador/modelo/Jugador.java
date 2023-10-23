package ar.edu.unlu.poo.tpIntegrador.modelo;

public class Jugador {
    private static final int TAMANIO_TABLERO = 10;
    private final Barco[] barcos = new Barco[5];
    private Tablero tablero;

    public Jugador() {
        tablero = new Tablero(TAMANIO_TABLERO);
    }

    public Barco[] getBarcos() {
        return barcos;
    }

    public void disparar(Disparo disparo) {
        tablero.marcarDisparo(disparo);
    }

    public boolean ponerBarco(Barco barco) {
        if (barco.isPosicionesValidas(TAMANIO_TABLERO, getBarcos())) {

            if (barco.tamanioDelBarco() == 2) {
                if (barcos[0] != null) {
                    ;
                }
                else return false;
            }
        }
    }

} 
