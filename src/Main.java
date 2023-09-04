import ar.edu.unlu.poo.tp1.ej11.Diccionario;
import ar.edu.unlu.poo.tp1.ej11.Juego;
import ar.edu.unlu.poo.tp1.ej11.Jugador;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            jugadores.add(new Jugador(i));
        }
        jugadores.get(0).agregarPalabra("Hola");
        jugadores.get(0).agregarPalabra("Xilofon");
        jugadores.get(1).agregarPalabra("Mama");
        jugadores.get(1).agregarPalabra("Zorro");
        System.out.println("""
                Palabras jugador 0:\s
                Hola
                Xilofon""");
        System.out.println("""
                Palabras jugador 1:\s
                Mama
                Zorro""");
        System.out.println("PRIMERA PRUEBA - Las palabras seran asignadas como validas o no validas aleatoriamente en cada consulta");
        for (Jugador j : jugadores) {
            System.out.println("Puntaje jugador " + j.getIdentificador() + ": " + Juego.otorgarPuntaje(j.getPalabras()));
        }
        System.out.println("El ganador es: " + Juego.ganador(jugadores).getIdentificador() + "  --AVISO: puede ser distinto, es recalculado por la forma en que funciona el diccionario--");
        System.out.println("SEGUNDA PRUEBA - TODAS las palabras seran asignadas como validas");
        Diccionario.setTodasLasPalabrasSonValidas(true);
        for (Jugador j : jugadores) {
            System.out.println("Puntaje jugador " + j.getIdentificador() + ": " + Juego.otorgarPuntaje(j.getPalabras()));
        }
        System.out.println("El ganador es: " + Juego.ganador(jugadores).getIdentificador());
    }
}