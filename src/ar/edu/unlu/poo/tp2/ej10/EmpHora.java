package ar.edu.unlu.poo.tp2.ej10;

import java.time.Month;

public class EmpHora extends Empleado {
    private double sueldoPorHora;
    private int horasContratadas;

    public EmpHora(String nombre, String apellido, String telefono, int cuit, Month mesDeCumpleanios, double sueldoPorHora, int horasContratadas) {
        super(nombre, apellido, telefono, cuit, mesDeCumpleanios);
        setSueldoPorHora(sueldoPorHora);
        setHorasContratadas(horasContratadas);
    }

    public double getSueldoPorHora() {
        return sueldoPorHora;
    }

    public void setSueldoPorHora(double sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }

    public int getHorasContratadas() {
        return horasContratadas;
    }

    public void setHorasContratadas(int horasContratadas) {
        this.horasContratadas = horasContratadas;
    }

    @Override
    public double calcularSueldo() {
        return (getHorasContratadas() > 40 ? getSueldoPorHora() * getHorasContratadas() * 1.2 :
                getSueldoPorHora() * getHorasContratadas())
                + (correspondeBonoCumpleanios() ? 2000 : 0);
    }
}
