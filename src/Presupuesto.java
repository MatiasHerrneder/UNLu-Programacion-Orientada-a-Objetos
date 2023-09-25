import java.time.LocalDate;

public class Presupuesto {
    private int dias;
    private Vehiculo vehiculo;
    private LocalDate fechaDeEmision;
    private final double precio;
    private Alquiler alquiler = null;

    public Presupuesto(int dias, Vehiculo vehiculo) {
        setDias(dias);
        setVehiculo(vehiculo);
        setFechaDeEmision(LocalDate.now());
        precio = getVehiculo().costoDeAlquiler(getDias());
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaDeEmision() {
        return fechaDeEmision;
    }

    public void setFechaDeEmision(LocalDate fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public double getPrecio() {
        return precio;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void alquilar() {
        if (!seAlquilo()) {
            alquiler = new Alquiler(LocalDate.now(), LocalDate.now().plusDays(getDias()), precio);
        }
    }

    public boolean seAlquilo() {
        return alquiler != null;
    }

}
