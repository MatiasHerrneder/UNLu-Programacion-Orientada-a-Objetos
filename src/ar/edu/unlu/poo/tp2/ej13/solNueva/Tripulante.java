package ar.edu.unlu.poo.tp2.ej13.solNueva;

import java.util.ArrayList;

public class Tripulante extends Rol {
    private String cargo;
    private final ArrayList<ReciboSueldo> recibos = new ArrayList<>();

    public Tripulante(String cargo) {
        setCargo(cargo);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ArrayList<ReciboSueldo> getRecibos() {
        return recibos;
    }

    public void agregarRecibo(ReciboSueldo recibo) {
        getRecibos().add(recibo);
    }

    public void eliminarRecibo(ReciboSueldo recibo) {
        getRecibos().remove(recibo);
    }

}
