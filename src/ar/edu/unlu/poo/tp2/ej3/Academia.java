package ar.edu.unlu.poo.tp2.ej3;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class Academia {
    private final int SUElDO_PROFESOR_POR_ASISTENCIA = 10;
    private final ArrayList<Diagramacion> diagramaciones = new ArrayList<>();

    private final ArrayList<Persona> personas = new ArrayList<>();

    public ArrayList<Diagramacion> getDiagramaciones() {
        return diagramaciones;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void cargarDiagramacion(Persona profesor, int aula, Year anio, Nivel nivel, Disciplina disciplina, String diasYHorarios) {
        getDiagramaciones().add(new Diagramacion(profesor, aula, anio, nivel, disciplina, diasYHorarios));
    }

    public void cargarPersona(int dni, String nombre, String telefono) {
        getPersonas().add(new Persona(dni, nombre, telefono));
    }

    public void registrarAlumno(Diagramacion diagramacion, Persona alumno){
        diagramacion.agregarAlumno(alumno);
    }

    public int liquidacionProfesor(Diagramacion diagramacion) {
        return diagramacion.cantidadDeAsistencias() * SUElDO_PROFESOR_POR_ASISTENCIA;
    }

    public Disciplina disciplinaDeMayoresIngresos() {
        Disciplina[] disciplinas = Disciplina.values();
        int[] apariciones = new int[disciplinas.length];
        Arrays.fill(apariciones, 0);
        for (Diagramacion d : getDiagramaciones()) {
            apariciones[d.getDisciplina().ordinal()]++;
        }
        Disciplina res = null;
        int max = 0;
        for (int i = 0; i < disciplinas.length; i++) {
            if (apariciones[i] >= max) {
                max = apariciones[i];
                res = disciplinas[i];
            }
        }
        return Disciplina.valueOf(String.valueOf(res));
    }
}
