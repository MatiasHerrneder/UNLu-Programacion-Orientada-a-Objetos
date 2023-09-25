package ar.edu.unlu.poo.tp2.ej12;

import java.time.LocalDate;
import java.util.ArrayList;

public class OLDCliente {

    private int cuil;
    private String nombre;
    private OLDCuentaCredito OLDCuentaCredito = null;
    private float saldo = 0;
    private float limiteDeGiroEnDescubierto;
    private OLDInversion OLDInversion = null;
    private final ArrayList<OLDInversion> historialDeInversiones = new ArrayList<>();
    private boolean canceladoAutomaticoDeInversion = false;

    public OLDCliente(int cuil, String nombre, float limiteDeGiroEnDescubierto) {
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

    private void setInversion(OLDInversion OLDInversion){
        this.OLDInversion = OLDInversion;
    }

    public float getSaldo() {
        return saldo;
    }

    private void setSaldo(float monto) {
        saldo = monto;
    }

    private OLDCuentaCredito getCuentaCredito() {
        return OLDCuentaCredito;
    }

    private void setCuentaCredito(OLDCuentaCredito OLDCuentaCredito) {
        this.OLDCuentaCredito = OLDCuentaCredito;
    }

    private OLDInversion getInversion() {
        return OLDInversion;
    }

    public boolean isCanceladoAutomaticoDeInversion() {
        return canceladoAutomaticoDeInversion;
    }

    private ArrayList<OLDInversion> getHistorialDeInversiones() {
        return historialDeInversiones;
    }

    private void agregarInversionAlHistorial(OLDInversion OLDInversion) {
        getHistorialDeInversiones().add(OLDInversion);
    }

    public boolean abrirCuentaCredito(float limiteDeGasto) {
        if (getCuentaCredito() == null) {
            setCuentaCredito(new OLDCuentaCredito(limiteDeGasto));
            return true;
        }
        return false;
    }

    public boolean hacerInversion(float monto, int duracion) {
        if (getInversion() == null || monto > getSaldo() + getLimiteDeGiroEnDescubierto()) {
            restarSaldoDebito(monto);
            setInversion(new OLDInversion(monto, duracion));
        }
        return false;
    }

    public boolean finalizarInversion(LocalDate fechaDeFinalizacion) {
        if (getInversion() != null) {
            sumarSaldoDebito(getInversion().retorno(fechaDeFinalizacion));
            agregarInversionAlHistorial(getInversion());
            setInversion(null);
            return true;
        }
        return false;
    }

    public boolean sumarSaldoDebito(float monto) {
        setSaldo(getSaldo() + monto);
        return true;
    }

    public OLDEstadoTransaccion restarSaldoDebito(float monto) {
        if (isCanceladoAutomaticoDeInversion()) {
            if (getSaldo() - monto + getPosibleRetornoDeInversion() > - getLimiteDeGiroEnDescubierto()) {
                if (getSaldo() - monto < 0) {
                    finalizarInversion(LocalDate.now());
                    System.out.println("Se cancelo la inversion para devolver fondos");
                }
                setSaldo(getSaldo() - monto);
                if (getSaldo() > 0) {
                    return OLDEstadoTransaccion.completada;
                }
                else return OLDEstadoTransaccion.giradoEnDescubierto;
            }
        }
        else {
            if (getSaldo() - monto > - getLimiteDeGiroEnDescubierto()) {
                setSaldo(getSaldo() - monto);
                if (getSaldo() > 0) {
                    return OLDEstadoTransaccion.completada;
                }
                else return OLDEstadoTransaccion.giradoEnDescubierto;
            }
        }
        return OLDEstadoTransaccion.noCompletada;
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

    public float getPosibleRetornoDeInversion() {
        if (getInversion() == null) {
            return 0;
        }
        else {
            return getInversion().retorno(LocalDate.now());
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

    public void activarCanceladoAutomaticoDeInversion() {
        System.out.println("Las inversiones se cancelaran si es necesario");
        canceladoAutomaticoDeInversion = true;
    }

    public void desactivarCanceladoAutomaticoDeInversion() {
        System.out.println("Las inversiones ya NO se cancelaran automaticamente");
        canceladoAutomaticoDeInversion = false;
    }

}
