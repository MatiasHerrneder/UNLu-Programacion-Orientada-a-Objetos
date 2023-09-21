package ar.edu.unlu.poo.tp2.ej7;

public class Empleado {
    private String apellido;
    private String direccion;
    private String dni;
    private String nombre;
    private String telefono;
    private boolean descuentoUnicoRealizado = false;

    public Empleado(String apellido, String direccion, String dni, String nombre, String telefono) {
        setApellido(apellido);
        setDireccion(direccion);
        setDni(dni);
        setNombre(nombre);
        setTelefono(telefono);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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

    public boolean isDescuentoUnicoRealizado() {
        return descuentoUnicoRealizado;
    }

    public void realizarDescuentoUnico() {
        descuentoUnicoRealizado = true;
    }
}
