package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;

public class VistaGrafica implements IVista {
    private Controlador controlador;
    private VentanaDeConexion ventanaDeConexion;
    private VentanaPrincipal ventanaPrincipal;

    public VistaGrafica(Controlador controlador) {
        this.controlador = controlador;
        controlador.setVista(this);
    }

    public void iniciar() {
        this.ventanaDeConexion = new VentanaDeConexion(this.controlador);
        this.ventanaDeConexion.setVisible(true);
    }

    public void mostrarTablero() {

    }

    @Override
    public void mostrarDisparo(EstadoDisparo estado, boolean disparoFuePropio) {
        ventanaPrincipal.mostrarTablero();
    }

    @Override
    public void jugarTurno() {
        ventanaPrincipal.jugarTurno();
    }

    @Override
    public void colocarBarcos() { //primero que se ejecuta
        ventanaPrincipal = new VentanaPrincipal(this.controlador);
        ventanaPrincipal.setVisible(true);
    }

    @Override
    public void comienzoDePartida() { //se ejecuta una vez colocados los barcos
        ventanaPrincipal.borrarInterfazBarcos();
    }

    @Override
    public void finDeLaPartida(boolean ganada) {
        ventanaPrincipal.finDeLaPartida();
    }
}
