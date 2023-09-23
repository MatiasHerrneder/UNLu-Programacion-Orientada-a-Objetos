package ar.edu.unlu.poo.tp2.ej9.d3;

public class Esfera extends Figura3D {
    private double radio;

    public Esfera(double radio) {
        setRadio(radio);
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(getRadio(), 2);
    }

    @Override
    public double getVolumen() {
        return ((double) 4 / 3) * Math.PI * Math.pow(getRadio(), 3);
    }
}
