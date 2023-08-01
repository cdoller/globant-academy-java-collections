package ejercicio5_paises_set;

import Entidad.Pais;
import Enum.Continente;
import Servicio.ServicioPais;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        ServicioPais servPais = new ServicioPais();
        servPais.agregarPais("Suecia", Continente.EUROPA);
        servPais.agregarPais("Colombia", Continente.AMERICA);
        servPais.agregarPais("Argentina", Continente.AMERICA);
        servPais.agregarPais("Argentina", Continente.AMERICA); // no se agrega xq es un set

        // LISTADO DE PAISES DESDE EL HASHSET
        HashSet<Pais> paisesHashSet = servPais.getPaises();
        System.out.println("Listado de paises desde el HASHSET:");
        for (Pais pais : paisesHashSet) {
            System.out.println("Pais: " + pais.getNombre() + " - Continente: " + pais.getContinente());
        }
        
        // PAISES ORDENADOS DESDE EL HASHSET A-Z
        ArrayList<Pais> paisesList = new ArrayList<Pais>(servPais.getPaises());
        Collections.sort(paisesList, Pais.compararPorNombreAsc);
        System.out.println("\nListado de paises ArrayList/HashSet [A-Z]:");
        for (Pais pais : paisesList) {
            System.out.println(pais.getNombre());
        }
        
        // PAISES ORDENADOS DESDE EL TREESET A-Z
        TreeSet<Pais> paisesTree = servPais.getPaisesOrdenados();
        System.out.println("\nListado de paises TreeSet [A-Z]:");
        for (Pais pais : paisesTree) {
            System.out.println(pais.getNombre());
        }
        
        // PAISES ORDENADOS DESDE EL TREESET Z-A
        TreeSet<Pais> paisesTree2 = new TreeSet<>(Collections.reverseOrder(Pais.compararPorNombreAsc));
        paisesTree2.addAll(paisesTree);
        
        System.out.println("\nListado de paises TreeSet[Z-A]:");
        for (Pais pais : paisesTree2) {
            System.out.println(pais.getNombre());
        }
        
        // PAISES ORDENADOS DESDE EL HASHSET Z-A
        ArrayList<Pais> paisesList2 = new ArrayList<Pais>(servPais.getPaises());
        Collections.sort(paisesList2, Pais.compararPorNombreAsc.reversed());
        System.out.println("\nListado de paises HashSet/ArrayList [Z-A]:");
        for (Pais pais : paisesList2) {
            System.out.println(pais.getNombre());
        }
        
        //////////////////////////////////////////////////////////////////////////
        System.out.println("\nPaises a borrar: ");
        System.out.println("Brasil: " + servPais.borrarPais("Brasil", Continente.AMERICA));
        System.out.println("Argentina Africana (?): " + servPais.borrarPais("Argentina", Continente.AFRICA));
        System.out.println("Argentina: " + servPais.borrarPais("Argentina", Continente.AMERICA));
        
        //////////////////////////////////////////////////////////////////////////
        System.out.println("\nListado de paises luego de borrar HASHSET:");
        for (Pais pais : paisesHashSet) {
            System.out.println(pais.getNombre());
        }
        //////////////////////////////////////////////////////////////////////////
        System.out.println("\nListado de paises luego de borrar TREESET:");
        for (Pais pais : paisesTree) {
            System.out.println(pais.getNombre());
        }
    }

}
