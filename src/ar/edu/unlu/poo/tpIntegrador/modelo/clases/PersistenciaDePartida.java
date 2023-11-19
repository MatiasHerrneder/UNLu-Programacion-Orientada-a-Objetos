package ar.edu.unlu.poo.tpIntegrador.modelo.clases;

import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.NoHayPartidaGuardada;

import java.io.*;

public class PersistenciaDePartida {
    record Partida(Jugador j1, Jugador j2, int turno) implements Serializable {}
    private Partida partida;
    private boolean actualizado = false;
    private final File archivo = new File("partida_guardada.bin");

    private void recuperar() throws NoHayPartidaGuardada {
        if (archivo.exists()) {
            try {
                FileInputStream fos = new FileInputStream(archivo);
                var oos = new ObjectInputStream(fos);
                partida = (Partida) oos.readObject();
                fos.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            actualizado = true;
        }
        else throw new NoHayPartidaGuardada();
    }

    public void guardarPartida(Jugador jugador1, Jugador jugador2, int turno) {
        try {
            partida = new Partida(jugador1, jugador2, turno);
            FileOutputStream fos = new FileOutputStream(archivo);
            var oos = new ObjectOutputStream(fos);
            oos.writeObject(partida);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        actualizado = true;
    }

    public Jugador getJugador1() throws NoHayPartidaGuardada {
        if (!actualizado) recuperar();
        return partida.j1;
    }

    public Jugador getJugador2() throws NoHayPartidaGuardada {
        if (!actualizado) recuperar();
        return partida.j2;
    }

    public int getTurno() throws NoHayPartidaGuardada {
        if (!actualizado) recuperar();
        return partida.turno;
    }
}
