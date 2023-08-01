package Servicio;

import java.util.HashSet;
import Entidad.Pais;
import Enum.Continente;
import java.util.Iterator;
import java.util.TreeSet;

public class ServicioPais{
    HashSet<Pais> paises;
    TreeSet<Pais> paisesOrdenados;
    
    public ServicioPais(){
        paises = new HashSet();
        paisesOrdenados = new TreeSet<Pais>(Pais.compararPorNombreAsc);
    }

    public HashSet<Pais> getPaises() {
        return paises;
    }

    public TreeSet<Pais> getPaisesOrdenados() {
        return paisesOrdenados;
    }
            
    public Pais agregarPais(String nombre, Continente continente){
        Pais nuevoPais = new Pais(nombre, continente);
        paises.add(nuevoPais);
        paisesOrdenados.add(nuevoPais);
        return nuevoPais;
    }
    
    public Boolean borrarPais(String nombre, Continente continente){
        Iterator<Pais> it = paises.iterator();
        while(it.hasNext()){
            Pais pais = it.next();
            if(pais.equals(new Pais(nombre, continente))){
                it.remove();
                paisesOrdenados.remove(pais);
                return true;
            }
        }
        return false;
    }
}