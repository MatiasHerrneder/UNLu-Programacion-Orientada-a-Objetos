public class Auto extends Vehiculo {
    private int cantAsientos;

    public Auto(String patente, int cantAsientos) {
        super(patente);
        setCantAsientos(cantAsientos);
    }

    public int getCantAsientos() {
        return cantAsientos;
    }

    public void setCantAsientos(int cantAsientos) {
        this.cantAsientos = cantAsientos;
    }

    @Override
    public double costoDeAlquiler(int dias) {
        return dias * (3000 + 300 * getCantAsientos());
    }
}
