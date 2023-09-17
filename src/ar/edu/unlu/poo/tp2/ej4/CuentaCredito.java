package ar.edu.unlu.poo.tp2.ej4;

public class CuentaCredito {
    private float limiteDeGasto;
    private final float maximoLimiteDeGasto;

    public CuentaCredito(float limiteDeGasto) {
        setLimiteDeGasto(limiteDeGasto);
        maximoLimiteDeGasto = limiteDeGasto;
    }

    private void setLimiteDeGasto(float limiteDeGasto) {
        this.limiteDeGasto = limiteDeGasto;
    }

    public float getLimiteDeGasto() {
        return limiteDeGasto;
    }

    public float getMaximoLimiteDeGasto() {
        return maximoLimiteDeGasto;
    }

    public void pagarDeuda(float monto) {
        setLimiteDeGasto(getLimiteDeGasto() + monto);
        if (getLimiteDeGasto() > getMaximoLimiteDeGasto()){
            setLimiteDeGasto(getMaximoLimiteDeGasto());
        }
    }

    public boolean realizarCompra(float monto) {
        if (getLimiteDeGasto() >= monto * 1.05) {
            setLimiteDeGasto((float) (getLimiteDeGasto() - (monto * 1.05)));
            return true;
        }
        return false;
    }
}
