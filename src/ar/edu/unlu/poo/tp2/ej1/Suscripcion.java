package ar.edu.unlu.poo.tp2.ej1;

import java.util.ArrayList;

public class Suscripcion {
    private TipoDeSuscripcion tipoDeSuscripcion;
    private ArrayList<Socio> sociosAdheridos = new ArrayList<>();
    private ArrayList<Actividad> actividades = new ArrayList<>();
    public Suscripcion(TipoDeSuscripcion tipoDeSuscripcion) {
        setTipoDeSuscripcion(tipoDeSuscripcion);
    }
    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public ArrayList<Socio> getSociosAdheridos() {
        return sociosAdheridos;
    }
    public void agregarSocio(Socio socio) {
        if (!estaSuscrito(socio)) {
            getSociosAdheridos().add(socio);
        }
    }
    public void quitarSocio(Socio socio) {
        getSociosAdheridos().remove(socio);
    }
    public void agregarActividad(Actividad actividad){
        if (!getActividades().contains(actividad)) {
            getActividades().add(actividad);
        }
    }
    public void quitarActividad(Actividad actividad) {
        for (Actividad a : getActividades()) {
            if (a.equals(actividad)) {
                getActividades().remove(a);
            }
        }
    }
    public void setTipoDeSuscripcion(TipoDeSuscripcion tipoDeSuscripcion) {
        this.tipoDeSuscripcion = tipoDeSuscripcion;
    }

    public TipoDeSuscripcion getTipoDeSuscripcion() {
        return tipoDeSuscripcion;
    }
    public boolean estaSuscrito(Socio socio) {
        return getSociosAdheridos().contains(socio);
    }
    public void mostrarListaDeSocios() {
        for (Socio s : getSociosAdheridos()) {
            System.out.println(s.devolverDatos());
        }
    }
}
