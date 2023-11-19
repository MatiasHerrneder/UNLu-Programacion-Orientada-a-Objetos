package ar.edu.unlu.poo.tpIntegrador.vista.grafica.ventanas;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Barco;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Coordenadas;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.Direccion;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.CasillaYaDisparada;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.CoordenadaInvalida;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.NoEsTurnoDelJugador;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.PosicionDeBarcosInvalida;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.IBarco;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.ITablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaPrincipal extends JPanel {
    private final Controlador controlador;
    private final ITablero tablero;
    JButton[][] casillas;
    Barco barcoAColocar;
    IBarco[] barcos;
    KeyListener flechas;
    JButton bColocarBarco;
    JButton bGirarBarco;
    JLabel msg;
            
    public VentanaPrincipal(Controlador controlador) {
        this.controlador = controlador;
        tablero = controlador.getTablero();
        setLayout(new BorderLayout());
        //creo mi grilla de juego
        add(crearPanelGrilla(), BorderLayout.CENTER);
        //barcos
        generarInterfazBarcos();
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
                        controlador.disparar(new Coordenadas(finalI, finalJ));
//                        mostrarMensaje("Turno del rival");
                    } catch (NoEsTurnoDelJugador | CasillaYaDisparada ignored) {
                    } catch (CoordenadaInvalida ex) {
                        ex.printStackTrace();
                    }
                    requestFocus();
                });
            }
        }
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                res.add(casillas[j][i]); //en un loop afuera para que se agreguen en orden (x,y)
            }
        }
        return res;
    }

    private void generarInterfazBarcos() {
        // listeners de teclas
        flechas = new KeyListener() {
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
                    } catch (CoordenadaInvalida ignored) {}
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    try {
                        barcoAColocar.setPosicion(new Coordenadas(barcoAColocar.getPosicionBarco().getPosX() + 1, barcoAColocar.getPosicionBarco().getPosY()));
                    } catch (CoordenadaInvalida ignored) {}
                } else if (keyCode == KeyEvent.VK_UP) {
                    try {
                        barcoAColocar.setPosicion(new Coordenadas(barcoAColocar.getPosicionBarco().getPosX(), barcoAColocar.getPosicionBarco().getPosY() - 1));
                    } catch (CoordenadaInvalida ignored) {}
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    try {
                        barcoAColocar.setPosicion(new Coordenadas(barcoAColocar.getPosicionBarco().getPosX(), barcoAColocar.getPosicionBarco().getPosY() + 1));
                    } catch (CoordenadaInvalida ignored) {}
                }

                try {
                    if (!barcoAColocar.colaDelBarco().isDentroDe(0, tablero.getTamanio() - 1) || !barcoAColocar.getPosicionBarco().isDentroDe(0, tablero.getTamanio() - 1)) barcoAColocar.setPosicion(viejaPos);
                } catch (CoordenadaInvalida ex) {
                    barcoAColocar.setPosicion(viejaPos);
                }
                mostrarBarcoAColocar();
            }
        };
        addKeyListener(flechas);

        // boton rotar barco
        bGirarBarco = new JButton("Girar barco");
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
            requestFocus();
        });
        add(bGirarBarco, BorderLayout.NORTH);

        //boton para colocar barco
        bColocarBarco = new JButton("Colocar barco");
        bColocarBarco.addActionListener(e -> colocarBarco());
        add(bColocarBarco, BorderLayout.SOUTH);
    }

    public void borrarInterfazBarcos() {
        if (msg == null) {
            removeKeyListener(flechas);
            remove(bColocarBarco);
            remove(bGirarBarco);

            msg = new JLabel("");
            add(msg, BorderLayout.NORTH);
        }
        pintarCasillasAgua();
    }

    public void crearBarcos() {
        setFocusable(true);

        barcos = new IBarco[5];
        //inicializo primer barco a colocar
        try {
            barcoAColocar = new Barco(new Coordenadas(0, 0), Direccion.DERECHA, 5);
        } catch (CoordenadaInvalida e) {
            e.printStackTrace();
        }
        mostrarBarcoAColocar();
    }

    private void colocarBarco() {
        int tam = 5;
        if (barcos[barcos.length - 1] == null) {
            int i = 0;
            while (i < barcos.length && barcos[i] != null) i++;
            barcos[i] = new Barco(barcoAColocar.getPosicionBarco(), barcoAColocar.getDireccion(), barcoAColocar.getLargoDelBarco());
            switch (i) {
                case 0 -> tam = 4;
                case 1, 2 -> tam = 3;
                case 3 -> tam = 2;
            }
        }
        if (barcos[barcos.length - 1] != null) {
            try {
                this.controlador.colocarBarcos(barcos); //todos los barcos creados, los paso al controlador
                requestFocus();
                return;
            } catch (PosicionDeBarcosInvalida e) {
                crearBarcos();
            }
        }
        else {
            try {
                barcoAColocar = new Barco(new Coordenadas(0, 0), Direccion.DERECHA, tam);
            } catch (CoordenadaInvalida e) {
                e.printStackTrace();
            }
        }
        mostrarBarcoAColocar();
        requestFocus();
    }

    private void mostrarBarcoAColocar() {
        pintarBarcosColocados();
        if (barcos[barcos.length - 1] == null) {
            Coordenadas pos = barcoAColocar.getPosicionBarco();
            for (int i = 0; i < barcoAColocar.getLargoDelBarco(); i++) {
                casillas[pos.getPosX()][pos.getPosY()].setBackground(Color.BLACK);
                try {
                    pos = barcoAColocar.siguienteCoordenada(pos);
                } catch (CoordenadaInvalida ignored) {
                }
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
        colBarco[4] = Color.magenta;
        int i = 0;
        while (i < barcos.length && barcos[i] != null) {
            Coordenadas pos = barcos[i].getPosicionBarco();
            for (int j = 0; j < barcos[i].getLargoDelBarco(); j++) {
                casillas[pos.getPosX()][pos.getPosY()].setBackground(colBarco[i]);
                try {
                    pos = barcos[i].siguienteCoordenada(pos);
                } catch (CoordenadaInvalida e) {
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

    public void jugarTurno() {
        mostrarMensaje("Tu turno");
    }

    public void mostrarTablero(EstadoDisparo estadoDisparo, boolean disparoFuePropio) {
        mostrarTablero();
        if (disparoFuePropio) {
            mostrarMensaje(estadoDisparo.toString());
        }
    }

    public void mostrarTablero() {
        ITablero tablero = controlador.getTablero();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                switch (tablero.getEstadoPos(i, j)) {
                    case SIN_DISPARAR -> casillas[i][j].setBackground(Color.CYAN);
                    case GOLPEADO, HUNDIDO -> casillas[i][j].setBackground(Color.RED);
                    case AGUA -> casillas[i][j].setBackground(Color.GRAY);
                }
            }
        }
    }

    public void finDeLaPartida(boolean ganada) {
        mostrarTablero();
        if (ganada) mostrarMensaje("GANASTE");
        else mostrarMensaje("PERDISTE");
    }

    private void mostrarMensaje(String mensaje) {
        msg.setText(mensaje);
    }

}
