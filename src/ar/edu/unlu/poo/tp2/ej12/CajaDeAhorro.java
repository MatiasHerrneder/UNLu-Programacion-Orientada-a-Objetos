package ar.edu.unlu.poo.tp2.ej12;

import java.time.LocalDate;

public class CajaDeAhorro {
    private final double INTERES_POR_INVERSION = 0.4;
    private double saldo;
    private double saldoInvertido;
    private LocalDate fechaInversion;
    private int diasParaCobrarInversion;
    private boolean precancelarInversionAutomaticamente = false;

    public CajaDeAhorro(double saldo) {
        setSaldo(saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldoInvertido() {
        return saldoInvertido;
    }

    public void setSaldoInvertido(double saldoInvertido) {
        this.saldoInvertido = saldoInvertido;
    }

    public double getINTERES_POR_INVERSION() {
        return INTERES_POR_INVERSION;
    }

    public LocalDate getFechaInversion() {
        return fechaInversion;
    }

    public void setFechaInversion(LocalDate fechaInversion) {
        this.fechaInversion = fechaInversion;
    }

    public int getDiasParaCobrarInversion() {
        return diasParaCobrarInversion;
    }

    public void setDiasParaCobrarInversion(int diasParaCobrarInversion) {
        this.diasParaCobrarInversion = diasParaCobrarInversion;
    }

    public boolean isPrecancelarInversionAutomaticamente() {
        return precancelarInversionAutomaticamente;
    }

    public void setPrecancelarInversionAutomaticamente(boolean precancelarInversionAutomaticamente) {
        this.precancelarInversionAutomaticamente = precancelarInversionAutomaticamente;
    }

    public boolean gastar(double monto) {
        if (monto > getSaldo()) {
            if (monto <= getSaldo() + getInteresesAGanar() && isPrecancelarInversionAutomaticamente()) {
                recuperarInversion();
            }
        }
        if (monto <= getSaldo()) {
            setSaldo(getSaldo() - monto);
            return true;
        }
        else return false;
    }

    public boolean depositar(double monto) {
        setSaldo(getSaldo() + monto);
        return true;
    }

    public boolean invertir(double monto, int diasParaCobrarInversion) {
        if (monto <= getSaldo()) {
            setSaldoInvertido(monto);
            setSaldo(getSaldo() - monto);
            setFechaInversion(LocalDate.now());
            setDiasParaCobrarInversion(diasParaCobrarInversion);
            return true;
        }
        else return false;
    }

    public boolean recuperarInversion() {
        setSaldo(getSaldo() + getInteresesAGanar());
        setSaldoInvertido(0);
        return true;
    }

    public double getInteresesAGanar() {
        if (getSaldoInvertido() <= 0) return 0;
        if (getFechaInversion().plusDays(getDiasParaCobrarInversion()).isBefore(LocalDate.now())) {
            return getSaldoInvertido() + getSaldoInvertido() * INTERES_POR_INVERSION;
        }
        else if (getFechaInversion().plusDays(30).isBefore(LocalDate.now())) {
            return getSaldoInvertido() + getSaldoInvertido() * 0.05;
        }
        else return getSaldoInvertido();
    }

}
