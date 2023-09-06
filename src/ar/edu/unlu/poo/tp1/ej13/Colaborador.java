package ar.edu.unlu.poo.tp1.ej13;

import java.util.ArrayList;

public class Colaborador {
    private String nombre;
    private ArrayList<Tarea> tareasFinalizadas = new ArrayList<>();
    public Colaborador(String nombre) {
        setNombre(nombre);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void finalizarTarea(Tarea tarea) {
        tarea.finalizar(this);
        tareasFinalizadas.add(tarea);
    }

    public ArrayList<Tarea> getTareasFinalizadas(){
        return tareasFinalizadas;
    }
}
