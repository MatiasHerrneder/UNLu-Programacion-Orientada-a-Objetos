package ar.edu.unlu.poo.tp2.ej13.solOriginal;

import java.util.ArrayList;

public class OVuelo {
    private ArrayList<OPersona> miembrosVuelo;

    public OVuelo(ArrayList<OPersona> miembrosVuelo) {
        setMiembrosVuelo(miembrosVuelo);
    }

    public ArrayList<OPersona> getMiembrosVuelo() {
        return miembrosVuelo;
    }

    public void setMiembrosVuelo(ArrayList<OPersona> miembrosVuelo) {
        this.miembrosVuelo = miembrosVuelo;
    }
}
