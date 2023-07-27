package Entidad;

import java.util.ArrayList;

public class Alumno{
    private String nombre;
    private ArrayList<Integer> notas;
    
    public Alumno(String nombre){
        this.nombre = nombre;
        notas = new ArrayList<Integer>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }
    
    public void agregarNota(int nota){
        notas.add(nota);
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", notas=" + notas.toString() + '}';
    }
    
    
    
}