package ar.edu.unlu.poo.tp1.ej1;

public class Nodo {

    private Object dato;
    private Nodo siguiente = null;

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

}
