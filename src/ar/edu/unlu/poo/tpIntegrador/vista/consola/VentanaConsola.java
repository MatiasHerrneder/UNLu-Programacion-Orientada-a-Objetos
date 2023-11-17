package ar.edu.unlu.poo.tpIntegrador.vista.consola;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsola extends JFrame {
    private final JTextField inputBox;
    private JTextArea outputBox;

    public VentanaConsola(String tituloVentana, VistaConsola cliente) {
        setLayout(new BorderLayout());
        setSize(400, 400);
        setTitle(tituloVentana);
        setLocationRelativeTo(null);
        setVisible(true);

        inputBox = new JTextField(100);
        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escribir(">> " + inputBox.getText());
                cliente.inputConsola(inputBox.getText().trim());
                inputBox.setText("");
            }
        });
        add(inputBox, BorderLayout.SOUTH);

        outputBox = new JTextArea();
        outputBox.setEditable(false);
        add(outputBox, BorderLayout.CENTER);
    }

    public void escribir(String mensaje) {
        outputBox.append(mensaje + "\n");
    }

}
