package ar.edu.unlu.poo.tp2.ej8;

public class Socio {
    private PublicacionPrestable prestado = null;
    private String nombre;

    public Socio(String nombre) {
        setNombre(nombre);
    }

    public PublicacionPrestable getPrestado() {
        return prestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean tieneEnPrestamo() {
        return getPrestado() != null;
    }

    public void prestar(PublicacionPrestable publicacion) {
        prestado = publicacion;
    }

    public void devolver() {
        prestado = null;
    }

    public boolean isNombre(String nombre) {
        return getNombre().equals(nombre);
    }
}
