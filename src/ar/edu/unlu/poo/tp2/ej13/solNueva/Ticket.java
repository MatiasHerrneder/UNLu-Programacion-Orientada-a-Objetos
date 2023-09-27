package ar.edu.unlu.poo.tp2.ej13.solNueva;

public class Ticket {
    private Vuelo vuelo;
    private Pasajero pasajero;

    public Ticket(Vuelo vuelo, Pasajero pasajero) {
        setVuelo(vuelo);
        setPasajero(pasajero);
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
}
