package ar.edu.unlu.poo.tp2.ej2;

import java.util.ArrayList;

public class Paquete {
    private String destino;
    private ProveedorMedioDeTransporte medioDeTransporte;
    private final ArrayList<String> excursiones;
    private ProveedorHospedaje hospedaje;

    public Paquete(String destino, ArrayList<String> excursiones,
                   ProveedorMedioDeTransporte medioDeTransporte, ProveedorHospedaje hospedaje) {
            setDestino(destino);
            this.excursiones = excursiones;
            setHospedaje(hospedaje);
            setMedioDeTransporte(medioDeTransporte);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public ProveedorMedioDeTransporte getMedioDeTransporte() {
        return medioDeTransporte;
    }

    public void setMedioDeTransporte(ProveedorMedioDeTransporte medioDeTransporte) {
        this.medioDeTransporte = medioDeTransporte;
    }

    public ArrayList<String> getExcursiones() {
        return excursiones;
    }

    public void agregarExcursion(String excursion) {
        getExcursiones().add(excursion);
    }

    public void eliminarExcursion(String excursion) {
        getExcursiones().remove(excursion);
    }

    public ProveedorHospedaje getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(ProveedorHospedaje hospedaje) {
        this.hospedaje = hospedaje;
    }

    public String mostrarInformacion() {
        return getDestino() + ", " + getHospedaje().datos() + ", " + getMedioDeTransporte().datos() + ", " + getExcursiones();
    }
}
