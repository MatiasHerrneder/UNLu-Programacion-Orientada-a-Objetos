import ar.edu.unlu.poo.tp2.ej3.Academia;
import ar.edu.unlu.poo.tp2.ej3.Disciplina;
import ar.edu.unlu.poo.tp2.ej3.Nivel;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        Academia a = new Academia();
        a.cargarPersona(1234567, "Juan", "12345");
        a.cargarPersona(2345678, "Carlos", "23345");
        a.cargarPersona(3456789, "Pedro", "44445");
        a.cargarPersona(4567890, "Marcos", "12551");

        a.cargarDiagramacion(a.getPersonas().get(0), 2, Year.now(), Nivel.intermedio, Disciplina.Contemporaneo, "Martes y jueves 16hs");
        a.getDiagramaciones().get(0).agregarAlumno(a.getPersonas().get(1));
        a.getDiagramaciones().get(0).agregarAlumno(a.getPersonas().get(2));
        a.getDiagramaciones().get(0).agregarAlumno(a.getPersonas().get(3));
        //cada persona asiste una vez a la clase
        a.getDiagramaciones().get(0).registrarAsistencia(a.getPersonas().get(1));
        a.getDiagramaciones().get(0).registrarAsistencia(a.getPersonas().get(2));
        a.getDiagramaciones().get(0).registrarAsistencia(a.getPersonas().get(3));


        System.out.println(a.liquidacionProfesor(a.getDiagramaciones().get(0)));
        System.out.println(a.disciplinaDeMayoresIngresos());
    }
}