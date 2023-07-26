package ejercicio1_razasperrosarraylist;

import Entidad.RazaPerro;
import Servicio.ServicioRazaPerro;
import Utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ServicioRazaPerro servRazaPerro = new ServicioRazaPerro();
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        
        // Agregamos razas de perros
        while(true){
            System.out.println("Ingrese una raza de perro o presione \"Q\" para salir");
            String inputUsuario = input.next();
            if(inputUsuario.matches("[Qq]"))
                break;
            int id = servRazaPerro.agregarRaza(servRazaPerro.crearNuevaRaza(inputUsuario));
            System.out.println("Raza agregada con id: " + id);
        }
        // Mostramos la lista de razas
        ArrayList<RazaPerro> razas = servRazaPerro.getRazasPerros();
        System.out.println("Se agregaron " + razas.size() + " raza/s de perros:");
        System.out.println(razas.toString());
        
        // Eliminamos una raza de perro
        System.out.println("Ingrese la raza que desea quitar: ");
        Boolean razaEliminada = servRazaPerro.quitarRaza(input.next());
        if(razaEliminada){
            System.out.println("La raza ha sido quitada");
        }else{
            System.out.println("La raza no se encuentra en la lista");
        }
        
        // Ordenamos y mostramos la lista de razas
        System.out.println("Lista de razas de perros ordenada: ");
        Collections.sort(razas, ServicioRazaPerro.compararPorNombreRazaAsc);
        System.out.println(razas.toString());
    }
    
}
