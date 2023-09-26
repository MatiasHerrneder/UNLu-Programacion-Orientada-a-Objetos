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
        if (getMontoDisponibleParaCompras() > 0) {
            getCompras().add(monto * 1.05);
            getPagado().add(0.0);
            return true;
        }
        else return false;
    }

    public boolean pagar(double monto, int indiceCompra) {
        if (getPagado().get(indiceCompra) + monto > getCompras().get(indiceCompra)) {
            getPagado().set(indiceCompra, getCompras().get(indiceCompra));
        }
        else {
            getPagado().set(indiceCompra, getPagado().get(indiceCompra) + monto);
        }
        return true;
    }

    public double getMontoDisponibleParaCompras() {
        return getLimite() - getSaldoDeudor();
    }

    public double getSaldoDeudor() {
        double res = 0;
        for (int i = 0; i < getCompras().size(); i++) {
            res += getSaldoDeudorCompra(i);
        }
        return res;
    }

    public double getSaldoDeudorCompra(int indiceCompra) {
        return getCompras().get(indiceCompra) - getPagado().get(indiceCompra);
    }

}
