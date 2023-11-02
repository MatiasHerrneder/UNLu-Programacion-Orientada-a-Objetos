package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;

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
            try {
                String nombre = tfNombre.getText();
                controlador.conectarUsuario(nombre);
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });




    }
}
