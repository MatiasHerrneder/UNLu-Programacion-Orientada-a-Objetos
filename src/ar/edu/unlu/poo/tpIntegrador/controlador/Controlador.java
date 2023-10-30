package ar.edu.unlu.poo.tpIntegrador.controlador;

import java.rmi.RemoteException;

import ar.edu.unlu.poo.tpIntegrador.modelo.*;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

public class Controlador implements IControladorRemoto {

    private IJuego modelo;
    private IVista vista;
    private IUsuario usuario;

    public <T extends IObservableRemoto> Controlador(T modelo) {
        try {
            this.setModeloRemoto(modelo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Controlador() {

    }

    public void setVista(IVista vista) {
        this.vista = vista;
    }

    public void colocarBarco() {

    }

    public void disparar(Coordenadas posicion) {
        try {
            modelo.disparar((Usuario) this.usuario, posicion);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ITablero getTablero() {
        try {
            return modelo.getTablero((Usuario) usuario);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void conectarUsuario(String nombre) {
        try {
            this.usuario = (IUsuario) this.modelo.conectarUsuario(nombre);
//            this.vista.mostrarListaUsuarios((IUsuario[]) this.modelo.getUsuarios());
//            this.vista.mostrarChat((IMensaje[]) this.modelo.getMensajes());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void desconectarUsuario(int usuarioId) {
        try {
            this.modelo.desconectarUsuario(usuarioId);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cerrarApp() {
        try {
            this.modelo.cerrar(this, this.usuario.getId());
            System.exit(0);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public <T extends IObservableRemoto> void setModeloRemoto(T t) throws RemoteException {
        this.modelo = (IJuego) t;
    }

    @Override
    public void actualizar(IObservableRemoto observable, Object o) throws RemoteException {
        if (o instanceof Eventos) {
            boolean disparoJ1 = this.usuario.isJugador(1);
            switch ((Eventos) o) {
                case AGUA_J1 -> this.vista.mostrarDisparo(EstadoDisparo.AGUA, disparoJ1);
                case AGUA_J2 -> this.vista.mostrarDisparo(EstadoDisparo.AGUA, !disparoJ1);
                case GOLPEADO_J1 -> this.vista.mostrarDisparo(EstadoDisparo.GOLPEADO, disparoJ1);
                case GOLPEADO_J2 -> this.vista.mostrarDisparo(EstadoDisparo.GOLPEADO, !disparoJ1);
                case HUNDIDO_J1 -> this.vista.mostrarDisparo(EstadoDisparo.HUNDIDO, disparoJ1);
                case HUNDIDO_J2 -> this.vista.mostrarDisparo(EstadoDisparo.HUNDIDO, !disparoJ1);
            }
        }
    }
}
