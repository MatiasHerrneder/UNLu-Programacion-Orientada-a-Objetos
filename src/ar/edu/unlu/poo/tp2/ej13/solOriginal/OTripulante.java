package ar.edu.unlu.poo.tp2.ej13.solOriginal;

import java.util.ArrayList;

public class OTripulante extends OPersona {
    private String cargo;
    private ArrayList<OReciboSueldo> recibos;

    public OTripulante(String nombre, String numeroDeTelefono, String direccion, String cargo, ArrayList<OReciboSueldo> recibos) {
        super(nombre, numeroDeTelefono, direccion);
        setCargo(cargo);
        setRecibos(recibos);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ArrayList<OReciboSueldo> getRecibos() {
        return recibos;
    }

    public void setRecibos(ArrayList<OReciboSueldo> recibos) {
        this.recibos = recibos;
    }
}
