package ar.edu.unlu.poo.tp1.ej4;

public class Cola {

    private Nodo primerNodo;

    public Cola(){
        primerNodo = null;
    }

    public boolean esVacia() {
        return primerNodo == null;
    }

    public void encolar(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (esVacia()) {
            primerNodo = nuevoNodo;
        }
        else {
            nuevoNodo.setSiguiente(primerNodo);
            primerNodo = nuevoNodo;
        }
    }

    public Object desencolar() {
        Object res = null;
        if (!esVacia()) {
            Nodo nodo = primerNodo;
            if (nodo.getSiguiente() == null) {
                res = nodo.getDato();
                primerNodo = null;
            }
            else {
                while (nodo.getSiguiente().getSiguiente() != null) {
                    nodo = nodo.getSiguiente();
                }
                res = nodo.getSiguiente().getDato();
                nodo.setSiguiente(null);
            }
        }
        return res;
    }

}
