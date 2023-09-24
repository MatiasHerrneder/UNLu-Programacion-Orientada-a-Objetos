package ar.edu.unlu.poo.tp2.ej10;

import java.time.Month;

public class EmpAsalariado extends Empleado {
    private double sueldo;

    public EmpAsalariado(String nombre, String apellido, String telefono, int cuit, Month mesDeCumpleanios, double sueldo) {
        super(nombre, apellido, telefono, cuit, mesDeCumpleanios);
        setSueldo(sueldo);
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    @Override
    public double calcularSueldo() {
        return correspondeBonoCumpleanios() ? getSueldo() + 3000 : getSueldo();
    }
}
