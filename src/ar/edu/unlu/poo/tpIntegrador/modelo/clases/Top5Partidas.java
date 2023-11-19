package ar.edu.unlu.poo.tpIntegrador.modelo.clases;

import ar.edu.unlu.poo.tpIntegrador.modelo.records.PartidaTop5;

import java.io.*;

public class Top5Partidas {
    private PartidaTop5[] partidas = new PartidaTop5[5];
    private final File archivo = new File("top5.bin");

    public void nuevaPartidaFinalizada(int turnos, String nombreJ1, String nombreJ2) {
        abrir();
        PartidaTop5 partidaAux, nuevaPartida;
        nuevaPartida = new PartidaTop5(turnos, nombreJ1, nombreJ2);
        for (int i = 0; i < partidas.length; i++) {
            if (partidas[i] == null) {
                partidas[i] = nuevaPartida;
                guardar();
                return;
            }
            if (partidas[i].turnos() > turnos) {
                partidaAux = new PartidaTop5(partidas[i].turnos(), partidas[i].nombreJ1(), partidas[i].nombreJ2());
                partidas[i] = nuevaPartida;
                nuevaPartida = partidaAux;
            }
        }
        guardar();
    }

    public PartidaTop5[] getTop5Partidas() {
        abrir();
        return partidas;
    }

    private void guardar() {
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            var oos = new ObjectOutputStream(fos);
            oos.writeObject(partidas);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrir() {
        if (archivo.exists()) {
            try {
                FileInputStream fos = new FileInputStream(archivo);
                var oos = new ObjectInputStream(fos);
                partidas = (PartidaTop5[]) oos.readObject();
                fos.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
