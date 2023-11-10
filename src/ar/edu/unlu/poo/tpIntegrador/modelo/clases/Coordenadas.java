package ar.edu.unlu.poo.tpIntegrador.modelo.clases;

import ar.edu.unlu.poo.tpIntegrador.modelo.excepciones.CoordenadaInvalida;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Coordenadas implements Serializable {
    @Serial
    private static final long serialVersionUID = 10020000L;
    private int posX;
    private int posY;

    public Coordenadas(int posX, char posY) throws CoordenadaInvalida {
        setPosX(posX);
        setPosY(posY);
    }

    public Coordenadas(int posX, int posY) throws CoordenadaInvalida {
        setPosX(posX);
        setPosY(posY);
    }

    public void setPosX(int posX) throws CoordenadaInvalida {
        if (posX < 0 || posX >= 100) throw new CoordenadaInvalida("No es valido el numero de la coordenada");
        else this.posX = posX;
    }

    public void setPosY(char posY) throws CoordenadaInvalida {
        posY = Character.toLowerCase(posY);
        if (posY >= 'a' && posY <= 'z') {
            this.posY = (int) posY - (int) 'a';
        }
        else throw new CoordenadaInvalida("No es valida la letra de la coordenada");
    }

    public void setPosY(int posY) throws CoordenadaInvalida {
        if (posY < 0 || posY >= 100) throw new CoordenadaInvalida("No es valido el numero de la coordenada");
        else this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public char getPosYChar() {
        return (char) (posY + (int) 'a');
    }

    public int getPosY() {
        return posY;
    }

    public boolean isDentroDe(int min, int max) {
        return getPosX() >= min && getPosX() <= max && getPosY() >= min && getPosY() <= max;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordenadas x = (Coordenadas) obj;
        return this.posY == x.posY && this.posX == (x.posX);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }

}

