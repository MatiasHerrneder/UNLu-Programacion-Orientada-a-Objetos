package ar.edu.unlu.poo.tp2.ej13.solNueva;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String numeroDeTelefono;
    private String direccion;
    private final ArrayList<Rol> roles = new ArrayList<>();

    public Persona(String nombre, String numeroDeTelefono, String direccion) {
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

    public ArrayList<Rol> getRoles() {
        return roles;
    }

    public void darRolPasajero(int numeroPasajero) {
        getRoles().add(new Pasajero(numeroPasajero));
    }

    public void darRolTripulante(String cargo) {
        getRoles().add(new Tripulante(cargo));
    }

    public void quitarRolPasajero(int numeroPasajero) {
        getRoles().remove(new Pasajero(numeroPasajero));
    }

    public void quitarRolTripulante(String cargo) {
        getRoles().remove(new Tripulante(cargo));
    }

}
