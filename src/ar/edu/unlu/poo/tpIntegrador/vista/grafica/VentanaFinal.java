package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class VentanaFinal extends JFrame {
    public VentanaFinal(Controlador controlador, boolean ganador) {
        setTitle("Partida terminada");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelPrincipal = (JPanel) getContentPane();
        panelPrincipal.setLayout(new FlowLayout());

        JLabel lMensajeFin = new JLabel(ganador ? "VICTORIA" : "DERROTA");
        JButton bVolverAJugar = new JButton("Volver a jugar");

        panelPrincipal.add(lMensajeFin);
        panelPrincipal.add(bVolverAJugar);

        bVolverAJugar.addActionListener(e -> {
            try {
                controlador.voverAJugar();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        });
    }



}
