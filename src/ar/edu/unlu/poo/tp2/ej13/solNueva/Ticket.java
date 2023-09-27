package ar.edu.unlu.poo.tp2.ej13.solNueva;

public class Ticket {
    private Vuelo vuelo;
    private Persona pasajero;

    public Ticket(Vuelo vuelo, Persona pasajero) {
        setVuelo(vuelo);
        setPasajero(pasajero);
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Persona getPasajero() {
        return pasajero;
    }

    public void setPasajero(Persona pasajero) {
        this.pasajero = pasajero;
    }
}
