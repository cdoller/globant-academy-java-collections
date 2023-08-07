package ejercicio2_extra_cantantes;

import Entidad.CantanteFamoso;
import Servicio.ServicioCantenteFamoso;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        CantanteFamoso cantante;
        ServicioCantenteFamoso servCantanteFamoso = new ServicioCantenteFamoso();
        Boolean bandera = true;

        servCantanteFamoso.agregarCantante("Elvis Presley", "Elvis' Christmas Album");
        servCantanteFamoso.agregarCantante("Michael Jackson", "Thriller");
        servCantanteFamoso.agregarCantante("The Weeknd", "After Hours");
        servCantanteFamoso.agregarCantante("Soda Stereo", "Canción animal");
        servCantanteFamoso.agregarCantante("Queen", "Greatest Hits");

        mostrarListaCantantes(servCantanteFamoso.getCantantes());

        do {
            System.out.println("---Menu Cantantes---");
            System.out.println("| A. Agregar Cantante");
            System.out.println("| B. Mostrar Todos");
            System.out.println("| C. Eliminar Cantante");
            System.out.println("| Q. Salir");
            System.out.print(">>>> ");
            switch (input.next().toUpperCase()) {
                case "A":
                    System.out.print("Ingrese nombre:");
                    String nombre = input.next();
                    System.out.print("Ingrese disco mas vendido:");
                    String discoMasVendido = input.next();
                    cantante = servCantanteFamoso.agregarCantante(nombre, discoMasVendido);
                    if (cantante == null) {
                        System.out.println("El cantante no pudo darse de alta");
                        break;
                    }
                    System.out.println("Cantante " + cantante.getNombre() + " agregado");
                    break;
                case "B":
                    mostrarListaCantantes(servCantanteFamoso.getCantantes());
                    break;
                case "C":
                    System.out.print("Ingrese el nombre: ");
                    nombre = input.next();
                    if (!servCantanteFamoso.eliminarCantante(nombre)) {
                        System.out.println("El cantante " + nombre + "no se ha podido eliminar");
                        break;
                    }
                    System.out.println("El cantante " + nombre + " ha sido eliminado");
                    break;
                case "Q":
                    System.out.println("Gracias, nos vemos");
                    bandera = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelva a ingresar");
            }
        } while (bandera);
    }

    public static void mostrarListaCantantes(ArrayList<CantanteFamoso> cantantes) {
        for (CantanteFamoso cantante : cantantes) {
            System.out.println(cantante.getNombre() + " - Disco mas vendido: " + cantante.getDiscoConMasVentas());
        }
    }

}
