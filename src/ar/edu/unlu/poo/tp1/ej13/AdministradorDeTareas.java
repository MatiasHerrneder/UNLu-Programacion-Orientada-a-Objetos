package ar.edu.unlu.poo.tp1.ej13;

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

    private ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void mostrarTodasLasTareas() {
        tareas.forEach((n) -> System.out.println(n.mostrarTarea()));
    }

    public void mostrarTareasVigentes() {
        ArrayList<Tarea> lt = ordenarTareas(getTareas());
        for (Tarea t : lt) {
            System.out.println(t.mostrarTarea());
        }
    }

    private ArrayList<Tarea> ordenarTareas(ArrayList<Tarea> tareas) {
        ArrayList<Tarea> r = new ArrayList<>();
        for (Tarea t : tareas) {
            //no vencidas() prioridad -> fecha de venc
            if (!t.estaVencida() && !t.estaCompleta()) {
                int i = 0;
                t.recordatorioVencido();
                while (i < r.size() && r.get(i).getPrioridad().ordinal() > t.getPrioridad().ordinal()){
                    i++;
                }
                while (i < r.size() && r.get(i).getPrioridad().ordinal() > t.getPrioridad().ordinal() && r.get(i).getFechaLimite().isBefore(t.getFechaLimite())) {
                    i++;
                }
                r.add(i, t);
            }
        }
        return r;
    }

    public ArrayList<Tarea> buscarTareas(String descripcion) {
        /*
        int i = 0;
        Tarea r = null;
        while (i < getTareas().size() && r == null) {
            if (getTareas().get(i).getDescripcion().contains(descripcion)) {
                r = getTareas().get(i);
            }
            i++;
        }
        return r;
        */
        ArrayList<Tarea> lt = ordenarTareas(getTareas());
        ArrayList<Tarea> res = new ArrayList<>();
        for (Tarea t : lt) {
            if (t.getDescripcion().contains(descripcion)) {
                res.add(t);
            }
        }
        return res;
    }

}