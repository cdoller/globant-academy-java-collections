package Servicio;

import Entidad.RazaPerro;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ServicioRazaPerro {

    private ArrayList<RazaPerro> razasPerros;

    public ServicioRazaPerro() {
        razasPerros = new ArrayList<RazaPerro>();
    }

    public ArrayList<RazaPerro> getRazasPerros() {
        return razasPerros;
    }

    /**
     * Crea una nueva raza
     *
     * @param nombreRaza
     * @return
     */
    public RazaPerro crearNuevaRaza(String nombreRaza) {
        return new RazaPerro(nombreRaza);
    }

    /**
     * Agrega una nueva raza
     *
     * @param raza
     * @return indice del ultimo elemento creado
     */
    public int agregarRaza(RazaPerro raza) {
        razasPerros.add(raza);
        return razasPerros.lastIndexOf(raza);
    }
    
    /**
     * Eliminar una raza de perro
     * @param raza, nombre de la raza que se desea quitar
     * @return true, si la raza fue eliminada
     */
    public Boolean quitarRaza(String raza){
        Iterator<RazaPerro> it = razasPerros.iterator();
        while(it.hasNext()){
            if(it.next().getNombre().equals(raza)){
                it.remove();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodos de ordenamiento
     */
    public static Comparator<RazaPerro> compararPorNombreRazaAsc = (RazaPerro t, RazaPerro t1) -> t.getNombre().compareTo(t1.getNombre());
    public static Comparator<RazaPerro> compararPorNombreRazaDesc = (RazaPerro r, RazaPerro r1) -> r1.getNombre().compareTo(r.getNombre());
    
//    public static Comparator<RazaPerro> compararPorNombreRazaAsc = new Comparator<RazaPerro>(){
//        @Override
//        public int compare(RazaPerro t, RazaPerro t1) {
//            return t.getNombre().compareTo(t1.getNombre());
//        }        
//    };
}
