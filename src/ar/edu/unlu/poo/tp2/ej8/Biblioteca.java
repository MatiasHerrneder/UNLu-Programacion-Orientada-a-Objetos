package ar.edu.unlu.poo.tp2.ej8;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Libro> libros = new ArrayList<>();
    private final ArrayList<Revista> revistas = new ArrayList<>();
    private final ArrayList<Diario> diarios = new ArrayList<>();
    private final ArrayList<Tesis> tesis = new ArrayList<>();
    private final ArrayList<Socio> socios = new ArrayList<>();

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Revista> getRevistas() {
        return revistas;
    }

    public ArrayList<Diario> getDiarios() {
        return diarios;
    }

    public ArrayList<Tesis> getTesis() {
        return tesis;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void agregarLibro(String nombre, String editor, String telefonoProveedor, String isbn,
                             Year anioDePublicacion, int cantidadTotalDeEjemplares) {
        getLibros().add(new Libro(nombre, editor, telefonoProveedor, isbn, anioDePublicacion,
                            cantidadTotalDeEjemplares));
    }

    public void agregarRevista(String nombre, String editor, String telefonoProveedor, String issn,
                                int nroDePublicacion, Year anioDePublicacion, int cantidadTotalDeEjemplares) {
        getRevistas().add(new Revista(nombre, editor, telefonoProveedor, issn, nroDePublicacion, anioDePublicacion,
                                cantidadTotalDeEjemplares));
    }

    public void agregarDiario(String nombre, String editor, String telefonoProveedor, LocalDate fechaDePublicacion) {
        getDiarios().add(new Diario(nombre, editor, telefonoProveedor, fechaDePublicacion));
    }

    public void agregarTesis(String nombre, String editor, String telefonoProveedor, String autor,
                             Month mesDePublicacion, Year anioDePublicacion) {
        getTesis().add(new Tesis(nombre, editor, telefonoProveedor, autor, mesDePublicacion, anioDePublicacion));
    }

    public void agregarSocio(String nombre) {
        getSocios().add(new Socio(nombre));
    }

    public ArrayList<Libro> buscarLibrosPorNombre(String nombre) {
        ArrayList<Libro> res = new ArrayList<>();
        for (Libro x : getLibros()) {
            if (x.isNombre(nombre)) {
                res.add(x);
            }
        }
        return res;
    }

    public ArrayList<Revista> buscarRevistasPorNombre(String nombre) {
        ArrayList<Revista> res = new ArrayList<>();
        for (Revista x : getRevistas()) {
            if (x.isNombre(nombre)) {
                res.add(x);
            }
        }
        return res;
    }

    public ArrayList<Tesis> buscarTesisPorNombre(String nombre) {
        ArrayList<Tesis> res = new ArrayList<>();
        for (Tesis x : getTesis()) {
            if (x.isNombre(nombre)) {
                res.add(x);
            }
        }
        return res;
    }

    public ArrayList<Diario> buscarDiariosPorNombre(String nombre) {
        ArrayList<Diario> res = new ArrayList<>();
        for (Diario x : getDiarios()) {
            if (x.isNombre(nombre)) {
                res.add(x);
            }
        }
        return res;
    }

    public ArrayList<Socio> buscarSociosPorNombre(String nombre) {
        ArrayList<Socio> res = new ArrayList<>();
        for (Socio s : getSocios()) {
            if (s.isNombre(nombre)) {
                res.add(s);
            }
        }
        return res;
    }

    private void ejemplaresPrestados(ArrayList<? extends PublicacionPrestable> publicaciones) {
        for (PublicacionPrestable p : publicaciones) {
            System.out.println(p.descripcion());
            System.out.println("Se prestaron " + p.getCantidadDeEjemplaresPrestados() + " ejemplares");
            System.out.println("---------------------");
        }
    }

    public void librosPrestados() {
        ejemplaresPrestados(getLibros());
    }

    public void revistasPrestadas() {
        ejemplaresPrestados(getRevistas());
    }

    private void ejemplaresDisponiblesPorPublicacionPrestable(ArrayList<? extends PublicacionPrestable> publicaciones) {
        for (PublicacionPrestable p : publicaciones) {
            System.out.println(p.descripcion());
            System.out.println("Disponibles " + p.getCantidadDeEjemplaresDisponibles() + " ejemplares");
            System.out.println("---------------------");
        }
    }

    public void ejemplaresDisponiblesPorLibro() {
        ejemplaresDisponiblesPorPublicacionPrestable(getLibros());
    }

    public void ejemplaresDisponiblesPorRevista() {
        ejemplaresDisponiblesPorPublicacionPrestable(getRevistas());
    }

}
