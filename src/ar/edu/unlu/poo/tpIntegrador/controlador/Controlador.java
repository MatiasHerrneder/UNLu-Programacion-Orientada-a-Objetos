package ar.edu.unlu.poo.tpIntegrador.controlador;

import java.rmi.RemoteException;

import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Barco;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Coordenadas;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Usuario;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.Eventos;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.CasillaYaDisparada;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.JugadoresYaConectados;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.NoEsTurnoDelJugador;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.PosicionDeBarcosInvalida;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.IBarco;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.IJuego;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.ITablero;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.IUsuario;
import ar.edu.unlu.poo.tpIntegrador.modelo.records.EventoSegunJugador;
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

    public void colocarBarcos(IBarco[] barcos) throws PosicionDeBarcosInvalida {
        Barco[] b = new Barco[barcos.length]; //por alguna razon no me dejaba castear el array directamente
        for (int i = 0; i < barcos.length; i++) {
            b[i] = (Barco) barcos[i];
        }
        try {
            this.modelo.ponerBarcos((Usuario) this.usuario, b);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void iniciarPartida() {
        try {
            this.modelo.iniciarPartida();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void listoParaComenzarPartida() {
        try {
            this.modelo.jugadorListoParaComenzar((Usuario) this.usuario);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void disparar(Coordenadas posicion) throws NoEsTurnoDelJugador, CasillaYaDisparada {
        try {
            this.modelo.disparar((Usuario) this.usuario, posicion);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ITablero getTablero() {
        try {
            return this.modelo.getTablero((Usuario) usuario);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void conectarUsuario(String nombre) throws JugadoresYaConectados {
        try {
            this.usuario = (IUsuario) this.modelo.conectarUsuario(nombre);
            if (this.usuario.isJugador(2)) modelo.iniciarPartida();
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

    public void voverAJugar() throws RemoteException {
        modelo.iniciarPartida();
    }

    @Override
    public <T extends IObservableRemoto> void setModeloRemoto(T t) throws RemoteException {
        this.modelo = (IJuego) t;
    }

    @Override
    public void actualizar(IObservableRemoto observable, Object o) throws RemoteException {
        if (o instanceof Eventos) {
            switch ((Eventos) o) {
                case COLOCAR_BARCOS -> this.vista.colocarBarcos();
                case COMENZAR_PARTIDA -> {
                    this.vista.comienzoDePartida();
                    if (this.usuario.isJugador(1)) this.vista.jugarTurno();
                }
            }
        }
        else if (o instanceof EventoSegunJugador evento) {
            switch (evento.evento()) {
                case AGUA, GOLPEADO, HUNDIDO -> {
                    EstadoDisparo estado = null;
                    switch (evento.evento()) {
                        case AGUA -> estado = EstadoDisparo.AGUA;
                        case GOLPEADO -> estado = EstadoDisparo.GOLPEADO;
                        case HUNDIDO -> estado = EstadoDisparo.HUNDIDO;
                    }
                    if (evento.usuario().getId() == this.usuario.getId())
                        this.vista.mostrarDisparo(estado, true);
                    else {
                        this.vista.mostrarDisparo(estado, false);
                        this.vista.jugarTurno();
                    }
                }
                case VICTORIA -> {
                    this.vista.finDeLaPartida(evento.usuario().getId() == this.usuario.getId());
                }
//                case BARCOS_INVALIDOS -> {
//                    if (evento.getUsuario().getId() == this.usuario.getId()) this.vista.errorEnBarcos();
//                }
            }
        }
    }
}
