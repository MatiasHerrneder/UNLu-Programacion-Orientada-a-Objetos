package ar.edu.unlu.poo.tp2.ej9.d2;

public class Triangulo extends Figura2D {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double getArea() {
        return getBase() * getAltura() / 2;
    }
}
