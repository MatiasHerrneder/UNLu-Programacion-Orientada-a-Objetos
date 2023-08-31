package ar.edu.unlu.poo.tp1.ej6;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();

    public Libro crearLibro(String titulo, String autor, String isbn, int cantidadDePaginas, int cantDeEjemplares) {
        libros.add(new Libro(titulo, autor, isbn, cantidadDePaginas, cantDeEjemplares));
        return libros.get(libros.size()-1);
    }
    public Libro crearLibro(String titulo, String autor, int cantidadDePaginas, int cantDeEjemplares) {
        libros.add(new Libro(titulo, autor, cantidadDePaginas, cantDeEjemplares));
        return libros.get(libros.size()-1);
    }

    public boolean tieneMasPaginasQue(Libro l1, Libro l2) {
        return l1.getCantDePaginas() > l2.getCantDePaginas();
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }

    public int cantidadDePrestamosRealizados() {
        int c = 0;
        for (Libro libro : libros) {
            c += libro.getCantidadDePrestamosRealizados();
        }
        return c;
    }
}
