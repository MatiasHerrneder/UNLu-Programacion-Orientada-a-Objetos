public class Camioneta extends Vehiculo {
    private static double PAT = 3;

    public Camioneta(String patente) {
        super(patente);
    }

    public static double getPAT() {
        return PAT;
    }

    public static void setPAT(double PAT) {
        Camioneta.PAT = PAT;
    }

    @Override
    public double costoDeAlquiler(int dias) {
        return dias * (3000 + 600 * getPAT());
    }
}
