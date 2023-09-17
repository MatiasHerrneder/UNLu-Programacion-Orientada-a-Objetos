package ar.edu.unlu.poo.tp2.ej5;

import java.util.ArrayList;

public class Cliente {

    private int cuil;
    private String nombre;
    private CuentaCredito cuentaCredito = null;
    private float saldo = 0;
    private float limiteDeGiroEnDescubierto;
    private Inversion inversion = null;
    private final ArrayList<Inversion> historialDeInversiones = new ArrayList<>();

    public Cliente(int cuil, String nombre, float limiteDeGiroEnDescubierto) {
        setCuil(cuil);
        setNombre(nombre);
        setLimiteDeGiroEnDescubierto(limiteDeGiroEnDescubierto);
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public int getCuil() {
        return cuil;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLimiteDeGiroEnDescubierto(float limiteDeGiroEnDescubierto) {
        this.limiteDeGiroEnDescubierto = limiteDeGiroEnDescubierto;
    }

    public float getLimiteDeGiroEnDescubierto() {
        return limiteDeGiroEnDescubierto;
    }

    private void setInversion(Inversion inversion){
        this.inversion = inversion;
    }

    public float getSaldo() {
        return saldo;
    }

    private void setSaldo(float monto) {
        saldo = monto;
    }

    private CuentaCredito getCuentaCredito() {
        return cuentaCredito;
    }

    private void setCuentaCredito(CuentaCredito cuentaCredito) {
        this.cuentaCredito = cuentaCredito;
    }

    private Inversion getInversion() {
        return inversion;
    }

    private ArrayList<Inversion> getHistorialDeInversiones() {
        return historialDeInversiones;
    }

    private void agregarInversionAlHistorial(Inversion inversion) {
        getHistorialDeInversiones().add(inversion);
    }

    public boolean abrirCuentaCredito(float limiteDeGasto) {
        if (getCuentaCredito() == null) {
            setCuentaCredito(new CuentaCredito(limiteDeGasto));
            return true;
        }
        return false;
    }

    public boolean hacerInversion(float monto, int duracion) {
        if (getInversion() == null || monto > getSaldo() + getLimiteDeGiroEnDescubierto()) {
            restarSaldoDebito(monto);
            setInversion(new Inversion(monto, duracion));
        }
        return false;
    }

    public boolean finalizarInversion() {
        if (getInversion() != null) {
            sumarSaldoDebito(getInversion().retorno());
            agregarInversionAlHistorial(getInversion());
            setInversion(null);
        }
        return false;
    }

    public boolean sumarSaldoDebito(float monto) {
        setSaldo(getSaldo() + monto);
        return true;
    }

    public EstadoTransaccion restarSaldoDebito(float monto) {
        if (getSaldo() - monto > - getLimiteDeGiroEnDescubierto()) {
            setSaldo(getSaldo() - monto);
            if (getSaldo() > 0) {
                return EstadoTransaccion.completada;
            }
            else return EstadoTransaccion.giradoEnDescubierto;
        }
        return EstadoTransaccion.noCompletada;
    }

    public boolean hacerCompraCredito(float monto) {
        if (getCuentaCredito() != null)
            return getCuentaCredito().realizarCompra(monto);
        return false;
    }

    public boolean pagarDeudaCredito(float monto) {
        getCuentaCredito().pagarDeuda(monto);
        return true;
    }

    public float getMontoInvertido() {
        if (getInversion() == null) {
            return 0;
        }
        else {
            return getInversion().getValor();
        }
    }

    public float getSaldoDeudorCredito() {
        if (getCuentaCredito() == null) {
            return 0;
        }
        else {
            return getCuentaCredito().getMaximoLimiteDeGasto() - getCuentaCredito().getLimiteDeGasto();
        }
    }

    public float getMontoCredito() {
        if (getCuentaCredito() == null) {
            return 0;
        }
        else {
            return getCuentaCredito().getLimiteDeGasto();
        }
    }

}
