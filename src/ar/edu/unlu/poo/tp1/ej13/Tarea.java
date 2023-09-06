package ar.edu.unlu.poo.tp1.ej13;

import java.time.LocalDate;

public class Tarea {

    private String descripcion;
    private Prioridades prioridad;
    private boolean estado;
    private LocalDate fechaLimite;
    private LocalDate fechaDeRecordatorio;
    private LocalDate fechaDeFinalizacion = null;
    private Colaborador finalizadaPor = null;

    public Tarea(String descripcion, Prioridades prioridad, boolean estaCompleta, LocalDate fechaLimite, LocalDate fechaDeRecordatorio) {
        setDescripcion(descripcion);
        setPrioridad(prioridad);
        setEstado(estaCompleta);
        setFechaLimite(fechaLimite);
        setFechaDeRecordatorio(fechaDeRecordatorio);
    }

    public Tarea(String descripcion, Prioridades prioridad, boolean estaCompleta, LocalDate fechaLimite) {
        this(descripcion, prioridad, estaCompleta, fechaLimite, null);
    }

    public Tarea(String descripcion, Prioridades prioridad, LocalDate fechaLimite, LocalDate fechaDeRecordatorio) {
        this(descripcion, prioridad, false, fechaLimite, fechaDeRecordatorio);
    }

    public Tarea(String descripcion, Prioridades prioridad, LocalDate fechaLimite) {
        this(descripcion, prioridad, false, fechaLimite);
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

    private void setFechaDeFinalizacion(LocalDate fechaDeFinalizacion) {
        this.fechaDeFinalizacion = fechaDeFinalizacion;
    }

    private void setFinalizadaPor(Colaborador finalizadaPor) {
        this.finalizadaPor = finalizadaPor;
    }

    public Colaborador getFinalizadaPor() {
        return finalizadaPor;
    }

    public LocalDate getFechaDeFinalizacion() {
        return fechaDeFinalizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setFechaDeRecordatorio(LocalDate fechaDeRecordatorio) {
        this.fechaDeRecordatorio = fechaDeRecordatorio;
    }

    public LocalDate getFechaDeRecordatorio() {
        return fechaDeRecordatorio;
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
        String s = "";
        if (estaVencida()) {
            s = "(Vencida) ";
        }
        else if (recordatorioVencido()) {
            s = "(Por vencer) ";
        }
        return s + getDescripcion() + "[" + getFechaLimite() + " " + getPrioridad() + "]";
    }

    public boolean estaVencida() {
        return (LocalDate.now().isAfter(getFechaLimite()));
    }

    public boolean recordatorioVencido() {
        if (getFechaDeRecordatorio() != null && LocalDate.now().isAfter(getFechaDeRecordatorio())) {
            setPrioridad(Prioridades.ALTA);
            return true;
        }
        return false;
    }

    public void finalizar(Colaborador colaborador){
        setFechaDeFinalizacion(LocalDate.now());
        setFinalizadaPor(colaborador);
        setEstado(true);
    }
}
