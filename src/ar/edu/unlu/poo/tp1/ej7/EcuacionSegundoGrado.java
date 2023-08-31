package ar.edu.unlu.poo.tp1.ej7;

public class EcuacionSegundoGrado {

    private final int a;
    private final int b;
    private final int c;

    EcuacionSegundoGrado(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public double[] encontrarRaices() {
        //(-b ± √((b^2) - (4 * a * c))) / (2 * a)
        //((b^2) - 4 * a * c)
        double[] res;

        double discriminante = Math.pow(getB(),2) - 4 * getA() * getC();
        if (discriminante < 0) {
            res = new double[0];
        }
        else if (discriminante == 0) {
            res = new double[1];
            res[0] = - getB();
        }
        else {
            res = new double[2];
            res[0] = - getB() + Math.sqrt(discriminante) / (2 * getA());
            res[1] = - getB() - Math.sqrt(discriminante) / (2 * getA());
        }
        return res;
    }

    public double resolverParaX(int x) {
        //y = a * x^2 + b * x + c
        return getA() * Math.pow(x, 2) + getB() * x + getC();
    }
}
