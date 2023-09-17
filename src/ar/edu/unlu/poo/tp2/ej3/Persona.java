package ar.edu.unlu.poo.tp2.ej3;

public class Persona {
    private int dni;
    private String nombre;
    private String telefono;

    public int getDni() {
        return dni;
    }

    public Persona(int dni, String nombre, String telefono) {
        setDni(dni);
        setNombre(nombre);
        setTelefono(telefono);
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
