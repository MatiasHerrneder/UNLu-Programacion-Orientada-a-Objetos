package ar.edu.unlu.poo.tp2.ej14;

import java.util.ArrayList;

public class Paquete {
    private String destino;
    private int cantMaxClientes;
    private final Proveedor[] proveedores = new Proveedor[3];
    private final ArrayList<Venta> ventas = new ArrayList<>();

    public Paquete(String destino, int cantMaxClientes) {
        setDestino(destino);
        setCantMaxClientes(cantMaxClientes);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCantMaxClientes() {
        return cantMaxClientes;
    }

    public void setCantMaxClientes(int cantMaxClientes) {
        this.cantMaxClientes = cantMaxClientes;
    }

    public Proveedor[] getProveedores() {
        return proveedores;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void agregarVenta(Venta venta) {
        if (!estaCerrado() && cantClientes() + venta.getUnidades() <= getCantMaxClientes()) {
            getVentas().add(venta);
        }
    }

    public boolean estaCerrado(int toleranciaEspaciosSinLlenar) {
        return getCantMaxClientes() - cantClientes() - toleranciaEspaciosSinLlenar <= 0;
    }

    public boolean estaCerrado() {
        return estaCerrado(0);
    }

    public int cantClientes() {
        int r = 0;
        for (Venta v : getVentas()) {
            r += v.getUnidades();
        }
        return r;
    }

    public void agregarProveedor(Proveedor proveedor) {
        if (getProveedores()[0] == null) {
            getProveedores()[0] = proveedor;
        }
        else if (getProveedores()[1] == null) {
            getProveedores()[1] = proveedor;
        }
        else if (getProveedores()[2] == null) {
            getProveedores()[2] = proveedor;
        }
    }
}
