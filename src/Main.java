import ar.edu.unlu.poo.tp2.ej1.GestorDeSuscripciones;
import ar.edu.unlu.poo.tp2.ej1.Socio;
import ar.edu.unlu.poo.tp2.ej1.TipoDeSuscripcion;

public class Main {
    public static void main(String[] args) {
        GestorDeSuscripciones g = GestorDeSuscripciones.crearGestorDeSuscripciones();
        g.agregarSocio(new Socio(1234567, "Juan", "dir1", "email1"), TipoDeSuscripcion.BASICA);
        g.agregarSocio(new Socio(2345678, "Marta", "dir2", "email2"), TipoDeSuscripcion.BASICA);
        g.agregarSocio(new Socio(3456789, "Pedro", "dir3", "email3"), TipoDeSuscripcion.BASICA);
        g.agregarSocio(new Socio(4567890, "Marcos", "dir4", "email4"), TipoDeSuscripcion.INTERMEDIA);
        g.agregarSocio(new Socio(5678901, "Paula", "dir5", "email5"), TipoDeSuscripcion.INTERMEDIA);
        g.agregarSocio(new Socio(6789012, "Gisela", "dir6", "email6"), TipoDeSuscripcion.DESTACADA);
        g.mostrarListaDeSocios(TipoDeSuscripcion.BASICA);
    }
}