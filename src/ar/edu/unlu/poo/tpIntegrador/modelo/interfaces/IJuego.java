package ar.edu.unlu.poo.tpIntegrador.modelo.interfaces;

import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Barco;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Coordenadas;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Usuario;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.CasillaYaDisparada;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.JugadoresYaConectados;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.NoEsTurnoDelJugador;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.PosicionDeBarcosInvalida;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;
import ar.edu.unlu.rmimvc.observer.IObservadorRemoto;

import java.rmi.RemoteException;

public interface IJuego extends IObservableRemoto {
    ITablero getTablero(Usuario usuario) throws RemoteException;
    void disparar(Usuario usuario, Coordenadas posicion) throws RemoteException, NoEsTurnoDelJugador, CasillaYaDisparada;
    void ponerBarcos(Usuario usuario, Barco[] barcos) throws PosicionDeBarcosInvalida, RemoteException;
    void jugadorListoParaComenzar(Usuario usuario) throws RemoteException;
    void iniciarPartida() throws RemoteException;
    Usuario conectarUsuario(String nombre) throws RemoteException, JugadoresYaConectados;
    void desconectarUsuario(int usuarioId) throws RemoteException;
    void cerrar(IObservadorRemoto controlador, int usuarioId) throws RemoteException;
    void volverAJugar(Usuario usuario) throws RemoteException;
}
