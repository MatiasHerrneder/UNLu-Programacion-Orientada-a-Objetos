package ar.edu.unlu.poo.tp1.ej11;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<String> palabras = new ArrayList<>();
    private int id;

    public Jugador(int id) {
        setId(id);
    }

    public void agregarPalabra(String palabra) {
        palabras.add(palabra);
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    private void setId(int id){
        this.id = id;
    }

    public int getIdentificador() {
        return id;
    }
}
