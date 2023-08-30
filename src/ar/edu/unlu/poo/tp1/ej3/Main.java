package ar.edu.unlu.poo.tp1.ej3;

public class Main {
    public static void main(String[] args) {

        Pila pila = new Pila();

        System.out.println("Esta vacia? " + pila.esVacia());

        System.out.println("---- Apilo elementos");

        pila.apilar("PRIMERO");
        pila.apilar("SEGUNDO");
        pila.apilar("TERCERO");

        System.out.println("Esta vacia? " + pila.esVacia());

        System.out.println("---- Desapilo elementos");

        System.out.println("Desapilo " + pila.desapilar());
        System.out.println("Desapilo " + pila.desapilar());
        System.out.println("Desapilo " + pila.desapilar());
        System.out.println("Desapilo " + pila.desapilar());

        System.out.println("Esta vacia? " + pila.esVacia());
    }
}