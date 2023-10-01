package ar.edu.unlu.poo.tp2.ej14;

public class GuiaTuristico extends Proveedor {

    public GuiaTuristico(String razonSocial, int cuit, String telefono, double importeBase) {
        super(razonSocial, cuit, telefono, importeBase);
    }

    @Override
    public double montoAPagar(int cantidadDeClientes) {
        return cantidadDeClientes > 200 ? getImporteBase() + 90 : getImporteBase();
    }
}
