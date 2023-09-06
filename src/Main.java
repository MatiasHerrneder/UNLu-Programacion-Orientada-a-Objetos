import ar.edu.unlu.poo.tp1.ej12.AdministradorDeTareas;
import ar.edu.unlu.poo.tp1.ej12.Prioridades;
import ar.edu.unlu.poo.tp1.ej12.Tarea;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AdministradorDeTareas admTareas = new AdministradorDeTareas();
        admTareas.crearTarea("T1", Prioridades.BAJA, "2023-11-10", "2023-11-06");
        admTareas.crearTarea("T2", Prioridades.BAJA, "2023-11-09", "2023-08-28");
        admTareas.crearTarea("T3", Prioridades.BAJA, "2023-11-11");
        admTareas.crearTarea("T4", Prioridades.BAJA, "2023-08-28");
        admTareas.crearTarea("T122", Prioridades.BAJA, "2023-11-03");
        admTareas.mostrarTareasVigentes();
        System.out.println("--- Ahora muestro que tareas contienen el numero 2 en su nombre ---");
        ArrayList<Tarea> misTareas = admTareas.buscarTareas("2");
        for (Tarea t : misTareas) {
            System.out.println(t.mostrarTarea());
        }
        System.out.println("--- Las marco como realizadas y muestro todas las tareas ---");
        for (Tarea t : misTareas) {
            t.setEstado(true);
        }
        admTareas.mostrarTareasVigentes();
    }
}