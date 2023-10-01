package ar.edu.unlu.poo.tp2.ej14;

public class Transporte extends Proveedor {

    public Transporte(String razonSocial, int cuit, String telefono, double importeBase) {
        super(razonSocial, cuit, telefono, importeBase);
    }

    @Override
    public double montoAPagar(int cantidadDeClientes) {
        return getImporteBase() + getImporteBase() * cantidadDeClientes * 0.003;
    }
}
