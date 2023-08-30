package ar.edu.unlu.poo.tp1.ej2;

public class Main {
    public static void main(String[] args) {
        ListaEnlazadaDoble lista = new ListaEnlazadaDoble();

        System.out.println("----PRUEBAS DE FUNCIONAMIENTO");

        System.out.println("Esta vacia? " + lista.esVacia());

        System.out.println("----AGREGO ELEMENTOS HOLA Y CHAU");
        lista.agregar("HOLA");
        lista.agregar("CHAU");

        System.out.println("Esta vacia? " + lista.esVacia());
        System.out.println("Tamaño: " + lista.longitud());

        System.out.println("i0: " + lista.recuperar(0));
        System.out.println("i1: " + lista.recuperar(1));
        System.out.println("i2: " + lista.recuperar(2));
        System.out.println("i3: " + lista.recuperar(3));


        System.out.println("----INSETO ELEMENTOS EN EL MEDIO Y EN UN INDICE MAYOR AL TAMAÑO");
        lista.insertar(1, "medium");
        lista.insertar(45, "ultimum");

        System.out.println("Tamaño: " + lista.longitud());

        System.out.println("i0: " + lista.recuperar(0));
        System.out.println("i1: " + lista.recuperar(1));
        System.out.println("i2: " + lista.recuperar(2));
        System.out.println("i3: " + lista.recuperar(3));


        System.out.println("----ELIMINO EL ELEMENTO DEL MEDIO");
        lista.eliminar("medium");

        System.out.println("Tamaño: " + lista.longitud());

        System.out.println("i0: " + lista.recuperar(0));
        System.out.println("i1: " + lista.recuperar(1));
        System.out.println("i2: " + lista.recuperar(2));
        System.out.println("i3: " + lista.recuperar(3));
    }
}