package ar.edu.unlu.poo.tp2.ej2;

import java.util.ArrayList;

public class ProveedorExcursion extends Proveedor{

    public ProveedorExcursion(String razonSocial, String cuil) {
        super(razonSocial, cuil);
    }

    public ArrayList<String> getExcursiones() {
        return super.getServicios();
    }

    public void agregarExcursion(String excursion) {
        super.agregarServicio(excursion);
    }

    public void borrarExcursion(String excursion) {
        super.borrarServicio(excursion);
    }
}
