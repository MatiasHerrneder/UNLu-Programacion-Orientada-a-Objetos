package ar.edu.unlu.poo.tp2.ej13.solNueva;

import java.util.ArrayList;

public class Vuelo {
    private ArrayList<Persona> miembrosVuelo;

    public Vuelo(ArrayList<Persona> miembrosVuelo) {
        setMiembrosVuelo(miembrosVuelo);
    }

    public ArrayList<Persona> getMiembrosVuelo() {
        return miembrosVuelo;
    }

    public void setMiembrosVuelo(ArrayList<Persona> miembrosVuelo) {
        this.miembrosVuelo = miembrosVuelo;
    }
}
