import ar.edu.unlu.poo.tp2.ej8.Biblioteca;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        b.agregarSocio("Carlos");
        b.agregarSocio("Marta");

        b.agregarDiario("di1", "ed1", "123", LocalDate.now());
        b.agregarDiario("di2", "ed2", "123", LocalDate.now());

        b.agregarLibro("li1", "ed1", "123", "123", Year.now(), 3);
        b.agregarLibro("li2", "ed2", "123", "456", Year.now(), 10);
        b.agregarLibro("li3", "ed3", "123", "789", Year.now(), 30);
        b.buscarLibrosPorNombre("li1").get(0).agregarAutor("a1");
        b.buscarLibrosPorNombre("li1").get(0).agregarAutor("a2");
        b.buscarLibrosPorNombre("li2").get(0).agregarAutor("a1");
        b.buscarLibrosPorNombre("li3").get(0).agregarAutor("a1");
        b.buscarLibrosPorNombre("li3").get(0).agregarAutor("a2");

        b.agregarRevista("re1", "ed1", "123", "123", 1, Year.now(), 10);
        b.agregarRevista("re2", "ed2", "123", "456", 4, Year.now(), 10);

        b.agregarTesis("te1", "ed1", "123", "a1", Month.JANUARY, Year.now());
        b.agregarTesis("te2", "ed2", "123", "a2", Month.FEBRUARY, Year.now());

        System.out.println("-*--- Libros prestados ---*-");
        b.librosPrestados();

        System.out.println("-*--- Revistas prestadas ---*-");
        b.revistasPrestadas();

        System.out.println("--- REALIZO PRESTAMOS ---");
        b.buscarLibrosPorNombre("li1").get(0).prestar(b.buscarSociosPorNombre("Carlos").get(0));
        b.buscarRevistasPorNombre("re2").get(0).prestar(b.buscarSociosPorNombre("Marta").get(0));

        System.out.println("-*--- Libros prestados ---*-");
        b.librosPrestados();

        System.out.println("-*--- Revistas prestadas ---*-");
        b.revistasPrestadas();

        System.out.println("-*--- Libros disponibles ---*-");
        b.ejemplaresDisponiblesPorLibro();

        System.out.println("-*--- Revistas disponibles ---*-");
        b.ejemplaresDisponiblesPorRevista();
    }
}