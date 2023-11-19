package ar.edu.unlu.poo.tpIntegrador.vista.grafica.ventanas;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.records.PartidaTop5;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class VentanaTop5 extends JFrame {
    public VentanaTop5(Controlador controlador) {
        setTitle("Top 5 partidas");
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        setLayout(new FlowLayout());
        add(panel);
        PartidaTop5[] top = null;
        try {
            top = controlador.getTop5();
            panel.setLayout(new GridLayout(top.length, 0));
        } catch (RemoteException e) {
            panel.setLayout(new GridLayout(1, 0));
        }
        mostrarRecords(top, panel);
        setVisible(true);
    }

    private void mostrarRecords(PartidaTop5[] records, JPanel panel) {
        if (records[0] != null) {
            int i = 0;
            while (i < records.length && records[i] != null){
                JLabel label = new JLabel(i+1 + "_ " + records[i].turnos() + " turnos jugados entre " + records[i].nombreJ1() + " y " + records[i].nombreJ2());
                panel.add(label);
                i++;
            }
        }
        else {
            JLabel label = new JLabel("No hay partidas registradas");
            panel.add(label);
        }
    }
}
