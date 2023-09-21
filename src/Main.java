import ar.edu.unlu.poo.tp2.ej7.Cliente;
import ar.edu.unlu.poo.tp2.ej7.Combustible;
import ar.edu.unlu.poo.tp2.ej7.ModuloInformes;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ModuloInformes a = new ModuloInformes();
        a.agregarCliente("1", "1");
        a.agregarCliente("2", "1");
        a.agregarCliente("3", "1");
        a.agregarCliente("4", "1");
        a.agregarCliente("5", "1");
        a.agregarCliente("6", "1");
        a.agregarCliente("7", "1");
        a.agregarCliente("8", "1");
        a.agregarCliente("9", "1");
        a.agregarCliente("10", "1");
        a.agregarCliente("11", "1");
        a.agregarCliente("12", "1");

        a.agregarEmpleado("1", "1", "1", "1", "1");
        a.agregarEmpleado("2", "1", "1", "1", "1");
        a.agregarEmpleado("3", "1", "1", "1", "1");
        a.agregarEmpleado("4", "1", "1", "1", "1");

        a.agregarExpendedor(1, Combustible.NAFTA);
        a.agregarExpendedor(2, Combustible.GASOIL);
        a.agregarExpendedor(3, Combustible.KEROSENE);

        a.getClientes().get(0).agregarVenta(LocalDate.now(), 100, a.getExpendedores().get(0), a.getEmpleados().get(0), 10, a.informeTop10Clientes());
        a.getClientes().get(0).agregarVenta(LocalDate.now(), 10, a.getExpendedores().get(0), a.getEmpleados().get(1), 1, a.informeTop10Clientes());
        //a.getClientes().get(1).agregarVenta(LocalDate.now(), 20, a.getExpendedores().get(1), a.getEmpleados().get(2), 5, a.informeTop10Clientes());
        a.getClientes().get(1).agregarVentaConDescuentoDeEmpleado(LocalDate.now(), 20, a.getExpendedores().get(1), a.getEmpleados().get(2), 5, a.informeTop10Clientes());
        a.getClientes().get(2).agregarVenta(LocalDate.now(), 400, a.getExpendedores().get(2), a.getEmpleados().get(0), 80, a.informeTop10Clientes());

        System.out.println("--- Informe top 10 clientes ---");
        for (Cliente x : a.informeTop10Clientes()) {
            System.out.println(x.toString());
        }
        System.out.println("--- Informe ventas x combustible ---");
        a.informeVentasXCombustible();
        System.out.println("--- Informe ventas x surtidor ---");
        a.informeVentasXSurtidor();
        System.out.println("--- Informe litros x surtidor ---");
        a.informeLitrosXSurtidor();
        System.out.println("--- Informe ventas x empleado ---");
        a.informeVentasXEmpleado();
    }
}