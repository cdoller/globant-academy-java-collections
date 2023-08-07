package Servicio;

import Entidad.CantanteFamoso;
import java.util.ArrayList;

public class ServicioCantenteFamoso{
    private ArrayList<CantanteFamoso> cantantes;

    public ServicioCantenteFamoso() {
        cantantes = new ArrayList<>();
    }
    
    public CantanteFamoso agregarCantante(String nombre, String discoConMasVentas){
        CantanteFamoso nuevoCantante = new CantanteFamoso(nombre, discoConMasVentas);
        cantantes.add(nuevoCantante);
        return nuevoCantante;
    }

    public ArrayList<CantanteFamoso> getCantantes() {
        return cantantes;
    }
    
    public Boolean eliminarCantante(String nombre){
        for (CantanteFamoso cantante : cantantes) {
            if(cantante.getNombre().equalsIgnoreCase(nombre)){
                cantantes.remove(cantante);
                return true;
            }                
        }
        return false;
    }
}