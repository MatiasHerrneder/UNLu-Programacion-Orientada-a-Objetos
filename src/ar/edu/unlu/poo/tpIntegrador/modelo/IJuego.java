package ar.edu.unlu.poo.tpIntegrador.modelo;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;
import ar.edu.unlu.rmimvc.observer.IObservadorRemoto;

import java.rmi.RemoteException;

public interface IJuego extends IObservableRemoto {
    ITablero getTablero(Usuario usuario) throws RemoteException;
    void disparar(Usuario usuario, Coordenadas posicion) throws RemoteException;
    void jugadorListoParaComenzar(Usuario usuario) throws RemoteException;
    void iniciarPartida() throws RemoteException;
    Usuario conectarUsuario(String nombre) throws RemoteException;
    void desconectarUsuario(int usuarioId) throws RemoteException;
    void cerrar(IObservadorRemoto controlador, int usuarioId) throws RemoteException;
}
