package ar.edu.unlu.poo.tp2.ej1;

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
        if (getBasica().getActividades().contains(a)) {
            getBasica().quitarActividad(a);
            getIntermedia().quitarActividad(a);
            getDestacada().quitarActividad(a);
        }
        else if ((tipo == TipoDeSuscripcion.INTERMEDIA || tipo == TipoDeSuscripcion.DESTACADA) && getIntermedia().getActividades().contains(a)) {
            getIntermedia().quitarActividad(a);
            getDestacada().quitarActividad(a);
        }
        else if (tipo == TipoDeSuscripcion.DESTACADA && getDestacada().getActividades().contains(a)) {
            getDestacada().quitarActividad(a);
        }
    }

    public void agregarSocio(Socio socio, TipoDeSuscripcion tipo) {
        suscripcion(tipo).agregarSocio(socio);
    }

    public void quitarSocio(Socio socio, TipoDeSuscripcion tipo) {
        suscripcion(tipo).quitarSocio(socio);
    }

    public void mostrarListaDeSocios(TipoDeSuscripcion tipo) {
        suscripcion(tipo).mostrarListaDeSocios();
    }

    public Suscripcion suscripcion(TipoDeSuscripcion tipo) {
        if (tipo == TipoDeSuscripcion.BASICA) return getBasica();
        else if (tipo == TipoDeSuscripcion.INTERMEDIA) return getIntermedia();
        else return getDestacada();
    }
}
