package ar.edu.unlu.poo.tp2.ej3;

import java.time.Year;
import java.util.ArrayList;

public class Diagramacion {
    private final ArrayList<Persona> alumnos = new ArrayList<>();
    private final ArrayList<Integer> diasAsistidos = new ArrayList<>();
    private Persona profesor;
    private int aula;
    private Year anio;
    private Nivel nivel;
    private String diasYHorarios;
    private Disciplina disciplina;

    public Diagramacion(Persona profesor, int aula, Year anio, Nivel nivel, Disciplina disciplina, String diasYHorarios) {
        setProfesor(profesor);
        setAnio(anio);
        setAula(aula);
        setNivel(nivel);
        setDisciplina(disciplina);
        setDiasYHorarios(diasYHorarios);
    }

    public void agregarAlumno(Persona alumno) {
        getAlumnos().add(alumno);
        getDiasAsistidos().add(0);
    }

    public void registrarAsistencia(Persona alumnno) {
        int posAlumno = getAlumnos().indexOf(alumnno);
        if (posAlumno >= 0){
            getDiasAsistidos().set(posAlumno, getDiasAsistidos().get(posAlumno) + 1);
        }
    }

    public Persona getProfesor() {
        return profesor;
    }

    public void setProfesor(Persona profesor) {
        this.profesor = profesor;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public Year getAnio() {
        return anio;
    }

    public void setAnio(Year anio) {
        this.anio = anio;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public ArrayList<Persona> getAlumnos() {
        return alumnos;
    }

    public String getDiasYHorarios() {
        return diasYHorarios;
    }

    public void setDiasYHorarios(String diasYHorarios) {
        this.diasYHorarios = diasYHorarios;
    }

    private ArrayList<Integer> getDiasAsistidos() {
        return diasAsistidos;
    }

    public int cantidadDeAsistencias() {
        int res = 0;
        for (Integer d : getDiasAsistidos()) {
            res += d;
        }
        return res;
    }
}
