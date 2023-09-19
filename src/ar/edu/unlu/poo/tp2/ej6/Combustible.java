package ar.edu.unlu.poo.tp2.ej6;

public enum Combustible {
    NAFTA(15), GASOIL(10), KEROSENE(5);

    private final int precio;

    private Combustible(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return this.precio;
    }

    public static Combustible getCombustiblePorValor(int valor) {
        for (Combustible c : values()) {
            if (c.ordinal() == valor) return c;
        }
        throw new IllegalArgumentException("Valor invalido para Combustible: " + valor);
    }
}
