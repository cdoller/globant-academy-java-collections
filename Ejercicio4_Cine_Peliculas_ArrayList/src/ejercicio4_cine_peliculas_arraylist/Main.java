package ejercicio4_cine_peliculas_arraylist;

import Servicio.ServicioPelicula;
import Entidad.Pelicula;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        ServicioPelicula servPelicula = new ServicioPelicula();

        servPelicula.crearPelicula("Harry Potter 3", "Alfonso Cuarón", 139);
        servPelicula.crearPelicula("Senior de los Anillos 2", "Peter Jackson", 179);
        servPelicula.crearPelicula("John Wick 4", "Chad Stahelski", 169);
        servPelicula.crearPelicula("Interestelar", "Christopher Nolan", 169);
        servPelicula.crearPelicula("Yo antes de ti", "Thea Sharrock", 110);
        
        Boolean terminar = false;
        while(!terminar){
            System.out.println("---- Menu Peliculas Cine ----");
            System.out.println("| 1 - Agregar Pelicula");
            System.out.println("| 2 - Mostrar listado peliculas");
            System.out.println("| 3 - Ordenar Peliculas");
            System.out.println("| 4 - Filtrar Peliculas por duracion");
            System.out.println("| 9 - Para SALIR");
            System.out.print("| >>>>>  ");
            int opcion = input.nextInt();
            switch(opcion){
                case 1:
                    System.out.print("Ingrese titulo: ");
                    String titulo = input.next();
                    System.out.print("Ingrese director: ");
                    String director = input.next();
                    System.out.print("Ingrese duracion en minutos: ");
                    Integer duracion = input.nextInt();
                    servPelicula.crearPelicula(titulo, director, duracion);
                    if(servPelicula.crearPelicula(titulo, director, duracion))
                        System.out.println("Pelicula agregada exitosamente");
                    break;
                case 2:
                    mostrarPeliculas(servPelicula.getPeliculas());
                    break;
                case 3:
                    System.out.println("| A - Por titulo alfabeticamente");
                    System.out.println("| B - Por duracion menor a mayor");
                    System.out.println("| C - Por duracion mayor a menor");
                    System.out.println("| D - Por director alfabeticamente");
                    String opcionOrdenar = input.next();
                    switch(opcionOrdenar){
                        case "A":
                            Collections.sort(servPelicula.getPeliculas(), ServicioPelicula.compararPorTituloAsc);
                            break;
                        case "B":
                            Collections.sort(servPelicula.getPeliculas(), ServicioPelicula.compararPorDuracionAsc);
                            break;
                        case "C":
                            Collections.sort(servPelicula.getPeliculas(), ServicioPelicula.compararPorDuracionDesc);
                            break;
                        case "D":
                            Collections.sort(servPelicula.getPeliculas(), ServicioPelicula.compararPorDirectorAsc);
                            break;
                    }
                    mostrarPeliculas(servPelicula.getPeliculas());
                    break;
                case 4:
                    System.out.print("Ingrese la duracion minima: ");
                    int duracionMinima = input.nextInt();
                    mostrarPeliculas(servPelicula.filtrarPeliculasDuracionMayorA(duracionMinima));
                    break;
                default:
                    terminar = true;
            }
        }
    }
    
    public static void mostrarPeliculas(ArrayList<Pelicula> peliculas){
        Iterator<Pelicula> it = peliculas.iterator();
        int contador = 1;
        while(it.hasNext()){
            Pelicula pelicula = it.next();
            System.out.println(contador + " )");
            System.out.println("Titulo  : " + pelicula.getTitulo());
            System.out.println("Director: " + pelicula.getDirector());
            System.out.println("Duracion: " + pelicula.getDuracionMinutos());
            contador ++;
        }
    }

}
