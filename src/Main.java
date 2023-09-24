import ar.edu.unlu.poo.tp2.ej10.*;

import java.time.Month;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Empleado> e = new ArrayList<>();
        e.add(new EmpAsalariado("", "", "", 1, Month.SEPTEMBER, 100));
        e.add(new EmpComision("", "", "", 1, Month.OCTOBER, 0.02, 5000));
        e.add(new EmpComisionConBase("", "", "", 1, Month.SEPTEMBER, 50, 0.01, 5000));
        e.add(new EmpHora("", "", "", 1, Month.OCTOBER, 10, 250));
        e.add(new Pasante("", "", "", 1, Month.SEPTEMBER));

        for (Empleado emp : e) {
            System.out.println(emp.calcularSueldo());
        }

    }
}