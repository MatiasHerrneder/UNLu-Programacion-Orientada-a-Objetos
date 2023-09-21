package ar.edu.unlu.poo.tp2.ej7;

import java.time.LocalDate;

public class Venta {

    private LocalDate fecha;
    private float importeTotal;
    private Expendedor expendedor;
    private Empleado empleado;
    private float Litros;
    private float descuento;
    private float precioCombustible;


    public Venta(LocalDate fecha, float importeTotal, Expendedor expendedor, Empleado empleado, float litros, float precioCombustible, float descuento) {
        setEmpleado(empleado);
        setFecha(fecha);
        setImporteTotal(importeTotal);
        setExpendedor(expendedor);
        setLitros(litros);
        setPrecioCombustible(precioCombustible);
        setDescuento(descuento);
    }

    public Venta(LocalDate fecha, float importeTotal, Expendedor expendedor, Empleado empleado, float litros, float precioCombustible) {
        this(fecha, importeTotal, expendedor, empleado, litros, precioCombustible, 0);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getImporteTotal() {
        return importeTotal - importeTotal * descuento;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
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

    public float getPrecioCombustible() {
        return precioCombustible;
    }

    public void setPrecioCombustible(float precioCombustible) {
        this.precioCombustible = precioCombustible;
    }

    @Override
    public String toString() {
        return "Fecha: " + getFecha() + ", Importe: " + getImporteTotal() + ", Expendedor: " +
                getExpendedor().getCodigo() + ", Empleado: " + getEmpleado().getApellido() + ", Litros: " + getLitros();
    }
}
