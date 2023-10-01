package ar.edu.unlu.poo.tp2.ej14;

public abstract class Proveedor {
    private String razonSocial;
    private int cuit;
    private String telefono;
    private double importeBase;
    public abstract double montoAPagar(int cantidadDeClientes);

    public Proveedor(String razonSocial, int cuit, String telefono, double importeBase) {
        setRazonSocial(razonSocial);
        setCuit(cuit);
        setTelefono(telefono);
        setImporteBase(importeBase);
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getImporteBase() {
        return importeBase;
    }

    public void setImporteBase(double importeBase) {
        this.importeBase = importeBase;
    }
}
