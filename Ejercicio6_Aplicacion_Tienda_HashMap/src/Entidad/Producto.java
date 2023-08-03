package Entidad;

public class Producto{
    private String nombre;
    private Double precio;
    private Boolean activo;
    
    public Producto(String nombre, Double precio){
        this.nombre = nombre;
        this.precio = precio;
        activo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + '}';
    }
    
}