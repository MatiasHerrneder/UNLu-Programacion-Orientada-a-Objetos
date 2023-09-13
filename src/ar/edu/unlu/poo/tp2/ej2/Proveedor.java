package ar.edu.unlu.poo.tp2.ej2;

import java.util.ArrayList;

public class Proveedor {
    private String razonSocial;
    private String cuil;
    private final ArrayList<String> servicios = new ArrayList<>();

    protected Proveedor(String razonSocial, String cuil) {
        setCuil(cuil);
        setRazonSocial(razonSocial);
    }

    protected ArrayList<String> getServicios() {
        return servicios;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    protected void agregarServicio(String servicio) {
        getServicios().add(servicio);
    }

    protected void borrarServicio(String servicio) {
        getServicios().remove(servicio);
    }

    public String datos() {
        StringBuilder res = new StringBuilder();
        for (String s : getServicios()) {
            res.append(s).append(", ");
        }
        return res.toString();
    }
}
