package ar.edu.unlu.poo.tp1.ej3;

public class Pila {

    private Nodo tope;

    public Pila() {
        tope = null;
    }

    public boolean esVacia() {
        return tope == null;
    }

    public void apilar(Object dato) {
        Nodo nodo = new Nodo(dato);
        nodo.setSiguiente(tope);
        tope = nodo;
    }

    public Object desapilar() {
        if (esVacia()) {
            return null;
        }
        Nodo nodo = tope;
        tope = tope.getSiguiente();
        return nodo.getDato();
    }

}
