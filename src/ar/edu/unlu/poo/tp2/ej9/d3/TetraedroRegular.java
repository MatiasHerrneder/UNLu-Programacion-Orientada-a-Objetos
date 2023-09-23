package ar.edu.unlu.poo.tp2.ej9.d3;

public class TetraedroRegular extends Figura3D {
    private double arista;

    public TetraedroRegular(double arista) {
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
        return Math.pow(getArista(), 2) * Math.sqrt(3);
    }

    @Override
    public double getVolumen() {
        return Math.pow(getArista(), 3) * Math.sqrt(2) / 12;
    }

}
