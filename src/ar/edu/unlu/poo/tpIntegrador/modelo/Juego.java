package ar.edu.unlu.poo.tpIntegrador.modelo;

import ar.edu.unlu.rmimvc.observer.IObservadorRemoto;
import ar.edu.unlu.rmimvc.observer.ObservableRemoto;

import java.rmi.RemoteException;

public class Juego extends ObservableRemoto implements IJuego {
    private Jugador jugador1;
    private Jugador jugador2;
    private int turno = 0;


    private boolean esTurnoJugador(Jugador jugador) {
        return turno % 2 == 0 && jugador == this.jugador1 || turno % 2 == 1 && jugador == this.jugador2;
    }

    @Override
    public ITablero getTablero(Usuario usuario) {
        if (usuario.isJugador(1)) return (ITablero) jugador1.getTablero();
        else return (ITablero) jugador2.getTablero();
    }

    @Override
    public void disparar(Usuario usuario, Coordenadas posicion) throws RemoteException {
        Jugador jugadorQueDispara;
        Jugador jugadorQueResponde;
        if (usuario.isJugador(1)) {
            jugadorQueDispara = jugador1;
            jugadorQueResponde = jugador2;
        }
        else {
            jugadorQueDispara = jugador2;
            jugadorQueResponde = jugador1;
        }
        if (esTurnoJugador(jugadorQueDispara)) {
            EstadoDisparo estadoDisparo = jugadorQueResponde.verificarDisparoRival(posicion);
            jugadorQueDispara.marcarDisparo(new Disparo(posicion, estadoDisparo));
            switch (estadoDisparo) {
                case AGUA-> {
                    if (jugadorQueDispara.equals(this.jugador1)) this.notificarObservadores(Eventos.AGUA_J1);
                    else this.notificarObservadores(Eventos.AGUA_J2);
                }
                case GOLPEADO -> {
                    if (jugadorQueDispara.equals(this.jugador1)) this.notificarObservadores(Eventos.GOLPEADO_J1);
                    else this.notificarObservadores(Eventos.GOLPEADO_J2);
                }
                case HUNDIDO -> {
                    if (jugadorQueDispara.equals(this.jugador1)) this.notificarObservadores(Eventos.HUNDIDO_J1);
                    else this.notificarObservadores(Eventos.HUNDIDO_J2);
                }
            }
        }
    }

    @Override
    public void agregarJugador() {

    }

    @Override
    public Usuario conectarUsuario(String nombre) throws RemoteException {
        return null;
    }

    @Override
    public void desconectarUsuario(int usuarioId) throws RemoteException {

    }

    public void cerrar(IObservadorRemoto controlador, int usuarioId) throws RemoteException {
        this.removerObservador(controlador);
        this.desconectarUsuario(usuarioId);
    }

}
