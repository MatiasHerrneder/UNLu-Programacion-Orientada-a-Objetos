package ar.edu.unlu.poo.tp2.ej2;

import java.util.ArrayList;

public class Administrador {
    private final ArrayList<String> destinos = new ArrayList<>();
    private final ArrayList<ProveedorHospedaje> proveedoresHospedaje = new ArrayList<>();
    private final ArrayList<ProveedorExcursion> proveedoresExcursiones = new ArrayList<>();
    private final ArrayList<ProveedorMedioDeTransporte> proveedoresMediosDeTransporte = new ArrayList<>();
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Paquete> paquetes = new ArrayList<>();

    public ArrayList<String> getDestinos() {
        return destinos;
    }

    public void agregarDestino(String destino) {
        getDestinos().add(destino);
    }

    public void eliminarDestino(String destino) {
        getDestinos().remove(destino);
    }

    public ArrayList<ProveedorExcursion> getProveedoresExcursiones() {
        return proveedoresExcursiones;
    }

    public void agregarProveedorExcursiones(ProveedorExcursion proveedorExcursion) {
        getProveedoresExcursiones().add(proveedorExcursion);
    }

    public void eliminarProveedorExcursiones(ProveedorExcursion proveedorExcursion) {
        getProveedoresExcursiones().remove(proveedorExcursion);
    }

    public ArrayList<ProveedorHospedaje> getProveedoresHospedaje() {
        return proveedoresHospedaje;
    }

    public void agregarProveedorHospedaje(ProveedorHospedaje proveedorHospedaje) {
        getProveedoresHospedaje().add(proveedorHospedaje);
    }

    public void eliminarProveedorHospedaje(ProveedorHospedaje proveedorHospedaje) {
        getProveedoresHospedaje().remove(proveedorHospedaje);
    }

    public ArrayList<ProveedorMedioDeTransporte> getProveedoresMediosDeTransporte() {
        return proveedoresMediosDeTransporte;
    }

    public void agregarProveedorMedioDeTransporte(ProveedorMedioDeTransporte proveedorMedioDeTransporte) {
        getProveedoresMediosDeTransporte().add(proveedorMedioDeTransporte);
    }

    public void eliminarProveedorMedioDeTransporte(ProveedorMedioDeTransporte proveedorMedioDeTransporte) {
        getProveedoresMediosDeTransporte().remove(proveedorMedioDeTransporte);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        getClientes().add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        getClientes().remove(cliente);
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void agregarPaquete(Paquete paquete) {
        getPaquetes().add(paquete);
    }

    public void eliminarPaquete(Paquete paquete) {
        getPaquetes().remove(paquete);
    }

    public ArrayList<Paquete> resumenDeVentas() {
        ArrayList<Paquete> res = new ArrayList<>();
        for (Cliente c : getClientes()) {
            for (Paquete pq : c.getPaquetesContratados()) {
                //insertar ordenado en res por destino
                int i = 0;
                while (i < res.size() && pq.getDestino().compareTo(res.get(i).getDestino()) < 0) {
                    i++;
                }
                res.add(pq);
            }
        }
        return res;
    }

    public String destinoFavorito() {
        ArrayList<Paquete> a = resumenDeVentas();
        int max = 0;
        int c = 1;
        String valMax = "";
        String ant = "";
        for (Paquete p : a) {
            if (p.getDestino().equals(ant)) {
                c++;
            }
            else {
                if (c > max) {
                    max = c;
                    valMax = ant;
                }
                c = 1;
                ant = p.getDestino();
            }
            if (c >= max) {
                valMax = ant;
            }
        }
        return valMax;
    }
}
