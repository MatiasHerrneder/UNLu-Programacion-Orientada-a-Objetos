package ar.edu.unlu.poo.tp2.ej6;

import java.util.ArrayList;
import java.util.Comparator;

public class ModuloInformes {
    private final ArrayList<Empleado> empleados = new ArrayList<>();
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Expendedor> expendedores = new ArrayList<>();

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Expendedor> getExpendedores() {
        return expendedores;
    }

    public void agregarCliente(String patente, String nombre) {
        getClientes().add(new Cliente(patente, nombre));
    }

    public void agregarEmpleado(String apellido, String direccion, String dni, String nombre, String telefono) {
        getEmpleados().add(new Empleado(apellido, direccion, dni, nombre, telefono));
    }

    public void agregarExpendedor(int codigo, Combustible combustible) {
        getExpendedores().add(new Expendedor(codigo, combustible));
    }

    public ArrayList<Cliente> informeTop10Clientes() {
        ArrayList<Cliente> res = new ArrayList<>(getClientes());
        Comparator<Cliente> comparador = new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return -Float.compare(o1.montoTotalDeCompras(), o2.montoTotalDeCompras());
            }
        };
        res.sort(comparador);

        while (res.size() > 10 || (!res.isEmpty() && res.get(res.size() - 1).montoTotalDeCompras() <= 0)){
            res.remove(res.size() - 1);
        }
        return res;
    }

    public void informeVentasXCombustible() {
        ArrayList<ArrayList<Venta>> ventasXComb = new ArrayList<>();
        for (int i = 0; i < Combustible.values().length; i++) {
            ventasXComb.add(new ArrayList<>());
        }
        for (Cliente cliente : getClientes()) {
            for (Venta venta : cliente.getVentas()) {
                ventasXComb.get(venta.getExpendedor().getCombustible().ordinal()).add(venta);
            }
        }
        for (int i = 0; i < ventasXComb.size(); i++) {
            System.out.println(Combustible.getCombustiblePorValor(i));
            for (int j = 0; j < ventasXComb.get(i).size(); j++) {
                System.out.println(ventasXComb.get(i).get(j).toString());
            }
        }
    }

    public void informeVentasXSurtidor() {
        ArrayList<ArrayList<Venta>> ventasXSurtidor = new ArrayList<>();
        for (int i = 0; i < getExpendedores().size(); i++) {
            ventasXSurtidor.add(new ArrayList<>());
        }
        for (Cliente cliente : getClientes()) {
            for (Venta venta : cliente.getVentas()) {
                ventasXSurtidor.get(getExpendedores().indexOf(venta.getExpendedor())).add(venta);
            }
        }
        for (int i = 0; i < ventasXSurtidor.size(); i++) {
            System.out.println(getExpendedores().get(i).getCodigo());
            for (int j = 0; j < ventasXSurtidor.get(i).size(); j++) {
                System.out.println(ventasXSurtidor.get(i).get(j).toString());
            }
        }
    }

    public void informeLitrosXSurtidor() {
        ArrayList<Float> litrosXSurtidor = new ArrayList<>();
        for (int i = 0; i < getExpendedores().size(); i++) {
            litrosXSurtidor.add((float) 0);
        }
        for (Cliente cliente : getClientes()) {
            for (Venta venta : cliente.getVentas()) {
                int indice = getExpendedores().indexOf(venta.getExpendedor());
                litrosXSurtidor.set(indice, litrosXSurtidor.get(indice) + venta.getLitros());
            }
        }
        for (int i = 0; i < litrosXSurtidor.size(); i++) {
            System.out.println("El surtidor: " + getExpendedores().get(i).getCodigo() + ", vendio " +
                                litrosXSurtidor.get(i) + " litros.");
        }
    }

    public void informeVentasXEmpleado() {
        ArrayList<ArrayList<Venta>> ventasXEmp = new ArrayList<>();
        for (int i = 0; i < getEmpleados().size(); i++) {
            ventasXEmp.add(new ArrayList<>());
        }
        for (Cliente cliente : getClientes()) {
            for (Venta venta : cliente.getVentas()) {
                ventasXEmp.get(getEmpleados().indexOf(venta.getEmpleado())).add(venta);
            }
        }
        for (int i = 0; i < ventasXEmp.size(); i++) {
            System.out.println(getEmpleados().get(i).getApellido());
            for (int j = 0; j < ventasXEmp.get(i).size(); j++) {
                System.out.println(ventasXEmp.get(i).get(j).toString());
            }
        }
    }
}
