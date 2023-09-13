package ar.edu.unlu.poo.tp2.ej2;

import java.util.ArrayList;

public class ProveedorHospedaje extends Proveedor {

    public ProveedorHospedaje(String razonSocial, String cuil) {
        super(razonSocial, cuil);
    }

    public ArrayList<String> getHospedajes() {
        return super.getServicios();
    }

    public void agregarHospedaje(String hospedaje) {
        super.agregarServicio(hospedaje);
    }

    public void borrarHospedaje(String hospedaje) {
        super.borrarServicio(hospedaje);
    }
}
