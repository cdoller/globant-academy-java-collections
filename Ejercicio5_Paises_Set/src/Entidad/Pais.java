package Entidad;

import java.util.Objects;
import Enum.Continente;
import java.util.Comparator;

public class Pais{
    private String nombre;
    private Continente continente;

    public Pais(String nombre, Continente continente) {
        this.nombre = nombre;
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + ", continente=" + continente + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        hash = 83 * hash + Objects.hashCode(this.continente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.nombre, other.getNombre())) {
            return false;
        }
        if (this.continente != other.getContinente()) {
            return false;
        }
        return true;
    }
    
    public static Comparator<Pais> compararPorNombreAsc = (Pais p1, Pais p2) 
            -> p1.getNombre().compareTo(p2.getNombre());
    
}