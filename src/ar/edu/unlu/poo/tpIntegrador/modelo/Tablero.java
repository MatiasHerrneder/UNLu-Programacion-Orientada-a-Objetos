package ar.edu.unlu.poo.tpIntegrador.modelo;

import java.io.Serial;
import java.io.Serializable;

public class Tablero implements ITablero, Serializable {
    @Serial
    private static final long serialVersionUID = 10000000L;
    private final EstadoDisparo[][] posiciones;
    private final int tamanio;

    public Tablero(int tamanio) {
        this.tamanio = tamanio;
        posiciones = new EstadoDisparo[tamanio][tamanio];
        inicializar();
    }

    private EstadoDisparo[][] getPosiciones() {
        return posiciones;
    }

    @Override
    public EstadoDisparo[][] getTablero() {
        return posiciones;
    }

    public int getTamanio() {
        return tamanio;
    }

    private void inicializar() {
        for (int i = 0; i < getTamanio(); i++) {
            for (int j = 0; j < getTamanio(); j++) {
                getPosiciones()[i][j] = EstadoDisparo.SIN_DISPARAR;
            }
        }
    }

    public void marcarDisparo(Disparo disparo) {
        getPosiciones()[disparo.getCoordenadas().getPosX()][disparo.getCoordenadas().getPosY()] = disparo.getEstado();
    }
}
