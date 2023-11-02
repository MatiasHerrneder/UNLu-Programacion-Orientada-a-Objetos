package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaPrincipal extends JFrame {
    private Controlador controlador;
    private JPanel panelPrincipal;
    private ITablero tablero;
    JButton[][] casillas;
    Barco barcoAColocar;
    IBarco[] barcos = new Barco[5];
            
    public VentanaPrincipal(Controlador controlador) {
        this.controlador = controlador;
        tablero = controlador.getTablero();
        //ventana principal
        setTitle("Batalla Naval");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelPrincipal = (JPanel) getContentPane();
        panelPrincipal.setLayout(new BorderLayout());
        //menu
        JMenuBar menu = new JMenuBar();
        JMenu menuB1 = new JMenu("Menu");
        JMenuItem menuB1B1 = new JMenuItem("primer boton");
        menuB1.add(menuB1B1);
        menu.add(menuB1);
        setJMenuBar(menu);
        //creo mi grilla de juego
        panelPrincipal.add(crearPanelGrilla(), BorderLayout.CENTER);
        //barcos
        crearBarcos();

    }

    private JPanel crearPanelGrilla() {
        JPanel res = new JPanel();
        res.setLayout(new GridLayout(tablero.getTamanio(), tablero.getTamanio()));
        casillas = new JButton[tablero.getTamanio()][tablero.getTamanio()];
        for (int i = 0; i < tablero.getTamanio(); i++) {
            for (int j = 0; j < tablero.getTamanio(); j++) {
                casillas[i][j] = new JButton();
                int finalI = i;
                int finalJ = j;
                casillas[i][j].addActionListener(e -> {
                    try {
                        //controlador.disparar(new Coordenadas(finalI, finalJ)); TODO
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
                res.add(casillas[i][j]);
            }
        }
        return res;
    }

    private void crearBarcos() {
        // listeners de teclas
        panelPrincipal.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //no usado
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //no usado
            }
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                Coordenadas viejaPos = barcoAColocar.getPosicionBarco();
                if (keyCode == KeyEvent.VK_LEFT) {
                    try {
                        barcoAColocar.setPosicion(new Coordenadas(barcoAColocar.getPosicionBarco().getPosX() - 1, barcoAColocar.getPosicionBarco().getPosY()));
                    } catch (Exception ignored) {}
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    try {
                        barcoAColocar.setPosicion(new Coordenadas(barcoAColocar.getPosicionBarco().getPosX() + 1, barcoAColocar.getPosicionBarco().getPosY()));
                    } catch (Exception ignored) {}
                } else if (keyCode == KeyEvent.VK_UP) {
                    try {
                        barcoAColocar.setPosicion(new Coordenadas(barcoAColocar.getPosicionBarco().getPosX(), barcoAColocar.getPosicionBarco().getPosY() - 1));
                    } catch (Exception ignored) {}
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    try {
                        barcoAColocar.setPosicion(new Coordenadas(barcoAColocar.getPosicionBarco().getPosX(), barcoAColocar.getPosicionBarco().getPosY() + 1));
                    } catch (Exception ignored) {}
                }

                try {
                    if (!barcoAColocar.colaDelBarco().isDentroDe(0, tablero.getTamanio() - 1)) barcoAColocar.setPosicion(viejaPos);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                mostrarBarcoAColocar();
            }
        });
        panelPrincipal.setFocusable(true);

        // boton rotar barco
        JButton bGirarBarco = new JButton("Girar barco");
        bGirarBarco.addActionListener(e -> {
            boolean posValida = false;
            while (!posValida) {
                if (barcoAColocar.getDireccion().ordinal() + 1 < Direccion.values().length) barcoAColocar.setDireccion(Direccion.values()[barcoAColocar.getDireccion().ordinal() + 1]);
                else barcoAColocar.setDireccion(Direccion.values()[0]);
                try {
                    if (barcoAColocar.colaDelBarco().isDentroDe(0, tablero.getTamanio() - 1)) posValida = true;
                } catch (Exception ignored) {}
            }
            mostrarBarcoAColocar();
        });
        panelPrincipal.add(bGirarBarco, BorderLayout.NORTH);

        //boton para colocar barco
        JButton bColocarBarco = new JButton("Colocar barco");
        bColocarBarco.addActionListener(e -> colocarBarco());
        panelPrincipal.add(bColocarBarco, BorderLayout.SOUTH);

        //inicializo primer barco a colocar
        try {
            barcoAColocar = new Barco(new Coordenadas(0, 0), Direccion.DERECHA, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mostrarBarcoAColocar();
    }

    private void colocarBarco() {
        int i = 1;
        while (i < barcos.length && barcos[i] != null) i++;
        if (i >= barcos.length) this.controlador.colocarBarcos(barcos); //todos los barcos creados, los paso al controlador
        else {
            barcos[i] = new Barco(barcoAColocar.getPosicionBarco(), barcoAColocar.getDireccion(), barcoAColocar.getLargoDelBarco());
            int tam = 5;
            switch (i) {
                case 1 -> tam = 4;
                case 2, 3 -> tam = 3;
                case 4 -> tam = 2;
            }
            try {
                barcoAColocar = new Barco(new Coordenadas(0, 0), Direccion.DERECHA, tam);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mostrarBarcoAColocar();
    }

    private void mostrarBarcoAColocar() {
        pintarBarcosColocados();
        Coordenadas pos = barcoAColocar.getPosicionBarco();
        for (int i = 0; i < barcoAColocar.getLargoDelBarco(); i++) {
            casillas[pos.getPosY()][pos.getPosX()].setBackground(Color.BLACK);
            try {
                pos = barcoAColocar.siguienteCoordenada(pos);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void pintarBarcosColocados() {
        pintarCasillasAgua();
        Color[] colBarco = new Color[barcos.length];
        colBarco[0] = Color.red;
        colBarco[1] = Color.blue;
        colBarco[2] = Color.green;
        colBarco[3] = Color.yellow;
        colBarco[4] = Color.MAGENTA;
        int i = 0;
        while (i < barcos.length && barcos[i] != null) {
            Coordenadas pos = barcos[i].getPosicionBarco();
            for (int j = 0; j < barcos[i].getLargoDelBarco(); j++) {
                casillas[pos.getPosY()][pos.getPosX()].setBackground(colBarco[i]);
                try {
                    pos = barcos[i].siguienteCoordenada(pos);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
    }

    private void pintarCasillasAgua() {
        for (JButton[] x : casillas) {
            for (JButton y : x) {
                y.setBackground(Color.CYAN);
            }
        }
    }

    public void panelPrincipal() {
        //panelPrincipal.add(panelJuego, BorderLayout.CENTER);
    }
}
