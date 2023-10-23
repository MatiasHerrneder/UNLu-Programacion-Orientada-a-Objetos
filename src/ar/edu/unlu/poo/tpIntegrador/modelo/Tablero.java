package ar.edu.unlu.poo.tpIntegrador.modelo;

public class Tablero {
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
