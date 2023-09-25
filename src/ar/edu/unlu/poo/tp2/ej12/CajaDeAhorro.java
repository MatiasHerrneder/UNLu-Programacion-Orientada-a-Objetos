package ar.edu.unlu.poo.tp2.ej12;

import java.time.LocalDate;

public class CajaDeAhorro {
    private final double INTERES_POR_INVERSION = 0.4;
    private double saldo;
    private double saldoInvertido;
    private LocalDate fechaInversion;
    private int diasParaCobrarInversion;

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

    public boolean gastar(double monto) {

    }

    public boolean depositar(double monto) {

    }

    public boolean invertir(double monto, int diasParaCobrarInversion) {

    }

    public boolean recuperarInversion() {

    }

    public double getInteresesAGanar() {
        if (!getFechaInversion().plusDays(getDiasParaCobrarInversion()).isBefore(LocalDate.now())) {
            return getSaldoInvertido() * INTERES_POR_INVERSION;
        }
        else if (!getFechaInversion().plusDays(30).isBefore(LocalDate.now())) {
            return getSaldoInvertido() * 0.05;
        }
        else return getSaldoInvertido();
    }
}
