package ar.edu.unlu.poo.tp2.ej6;

public class Expendedor {

    private int codigo;
    private Combustible combustible;

    public Expendedor(int codigo, Combustible combustible) {
        setCodigo(codigo);
        setCombustible(combustible);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }
}
