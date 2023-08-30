package ar.edu.unlu.poo.tp1.ej4;

public class Main {

    public static void main(String[] args) {
    
        Cola cola = new Cola();

        System.out.println("Esta vacia? " + cola.esVacia());

        System.out.println("---- Encolo elementos");

        cola.encolar("PRIMERO");
        cola.encolar("SEGUNDO");
        cola.encolar("TERCERO");

        System.out.println("Esta vacia? " + cola.esVacia());

        System.out.println("---- Desencolo elementos");

        System.out.println("Desencolo " + cola.desencolar());
        System.out.println("Desencolo " + cola.desencolar());
        System.out.println("Desencolo " + cola.desencolar());
        System.out.println("Desencolo " + cola.desencolar());

        System.out.println("Esta vacia? " + cola.esVacia());
    }
    
}