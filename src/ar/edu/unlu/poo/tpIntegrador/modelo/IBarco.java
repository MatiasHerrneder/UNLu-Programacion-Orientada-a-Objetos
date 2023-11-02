package ar.edu.unlu.poo.tpIntegrador.modelo;

public interface IBarco {
    int getLargoDelBarco();
    Coordenadas getPosicionBarco();
    Coordenadas siguienteCoordenada(Coordenadas coordenada) throws Exception;
    void setDireccion(Direccion direccion);
    void setPosicion(Coordenadas coordenadas);
    Coordenadas colaDelBarco() throws Exception;
}
