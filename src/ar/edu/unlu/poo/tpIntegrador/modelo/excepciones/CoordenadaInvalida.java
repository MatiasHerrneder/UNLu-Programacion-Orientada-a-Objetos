package ar.edu.unlu.poo.tpIntegrador.modelo.excepciones;

public class CoordenadaInvalida extends Exception {

    public CoordenadaInvalida() {
    }
    public CoordenadaInvalida(String mensaje) {
        super(mensaje);
    }
}
