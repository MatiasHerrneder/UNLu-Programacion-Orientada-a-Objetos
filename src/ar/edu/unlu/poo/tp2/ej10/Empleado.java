package ar.edu.unlu.poo.tp2.ej10;

import java.time.Month;
import java.time.YearMonth;

abstract public class Empleado {
    private String nombre;
    private String apellido;
    private String telefono;
    private int cuit;
    private Month mesDeCumpleanios;

    public Empleado(String nombre, String apellido, String telefono, int cuit, Month mesDeCumpleanios) {
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setCuit(cuit);
        setMesDeCumpleanios(mesDeCumpleanios);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public Month getMesDeCumpleanios() {
        return mesDeCumpleanios;
    }

    public void setMesDeCumpleanios(Month mesDeCumpleanios) {
        this.mesDeCumpleanios = mesDeCumpleanios;
    }

    protected boolean correspondeBonoCumpleanios() {
        return getMesDeCumpleanios().equals(YearMonth.now().getMonth());
    }

    abstract public double calcularSueldo();
}
