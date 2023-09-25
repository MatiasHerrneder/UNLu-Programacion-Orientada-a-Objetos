public class Combi extends Vehiculo {

    public Combi(String patente) {
        super(patente);
    }

    @Override
    public double costoDeAlquiler(int dias) {
        return dias * 4500;
    }
}
