package ar.edu.unlu.poo.tpIntegrador.vista.consola.flujos;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.CasillaYaDisparada;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.NoEsTurnoDelJugador;
import ar.edu.unlu.poo.tpIntegrador.vista.consola.VistaConsola;

public class FlujoJugarTurno extends Flujo {
    enum Estados {
        INICIO,
        TURNO_JUGADO,
        FINALIZADO
    }
    private Estados estado;
    FlujoInputCoordenadas inputCoordenadas;

    public FlujoJugarTurno(VistaConsola vista, Controlador controlador) {
        super(vista, controlador);
        estado = Estados.INICIO;
        vista.escribir("TU TURNO (enter)");
    }

    @Override
    public Flujo input(String input) {
        switch (estado) {
            case INICIO -> {
                estado = Estados.TURNO_JUGADO;
                inputCoordenadas = new FlujoInputCoordenadas(vista, controlador, this);
                return inputCoordenadas;
            }
            case TURNO_JUGADO -> {
                try {
                    this.controlador.disparar(inputCoordenadas.getCoordenadas());
                    estado = Estados.FINALIZADO;
                } catch (NoEsTurnoDelJugador e) {
                    vista.escribir("No es tu turno");
                } catch (CasillaYaDisparada e) {
                    vista.escribir("Esa casilla ya fue disparada");
                    inputCoordenadas = new FlujoInputCoordenadas(vista, controlador, this);
                    return inputCoordenadas;
                }
            }
            case FINALIZADO -> vista.escribir("Esperando al rival");
        }
        return this;
    }

}
