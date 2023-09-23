package ar.edu.unlu.poo.tp2.ej8;

import java.time.Month;
import java.time.Year;

public class Tesis extends Publicacion {
    private String autor;
    private Month mesDePublicacion;
    private Year anioDePublicacion;

    public Tesis(String nombre, String editor, String telefonoProveedor, String autor, Month mesDePublicacion,
                 Year anioDePublicacion) {
        super(nombre, editor, telefonoProveedor);
        setAutor(autor);
        setMesDePublicacion(mesDePublicacion);
        setAnioDePublicacion(anioDePublicacion);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Month getMesDePublicacion() {
        return mesDePublicacion;
    }

    public void setMesDePublicacion(Month mesDePublicacion) {
        this.mesDePublicacion = mesDePublicacion;
    }

    public Year getAnioDePublicacion() {
        return anioDePublicacion;
    }

    public void setAnioDePublicacion(Year anioDePublicacion) {
        this.anioDePublicacion = anioDePublicacion;
    }

    @Override
    public String descripcion() {
        return "La tesis " +  getNombre() +
                ", editada por " + getEditor() +
                ", el autor es " + getAutor() +
                ", se publico el mes " + getMesDePublicacion() +
                " del año " + getAnioDePublicacion();
    }
}
