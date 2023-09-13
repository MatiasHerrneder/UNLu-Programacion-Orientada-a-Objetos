package ar.edu.unlu.poo.tp2.ej2;

import java.util.ArrayList;

public class ProveedorMedioDeTransporte extends Proveedor {
    public ProveedorMedioDeTransporte(String razonSocial, String cuil) {
        super(razonSocial, cuil);
    }

    public ArrayList<String> getMediosDeTransporte() {
        return super.getServicios();
    }

    public void agregarMeidoDeTransporte(String medioDeTransporte) {
        super.agregarServicio(medioDeTransporte);
    }

    public void borrarMedioDeTransporte(String medioDeTransporte) {
        super.borrarServicio(medioDeTransporte);
    }
}
