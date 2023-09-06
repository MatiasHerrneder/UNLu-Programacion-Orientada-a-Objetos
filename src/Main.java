import ar.edu.unlu.poo.tp1.ej13.AdministradorDeTareas;
import ar.edu.unlu.poo.tp1.ej13.Colaborador;
import ar.edu.unlu.poo.tp1.ej13.Prioridades;
import ar.edu.unlu.poo.tp1.ej13.Tarea;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AdministradorDeTareas admTareas = new AdministradorDeTareas();
        System.out.println("----- Muestro las tareas por su nombre, ademas incluyo entre corchetes la" +
                " fecha de vencimiento y prioridad que tienen, todas las creadas son con prioridad baja," +
                " cuando tengan prioridad alta es por la cercania al vencimiento -----");
        Colaborador c1 = new Colaborador("Colaborador1");
        Colaborador c2 = new Colaborador("Colabo2");
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
        System.out.println("--- Las marco como realizadas por distintos el colaborador 2 ---");
        for (Tarea t : misTareas) {
            c2.finalizarTarea(t);
        }
        System.out.println("--- Muestro todas las tareas pendientes ---");
        admTareas.mostrarTareasVigentes();
        System.out.println("--- Muestro las realizadas por el colaborador 2 ---");
        ArrayList<Tarea> tareasc2 = c2.getTareasFinalizadas();
        for (Tarea t : tareasc2) {
            System.out.println(t.mostrarTarea());
        }
        System.out.println("--- Colaborador 1 resuelve la tarea 1 ---");
        misTareas = admTareas.buscarTareas("1");
        c1.finalizarTarea(misTareas.get(0));
        System.out.println(c1.getTareasFinalizadas().get(0).mostrarTarea());
        System.out.println("--- Por ultimo vuelvo a mostrar todas las tareas vigentes ---");
        admTareas.mostrarTareasVigentes();
    }
}