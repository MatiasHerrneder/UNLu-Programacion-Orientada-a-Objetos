package ar.edu.unlu.poo.tp2.ej6;

import java.time.LocalDate;

public class Venta {

    private LocalDate fecha;
    private float importeTotal;
    private Expendedor expendedor;
    private Empleado empleado;
    private float Litros;

    public Venta(LocalDate fecha, float importeTotal, Expendedor expendedor, Empleado empleado, float litros) {
        setEmpleado(empleado);
        setFecha(fecha);
        setImporteTotal(importeTotal);
        setExpendedor(expendedor);
        setLitros(litros);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Expendedor getExpendedor() {
        return expendedor;
    }

    public void setExpendedor(Expendedor expendedor) {
        this.expendedor = expendedor;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public float getLitros() {
        return Litros;
    }

    public void setLitros(float litros) {
        Litros = litros;
    }

    @Override
    public String toString() {
        return "Fecha: " + getFecha() + ", Importe: " + getImporteTotal() + ", Expendedor: " +
                getExpendedor().getCodigo() + ", Empleado: " + getEmpleado().getApellido() + ", Litros: " + getLitros();
    }
}
