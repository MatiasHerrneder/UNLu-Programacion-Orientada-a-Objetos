package ar.edu.unlu.poo.tp1.ej10;

import java.time.LocalDate;
import java.util.ArrayList;

public class AdministradorDeTareas {

    ArrayList<Tarea> tareas = new ArrayList<>();

    public Tarea crearTarea(String descripcion, Prioridades prioridad, String fechaVenc, String fechaRecordatorio){
        Tarea n = new Tarea(descripcion, prioridad, LocalDate.parse(fechaVenc), LocalDate.parse(fechaRecordatorio));
        tareas.add(n);
        return n;
    }

    public Tarea crearTarea(String descripcion, Prioridades prioridad, String fechaVenc){
        Tarea n = new Tarea(descripcion, prioridad, LocalDate.parse(fechaVenc));
        tareas.add(n);
        return n;
    }

    public void mostrarTareas() {
        tareas.forEach((n) -> System.out.println(n.mostrarTarea()));
    }
}