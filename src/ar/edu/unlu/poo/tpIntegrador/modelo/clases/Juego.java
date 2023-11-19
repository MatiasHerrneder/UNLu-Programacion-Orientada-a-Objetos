package ar.edu.unlu.poo.tpIntegrador.modelo.clases;

import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EventoCargarPartida;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.Eventos;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.*;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.IJuego;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.ITablero;
import ar.edu.unlu.poo.tpIntegrador.modelo.records.EventoSegunJugador;
import ar.edu.unlu.poo.tpIntegrador.modelo.records.PartidaTop5;
import ar.edu.unlu.rmimvc.observer.IObservadorRemoto;
import ar.edu.unlu.rmimvc.observer.ObservableRemoto;

import java.rmi.RemoteException;

public class Juego extends ObservableRemoto implements IJuego {
    private Jugador jugador1;
    private Jugador jugador2;
    private int turno = 0;
    private int volverAJugar = 0;
    private final Top5Partidas topPartidas;
    private final PersistenciaDePartida persistenciaDePartida;
    private boolean partidaGuardable = false;

    public Juego() {
        this.jugador1 = new Jugador();
        this.jugador2 = new Jugador();
        topPartidas = new Top5Partidas();
        persistenciaDePartida = new PersistenciaDePartida();
    }

    public void iniciarPartida() throws RemoteException {
        notificarObservadores(Eventos.COLOCAR_BARCOS);
    }

    private boolean esTurnoJugador(Jugador jugador) {
        return turno % 2 == 0 && jugador == this.jugador1 || turno % 2 == 1 && jugador == this.jugador2;
    }

    @Override
    public ITablero getTablero(Usuario usuario) {
        if (usuario.isJugador(1)) return jugador1.getTablero();
        else return jugador2.getTablero();
    }

    @Override
    public void disparar(Usuario usuario, Coordenadas posicion) throws RemoteException, NoEsTurnoDelJugador, CasillaYaDisparada {
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

        if (!esTurnoJugador(jugadorQueDispara)) throw new NoEsTurnoDelJugador();
        if (jugadorQueDispara.getTablero().getEstadoPos(posicion.getPosX(), posicion.getPosY()) != EstadoDisparo.SIN_DISPARAR) throw new CasillaYaDisparada();

        EstadoDisparo estadoDisparo = jugadorQueResponde.verificarDisparoRival(posicion);
        jugadorQueDispara.marcarDisparo(new Disparo(posicion, estadoDisparo));
        switch (estadoDisparo) {
            case AGUA-> this.notificarObservadores(new EventoSegunJugador(Eventos.AGUA, usuario));
            case GOLPEADO -> this.notificarObservadores(new EventoSegunJugador(Eventos.GOLPEADO, usuario));
            case HUNDIDO -> {
                if (jugadorQueResponde.todosLosBarcosHundidos()) {
                    topPartidas.nuevaPartidaFinalizada(turno, jugador1.getNombre(), jugador2.getNombre());
                    this.notificarObservadores(new EventoSegunJugador(Eventos.VICTORIA, usuario));
                    partidaGuardable = false;
                }
                else this.notificarObservadores(new EventoSegunJugador(Eventos.HUNDIDO, usuario));
            }
        }
        turno++;
    }

    @Override
    public void ponerBarcos(Usuario usuario, Barco[] barcos) throws PosicionDeBarcosInvalida, RemoteException {
        Jugador jugadorLlamado;
        Jugador otroJugador;
        if (usuario.isJugador(1)) {
            jugadorLlamado = jugador1;
            otroJugador = jugador2;
        }
        else {
            jugadorLlamado = jugador2;
            otroJugador = jugador1;
        }
        jugadorLlamado.setBarcos(barcos);
        if (otroJugador.getBarcos() != null) {
            partidaGuardable = true;
            notificarObservadores(Eventos.COMENZAR_PARTIDA);
        }
    }

    @Override
    public Usuario conectarUsuario(String nombre) throws RemoteException, JugadoresYaConectados {
        if (!jugador1.hayUsuarioConectado()) {
            jugador1.setIdUsuario(1); //TODO
            jugador1.setNombre(nombre);
            return new Usuario(1, nombre, 1); //TODO ver ID
        }
        else if (!jugador2.hayUsuarioConectado()) {
            jugador2.setIdUsuario(2); //TODO
            jugador2.setNombre(nombre);
            return new Usuario(2, nombre, 2); //TODO
        }
        else throw new JugadoresYaConectados();
    }

    @Override
    public void desconectarUsuario(int usuarioId) throws RemoteException {
    }

    public void cerrar(IObservadorRemoto controlador, int usuarioId) throws RemoteException {
        this.removerObservador(controlador);
        this.desconectarUsuario(usuarioId);
    }

    @Override
    public void volverAJugar(Usuario usuario) throws RemoteException {
        if (volverAJugar != 0 && !usuario.isJugador(volverAJugar)) {
            jugador1.nuevaPartida();
            jugador2.nuevaPartida();
            volverAJugar = 0;
            turno = 0;
            notificarObservadores(Eventos.VOLVER_A_JUGAR);
        }
        volverAJugar = usuario.getNumeroDeJugador();
    }

    @Override
    public PartidaTop5[] getTop5() throws RemoteException {
        return topPartidas.getTop5Partidas();
    }

    @Override
    public void guardarPartida(Usuario usuario) throws RemoteException, PartidaNoGuardable {
        if (jugador1.getBarcos() != null && jugador2.getBarcos() != null && partidaGuardable) {
            persistenciaDePartida.guardarPartida(jugador1, jugador2, turno);
            notificarObservadores(new EventoSegunJugador(Eventos.PARTIDA_GUARDADA, usuario));
        }
        else throw new PartidaNoGuardable();
    }

    @Override
    public void reanudarPartida(Usuario usuario) throws RemoteException, NoHayPartidaGuardada {
        jugador1 = persistenciaDePartida.getJugador1();
        jugador2 = persistenciaDePartida.getJugador2();
        turno = persistenciaDePartida.getTurno();
        partidaGuardable = true;
        notificarObservadores(new EventoCargarPartida(new EventoSegunJugador(Eventos.CARGAR_PARTIDA, usuario),
                esTurnoJugador(jugador1) ? jugador1.getIdUsuario() : jugador2.getIdUsuario()));
    }
}
