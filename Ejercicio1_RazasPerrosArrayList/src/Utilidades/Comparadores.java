package Utilidades;

import Entidad.RazaPerro;
import java.util.Comparator;

public class Comparadores {

    public static Comparator<RazaPerro> compararPorNombreRazaAsc = new Comparator<RazaPerro>(){
        @Override
        public int compare(RazaPerro t, RazaPerro t1) {
            return t.getNombre().compareTo(t1.getNombre());
        }        
    };
    
    public static Comparator<RazaPerro> compararPorNombreRazaDesc = new Comparator<RazaPerro>(){
        @Override
        public int compare(RazaPerro t, RazaPerro t1) {
            return t1.getNombre().compareTo(t.getNombre());
        }        
    };
}
