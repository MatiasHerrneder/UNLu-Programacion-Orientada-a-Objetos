package ar.edu.unlu.poo.tpIntegrador.vista.consola;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.ITablero;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;
import ar.edu.unlu.poo.tpIntegrador.vista.consola.flujos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VistaConsola extends JFrame implements IVista {
    private Controlador controlador;
//    private VentanaConsola consola;
    private Flujo flujo;
    private final JTextField inputBox;
    private JTextArea outputBox;

    public VistaConsola(Controlador controlador) {
//        consola = new VentanaConsola("Batalla Naval", this);
        this.controlador = controlador;
        controlador.setVista(this);
        setLayout(new BorderLayout());
        setSize(800, 600);
        setTitle("Batalla Naval");
        setLocationRelativeTo(null);
        setVisible(true);

        inputBox = new JTextField(100);
        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputBox.getText().trim().isEmpty()) {
                    escribir(">> " + inputBox.getText());
                }
                outputBox.setCaretPosition(outputBox.getDocument().getLength());
                inputConsola(inputBox.getText());
                inputBox.setText("");
            }
        });
        add(inputBox, BorderLayout.SOUTH);

        outputBox = new JTextArea();
        outputBox.setEditable(false);
        Font fuente = new Font("Monospaced", Font.PLAIN, 12);
        outputBox.setFont(fuente);
        outputBox.setBackground(Color.BLACK);
        outputBox.setForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(outputBox);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scroll, BorderLayout.CENTER);
    }

    public void escribir(String mensaje) {
        outputBox.append(mensaje + "\n");
    }

    public void inputConsola(String input) {
        Flujo res = null;
        if (flujo != null) res = flujo.input(input);
        if (res != null) flujo = res;
    }

    @Override
    public void iniciar() {
        flujo = new FlujoConexion(this, controlador);
    }

    @Override
    public void colocarBarcos() {
        flujo = new FlujoColocarBarcos(this, controlador);
        inputConsola("");
    }

    private void mostrarTablero() {
        final String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        ITablero tablero = controlador.getTablero();
        escribir("   |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10 |");
        escribir("---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        for (int i = 0; i < tablero.getTamanio(); i++) {
            StringBuilder s = new StringBuilder(" ");
            s.append(letras.charAt(i));
            s.append(" | ");
            for (int j = 0; j < tablero.getTamanio(); j++) {
                switch (tablero.getEstadoPos(i, j)) {
                    case SIN_DISPARAR -> s.append("   ");
                    case AGUA -> s.append(" o ");
                    default -> s.append(" X ");
                }
                s.append(" | ");
            }
            escribir(String.valueOf(s));
            escribir("---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        }
    }


    @Override
    public void mostrarDisparo(EstadoDisparo estado, boolean disparoFuePropio) {
        if (disparoFuePropio) {
            switch (estado) {
                case HUNDIDO -> escribir("El barco enemigo fue hundido!");
                case GOLPEADO -> escribir("El barco enemigo fue golpeado");
                case AGUA -> escribir("Disparo al agua");
            }
        }
        else {
            switch (estado) {
                case HUNDIDO -> escribir("El enemigo hundio nuestro barco!");
                case GOLPEADO -> escribir("El enemigo golpeo nuestro barco");
                case AGUA -> escribir("Disparo enemigo al agua");
            }
        }
        mostrarTablero();
    }

    @Override
    public void jugarTurno() {
        flujo = new FlujoJugarTurno(this, controlador);
    }

    @Override
    public void comienzoDePartida() {
        escribir("COMIENZA LA PARTIDA");
    }

    @Override
    public void finDeLaPartida(boolean ganada) {
        //TODO
    }

    @Override
    public void volverAJugar() {

    }
}


