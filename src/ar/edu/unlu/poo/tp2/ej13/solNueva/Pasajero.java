package ar.edu.unlu.poo.tp2.ej13.solNueva;

public class Pasajero extends Rol {
    private int numeroPasajero;

    public Pasajero(int numeroPasajero) {
        setNumeroPasajero(numeroPasajero);
    }

    public int getNumeroPasajero() {
        return numeroPasajero;
    }

    public void setNumeroPasajero(int numeroPasajero) {
        this.numeroPasajero = numeroPasajero;
    }
}
