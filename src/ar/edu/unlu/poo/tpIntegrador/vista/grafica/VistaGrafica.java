package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.NoHayPartidaGuardada;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.PartidaNoGuardable;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;
import ar.edu.unlu.poo.tpIntegrador.vista.grafica.ventanas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaGrafica extends JFrame implements IVista {
    private final Controlador controlador;
    private VentanaDeConexion ventanaDeConexion;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaFinal ventanaFinal;
    private boolean partidaCargable = false;

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
        JMenuItem menuB1Top5 = new JMenuItem("Top de partidas");
        menuB1Top5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaTop5(controlador);
            }
        });
        JMenuItem menuB1GuardarPartida = new JMenuItem("Guardar partida");
        menuB1GuardarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controlador.guardarPartida();
                } catch (PartidaNoGuardable ex) {
                    new VentanaPopup("Solo se puede guardar una partida comenzada");
                }
            }
        });
        JMenuItem menuB1CargarPartida = new JMenuItem("Cargar partida");
        menuB1CargarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (partidaCargable) {
                    try {
                        controlador.cargarPartida();
                    } catch (NoHayPartidaGuardada ex) {
                        new VentanaPopup("No hay partida guardada para cargar");
                    }
                }
                else new VentanaPopup("Solo se puede cargar una partida\nuna vez se conectaron los usuarios");
            }
        });
        menuB1.add(menuB1Top5);
        menuB1.add(menuB1GuardarPartida);
        menuB1.add(menuB1CargarPartida);
        menu.add(menuB1);
        setJMenuBar(menu);
        //inicializo
        ventanaDeConexion = new VentanaDeConexion(this.controlador);
        add(ventanaDeConexion);
        setVisible(true);
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
        partidaCargable = true;
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

    @Override
    public void partidaGuardada(boolean accionPropia) {
        String msg;
        if (accionPropia) msg = "La partida se guardo con exito";
        else msg = "El rival guardo la partida";
        new VentanaPopup(msg);
    }

    @Override
    public void partidaCargada(boolean accionPropia) {
        comienzoDePartida();
        if (accionPropia) {
            new VentanaPopup("Partida cargada con exito");
        }
        else new VentanaPopup("El oponente cargo una partida");
        revalidate();
        repaint();
    }

}
