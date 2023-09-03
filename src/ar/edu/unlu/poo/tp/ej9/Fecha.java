package ar.edu.unlu.poo.tp.ej9;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
    static public LocalDate stringAFecha(String fecha) {
        LocalDate localDate;
        try {
            DateTimeFormatter dma = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            localDate = LocalDate.parse(fecha, dma);
        }
        catch (Exception e) {
            try {
                DateTimeFormatter mda = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                localDate = LocalDate.parse(fecha, mda);
            }
            catch (Exception f) {
                return null;
            }
        }
        return localDate;
    }

    static public boolean esMenorque(LocalDate fecha, LocalDate otra) {
        return fecha.isBefore(otra);
    }

    static public boolean esMayorque(LocalDate fecha, LocalDate otra) {
        return fecha.isAfter(otra);
    }

    static public boolean estaEntreFechas(LocalDate fecha, LocalDate anterior, LocalDate posterior) {
        return (esMenorque(fecha, posterior) && esMayorque(fecha, anterior));
    }

}