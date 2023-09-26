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
        if (monto > getSaldo() + getLimiteDeGiroDescubierto() - getGiroDescubierto()) {
            if (monto <= getSaldo() + getInteresesAGanar() + getLimiteDeGiroDescubierto() - getGiroDescubierto()
                    && isPrecancelarInversionAutomaticamente()) {
                recuperarInversion();
            }
        }
        if (monto <= getSaldo()) {
            setSaldo(getSaldo() - monto);
            return true;
        }
        else if (monto <= getSaldo() + getLimiteDeGiroDescubierto() - getGiroDescubierto()) {
            setGiroDescubierto(getGiroDescubierto() + monto - getSaldo());
            setSaldo(0);
            return true;
        }
        else return false;
    }

    public boolean depositar(double monto) {
        if (getGiroDescubierto() > 0) {
            if (getGiroDescubierto() < monto){
                setGiroDescubierto(0);
                setSaldo(monto - getGiroDescubierto());
            }
            else {
                setGiroDescubierto(getGiroDescubierto() - monto);
            }
        }
        else setSaldo(getSaldo() + monto);
        return true;
    }

    public boolean recuperarInversion() {
        depositar(getInteresesAGanar());
        setSaldoInvertido(0);
        return true;
    }

}
