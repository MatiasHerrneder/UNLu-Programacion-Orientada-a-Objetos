import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AdministradorVehiculos a = new AdministradorVehiculos();

        a.agregarAuto("12", 4);
        a.agregarAutoVIP("23", 2);
        a.agregarCombi("33");
        a.agregarCamioneta("543");
        a.agregarCamion("132");
        a.agregarAuto("33", 3); //patente repetida

        ArrayList<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("c1", "1"));
        clientes.add(new Cliente("c2", "2"));
        clientes.add(new Cliente("c3", "3"));

        clientes.get(0).agregarPresupuesto(10, a.buscarVehiculoPorPatente("12"));
        clientes.get(0).agregarPresupuesto(10, a.buscarVehiculoPorPatente("23"));
        clientes.get(0).agregarPresupuesto(5, a.buscarVehiculoPorPatente("33"));
        clientes.get(0).agregarPresupuesto(100, a.buscarVehiculoPorPatente("132"));
        clientes.get(1).agregarPresupuesto(12, a.buscarVehiculoPorPatente("543"));
        clientes.get(2).agregarPresupuesto(10, a.buscarVehiculoPorPatente("12"));

        clientes.get(0).getPresupuestos().get(0).alquilar();
        clientes.get(0).getPresupuestos().get(1).alquilar();
        clientes.get(0).getPresupuestos().get(2).alquilar();
        clientes.get(2).getPresupuestos().get(0).alquilar();

        double montoTotal = 0;
        for (Cliente c : clientes) {
            montoTotal += c.montoTotalAlquilado();
            System.out.println("El cliente " + c.getNombre() +
                    " alquilo en total un monto de " + c.montoTotalAlquilado());
        }
        System.out.println("EL MONTO TOTAL GENERADO ES DE " + montoTotal);

        clientes.get(0).getPresupuestos().get(3).alquilar();

        System.out.println("--- Cierro un presupuesto grande y pruebo de nuevo ---");

        montoTotal = 0;
        for (Cliente c : clientes) {
            montoTotal += c.montoTotalAlquilado();
            System.out.println("El cliente " + c.getNombre() +
                    " alquilo en total un monto de " + c.montoTotalAlquilado());
        }
        System.out.println("EL MONTO TOTAL GENERADO ES DE " + montoTotal);
    }
}