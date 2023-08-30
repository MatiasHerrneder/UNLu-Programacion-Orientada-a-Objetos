package ar.edu.unlu.poo.tp1.ej4;

public class Nodo {
    Nodo siguiente = null;
    Object dato;

    public Nodo(Object dato) {
        setDato(dato);
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
}
