package ar.edu.unlu.poo.tp2.ej9.d3;

public class Cubo extends Figura3D {
    private double arista;

    public Cubo(double arista) {
        setArista(arista);
    }

    public void setArista(double arista) {
        this.arista = arista;
    }

    public double getArista() {
        return arista;
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(getArista(), 2);
    }

    @Override
    public double getVolumen() {
        return Math.pow(getArista(), 3);
    }
}
