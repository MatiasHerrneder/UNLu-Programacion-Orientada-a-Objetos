import ar.edu.unlu.poo.tp.ej9.Fecha;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate f1 = Fecha.stringAFecha("10-20-2023");
        LocalDate f2 = Fecha.stringAFecha("30-11-2023");
        LocalDate f3 = Fecha.stringAFecha("11-12-2023");
        LocalDate f4 = Fecha.stringAFecha("20-20-2020");
        System.out.println("Convirtiendo los strings a fechas:\n" +
                "Inputs:\n" +
                "10-20-2023\n" +
                "30-11-2023\n" +
                "11-12-2020\n" +
                "20-20-2020\n" +
                "Outputs:\n" + f1 + "\n" + f2 + "\n" + f3 + "\n" + f4);
        if (f1 != null && f2 != null && f3 != null) {
            System.out.println("Como " + f1 + ", " + f2 + " y " + f3 + " son validas, pruebo:");
            System.out.println("Es " + f1 + " menor que " + f2 + "?: " + Fecha.esMenorque(f1, f2));
            System.out.println("Es " + f3 + " mayor que " + f2 + "?: " + Fecha.esMayorque(f3, f2));
            System.out.println("Es " + f3 + " menor que " + f1 + "?: " + Fecha.esMenorque(f3, f1));
            System.out.println("Se encuentra " + f2 + " entre " + f1 + " y " + f3 + "?: " + Fecha.estaEntreFechas(f2, f1, f3));
        }
    }
}