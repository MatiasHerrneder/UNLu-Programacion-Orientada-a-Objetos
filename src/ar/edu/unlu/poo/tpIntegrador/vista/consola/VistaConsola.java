package ar.edu.unlu.poo.tpIntegrador.vista.consola;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Barco;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Coordenadas;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.Direccion;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.CasillaYaDisparada;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.JugadoresYaConectados;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.NoEsTurnoDelJugador;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.PosicionDeBarcosInvalida;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.IBarco;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.ITablero;
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
        try {
            this.controlador.conectarUsuario(nombre);
        } catch (JugadoresYaConectados e) {
            System.out.println("ERROR: ya hay 2 jugadores conectados a la partida");
        }
        //comienzoDePartida();
        //mostrarTablero();
    }

    private void mostrarTablero() {
        final String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        ITablero tablero = controlador.getTablero();
        System.out.println("   |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10 |");
        System.out.println("---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
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
            System.out.println(s);
            System.out.println("---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        }
    }

    private Coordenadas getCoordenadasDeTeclado() {
        System.out.println("Ingrese coordenada X: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ingrese coordenada X: ");
            scanner.next();
        }
        int x = scanner.nextInt() - 1;
        System.out.println("Ingrese coordenada Y: ");
        boolean inputCorrecto = false;
        while (!inputCorrecto) {
            if (scanner.hasNextInt()) {
                int y = scanner.nextInt() - 1;
                inputCorrecto = true;
                try {
                    return new Coordenadas(x, y);
                } catch (Exception e) {
                    System.out.println("Coordenadas invalidas");
                    getCoordenadasDeTeclado();
                }
            }
            else {
                String input = scanner.nextLine();
                if (input.length() == 1) {
                    char y = input.charAt(0);
                    inputCorrecto = true;
                    try {
                        return new Coordenadas(x, y);
                    } catch (Exception e) {
                        System.out.println("Coordenadas invalidas");
                        getCoordenadasDeTeclado();
                    }
                }
            }
        }
        return null;
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
    public void jugarTurno() {
        try {
            this.controlador.disparar(getCoordenadasDeTeclado());
        } catch (NoEsTurnoDelJugador e) {
            e.printStackTrace();
        } catch (CasillaYaDisparada e) {
            System.out.println("Esa casilla ya fue disparada");
            jugarTurno();
        }
    }

    @Override
    public void colocarBarcos() {
        IBarco[] barcos = new Barco[5];
        barcos[0] = crearBarco(5);
        barcos[1] = crearBarco(4);
        barcos[2] = crearBarco(3);
        barcos[3] = crearBarco(3);
        barcos[4] = crearBarco(2);
        try {
            this.controlador.colocarBarcos(barcos);
        } catch (PosicionDeBarcosInvalida e) {
            errorEnBarcos();
        }
    }

    private void errorEnBarcos() {
        System.out.println("No son validas las posiciones de los barcos");
        colocarBarcos();
    }

    private IBarco crearBarco(int largo) {
        System.out.println("Ingresar posicion de barco de largo " + largo);
        Coordenadas pos = getCoordenadasDeTeclado();
        System.out.println("Ingresar direccion en la que va el barco desde su posicion inicial ([N]orte, [S]ur, [E]ste, [O]este)");
        boolean direccionValida = false;
        Direccion dir = null;
        while (!direccionValida) {
            switch (scanner.nextLine()) {
                case "N" -> {
                    dir = Direccion.ARRIBA;
                    direccionValida = true;
                }
                case "S" -> {
                    dir = Direccion.ABAJO;
                    direccionValida = true;
                }
                case "E" -> {
                    dir = Direccion.DERECHA;
                    direccionValida = true;
                }
                case "O" -> {
                    dir = Direccion.IZQUIERDA;
                    direccionValida = true;
                }
            }
        }
        return new Barco(pos,  dir, largo);
    }

    @Override
    public void comienzoDePartida() {
//        System.out.println("Jugadores conectados! pulsa cualquier tecla si estas preparado para iniciar la partida");
//        while (true) {
//            String userInput = scanner.nextLine();
//            if (userInput.isEmpty()) {
//                break;
//            } else {
//                this.controlador.listoParaComenzarPartida();
//            }
//        }
    }

    @Override
    public void finDeLaPartida(boolean ganada) {
        //TODO
    }

    @Override
    public void volverAJugar() {

    }

}
