package ar.edu.unlu.poo.tp1.ej8;

public class Password {
    private String contra;

    private final String letras = "abcdefghijklmnopqrstuvwxyz";

    public Password(int longitud) {
        setContra(longitud);
    }

    public Password() {
        this(8);
    }

    public boolean esFuerte() {
        String pass = getContra();
        int cMay = 0;
        int cMin = 0;
        int cNum = 0;
        int i = 0;
        while (i < pass.length() && !(cMay > 2 && cMin > 1 && cNum >= 2)) {
            char ch = pass.charAt(i);
            if (letras.indexOf(ch) >= 0) cMin++;
            else if (letras.indexOf(Character.toLowerCase(ch)) >= 0) cMay++;
            else cNum++;
            i++;
        }
        return cMay > 2 && cMin > 1 && cNum >= 2;
    }

    public String getContra() {
        return contra;
    }

    private void setContra(int longitud) {
        if (longitud < 8 || longitud > 24)
            longitud = 8;
        contra = "";
        for (int i = 0; i < longitud; i++){
            double opc = Math.random();
            if (opc < 1.0/3) contra += letras.charAt((int)(Math.random() * (26)));
            else if (opc < (1.0/3) * 2) contra += Character.toUpperCase(letras.charAt((int)(Math.random() * (26))));
            else contra += (int)(Math.random() * 10);
        }
    }

    public void crearContraFuerte(int longitud){
        while(!esFuerte()) setContra(longitud);
    }

}
