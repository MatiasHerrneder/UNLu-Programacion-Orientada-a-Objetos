package ar.edu.unlu.poo.tpIntegrador.modelo.clases;

import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.PosicionDeBarcosInvalida;

import java.io.Serializable;

public class Jugador implements Serializable {
    private static final int TAMANIO_TABLERO = 10;
    private Barco[] barcos = null;
    private Tablero tablero;
    private int idUsuario = -1;
    private boolean listoParaComenzar = false;
    private String nombre;

    public Jugador() {
        tablero = new Tablero(TAMANIO_TABLERO);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isListoParaComenzar() {
        return listoParaComenzar;
    }

    public void setListoParaComenzar() {
        this.listoParaComenzar = true;
    }

    public boolean hayUsuarioConectado() {
        return this.idUsuario != -1;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Barco[] getBarcos() {
        return barcos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setBarcos(Barco[] barcos) throws PosicionDeBarcosInvalida {
        for (Barco barco : barcos) {
            if (!barco.isPosicionesValidas(TAMANIO_TABLERO, barcos)) {
                throw new PosicionDeBarcosInvalida();
            }
        }
        this.barcos = barcos;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void marcarDisparo(Disparo disparo) {
        tablero.marcarDisparo(disparo);
    }

    public EstadoDisparo verificarDisparoRival(Coordenadas coordenadas) {
        for (Barco b : getBarcos()) {
            EstadoDisparo estadoDisparo = b.golpearBarco(coordenadas);
            if (estadoDisparo != EstadoDisparo.AGUA) {
                return estadoDisparo;
            }
        }
        return EstadoDisparo.AGUA;
    }

    public boolean todosLosBarcosHundidos() {
        for (Barco barco : barcos) {
            if (!barco.fueHundido()) return false;
        }
        return true;
    }

    public void nuevaPartida() {
        tablero = new Tablero(TAMANIO_TABLERO);
        barcos = null;
    }

} 
