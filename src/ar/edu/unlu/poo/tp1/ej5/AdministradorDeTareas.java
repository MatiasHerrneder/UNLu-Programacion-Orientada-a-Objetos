package ar.edu.unlu.poo.tp1.ej5;

import java.time.LocalDate;
import java.util.ArrayList;

public class AdministradorDeTareas {

    ArrayList<Tarea> tareas = new ArrayList<>();

    public void crearTarea(String descripcion, Prioridades prioridad, boolean completa, String fechaVenc){

        tareas.add(new Tarea(descripcion, prioridad, completa, LocalDate.parse(fechaVenc)));
    }

    public void crearTarea(String descripcion, Prioridades prioridad, boolean completa){
        tareas.add(new Tarea(descripcion, prioridad, completa));
    }

    public void crearTarea(String descripcion, Prioridades prioridad, String fechaVenc){
        tareas.add(new Tarea(descripcion, prioridad, LocalDate.parse(fechaVenc)));
    }

    public void crearTarea(String descripcion, Prioridades prioridad){
        tareas.add(new Tarea(descripcion, prioridad));
    }

    public void mostrarTareas() {
        tareas.forEach((n) -> System.out.println(n.mostrarTarea()));
    }

}