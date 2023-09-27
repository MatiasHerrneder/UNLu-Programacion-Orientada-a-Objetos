import ar.edu.unlu.poo.tp2.ej13.solNueva.Persona;
import ar.edu.unlu.poo.tp2.ej13.solOriginal.OPasajero;
import ar.edu.unlu.poo.tp2.ej13.solOriginal.OTripulante;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        OPasajero p1 = new OPasajero("Carlos","11", "Dir1", 1);
        OTripulante t1 = new OTripulante("Carlos","11", "Dir1", "Piloto", new ArrayList<>());

        Persona nuevaSol1 = new Persona("Carlos", "11", "Dir1");
        nuevaSol1.darRolPasajero(1);
        nuevaSol1.darRolTripulante("Piloto");
    }
}