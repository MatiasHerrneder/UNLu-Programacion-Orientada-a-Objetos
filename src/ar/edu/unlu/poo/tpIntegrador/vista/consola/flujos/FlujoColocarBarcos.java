package ar.edu.unlu.poo.tpIntegrador.vista.consola.flujos;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Barco;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Coordenadas;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.Direccion;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.PosicionDeBarcosInvalida;
import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.IBarco;
import ar.edu.unlu.poo.tpIntegrador.vista.consola.VistaConsola;

public class FlujoColocarBarcos extends Flujo {
    enum Estados {
        PRE_COLOCAR,
        INPUT_DIR,
        FINALIZADO
    }
    private Estados estado;
    private IBarco[] barcos = new IBarco[5];
    private int largoBarco;
    private FlujoInputCoordenadas inputCoordenadas;

    public FlujoColocarBarcos(VistaConsola vista, Controlador controlador) {
        super(vista, controlador);
        estado = Estados.PRE_COLOCAR;
    }

    @Override
    public Flujo input(String input) {
        switch (estado) {
            case PRE_COLOCAR -> {
                vista.escribir("FASE DE COLOCACION DE BARCOS");
                estado = Estados.INPUT_DIR;
                return colocarBarcos();
            }

            case INPUT_DIR -> {
                Coordenadas coordenadasBarco = inputCoordenadas.getCoordenadas();
                Direccion direccionBarco = null;
                boolean direccionValida = false;
                switch (input) {
                    case "N", "n" -> {
                        direccionBarco = Direccion.ARRIBA;
                        direccionValida = true;
                    }
                    case "S", "s" -> {
                        direccionBarco = Direccion.ABAJO;
                        direccionValida = true;
                    }
                    case "E", "e" -> {
                        direccionBarco = Direccion.DERECHA;
                        direccionValida = true;
                    }
                    case "O", "o" -> {
                        direccionBarco = Direccion.IZQUIERDA;
                        direccionValida = true;
                    }
                }
                if (direccionValida) {
                    int i = 0;
                    while (barcos[i] != null) i++;
                    barcos[i] = new Barco(coordenadasBarco, direccionBarco, largoBarco);
                    if (barcos[4] != null) {
                        try {
                            this.controlador.colocarBarcos(barcos);
                            estado = Estados.FINALIZADO;
                            return null;
                        } catch (PosicionDeBarcosInvalida e) {
                            vista.escribir("No son validas las posiciones de los barcos");
                            barcos = new IBarco[5];
                            estado = Estados.PRE_COLOCAR;
                        }
                    }
                    else {
                        estado = Estados.INPUT_DIR;
                        return colocarBarcos();
                    }
                }
                else {
                    vista.escribir("La direccion no es valida");
                }
            }
            case FINALIZADO -> vista.escribir("La partida comenzara cuando el otro jugador haya colocado los barcos");
        }
        return this;
    }

    private Flujo colocarBarcos() {
        if (barcos[0] == null) largoBarco = 5;
        else if (barcos[1] == null) largoBarco = 4;
        else if (barcos[2] == null) largoBarco = 3;
        else if (barcos[3] == null) largoBarco = 3;
        else if (barcos[4] == null) largoBarco = 2;
        vista.escribir("Ingresar posicion de barco de largo " + largoBarco);
        estado = Estados.INPUT_DIR;
        inputCoordenadas = new FlujoInputCoordenadas(vista, controlador, this);
        return inputCoordenadas;
    }

}
