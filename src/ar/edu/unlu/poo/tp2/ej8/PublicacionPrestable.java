package ar.edu.unlu.poo.tp2.ej8;

public abstract class PublicacionPrestable extends Publicacion {
    private int cantidadTotalDeEjemplares;
    private int cantidadDeEjemplaresDisponibles;
    private int cantidadDePrestamosRealizados = 0;

    public PublicacionPrestable(String nombre, String editor, String telefonoProveedor, int cantidadTotalDeEjemplares) {
        super(nombre, editor, telefonoProveedor);
        setCantidadDeEjemplaresDisponibles(cantidadTotalDeEjemplares);
        setCantidadTotalDeEjemplares(cantidadTotalDeEjemplares);
    }

    public int getCantidadTotalDeEjemplares() {
        return cantidadTotalDeEjemplares;
    }

    public void setCantidadTotalDeEjemplares(int cantidadTotalDeEjemplares) {
        this.cantidadTotalDeEjemplares = cantidadTotalDeEjemplares;
    }

    public int getCantidadDeEjemplaresDisponibles() {
        return cantidadDeEjemplaresDisponibles;
    }

    public void setCantidadDeEjemplaresDisponibles(int cantidadDeEjemplaresDisponibles) {
        this.cantidadDeEjemplaresDisponibles = cantidadDeEjemplaresDisponibles;
    }

    public int getCantidadDePrestamosRealizados() {
        return cantidadDePrestamosRealizados;
    }

    private void incrementarPrestamosRealizados() {
        cantidadDePrestamosRealizados++;
    }

    public int getCantidadDeEjemplaresPrestados() {
        return getCantidadTotalDeEjemplares() - getCantidadDeEjemplaresDisponibles();
    }

    public boolean prestar(Socio socio) {
        if (getCantidadDeEjemplaresDisponibles() > 1 && !socio.tieneEnPrestamo()) {
            setCantidadDeEjemplaresDisponibles(getCantidadDeEjemplaresDisponibles() - 1);
            incrementarPrestamosRealizados();
            socio.prestar(this);
            return true;
        }
        else return false;
    }

    public boolean devolver(Socio socio) {
        if (getCantidadTotalDeEjemplares() > getCantidadDeEjemplaresDisponibles() && socio.tieneEnPrestamo()) {
            setCantidadDeEjemplaresDisponibles(getCantidadDeEjemplaresDisponibles() + 1);
            socio.devolver();
            return true;
        }
        else return false;
    }
}
