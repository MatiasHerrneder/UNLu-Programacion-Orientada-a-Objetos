package ar.edu.unlu.poo.tp1.ej1;

public class ListaEnlazadaSimple {

    private Nodo primerElemento;

    public ListaEnlazadaSimple() { //Crear lista.
        primerElemento = null;
    }
    public boolean esVacia() { //Consultar si la lista está vacía.
        return primerElemento == null;
    }

    public int longitud() { //Consultar la longitud de la lista.
        Nodo nodo = primerElemento;
        int c = 0;
        while (nodo != null) {
            nodo = nodo.getSiguiente();
            c++;
        }
        return c;
    }

    public void agregar(Object dato) { //Agregar elemento al final de la lista.
        Nodo nuevoElem = new Nodo(dato);
        if (esVacia()){
            primerElemento = nuevoElem;
        }
        else {
            Nodo nodo = primerElemento;
            while (nodo.getSiguiente() != null) {
                nodo = nodo.getSiguiente();
            }
            nodo.setSiguiente(nuevoElem);
        }
    }

    public void eliminar(Object dato) { //Eliminar elemento de la lista.
        Nodo nodo = primerElemento;
        Nodo nodoAnt = null;
        while (nodo != null && nodo.getDato() != dato) {
            nodoAnt = nodo;
            nodo = nodo.getSiguiente();
        }
        if (nodo != null) {
            if (nodo == primerElemento){
                primerElemento = primerElemento.getSiguiente();
            }
            else {
                nodoAnt.setSiguiente(nodo.getSiguiente());
            }
        }
    }

    public Object recuperar(int indice) { //Recuperar elemento de la lista.
        Nodo nodo = primerElemento;
        int c = 0;
        while (nodo != null && c < indice) {
            nodo = nodo.getSiguiente();
            c++;
        }
        if (nodo != null) {
            return nodo.getDato();
        }
        return null;
    }

    public void insertar(int indice, Object dato) { //Insertar elemento en la lista en una posición específica. (o al final si se especifica una posicion mas grande que el tamaño)
        Nodo nuevoNodo = new Nodo(dato);
        if (indice <= 0 || esVacia()){
            nuevoNodo.setSiguiente(primerElemento);
            primerElemento = nuevoNodo;
        }
        else {
            Nodo nodo = primerElemento;
            Nodo nodoAnt = null;
            int c = 0;
            while (nodo != null && c < indice) {
                nodoAnt = nodo;
                nodo = nodo.getSiguiente();
                c++;
            }
            nodoAnt.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(nodo);
        }
    }

}
