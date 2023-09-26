package ar.edu.unlu.poo.tp2.ej12;

public class Usuario {
    private String nombre;
    private Cuenta cuentaNormal = null;
    private CuentaCredito cuentaCredito = null;
    private CajaDeAhorro cajaDeAhorro = null;

    public Usuario(String nombre) {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta getCuentaNormal() {
        return cuentaNormal;
    }

    public CuentaCredito getCuentaCredito() {
        return cuentaCredito;
    }

    public CajaDeAhorro getCajaDeAhorro() {
        return cajaDeAhorro;
    }

    public boolean abrirCuentaNormal(double saldo, double limiteDeGiroEnDescubierto) {
        if (getCuentaNormal() != null) return false;
        else {
            cuentaNormal = new Cuenta(saldo, limiteDeGiroEnDescubierto);
            return true;
        }
    }

    public boolean abrirCajaDeAhorro(double saldo) {
        if (getCajaDeAhorro() != null) return false;
        else {
            cajaDeAhorro = new CajaDeAhorro(saldo);
            return true;
        }
    }

    public boolean abrirCuentaCredito(double limite) {
        if (getCuentaCredito() != null) return false;
        else {
            cuentaCredito = new CuentaCredito(limite);
            return true;
        }
    }
}
