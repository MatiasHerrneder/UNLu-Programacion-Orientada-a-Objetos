package ar.edu.unlu.poo.tp2.ej1;

import java.time.LocalDate;

public class Socio {
    public Socio(int dni, String nombre, String direccion, String email, LocalDate fechaDeInscripcion) {
        setDni(dni);
        setNombre(nombre);
        setDireccion(direccion);
        setEmail(email);
        setFechaDeInscripcion(fechaDeInscripcion);
    }
    public Socio(int dni, String nombre, String direccion, String email) {
        this(dni, nombre, direccion, email, LocalDate.now());
    }
    private String nombre;
    private String direccion;
    private String email;
    private int dni;
    private LocalDate fechaDeInscripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public void setFechaDeInscripcion(LocalDate fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }
    public String devolverDatos() {
        return getNombre() + " (" + getDni() + "): " + getFechaDeInscripcion();
    }
}
