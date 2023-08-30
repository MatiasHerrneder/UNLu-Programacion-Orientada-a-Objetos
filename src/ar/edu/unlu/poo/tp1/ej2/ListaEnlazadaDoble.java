package ar.edu.unlu.poo.tp1.ej2;

public class ListaEnlazadaDoble {
    private Nodo primerElemento;

    public ListaEnlazadaDoble() { //Crear lista.
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
            nuevoElem.setAnterior(nodo);
            nodo.setSiguiente(nuevoElem);
        }
    }

    public void eliminar(Object dato) { //Eliminar elemento de la lista.
        if (primerElemento != null) {
            Nodo nodo = primerElemento;
            while (nodo.getSiguiente() != null && nodo.getDato() != dato) {
                nodo = nodo.getSiguiente();
            }
            if (nodo.getDato() == dato) {
                if (nodo.getAnterior() != null) {
                    nodo.getAnterior().setSiguiente(nodo.getSiguiente());
                }
                if (nodo.getSiguiente() != null) {
                    nodo.getSiguiente().setAnterior(nodo.getAnterior());
                }
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
        if (esVacia()) {
            primerElemento = nuevoNodo;
        }
        else if (indice <= 0){
            nuevoNodo.setSiguiente(primerElemento);
            primerElemento.setAnterior(nuevoNodo);
            primerElemento = nuevoNodo;
        }
        else {
            int c = 0;
            Nodo nodo = primerElemento;
            while (nodo.getSiguiente() != null && c < indice) {
                nodo = nodo.getSiguiente();
                c++;
            }
            if (nodo.getSiguiente() == null && c < indice) {
                //inserto al final
                nuevoNodo.setAnterior(nodo);
                nodo.setSiguiente(nuevoNodo);
            }
            else {
                //el medio
                nodo.getAnterior().setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(nodo.getAnterior());
                nuevoNodo.setSiguiente(nodo);
                nodo.setAnterior(nuevoNodo);
            }
        }
    }

}