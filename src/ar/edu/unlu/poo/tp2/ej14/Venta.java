package ar.edu.unlu.poo.tp2.ej14;

import java.time.LocalDate;

public class Venta {
    private LocalDate fecha;
    private int unidades;
    private Cliente cliente;

    public Venta(LocalDate fecha, int unidades, Cliente cliente) {
        setFecha(fecha);
        setUnidades(unidades);
        setCliente(cliente);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta de " + getUnidades() + " al cliente " + getCliente().getNombre();
    }
}
