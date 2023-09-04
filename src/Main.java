import ar.edu.unlu.poo.tp1.ej10.AdministradorDeTareas;
import ar.edu.unlu.poo.tp1.ej10.Prioridades;
import ar.edu.unlu.poo.tp1.ej10.Tarea;

public class Main {
    public static void main(String[] args) {
        AdministradorDeTareas admTareas = new AdministradorDeTareas();
        admTareas.crearTarea("Ir al supermercado mañana", Prioridades.BAJA, "2023-11-09", "2023-11-06");
        Tarea tej = admTareas.crearTarea("Consultar repuesto del auto", Prioridades.BAJA, "2023-11-09", "2023-08-28");
        admTareas.crearTarea("Ir al cine a ver la nueva pelicula de Marvel", Prioridades.BAJA, "2023-08-28");
        System.out.println("--Antes de consultar las tareas: --");
        System.out.println("Prioridad de 'Consultar repuesto del auto': " + tej.getPrioridad());
        System.out.println("\n--Ahora consulto las tareas cargadas--");
        admTareas.mostrarTareas();
        System.out.println("\n--Luego de consultar las tareas: --");
        System.out.println("Prioridad de 'Consultar repuesto del auto': " + tej.getPrioridad());
    }
}