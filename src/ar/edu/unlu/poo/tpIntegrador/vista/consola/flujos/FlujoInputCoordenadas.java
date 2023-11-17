package ar.edu.unlu.poo.tpIntegrador.vista.consola.flujos;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Coordenadas;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.CoordenadaInvalida;
import ar.edu.unlu.poo.tpIntegrador.vista.consola.VistaConsola;

public class FlujoInputCoordenadas extends Flujo {

    enum Estados {
        INPUT_X,
        INPUT_Y
    }
    private Estados estado;
    private String posXBarco;
    private final Flujo flujoAnterior;
    Coordenadas coordenadasBarco;

    public FlujoInputCoordenadas(VistaConsola vista, Controlador controlador, Flujo flujoAnterior) {
        super(vista, controlador);
        this.flujoAnterior = flujoAnterior;
        vista.escribir("Ingrese coordenada X: ");
        estado = Estados.INPUT_X;
    }

    @Override
    public Flujo input(String input) {
        switch (estado) {
            case INPUT_X -> {
                posXBarco = input;
                vista.escribir("Ingrese coordenada Y: ");
                estado = Estados.INPUT_Y;
            }

            case INPUT_Y -> {
                boolean coordValida = true;
                try {
                    coordenadasBarco = new Coordenadas(Integer.parseInt(posXBarco), input.charAt(0));
                    if (!coordenadasBarco.isDentroDe(0, controlador.getTablero().getTamanio() - 1)) coordValida = false;
                } catch (CoordenadaInvalida e) {
                    try {
                        coordenadasBarco = new Coordenadas(Integer.parseInt(posXBarco), Integer.parseInt(input));
                        if (!coordenadasBarco.isDentroDe(0, controlador.getTablero().getTamanio() - 1))
                            coordValida = false;
                    } catch (CoordenadaInvalida ex) {
                        coordValida = false;
                    }
                }
                if (!coordValida) {
                    vista.escribir("La coordenada no es valida");
                    vista.escribir("Ingrese coordenada X: ");
                    estado = Estados.INPUT_X;
                } else {
                    vista.escribir("Ingresar direccion del barco ([N]orte [S]ur [E]ste [O]este): ");
                    return flujoAnterior;
                }
            }
        }
        return this;
    }

    public Coordenadas getCoordenadas(){
        return coordenadasBarco;
    }
}
