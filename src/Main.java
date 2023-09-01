import ar.edu.unlu.poo.tp1.ej8.PasswordManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        System.out.println("Ingresa el numero de contraseñas a crear: ");
        int c = k.nextInt();
        System.out.println("Ingresa el tamaño de las contraseñas: ");
        int t = k.nextInt();
        PasswordManager.crearClaves(c, t);
        PasswordManager.mostrarClaves();
        System.out.println("\nAhora reconstruyo las contraseñas debiles: ");
        PasswordManager.reconstruirDebiles();
        PasswordManager.mostrarClaves();
    }
}