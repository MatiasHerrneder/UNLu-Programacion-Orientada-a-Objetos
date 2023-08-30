package ar.edu.unlu.poo.tp1.ej3;

public class Nodo {
    private Nodo siguiente = null;
    private Object dato;

    public Nodo(Object dato) {
        setDato(dato);
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Object getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
}
