package ar.edu.unlu.poo.tp2.ej4;

import java.time.LocalDate;

public class Inversion {
    private float valor;
    private int duracion;
    private LocalDate fechaDeInversion;

    public Inversion(float valor, int duracion) {
        setValor(valor);
        setDuracion(duracion);
        setFechaDeInversion(LocalDate.now());
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaDeInversion() {
        return fechaDeInversion;
    }

    public void setFechaDeInversion(LocalDate fechaDeInversion) {
        this.fechaDeInversion = fechaDeInversion;
    }

    public float retorno() {
        return (float) (getValor() * 1.4);
    }

}
