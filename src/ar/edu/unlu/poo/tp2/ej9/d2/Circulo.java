package ar.edu.unlu.poo.tp2.ej9.d2;

public class Circulo extends Figura2D {
    private double radio;

    public Circulo(double radio) {
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(getRadio(), 2);
    }
}
