package ar.edu.unlu.poo.tpIntegrador.modelo.clases;

import ar.edu.unlu.poo.tpIntegrador.modelo.interfaces.IUsuario;

import java.io.Serial;
import java.io.Serializable;

public class Usuario implements IUsuario, Serializable {
    @Serial
    private static final long serialVersionUID = 10010000L;
    private int id;
    private String nombre;
    private int numeroDeJugador;

    public Usuario(int id, String nombre, int numeroDeJugador) {
        setId(id);
        setNombre(nombre);
        setNumeroDeJugador(numeroDeJugador);
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroDeJugador() {
        return numeroDeJugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroDeJugador(int numeroDeJugador) {
        this.numeroDeJugador = numeroDeJugador;
    }

    @Override
    public boolean isJugador(int numeroDeJugador) {
        return this.numeroDeJugador == numeroDeJugador;
    }
}
