package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;

import javax.swing.*;
import java.awt.*;

public class VistaGrafica implements IVista {
    private Controlador controlador;
    private JFrame frameRaiz;
    private VentanaDeConexion ventanaDeConexion;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaFinal ventanaFinal;

    public VistaGrafica(Controlador controlador) {
        this.controlador = controlador;
        controlador.setVista(this);
    }

    public void iniciar() {
//        frameRaiz = new JFrame();
//        frameRaiz.setLayout(new FlowLayout());
//        frameRaiz.setVisible(true);
        ventanaDeConexion = new VentanaDeConexion(this.controlador);
        ventanaDeConexion.setVisible(true);
//        frameRaiz.add(ventanaDeConexion);
    }

    public void mostrarTablero() {

    }

    @Override
    public void mostrarDisparo(EstadoDisparo estado, boolean disparoFuePropio) {
        ventanaPrincipal.mostrarTablero(estado, disparoFuePropio);
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
        ventanaPrincipal.finDeLaPartida(ganada);
        ventanaFinal = new VentanaFinal(controlador, ganada);
        ventanaFinal.setVisible(true);
    }
}
