package ar.edu.unlu.poo.tpIntegrador.modelo.interfaces;

import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Barco;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Coordenadas;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Usuario;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.*;
import ar.edu.unlu.poo.tpIntegrador.modelo.records.PartidaTop5;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;
import ar.edu.unlu.rmimvc.observer.IObservadorRemoto;

import java.rmi.RemoteException;

public interface IJuego extends IObservableRemoto {
    ITablero getTablero(Usuario usuario) throws RemoteException;
    void disparar(Usuario usuario, Coordenadas posicion) throws RemoteException, NoEsTurnoDelJugador, CasillaYaDisparada;
    void ponerBarcos(Usuario usuario, Barco[] barcos) throws PosicionDeBarcosInvalida, RemoteException;
    void iniciarPartida() throws RemoteException;
    Usuario conectarUsuario(String nombre) throws RemoteException, JugadoresYaConectados;
    void desconectarUsuario(int usuarioId) throws RemoteException;
    void cerrar(IObservadorRemoto controlador, int usuarioId) throws RemoteException;
    void volverAJugar(Usuario usuario) throws RemoteException;
    PartidaTop5[] getTop5() throws RemoteException;
    void guardarPartida(Usuario usuario) throws RemoteException, PartidaNoGuardable;
    void reanudarPartida(Usuario usuario) throws RemoteException, NoHayPartidaGuardada;
}
