package ar.edu.unlu.poo.tp1.ej11;

import java.util.ArrayList;

public class Juego {
    private static final String letrasExtra = "kzxywq";
    public static int otorgarPuntaje(ArrayList<String> palabras) {
        int puntaje = 0;
        for (String pp : palabras) {
            String palabra = pp.toLowerCase();
            if (Diccionario.esPalabra(palabra)) {
                int r = 0;
                r += palabra.length();
                for (int i = 0; i < palabra.length(); i++) {
                    if (letrasExtra.indexOf(palabra.charAt(i)) >= 0) {
                        r++;
                    }
                }
                puntaje += r;
            }
        }
        return puntaje;
    }

    public static Jugador ganador(ArrayList<Jugador> jugadores) {
        Jugador r = null;
        int may = -1;
        for (Jugador j : jugadores) {
            int a = Juego.otorgarPuntaje(j.getPalabras());
            if (a > may) {
                r = j;
                may = a;
            }
        }
        return r;
    }

}
