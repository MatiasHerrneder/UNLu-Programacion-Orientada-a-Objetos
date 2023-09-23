package ar.edu.unlu.poo.tp2.ej8;

import java.time.LocalDate;

public class Diario extends Publicacion {
    private LocalDate fechaDePublicacion;

    public Diario(String nombre, String editor, String telefonoProveedor, LocalDate fechaDePublicacion) {
        super(nombre, editor, telefonoProveedor);
        setFechaDePublicacion(fechaDePublicacion);
    }

    public LocalDate getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(LocalDate fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    @Override
    public String descripcion() {
        return "El diario " +  getNombre() +
                ", editado por " + getEditor() +
                ", fue publicado el " + getFechaDePublicacion();
    }
}
