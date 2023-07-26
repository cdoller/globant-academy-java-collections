package Entidad;

public class RazaPerro {

    private String nombre;

    public RazaPerro(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "RazaPerro{" + "nombre=" + nombre + '}';
    }

}
