import ar.edu.unlu.poo.tp1.ej6.Biblioteca;
import ar.edu.unlu.poo.tp1.ej6.Libro;

public class Main {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        Libro l1 = b.crearLibro("Titulo1", "autor1", "isbn1", 200, 1);
        Libro l2 = b.crearLibro("Titulo2", "autor2", 100, 10);
        b.mostrarLibros();
        if (b.tieneMasPaginasQue(l1, l2)) {
            System.out.println("El libro " + l1.getTitulo() + ", tiene mas paginas que " + l2.getTitulo());
        }
        else {
            System.out.println("El libro " + l2.getTitulo() + ", tiene mas paginas que " + l1.getTitulo());
        }
        System.out.println("Presto libro con " + l1.getEjemplaresDisponibles() + " ejemplares disponibles:");
        System.out.println(l1.prestarLibro());

        System.out.println("Presto libro con " + l2.getEjemplaresDisponibles() + " ejemplares disponibles:");
        System.out.println(l2.prestarLibro());

        System.out.println("Se prestaron en total " + b.cantidadDePrestamosRealizados() + " libros");
    }
}