package ar.edu.unlu.poo.tp2.ej9.d2;

public class Cuadrado extends Figura2D {
    private double lado;

    public Cuadrado(double lado) {
        setLado(lado);
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public double getArea() {
        return Math.pow(getLado(), 2);
    }
}
