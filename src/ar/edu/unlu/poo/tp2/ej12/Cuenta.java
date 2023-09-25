package ar.edu.unlu.poo.tp2.ej12;

public class Cuenta extends CajaDeAhorro {
    private double limiteDeGiroDescubierto;
    private double giroDescubierto = 0;

    public Cuenta(double saldo, double limiteDeGiroDescubierto) {
        super(saldo);
        setLimiteDeGiroDescubierto(limiteDeGiroDescubierto);
    }

    public double getLimiteDeGiroDescubierto() {
        return limiteDeGiroDescubierto;
    }

    public void setLimiteDeGiroDescubierto(double limiteDeGiroDescubierto) {
        this.limiteDeGiroDescubierto = limiteDeGiroDescubierto;
    }

    public double getGiroDescubierto() {
        return giroDescubierto;
    }

    public void setGiroDescubierto(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
    }

    public boolean gastar(double monto) {

    }

    public boolean depositar(double monto) {

    }

    public boolean invertir(double monto) {

    }

    public boolean recuperarInversion() {

    }

    public double getInteresesAGanar() {

    }

}
