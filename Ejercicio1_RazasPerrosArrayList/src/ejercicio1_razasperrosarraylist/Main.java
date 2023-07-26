package ejercicio1_razasperrosarraylist;

import Entidad.RazaPerro;
import Servicio.ServicioRazaPerro;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ServicioRazaPerro servRazaPerro = new ServicioRazaPerro();
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        
        while(true){
            System.out.println("Ingrese una raza de perro o presione \"Y\" para salir");
            String inputUsuario = input.next();
            if(inputUsuario.matches("[Yy]"))
                break;
            int id = servRazaPerro.agregarRaza(servRazaPerro.crearNuevaRaza(inputUsuario));
            System.out.println("Raza agregada con id: " + id);
        }
        servRazaPerro.quitarRaza("Beagle");
        ArrayList<RazaPerro> razas = servRazaPerro.getRazasPerros();
        System.out.println("Se agregaron " + razas.size() + " raza/s de perros:");
        System.out.println(razas.toString());
    }
    
}
