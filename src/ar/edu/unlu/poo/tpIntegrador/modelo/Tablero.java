package ar.edu.unlu.poo.tpIntegrador.modelo;

public class Tablero {
    private static final int TAMANIO = 10;
    private final EstadoDisparo[][] posiciones = new EstadoDisparo[TAMANIO][TAMANIO];

    public Tablero() {
        inicializar();
    }

    private EstadoDisparo[][] getPosiciones() {
        return posiciones;
    }

    private void inicializar() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                getPosiciones()[i][j] = EstadoDisparo.SIN_DISPARAR;
            }
        }
    }

    public void marcarDisparo(Disparo disparo) {
        getPosiciones()[disparo.getCoordenadas().getPosX()][disparo.getCoordenadas().getPosY()] = disparo.getEstado();
    }
}
