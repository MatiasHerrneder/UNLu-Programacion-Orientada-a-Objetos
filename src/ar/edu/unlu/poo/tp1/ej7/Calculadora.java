package ar.edu.unlu.poo.tp1.ej7;

import java.util.Arrays;

public class Calculadora {

    public void testear(int a, int b, int c, int x) {
        System.out.println("Creo la ecuacion " + a + "x^2 + " + b + "x + " + c);
        EcuacionSegundoGrado ec1 = new EcuacionSegundoGrado(a, b, c);
        System.out.println("Raices: " + Arrays.toString(ec1.encontrarRaices()));
        System.out.println("Resuelvo para f(" + x + "): " + ec1.resolverParaX(x));
    }
}
