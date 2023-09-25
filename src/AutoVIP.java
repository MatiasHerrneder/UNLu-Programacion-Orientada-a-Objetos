public class AutoVIP extends Auto {

    public AutoVIP(String patente, int cantAsientos) {
        super(patente, cantAsientos);
    }

    @Override
    public double costoDeAlquiler(int dias) {
        return dias * (3000 + 500 * getCantAsientos());
    }
}
