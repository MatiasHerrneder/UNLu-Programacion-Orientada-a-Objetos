package ar.edu.unlu.poo.tp2.ej14;

public class Cliente {
    private String nombre;
    private int cuil;
    private String telefono;

    public Cliente(String nombre, int cuil, String telefono) {
        setNombre(nombre);
        setCuil(cuil);
        setTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
