package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.JugadoresYaConectados;

import javax.swing.*;
import java.awt.*;

public class VentanaDeConexion extends JFrame {
    private Controlador controlador;
    public VentanaDeConexion(Controlador controlador) {
        this.controlador = controlador;
        iniciar();
    }

    private void iniciar() {
        setTitle("Conectarse");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelPrincipal = (JPanel) getContentPane();
        panelPrincipal.setLayout(new FlowLayout());

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
                setVisible(false);
            } catch (JugadoresYaConectados ex) {
                JOptionPane.showMessageDialog(null, "Ya hay 2 jugadores conectados a la partida", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
