package Servicio;

import java.util.ArrayList;
import java.util.Comparator;
import Entidad.Pelicula;

public class ServicioPelicula{
    ArrayList<Pelicula> peliculas;
    
    public ServicioPelicula(){
        peliculas = new ArrayList<Pelicula>();
    }
    
    public Boolean crearPelicula(String titulo, String director, Integer duracionMinutos){
        Pelicula nuevaPelicula = new Pelicula(titulo, director, duracionMinutos);
        peliculas.add(nuevaPelicula);
        return true;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }
    
    /**
     * Filtra las peliculas segun su duracion
     * @param duracionMinutos duracion minima de la pelicula
     * @return las peliculas filtradas segun duracionMinutos
     */
    public ArrayList<Pelicula> filtrarPeliculasDuracionMayorA(Integer duracionMinutos){
        ArrayList<Pelicula> peliculasFiltradas = new ArrayList<Pelicula>();
        for (Pelicula pelicula : peliculas) {
            if(pelicula.getDuracionMinutos() >= duracionMinutos)
                peliculasFiltradas.add(pelicula);
        }
        return peliculasFiltradas;
    }

    @Override
    public String toString() {
        return "Listado Peliculas:\n" + peliculas.toString();
    }
    
    // COMPARATORS
    
    public static Comparator<Pelicula> compararPorDuracionAsc = (Pelicula p, Pelicula p1) 
            -> p.getDuracionMinutos().compareTo(p1.getDuracionMinutos());
    
    public static Comparator<Pelicula> compararPorDuracionDesc = (Pelicula p, Pelicula p1)
            -> p1.getDuracionMinutos().compareTo(p.getDuracionMinutos());
    
    public static Comparator<Pelicula> compararPorTituloAsc = (Pelicula p, Pelicula p1)
            -> p.getTitulo().compareTo(p1.getTitulo());
    
    public static Comparator<Pelicula> compararPorDirectorAsc = (Pelicula p, Pelicula p1)
            -> p.getDirector().compareTo(p1.getDirector());
}