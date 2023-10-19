package ar.edu.unlu.poo.tpIntegrador.modelo;

public class Disparo {
    private Coordenadas coordenadas;
    private EstadoDisparo estado = EstadoDisparo.SIN_DISPARAR;

    public Disparo(Coordenadas coordenadas, EstadoDisparo estado) {
        setCoordenadas(coordenadas);
        setEstado(estado);
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public EstadoDisparo getEstado() {
        return estado;
    }

    public void setEstado(EstadoDisparo estado) {
        this.estado = estado;
    }
}
