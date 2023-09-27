package ar.edu.unlu.poo.tp2.ej13.solOriginal;

public class OPasajero extends OPersona {
    private int numeroPasajero;

    public OPasajero(String nombre, String numeroDeTelefono, String direccion, int numeroPasajero) {
        super(nombre, numeroDeTelefono, direccion);
        setNumeroPasajero(numeroPasajero);
    }

    public int getNumeroPasajero() {
        return numeroPasajero;
    }

    public void setNumeroPasajero(int numeroPasajero) {
        this.numeroPasajero = numeroPasajero;
    }
}
