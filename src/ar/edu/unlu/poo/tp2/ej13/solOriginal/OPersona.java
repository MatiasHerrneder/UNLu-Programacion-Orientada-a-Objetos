package ar.edu.unlu.poo.tp2.ej13.solOriginal;

public class OPersona {
    private String nombre;
    private String numeroDeTelefono;
    private String direccion;

    public OPersona(String nombre, String numeroDeTelefono, String direccion) {
        setNombre(nombre);
        setNumeroDeTelefono(numeroDeTelefono);
        setDireccion(direccion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
