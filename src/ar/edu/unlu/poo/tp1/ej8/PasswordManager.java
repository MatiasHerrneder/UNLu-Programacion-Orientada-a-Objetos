package ar.edu.unlu.poo.tp1.ej8;

import java.util.ArrayList;

public class PasswordManager {
    static private ArrayList<Password> coleccion = new ArrayList<>();
    static public void crearClaves(int cant, int tam) {
        coleccion = new ArrayList<>();
        for (int i = 0; i < cant; i++){
            coleccion.add(new Password(tam));
        }
    }

    static public void mostrarClaves() {
        for (Password p : coleccion)
            System.out.println(p.getContra() + " - " + (p.esFuerte() ? "Fuerte" : "Debil"));
    }
}
