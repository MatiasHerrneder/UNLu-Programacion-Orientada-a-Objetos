import ar.edu.unlu.poo.tp2.ej9.d2.*;
import ar.edu.unlu.poo.tp2.ej9.d3.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Figura2D> f2d = new ArrayList<>();
        f2d.add(new Circulo(2));
        f2d.add(new Cuadrado(2));
        f2d.add(new Rectangulo(2, 4));
        f2d.add(new Triangulo(2, 3));
        f2d.add(new Cubo(2));
        f2d.add(new Esfera(2));
        f2d.add(new Paralelepipedo(2, 3, 4));
        f2d.add(new TetraedroRegular(2));

        ArrayList<Figura3D> f3d = new ArrayList<>();
        f3d.add(new Cubo(2));
        f3d.add(new Esfera(2));
        f3d.add(new Paralelepipedo(2, 3, 4));
        f3d.add(new TetraedroRegular(2));

        System.out.println("--- Imprimo Area de todas las figuras ---");
        for (Figura2D f : f2d) {
            System.out.println(f.getClass().getSimpleName() + ": " + f.getArea());
        }

        System.out.println("--- Imprimo Area y Volumen de todas las figuras 3D ---");
        for (Figura3D f : f3d) {
            System.out.println(f.getClass().getSimpleName() + ", Area: " + f.getArea() + ", Volumen: " + f.getVolumen());
        }

    }
}