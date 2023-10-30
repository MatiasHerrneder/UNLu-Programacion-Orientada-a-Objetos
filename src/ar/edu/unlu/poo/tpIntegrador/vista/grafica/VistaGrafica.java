package ar.edu.unlu.poo.tpIntegrador.vista.grafica;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;

import javax.swing.*;

public class VistaGrafica implements IVista {
    private Controlador controlador;
    private JFrame frame;

    public VistaGrafica(Controlador controlador) {
        this.controlador = controlador;
    }

    public void iniciar() {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this.controlador);
    }

    public void mostrarTablero() {

    }

    private EstadoDisparo[][] test() {
        EstadoDisparo[][] res = new EstadoDisparo[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                res[i][j] = EstadoDisparo.SIN_DISPARAR;
            }
        }
        return res;
    }

    @Override
    public void mostrarDisparo(EstadoDisparo estado, boolean disparoFuePropio) {

    }
}
