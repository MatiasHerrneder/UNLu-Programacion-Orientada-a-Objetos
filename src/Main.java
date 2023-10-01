import ar.edu.unlu.poo.tp2.ej14.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Administrador adm = new Administrador();
        adm.agregarProveedor(new Hospedaje("123", 123, "123", 100, 20));
        adm.agregarProveedor(new Transporte("456", 456, "456", 90));
        adm.agregarProveedor(new GuiaTuristico("789", 789, "789" ,40));
        adm.agregarPaquete(new Paquete("Lujan", 30));

        adm.getPaquetes().get(0).agregarProveedor(adm.getProveedores().get(0));
        adm.getPaquetes().get(0).agregarProveedor(adm.getProveedores().get(1));
        adm.getPaquetes().get(0).agregarProveedor(adm.getProveedores().get(2));

        adm.agregarCliente(new Cliente("1", 1, "1"));
        adm.agregarCliente(new Cliente("2", 2, "2"));
        adm.agregarCliente(new Cliente("3", 3, "3"));
        adm.agregarCliente(new Cliente("4", 4, "4"));

        adm.getPaquetes().get(0).agregarVenta(new Venta(LocalDate.now(), 20, adm.getClientes().get(0)));
        adm.getPaquetes().get(0).agregarVenta(new Venta(LocalDate.now(), 5, adm.getClientes().get(1)));
        adm.getPaquetes().get(0).agregarVenta(new Venta(LocalDate.now(), 2, adm.getClientes().get(0)));
        adm.getPaquetes().get(0).agregarVenta(new Venta(LocalDate.now(), 7, adm.getClientes().get(2)));
        adm.getPaquetes().get(0).agregarVenta(new Venta(LocalDate.now(), 3, adm.getClientes().get(3)));

        adm.ventasPorDestino();
        adm.destinoFavorito();
        adm.datosProveedores();
    }
}