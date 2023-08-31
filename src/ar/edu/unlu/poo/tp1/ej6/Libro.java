package ar.edu.unlu.poo.tp1.ej6;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private int cantDePaginas;
    private int cantTotalEjemplares;
    private int ejemplaresDisponibles;
    private int cantidadDePrestamosRealizados = 0;

    public Libro(String titulo, String autor, String isbn, int cantDePaginas, int cantTotalEjemplares) {
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        setCantDePaginas(cantDePaginas);
        setCantTotalEjemplares(cantTotalEjemplares);
        setEjemplaresDisponibles(cantTotalEjemplares);
    }

    public Libro(String titulo, String autor, int cantDePaginas, int cantTotalEjemplares) {
        this(titulo, autor, "", cantDePaginas, cantTotalEjemplares);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantDePaginas() {
        return cantDePaginas;
    }

    public void setCantDePaginas(int cantDePaginas) {
        this.cantDePaginas = cantDePaginas;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public int getCantTotalEjemplares() {
        return cantTotalEjemplares;
    }

    public void setCantTotalEjemplares(int cantTotalEjemplares) {
        this.cantTotalEjemplares = cantTotalEjemplares;
    }

    public int getCantidadDePrestamosRealizados() {
        return cantidadDePrestamosRealizados;
    }

    private void incrementarPrestamosRealizados() {
        cantidadDePrestamosRealizados++;
    }

    public boolean prestarLibro() {
        if (getEjemplaresDisponibles() > 1) {
            setEjemplaresDisponibles(getEjemplaresDisponibles() - 1);
            incrementarPrestamosRealizados();
            return true;
        }
        return false;
    }

    public boolean devolverLibro() {
        if (getCantTotalEjemplares() > getEjemplaresDisponibles()) {
            setEjemplaresDisponibles(getEjemplaresDisponibles() + 1);
            return true;
        }
        return false;
    }

    public boolean inTitulo(String aComparar){
        return getTitulo().contains(aComparar);
    }

    public boolean inAutor(String aComparar){
        return getAutor().contains(aComparar);
    }

    public boolean inISBN(String aComparar){
        return getIsbn().contains(aComparar);
    }

    @Override
    public String toString() {
        return "El libro " +  getTitulo() +
                " creado por el autor " + getAutor() +
                " tiene " + getCantDePaginas() +
                " páginas, quedan " + getEjemplaresDisponibles() +
                " disponibles y se prestaron " + (getCantTotalEjemplares() - getEjemplaresDisponibles());
    }
}
