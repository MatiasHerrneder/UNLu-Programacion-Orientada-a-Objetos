package ar.edu.unlu.poo.tp1.ej2;

public class Nodo {

    private Object dato;
    private Nodo siguiente = null;
    private Nodo anterior = null;

    public Nodo(Object dato){
        setDato(dato);
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}