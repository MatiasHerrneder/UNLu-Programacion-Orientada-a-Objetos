package ar.edu.unlu.poo.tp2.ej8;

import java.time.Year;

public class Revista extends PublicacionPrestable {
    private String issn;
    private int nroDePublicacion;
    private Year anioDePublicacion;

    public Revista(String nombre, String editor, String telefonoProveedor, String issn, int nroDePublicacion,
                   Year anioDePublicacion, int cantidadTotalDeEjemplares) {
        super(nombre, editor, telefonoProveedor, cantidadTotalDeEjemplares);
        setIssn(issn);
        setNroDePublicacion(nroDePublicacion);
        setAnioDePublicacion(anioDePublicacion);
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getNroDePublicacion() {
        return nroDePublicacion;
    }

    public void setNroDePublicacion(int nroDePublicacion) {
        this.nroDePublicacion = nroDePublicacion;
    }

    public Year getAnioDePublicacion() {
        return anioDePublicacion;
    }

    public void setAnioDePublicacion(Year anioDePublicacion) {
        this.anioDePublicacion = anioDePublicacion;
    }

    @Override
    public String descripcion() {
        return "La revista " + getNombre() +
                ", issn " + getIssn() +
                ", publicacion numero " + getNroDePublicacion() +
                ", editada por " + getEditor() +
                " en el año " + getAnioDePublicacion();
    }
}
