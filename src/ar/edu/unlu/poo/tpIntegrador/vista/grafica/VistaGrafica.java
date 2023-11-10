package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;

import javax.swing.*;
import java.awt.*;

public class VistaGrafica extends JFrame implements IVista {
    private Controlador controlador;
    private VentanaDeConexion ventanaDeConexion;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaFinal ventanaFinal;

    public VistaGrafica(Controlador controlador) {
        this.controlador = controlador;
        controlador.setVista(this);
    }

    public void iniciar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Batalla Naval");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        //menu
        JMenuBar menu = new JMenuBar();
        JMenu menuB1 = new JMenu("Menu");
        JMenuItem menuB1B1 = new JMenuItem("primer boton");
        menuB1.add(menuB1B1);
        menu.add(menuB1);
        setJMenuBar(menu);

        ventanaDeConexion = new VentanaDeConexion(this.controlador);
        add(ventanaDeConexion);
        setVisible(true);
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
    public void colocarBarcos() {
        remove(ventanaDeConexion);
        ventanaPrincipal = new VentanaPrincipal(this.controlador);
        add(ventanaPrincipal);
        revalidate();
        repaint();
    }

    @Override
    public void comienzoDePartida() { //se ejecuta una vez colocados los barcos
        ventanaPrincipal.borrarInterfazBarcos();
    }

    @Override
    public void finDeLaPartida(boolean ganada) {
        ventanaPrincipal.finDeLaPartida(ganada);
        remove(ventanaPrincipal);
        ventanaFinal = new VentanaFinal(controlador, ganada);
        add(ventanaFinal);
        revalidate();
        repaint();
    }

    @Override
    public void volverAJugar() {
        remove(ventanaFinal);
        ventanaPrincipal = new VentanaPrincipal(this.controlador);
        add(ventanaPrincipal);
        revalidate();
        repaint();
    }
}
