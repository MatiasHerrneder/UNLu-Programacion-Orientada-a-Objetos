package ar.edu.unlu.poo.tp2.ej13.solOriginal;

public class OTicket {
    private OVuelo vuelo;
    private OPasajero pasajero;

    public OTicket(OVuelo vuelo, OPasajero pasajero) {
        setVuelo(vuelo);
        setPasajero(pasajero);
    }

    public OVuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(OVuelo vuelo) {
        this.vuelo = vuelo;
    }

    public OPasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(OPasajero pasajero) {
        this.pasajero = pasajero;
    }
}
