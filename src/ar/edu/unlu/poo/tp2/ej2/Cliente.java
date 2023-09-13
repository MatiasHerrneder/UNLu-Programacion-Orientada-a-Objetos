package ar.edu.unlu.poo.tp2.ej2;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private int dni;
    private final ArrayList<Paquete> paquetesContratados = new ArrayList<>();

    public Cliente(String nombre, int dni) {
        setDni(dni);
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public ArrayList<Paquete> getPaquetesContratados() {
        return paquetesContratados;
    }

    public void contratarPaquete(Paquete paquete) {
        getPaquetesContratados().add(paquete);
    }
}
