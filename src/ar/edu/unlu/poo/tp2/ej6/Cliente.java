package ar.edu.unlu.poo.tp2.ej6;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    private String patente;
    private String nombre;
    private final ArrayList<Venta> ventas = new ArrayList<>();

    public Cliente(String patente, String nombre) {
        setPatente(patente);
        setNombre(nombre);
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void agregarVenta(LocalDate fecha, float importeTotal, Expendedor expendedor, Empleado empleado, float litros) {
        getVentas().add(new Venta(fecha, importeTotal, expendedor, empleado, litros));
    }

    public float montoTotalDeCompras() {
        float montoTotal = 0;
        for (Venta v : getVentas()) {
            montoTotal += v.getImporteTotal();
        }
        return montoTotal;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + ", Patente: " + getPatente();
    }
}
