package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class VentanaFinal extends JPanel {
    public VentanaFinal(Controlador controlador, boolean ganador) {
        setLayout(new FlowLayout());

        JLabel lMensajeFin = new JLabel(ganador ? "VICTORIA" : "DERROTA");
        JButton bVolverAJugar = new JButton("Volver a jugar");

        add(lMensajeFin);
        add(bVolverAJugar);

        bVolverAJugar.addActionListener(e -> {
            try {
                controlador.voverAJugar();
                remove(bVolverAJugar);
                lMensajeFin.setText("Esperando al otro jugador");
                revalidate();
                repaint();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        });
    }



}