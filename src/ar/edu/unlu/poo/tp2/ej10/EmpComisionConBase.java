package ar.edu.unlu.poo.tp2.ej10;

import java.time.Month;

public class EmpComisionConBase extends Empleado {
    private double sueldoBase;
    private double porcentajePorVenta;
    private double montoTotalDeVentas;

    public EmpComisionConBase(String nombre, String apellido, String telefono, int cuit, Month mesDeCumpleanios, double sueldoBase, double porcentajePorVenta, double montoTotalDeVentas) {
        super(nombre, apellido, telefono, cuit, mesDeCumpleanios);
        setSueldoBase(sueldoBase);
        setPorcentajePorVenta(porcentajePorVenta);
        setMontoTotalDeVentas(montoTotalDeVentas);
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
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
        return getSueldoBase() + getPorcentajePorVenta() * getMontoTotalDeVentas() +
                (correspondeBonoCumpleanios() ? 0.005 * getMontoTotalDeVentas() + 3000 : 0);
    }
}
