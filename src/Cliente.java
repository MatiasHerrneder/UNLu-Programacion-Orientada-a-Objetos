import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String cuit;
    private final ArrayList<Presupuesto> presupuestos = new ArrayList<>();

    public Cliente(String nombre, String cuit) {
        setNombre(nombre);
        setCuit(cuit);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public ArrayList<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    public void agregarPresupuesto(int dias, Vehiculo vehiculo) {
        getPresupuestos().add(new Presupuesto(dias, vehiculo));
    }

    public double montoTotalAlquilado() {
        double res = 0;
        for (Presupuesto p : getPresupuestos()) {
            if (p.seAlquilo()) res += p.getAlquiler().getSaldoAPagar();
        }
        return res;
    }

}
