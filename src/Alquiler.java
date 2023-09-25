import java.time.LocalDate;

public class Alquiler {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double saldoAPagar;

    public Alquiler(LocalDate fechaInicio, LocalDate fechaFin, double saldoAPagar) {
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setSaldoAPagar(saldoAPagar);
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public double getSaldoAPagar() {
        return saldoAPagar;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setSaldoAPagar(double saldoAPagar) {
        this.saldoAPagar = saldoAPagar;
    }
}
