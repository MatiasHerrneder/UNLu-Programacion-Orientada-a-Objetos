package ar.edu.unlu.poo.tpIntegrador.vista.consola;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.NoHayPartidaGuardada;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.PartidaNoGuardable;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.ITablero;
import ar.edu.unlu.poo.tpIntegrador.modelo.records.PartidaTop5;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;
import ar.edu.unlu.poo.tpIntegrador.vista.consola.flujos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;


public class VistaConsola extends JFrame implements IVista {
    private final Controlador controlador;
    private Flujo flujo;
    private final JTextField inputBox;
    private final JTextArea outputBox;
    private boolean partidaCargable = false;

    public VistaConsola(Controlador controlador) {
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
                String in = inputBox.getText();
                if (in.equalsIgnoreCase("help")) {
                    mostrarHelp();
                }
                else if (in.equalsIgnoreCase("top5")){
                    mostrarTop5();
                }
                else if (in.equalsIgnoreCase("guardarPartida")) {
                    try {
                        controlador.guardarPartida();
                    } catch (PartidaNoGuardable ex) {
                        escribir("Solo se puede guardar una partida comenzada");
                    }
                }
                else if (in.equalsIgnoreCase("cargarPartida")) {
                    if (partidaCargable) {
                        try {
                            controlador.cargarPartida();
                        } catch (NoHayPartidaGuardada ex) {
                            escribir("---- NO HAY PARTIDA GUARDADA PARA CARGAR ----");
                        }
                    }
                    else escribir("Antes de cargar una partida se deben conectar los usuarios");
                }
                else {
                    if (!in.trim().isEmpty()) {
                        escribir(">> " + inputBox.getText());
                    }
                    inputConsola(inputBox.getText());
                }
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

        escribir("ESCRIBA help PARA AYUDA SOBRE COMANDOS");
    }

    public void escribir(String mensaje) {
        outputBox.append(mensaje + "\n");
        outputBox.setCaretPosition(outputBox.getDocument().getLength());
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
        partidaCargable = true;
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
                switch (tablero.getEstadoPos(j, i)) {
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
        if (disparoFuePropio || estado == EstadoDisparo.SIN_DISPARAR) {
            switch (estado) {
                case HUNDIDO -> escribir("El barco enemigo fue hundido!");
                case GOLPEADO -> escribir("El barco enemigo fue golpeado");
                case AGUA -> escribir("Disparo al agua");
            }
            mostrarTablero();
        }
        else {
            switch (estado) {
                case HUNDIDO -> escribir("El enemigo hundio nuestro barco!");
                case GOLPEADO -> escribir("El enemigo golpeo nuestro barco");
                case AGUA -> escribir("Disparo enemigo al agua");
            }
        }
    }

    @Override
    public void jugarTurno() {
        flujo = new FlujoJugarTurno(this, controlador);
    }

    @Override
    public void comienzoDePartida() {
        escribir("COMIENZA LA PARTIDA");
        flujo = new FlujoEsperandoTurnoOponente(this, controlador);
    }

    @Override
    public void finDeLaPartida(boolean ganada) {
        flujo = new FlujoFinDePartida(this, controlador, ganada);
    }

    @Override
    public void volverAJugar() {
        outputBox.setText("");
        flujo = new FlujoColocarBarcos(this, controlador);
        inputConsola("");
    }

    @Override
    public void partidaGuardada(boolean accionPropia) {
        if (accionPropia) escribir("---- La partida fue guardada con exito ----");
        else escribir("---- El oponente guardo la partida ----");
    }

    @Override
    public void partidaCargada(boolean accionPropia) {
        if (accionPropia) {
            escribir("---- LA PARTIDA SE CARGO CON EXITO ----");
        }
        else escribir("---- EL OPONENTE CARGO UNA PARTIDA ----");
        flujo = new FlujoEsperandoTurnoOponente(this, controlador);
    }

    private void mostrarHelp() {
        escribir("""
                Los siguientes comandos pueden ser accedidos en cualquier momento:
                top5: muestra las 5 partidas mas rapidas registradas.
                guardarPartida: guarda la partida en el estado actual.
                cargarPartida: carga la ultima partida guardada""");
    }

    private void mostrarTop5() {
        escribir("---- TOP 5 ----");
        try {
            PartidaTop5[] top = controlador.getTop5();
            if (top[0] != null){
                int i = 0;
                while (i < top.length && top[i] != null){
                    escribir(i+1 + "_ " + top[i].turnos() + " turnos jugados entre " + top[i].nombreJ1() + " y " + top[i].nombreJ2());
                    i++;
                }
            }
            else escribir("No hay partidas registradas");
        } catch (RemoteException ex) {
            escribir("Error de red");
        }
        escribir("---- TOP 5 ----");
    }
}


