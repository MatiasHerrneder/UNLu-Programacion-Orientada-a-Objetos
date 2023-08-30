package ar.edu.unlu.poo.tp1.ej5;

public class Main {
    public static void main(String[] args) {
        AdministradorDeTareas admTareas = new AdministradorDeTareas();
        admTareas.crearTarea("Ir al supermercado mañana", Prioridades.BAJA, "2023-11-09");
        admTareas.crearTarea("Consultar repuesto del auto", Prioridades.BAJA, true, "2023-08-28");
        admTareas.crearTarea("Ir al cine a ver la nueva pelicula de Marvel", Prioridades.BAJA, "2023-08-28");
        admTareas.mostrarTareas();
    }
}