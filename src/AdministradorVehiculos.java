import java.util.ArrayList;

public class AdministradorVehiculos {
    private final ArrayList<Auto> autos = new ArrayList<>();
    private final ArrayList<AutoVIP> autosVIP = new ArrayList<>();
    private final ArrayList<Combi> combis = new ArrayList<>();
    private final ArrayList<Camioneta> camionetas = new ArrayList<>();
    private final ArrayList<Camion> camiones = new ArrayList<>();

    private ArrayList<Auto> getAutos() {
        return autos;
    }

    private ArrayList<AutoVIP> getAutosVIP() {
        return autosVIP;
    }

    private ArrayList<Combi> getCombis() {
        return combis;
    }

    private ArrayList<Camioneta> getCamionetas() {
        return camionetas;
    }

    private ArrayList<Camion> getCamiones() {
        return camiones;
    }

    private ArrayList<ArrayList<? extends Vehiculo>> getVehiculos() {
        ArrayList<ArrayList<? extends Vehiculo>> res = new ArrayList<>();
        res.add(getAutos());
        res.add(getAutosVIP());
        res.add(getCombis());
        res.add(getCamionetas());
        res.add(getCamiones());
        return res;
    }

    private boolean noExistePatente(String patente) {
        ArrayList<ArrayList<? extends Vehiculo>> todosLosVehiculos = getVehiculos();
        for (ArrayList<? extends Vehiculo> x : todosLosVehiculos) {
            for (Vehiculo y : x) {
                if (y.getPatente().equals(patente)) return false;
            }
        }
        return true;
    }

    public void agregarAuto(String patente, int cantidadDeAsientos) {
        if (noExistePatente(patente)) {
            getAutos().add(new Auto(patente, cantidadDeAsientos));
        }
    }

    public void agregarAutoVIP(String patente, int cantidadDeAsientos) {
        if (noExistePatente(patente)) {
            getAutosVIP().add(new AutoVIP(patente, cantidadDeAsientos));
        }
    }

    public void agregarCombi(String patente) {
        if (noExistePatente(patente)) {
            getCombis().add(new Combi(patente));
        }
    }

    public void agregarCamioneta(String patente) {
        if (noExistePatente(patente)) {
            getCamionetas().add(new Camioneta(patente));
        }
    }

    public void agregarCamion(String patente) {
        if (noExistePatente(patente)) {
            getCamiones().add(new Camion(patente));
        }
    }

    public Vehiculo buscarVehiculoPorPatente(String patente) {
        ArrayList<ArrayList<? extends Vehiculo>> a = getVehiculos();
        for (ArrayList<? extends Vehiculo> x : a) {
            for (Vehiculo y : x) {
                if (y.getPatente().equals(patente)) return y;
            }
        }
        return null;
    }
}
