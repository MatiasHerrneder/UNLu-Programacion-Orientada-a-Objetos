package ar.edu.unlu.poo.tp2.ej1;

import java.time.LocalDate;
import java.time.Month;

public class GestorDeSuscripciones {
    private static GestorDeSuscripciones instanciaUnica = null;
    private Suscripcion basica;
    private Suscripcion intermedia;
    private Suscripcion destacada;

    private GestorDeSuscripciones(){
        basica = new Suscripcion(TipoDeSuscripcion.BASICA);
        intermedia = new Suscripcion(TipoDeSuscripcion.INTERMEDIA);
        destacada = new Suscripcion(TipoDeSuscripcion.DESTACADA);
    }

    public static GestorDeSuscripciones crearGestorDeSuscripciones() {
        if (instanciaUnica == null) {
            instanciaUnica = new GestorDeSuscripciones();
        }
        return instanciaUnica;
    }

    public Suscripcion getBasica() {
        return basica;
    }

    public Suscripcion getIntermedia() {
        return intermedia;
    }

    public Suscripcion getDestacada() {
        return destacada;
    }

    public void agregarActividad(String descripcion, TipoDeSuscripcion tipo) {
        Actividad a = new Actividad(descripcion);
        if (tipo == TipoDeSuscripcion.BASICA) {
            getBasica().agregarActividad(a);
        }
        if (tipo != TipoDeSuscripcion.DESTACADA) {
            getIntermedia().agregarActividad(a);
        }
        getDestacada().agregarActividad(a);
    }

    public void eliminarActividad(String descripcion, TipoDeSuscripcion tipo) {
        Actividad a = new Actividad(descripcion);
        if (tipo == TipoDeSuscripcion.DESTACADA) {
            getBasica().quitarActividad(a);
            getIntermedia().quitarActividad(a);
            getDestacada().quitarActividad(a);
        }
        else if (tipo == TipoDeSuscripcion.INTERMEDIA) {
            getIntermedia().quitarActividad(a);
            getDestacada().quitarActividad(a);
        }
        else {
            getDestacada().quitarActividad(a);
        }
    }

    public void agregarSocio(Socio socio, TipoDeSuscripcion tipo) {
        suscripcion(tipo).agregarSocio(socio);
    }

    public void eliminarSocio(Socio socio, TipoDeSuscripcion tipo) {
        suscripcion(tipo).quitarSocio(socio);
    }

    public void mostrarListaDeSocios(TipoDeSuscripcion tipo) {
        suscripcion(tipo).mostrarListaDeSocios();
    }

    public void mostrarListaDeActividades(TipoDeSuscripcion tipo) {
        suscripcion(tipo).mostarListaDeActividades();
    }

    public Suscripcion suscripcion(TipoDeSuscripcion tipo) {
        if (tipo == TipoDeSuscripcion.BASICA) return getBasica();
        else if (tipo == TipoDeSuscripcion.INTERMEDIA) return getIntermedia();
        else return getDestacada();
    }

    public void generarListadoCompletoDeSocios() {
        System.out.println("- Socios con suscripcion DESTACADA -");
        mostrarListaDeSocios(TipoDeSuscripcion.DESTACADA);
        System.out.println("- Socios con suscripcion INTERMEDIA -");
        mostrarListaDeSocios(TipoDeSuscripcion.INTERMEDIA);
        System.out.println("- Socios con suscripcion BASICA -");
        mostrarListaDeSocios(TipoDeSuscripcion.BASICA);
    }

    public void reporteSociosInscriptosEsteMes() {
        Month mesAct = LocalDate.now().getMonth();
        for (Socio d : getDestacada().getSociosAdheridos()) {
            if (d.getFechaDeInscripcion().getMonth() == mesAct) System.out.println(d.devolverDatos());
        }
        for (Socio i : getIntermedia().getSociosAdheridos()) {
            if (i.getFechaDeInscripcion().getMonth() == mesAct) System.out.println(i.devolverDatos());
        }
        for (Socio b : getBasica().getSociosAdheridos()) {
            if (b.getFechaDeInscripcion().getMonth() == mesAct) System.out.println(b.devolverDatos());
        }
    }

    public void reporteActividadesPorTipo() {
        System.out.println("- Destacada -");
        mostrarListaDeActividades(TipoDeSuscripcion.DESTACADA);
        System.out.println("- Intermedia -");
        mostrarListaDeActividades(TipoDeSuscripcion.INTERMEDIA);
        System.out.println("- Basica -");
        mostrarListaDeActividades(TipoDeSuscripcion.BASICA);
    }
}
