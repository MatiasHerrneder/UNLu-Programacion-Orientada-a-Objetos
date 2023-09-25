abstract public class Vehiculo {
    private String patente;

    public Vehiculo(String patente) {
        setPatente(patente);
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    abstract public double costoDeAlquiler(int dias);

}
