package ar.edu.unlu.poo.tpIntegrador.modelo.interfaces;

import ar.edu.unlu.poo.tpIntegrador.modelo.clases.Coordenadas;
import ar.edu.unlu.poo.tpIntegrador.modelo.enumerados.Direccion;
import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.CoordenadaInvalida;

public interface IBarco {
    int getLargoDelBarco();
    Coordenadas getPosicionBarco();
    Coordenadas siguienteCoordenada(Coordenadas coordenada) throws CoordenadaInvalida;
    void setDireccion(Direccion direccion);
    void setPosicion(Coordenadas coordenadas);
    Coordenadas colaDelBarco() throws Exception;
}
