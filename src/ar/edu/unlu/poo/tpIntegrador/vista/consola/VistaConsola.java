package ar.edu.unlu.poo.tpIntegrador.vista.consola;

import ar.edu.unlu.poo.tpIntegrador.controlador.Controlador;
import ar.edu.unlu.poo.tpIntegrador.modelo.EstadoDisparo;
import ar.edu.unlu.poo.tpIntegrador.vista.IVista;


public class VistaConsola implements IVista {
    private Controlador controlador;

    public VistaConsola(Controlador controlador) {
        this.controlador = controlador;
        controlador.setVista(this);
    }

    public void iniciar() {
        mostrarTablero();
    }

    public void mostrarTablero() {
        EstadoDisparo[][] tablero = controlador.getTablero().getTablero();
        System.out.println("|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        for (EstadoDisparo[] fila : tablero) {
            StringBuilder s = new StringBuilder("| ");
            for (EstadoDisparo columna : fila) {
                switch (columna) {
                    case SIN_DISPARAR -> s.append("   ");
                    case AGUA -> s.append(" o ");
                    default -> s.append(" X ");
                }
                s.append(" | ");
            }
            System.out.println(s);
            System.out.println("|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        }
    }

    @Override
    public void mostrarDisparo(EstadoDisparo estado, boolean disparoFuePropio) {
        if (disparoFuePropio) {
            switch (estado) {
                case HUNDIDO -> System.out.println("El barco enemigo fue hundido!");
                case GOLPEADO -> System.out.println("El barco enemigo fue golpeado");
                case AGUA -> System.out.println("Disparo al agua");
            }
        }
        else {
            switch (estado) {
                case HUNDIDO -> System.out.println("El enemigo hundio nuestro barco!");
                case GOLPEADO -> System.out.println("El enemigo golpeo nuestro barco");
                case AGUA -> System.out.println("Disparo enemigo al agua");
            }
        }
        mostrarTablero();
    }
}
