package ar.edu.unlu.poo.tpIntegrador.vista.consola.flujos;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.JugadoresYaConectados;
import ar.edu.unlu.poo.tpIntegrador.vista.consola.VistaConsola;

public class FlujoConexion extends Flujo {
    enum Estados {
        CONECTAR,
        FINALIZADO
    }
    private Estados estado;

    public FlujoConexion(VistaConsola vista, Controlador controlador) {
        super(vista, controlador);
        estado = Estados.CONECTAR;
        vista.escribir("Conectado!");
        vista.escribir("Ingresa tu nombre: ");
    }

    @Override
    public Flujo input(String input) {
        switch (estado) {
            case CONECTAR -> {
                try {
                    controlador.conectarUsuario(input);
                    estado = Estados.FINALIZADO;
                    return null;
                } catch (JugadoresYaConectados ex) {
                    vista.escribir("ERROR: ya hay 2 jugadores conectados a la partida");
                }
            }
            case FINALIZADO -> vista.escribir("Esperando al otro jugador...");
        }
        return this;
    }

}
