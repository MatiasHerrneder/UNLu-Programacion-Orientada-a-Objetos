package ar.edu.unlu.poo.tp2.ej1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Actividad actividad = (Actividad) obj;
        return Objects.equals(descripcion, actividad.descripcion);
    }
}
