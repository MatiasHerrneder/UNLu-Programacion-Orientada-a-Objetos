package ar.edu.unlu.poo.tpIntegrador.modelo;

import java.io.Serializable;

public class Barco implements IBarco, Serializable {
    private final Coordenadas posicionBarco;
    private final Direccion direccion;
    private final int largoDelBarco;
    private final boolean[] golpes;

    public Barco(Coordenadas posicionBarco, Direccion direccion, int largoDelBarco) {
        this.posicionBarco = posicionBarco;
        this.direccion = direccion;
        this.largoDelBarco = largoDelBarco;
        golpes = new boolean[largoDelBarco];
    }

    public Coordenadas getPosicionBarco() {
        return posicionBarco;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public int getLargoDelBarco() {
        return largoDelBarco;
    }

    public boolean[] getGolpes() {
        return golpes;
    }

    public EstadoDisparo golpearBarco(Coordenadas coordenadas) {
        Coordenadas pos = getPosicionBarco();
        for (int i = 0; i < getLargoDelBarco(); i++) {
            if (coordenadas.equals(pos)) {
                getGolpes()[i] = true;
                for (boolean golpe : getGolpes()) {
                    if (!golpe) return EstadoDisparo.GOLPEADO;
                }
                return EstadoDisparo.HUNDIDO;
            }
        }
        return EstadoDisparo.AGUA;
    }

    public boolean isPosicionesValidas(int tamanioTablero, Barco[] barcos) {
        //verifico que la cabeza no se salga del tablero
        if (!getPosicionBarco().isDentroDe(1, tamanioTablero)) return false;
        //verifico que la cola no se salga del tablero
        try {

            if (colaDelBarco().isDentroDe(1, tamanioTablero)) return false;
        } catch (Exception e) {
            return false;
        }
        //verifico que no haya ya barcos en las casillas
        for (Barco barco : barcos) {
            if (barco != null) {
                Coordenadas b1 = getPosicionBarco();
                Coordenadas b2 = barco.getPosicionBarco();
                for (int i = 0; i < getLargoDelBarco(); i++) {
                    for (int j = 0; j < barco.getLargoDelBarco(); j++) {
                        if (b1.equals(b2)) return false;
                        try {
                            b2 = siguienteCoordenada(b2);
                        } catch (Exception e) {
                            return false;
                        }
                    }
                    try {
                        b1 = siguienteCoordenada(b1);
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Coordenadas colaDelBarco() throws Exception {
        return switch (getDireccion()) {
            case ABAJO -> new Coordenadas(getPosicionBarco().getPosX(),
                    getPosicionBarco().getPosY() + getLargoDelBarco() - 1);
            case ARRIBA -> new Coordenadas(getPosicionBarco().getPosX(),
                    getPosicionBarco().getPosY() - getLargoDelBarco() + 1);
            case DERECHA -> new Coordenadas(getPosicionBarco().getPosX() + getLargoDelBarco() - 1,
                    getPosicionBarco().getPosY());
            case IZQUIERDA -> new Coordenadas(getPosicionBarco().getPosX() - getLargoDelBarco() + 1,
                    getPosicionBarco().getPosY());
        };
    }

    private Coordenadas siguienteCoordenada(Coordenadas coordenadas) throws Exception {
        return switch (getDireccion()) {
            case ABAJO -> new Coordenadas(coordenadas.getPosX(), coordenadas.getPosY() + 1);
            case ARRIBA -> new Coordenadas(coordenadas.getPosX(), coordenadas.getPosY() - 1);
            case DERECHA -> new Coordenadas(coordenadas.getPosX() + 1, coordenadas.getPosY());
            case IZQUIERDA -> new Coordenadas(coordenadas.getPosX() - 1, coordenadas.getPosY());
        };
    }

}
