package ar.edu.unlu.poo.tp1.ej11;

import java.util.Random;

public class Diccionario {
    private static boolean todasLasPalabrasSonValidas = false;
    public static boolean esPalabra(String p) {
        if (getTodasLasPalabrasSonValidas()) {
            return true;
        }
        else {
            Random r = new Random();
            return r.nextBoolean();
        }
    }

    public static void setTodasLasPalabrasSonValidas(boolean todasLasPalabrasSonValidas) {
        Diccionario.todasLasPalabrasSonValidas = todasLasPalabrasSonValidas;
    }

    public static boolean getTodasLasPalabrasSonValidas() {
        return todasLasPalabrasSonValidas;
    }
}
