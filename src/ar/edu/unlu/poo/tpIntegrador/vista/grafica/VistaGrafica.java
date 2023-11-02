package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;

import javax.swing.*;

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

    }

    @Override
    public void jugarTurno(boolean turnoPropio) {

    }

    @Override
    public void colocarBarcos() { //primero que se ejecuta
        this.ventanaPrincipal = new VentanaPrincipal(this.controlador);
        this.ventanaPrincipal.setVisible(true);
    }

    @Override
    public void comienzoDePartida() { //se ejecuta una vez colocados los barcos

    }
}
