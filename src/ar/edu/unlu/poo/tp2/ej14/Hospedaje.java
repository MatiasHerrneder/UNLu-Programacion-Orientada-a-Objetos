package ar.edu.unlu.poo.tp2.ej14;

public class Hospedaje extends Proveedor {

    private int cantMinimaDeClientes;

    public Hospedaje(String razonSocial, int cuit, String telefono, double importeBase, int cantMinimaDeClientes) {
        super(razonSocial, cuit, telefono, importeBase);
        setCantMinimaDeClientes(cantMinimaDeClientes);
    }

    public int getCantMinimaDeClientes() {
        return cantMinimaDeClientes;
    }

    public void setCantMinimaDeClientes(int cantMinimaDeClientes) {
        this.cantMinimaDeClientes = cantMinimaDeClientes;
    }

    @Override
    public double montoAPagar(int cantidadMaxDeClientesEnPaquete) {
        return cantidadMaxDeClientesEnPaquete > getCantMinimaDeClientes() ? getImporteBase() -
                (cantidadMaxDeClientesEnPaquete - getCantMinimaDeClientes()) * 0.005 * getImporteBase() :
                getImporteBase();
    }
}
