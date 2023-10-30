package ar.edu.unlu.poo.tpIntegrador.vista.consola;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.*;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;

import java.util.Scanner;


public class VistaConsola implements IVista {
    private Controlador controlador;
    private Scanner scanner;

    public VistaConsola(Controlador controlador) {
        scanner = new Scanner(System.in);
        this.controlador = controlador;
        controlador.setVista(this);
    }

    public void iniciar() {
        System.out.println("Conectado!");
        System.out.println("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        this.controlador.conectarUsuario(nombre);
        //mostrarTablero();
    }

    public void mostrarTablero() {
        final String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        ITablero tablero = controlador.getTablero();
        System.out.println("   |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10 |");
        System.out.println("---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        for (int i = 0; i < tablero.getTamanio(); i++) {
            StringBuilder s = new StringBuilder(" ");
            s.append(letras.charAt(i));
            s.append(" | ");
            for (int j = 0; j < tablero.getTamanio(); j++) {
                switch (tablero.getTablero()[i][j]) {
                    case SIN_DISPARAR -> s.append("   ");
                    case AGUA -> s.append(" o ");
                    default -> s.append(" X ");
                }
                s.append(" | ");
            }
            System.out.println(s);
            System.out.println("---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        }
    }

    @Override
    public void mostrarDisparo(EstadoDisparo estado, boolean disparoFuePropio) {
        if (disparoFuePropio) {
            switch (estado) {
                case HUNDIDO -> System.out.println("El barco enemigo fue hundido!");
                case GOLPEADO -> System.out.println("El barco enemigo fue golpeado");
                case AGUA -> System.out.println("Disparo al agua");
            }
        }
        else {
            switch (estado) {
                case HUNDIDO -> System.out.println("El enemigo hundio nuestro barco!");
                case GOLPEADO -> System.out.println("El enemigo golpeo nuestro barco");
                case AGUA -> System.out.println("Disparo enemigo al agua");
            }
        }
        mostrarTablero();
    }

    @Override
    public void jugarTurno(boolean turnoPropio) {
        if (turnoPropio) {
            System.out.println("Ingrese coordenada X: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese coordenada X: ");
            }
            int x = scanner.nextInt();
            System.out.println("Ingrese coordenada Y: ");
            boolean inputCorrecto = false;
            while (!inputCorrecto) {
                if (scanner.hasNextInt()) {
                    int y = scanner.nextInt();
                    inputCorrecto = true;
                    try {
                        this.controlador.disparar(new Coordenadas(x, y));
                    } catch (Exception e) {
                        System.out.println("Coordenadas invalidas");
                        jugarTurno(true);
                    }
                }
                else {
                    String input = scanner.nextLine();
                    if (input.length() == 1) {
                        char y = input.charAt(0);
                        inputCorrecto = true;
                        try {
                            this.controlador.disparar(new Coordenadas(x, y));
                        } catch (Exception e) {
                            System.out.println("Coordenadas invalidas");
                            jugarTurno(true);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void comienzoDePartida() {
        System.out.println("Jugadores conectados! pulsa cualquier tecla si estas preparado para iniciar la partida");
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.isEmpty()) {
                break;
            } else {
                this.controlador.listoParaComenzarPartida();
            }
        }
    }
}
