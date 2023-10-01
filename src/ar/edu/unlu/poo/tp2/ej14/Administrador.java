package ar.edu.unlu.poo.tp2.ej14;

import java.time.LocalDate;
import java.util.ArrayList;

public class Administrador {
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Paquete> paquetes = new ArrayList<>();
    private final ArrayList<Proveedor> proveedores = new ArrayList<>();

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        getClientes().add(cliente);
    }

    public ArrayList<Paquete> getPaquetesVendidos() {
        ArrayList<Paquete> res = new ArrayList<>();
        for (Paquete p : getPaquetes()) {
            if (p.estaCerrado()) {
                res.add(p);
            }
        }
        return res;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void agregarPaquete(Paquete paquete) {
        getPaquetes().add(paquete);
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void agregarProveedor(Proveedor proveedor) {
        getProveedores().add(proveedor);
    }

    public void ventasPorDestino() {
        ArrayList<ArrayList<Venta>> ventaPorDestino = new ArrayList<>();
        ArrayList<String> destinos = new ArrayList<>();
        System.out.println("-- Mostrando ventas por destino");
        for (Paquete p : getPaquetesVendidos()) {
            for (Venta v : p.getVentas()) {
                if (v.getFecha().getYear() == LocalDate.now().getYear() &&
                        v.getFecha().getMonth() == LocalDate.now().getMonth()) {
                    int pos = destinos.indexOf(p.getDestino());
                    if (pos < 0) {
                        pos = ventaPorDestino.size();
                        destinos.add(p.getDestino());
                        ventaPorDestino.add(new ArrayList<>());
                    }
                    ventaPorDestino.get(pos).add(v);
                }
            }
        }
        for (int i = 0; i < ventaPorDestino.size(); i++) {
            System.out.println("- Destino: " + destinos.get(i));
            for (Venta j : ventaPorDestino.get(i)) {
                System.out.println(j.toString());
            }
        }
    }

    public void destinoFavorito() {
        ArrayList<String> destinos = new ArrayList<>();
        ArrayList<Integer> frec = new ArrayList<>();
        for (Paquete p : getPaquetesVendidos()) {
            int pos = destinos.indexOf(p.getDestino());
            if (pos < 0) {
                destinos.add(p.getDestino());
                frec.add(1);
            }
            else {
                frec.set(pos, frec.get(pos) + 1);
            }
        }
        int max = 0;
        int posMax = 0;
        for (int i = 0; i < destinos.size(); i++) {
            if (frec.get(i) > max) {
                max = frec.get(i);
                posMax = i;
            }
        }
        System.out.println("-- El destino favorito de los clientes es " + destinos.get(posMax));
    }

    public void datosProveedores() {
        System.out.println("-- Mostrando listado de proveedores: ");
        for (Proveedor p : getProveedores()) {
            System.out.println(p.getRazonSocial() + ", tipo: " + p.getClass().getSimpleName() + ", contacto: "
                    + p.getTelefono());
        }
    }

}
