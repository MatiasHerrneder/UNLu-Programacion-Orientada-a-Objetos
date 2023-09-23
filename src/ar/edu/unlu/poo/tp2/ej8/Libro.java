package ar.edu.unlu.poo.tp2.ej8;

import java.time.Year;
import java.util.ArrayList;

public class Libro extends PublicacionPrestable {
    private String isbn;
    private Year anioDePublicacion;
    private final ArrayList<String> autores = new ArrayList<>();


    public Libro(String nombre, String editor, String telefonoProveedor, String isbn, Year anioDePublicacion,
                 int cantidadTotalDeEjemplares) {
        super(nombre, editor, telefonoProveedor, cantidadTotalDeEjemplares);
        setIsbn(isbn);
        setAnioDePublicacion(anioDePublicacion);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Year getAnioDePublicacion() {
        return anioDePublicacion;
    }

    public void setAnioDePublicacion(Year anioDePublicacion) {
        this.anioDePublicacion = anioDePublicacion;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public String getStringAutores() {
        StringBuilder res = new StringBuilder();
        for (String a : getAutores()) {
            res.append(a).append(", ");
        }
        return res.toString();
    }

    public void quitarAutor(String autor) {
        getAutores().remove(autor);
    }

    public void agregarAutor(String autor) {
        getAutores().add(autor);
    }

    @Override
    public String descripcion() {
        return "El libro " + getNombre() +
                ", isbn " + getIsbn() +
                ", de los autores " + getStringAutores() +
                ", fue editado por " + getEditor() +
                " en el año " + getAnioDePublicacion();
    }
}
