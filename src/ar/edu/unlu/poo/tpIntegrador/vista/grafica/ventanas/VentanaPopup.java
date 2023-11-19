package ar.edu.unlu.poo.tpIntegrador.vista.grafica.ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPopup extends JFrame {
    public VentanaPopup(String mensaje) {
        setTitle("Aviso");
        setSize(300, 200);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        add(panel);

        JLabel labelMsg = new JLabel(mensaje);
        panel.add(labelMsg);

        JButton botonCerrar = new JButton("Aceptar");
        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
