package ar.edu.unlu.poo.tp2.ej10;

import java.time.Month;

public class Pasante extends Empleado {

    public Pasante(String nombre, String apellido, String telefono, int cuit, Month mesDeCumpleanios) {
        super(nombre, apellido, telefono, cuit, mesDeCumpleanios);
    }

    @Override
    public double calcularSueldo() {
        return 0;
    }
}
