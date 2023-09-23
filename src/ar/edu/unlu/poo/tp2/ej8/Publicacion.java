package ar.edu.unlu.poo.tp2.ej8;

public abstract class Publicacion {
    private String nombre;
    private String editor;
    private String telefonoProveedor;

    public Publicacion(String nombre, String editor, String telefonoProveedor) {
        setNombre(nombre);
        setEditor(editor);
        setTelefonoProveedor(telefonoProveedor);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    abstract public String descripcion();

    public boolean isNombre(String nombre) {
        return getNombre().equals(nombre);
    }
}
