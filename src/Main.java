import ar.edu.unlu.poo.tp1.ej7.Calculadora;

public class Main {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        System.out.println("-----------------");
        c.testear(5,6,7,2);
        System.out.println("-----------------");
        c.testear(1,0,-1,3);
        System.out.println("-----------------");
        c.testear(1,0,0,1);
    }
}