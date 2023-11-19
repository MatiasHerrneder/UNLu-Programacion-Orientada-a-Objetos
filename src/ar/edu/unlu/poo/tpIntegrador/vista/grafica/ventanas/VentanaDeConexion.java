package ar.edu.unlu.poo.tpIntegrador.vista.grafica.ventanas;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.JugadoresYaConectados;

import javax.swing.*;
import java.awt.*;

public class VentanaDeConexion extends JPanel {
    public VentanaDeConexion(Controlador controlador) {
        setLayout(new FlowLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));
        add(panelPrincipal);

        JLabel lNombre = new JLabel("Ingrese su nombre de usuario");
        JTextField tfNombre = new JTextField("Nombre", 20);
        JButton bNombre = new JButton("OK");

        panelPrincipal.add(lNombre);
        panelPrincipal.add(tfNombre);
        panelPrincipal.add(bNombre);

        bNombre.addActionListener(e -> {
            String nombre = tfNombre.getText();
            try {
                controlador.conectarUsuario(nombre);
                lNombre.setText("Esperando al otro jugador");
                panelPrincipal.remove(tfNombre);
                panelPrincipal.remove(bNombre);
            } catch (JugadoresYaConectados ex) {
                JOptionPane.showMessageDialog(null, "Ya hay 2 jugadores conectados a la partida", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
