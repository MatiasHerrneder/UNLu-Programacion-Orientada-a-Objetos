package ar.edu.unlu.poo.tp1.ej5;

import java.time.LocalDate;

public class Tarea {

    private String descripcion;
    private Prioridades prioridad;
    private boolean estado;
    private LocalDate fechaLimite;

    public Tarea(String descripcion, Prioridades prioridad, boolean estaCompleta, LocalDate fecha) {
        setDescripcion(descripcion);
        setPrioridad(prioridad);
        setEstado(estaCompleta);
        setFechaLimite(fecha);
    }

    public Tarea(String descripcion, Prioridades prioridad, LocalDate fecha) {
        this(descripcion, prioridad, false, fecha);
    }

    public Tarea(String descripcion, Prioridades prioridad, boolean estaCompleta) {
        this(descripcion, prioridad, estaCompleta, null);
    }

    public Tarea(String descripcion, Prioridades prioridad) {
        this(descripcion, prioridad, null);
    }

    public void setEstado(boolean estaCompleta) {
        this.estado = estaCompleta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(Prioridades prioridad) {
        this.prioridad = prioridad;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Prioridades getPrioridad() {
        return prioridad;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public boolean estaCompleta() {
        return estado;
    }

    public String mostrarTarea() {
        if (estaVencida()) {
            return "(Vencida) " + getDescripcion();
        }
        return getDescripcion();
    }

    public boolean estaVencida() {
        return fechaLimite.isBefore(LocalDate.now());
    }
}
