package ar.edu.unlu.poo.tp2.ej12;

import java.util.ArrayList;

public class CuentaCredito {
    private double limite;
    private final ArrayList<Double> compras = new ArrayList<>();
    private final ArrayList<Double> pagado = new ArrayList<>();

    public CuentaCredito(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ArrayList<Double> getCompras() {
        return compras;
    }

    public ArrayList<Double> getPagado() {
        return pagado;
    }

    public boolean comprar(double monto) {

    }

    public boolean pagar(double monto, int indiceCompra) {

    }

    public double getMontoDisponibleParaCompras() {

    }

    public double getSaldoDeudor() {

    }

    public double getSaldoDeudorCompra(int indiceCompra) {

    }

}
