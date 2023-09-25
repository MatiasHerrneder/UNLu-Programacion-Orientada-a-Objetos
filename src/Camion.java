public class Camion extends Vehiculo {

    public Camion(String patente) {
        super(patente);
    }

    @Override
    public double costoDeAlquiler(int dias) {
        return dias > 30 ? 75000 * dias : 100000 * dias;
    }
}
