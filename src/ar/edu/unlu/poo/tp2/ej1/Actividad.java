package ar.edu.unlu.poo.tp2.ej1;

public class Actividad {
    private String descripcion;

    public Actividad (String descripcion) {
        setDescripcion(descripcion);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
