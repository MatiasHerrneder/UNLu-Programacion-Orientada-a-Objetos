package ar.edu.unlu.poo.tp2.ej10;

import java.time.Month;

public class EmpComision extends Empleado {
    private double porcentajePorVenta;
    private double montoTotalDeVentas;

    public EmpComision(String nombre, String apellido, String telefono, int cuit, Month mesDeCumpleanios, double porcentajePorVenta, double montoTotalDeVentas) {
        super(nombre, apellido, telefono, cuit, mesDeCumpleanios);
        setPorcentajePorVenta(porcentajePorVenta);
        setMontoTotalDeVentas(montoTotalDeVentas);
    }

    public double getPorcentajePorVenta() {
        return porcentajePorVenta;
    }

    public void setPorcentajePorVenta(double porcentajePorVenta) {
        this.porcentajePorVenta = porcentajePorVenta;
    }

    public double getMontoTotalDeVentas() {
        return montoTotalDeVentas;
    }

    public void setMontoTotalDeVentas(double montoTotalDeVentas) {
        this.montoTotalDeVentas = montoTotalDeVentas;
    }

    @Override
    public double calcularSueldo() {
        return getPorcentajePorVenta() * getMontoTotalDeVentas() +
                (correspondeBonoCumpleanios() ? 0.005 * getMontoTotalDeVentas() + 2000 : 0);
    }
}
