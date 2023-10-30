package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.Coordenadas;
import ar.edu.unlu.poo.tpIntegrador.modelo.ITablero;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private Controlador controlador;
    public VentanaPrincipal(Controlador controlador) {
        this.controlador = controlador;
        iniciar();
    }
    private void iniciar() {
        setTitle("Ventana");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelPrincipal = (JPanel) getContentPane();
        panelPrincipal.setLayout(new BorderLayout());

        //panel juego
        ITablero tablero = controlador.getTablero(); //cambiar por llamada al modelo
        JPanel panelJuego = new JPanel();
        panelJuego.setLayout(new GridLayout(tablero.getTamanio(),tablero.getTamanio()));
        JButton[][] casillas = new JButton[tablero.getTamanio()][tablero.getTamanio()];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new JButton();
                int finalI = i;
                int finalJ = j;
                casillas[i][j].addActionListener(e -> {
                    try {
                        controlador.disparar(new Coordenadas(finalI, finalJ));
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                });
                panelJuego.add(casillas[i][j]);
            }
        }
        panelPrincipal.add(panelJuego, BorderLayout.CENTER);

        //menu
        JMenuBar menu = new JMenuBar();
        JMenu menuB1 = new JMenu("Menu");
        JMenuItem menuB1B1 = new JMenuItem("primer boton");
        menuB1.add(menuB1B1);
        menu.add(menuB1);
        setJMenuBar(menu);

        setVisible(true);
    }
}
