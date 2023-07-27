package Servicio;

import java.util.ArrayList;
import Entidad.Alumno;
import java.util.Iterator;

public class ServicioAlumno {

    private ArrayList<Alumno> alumnos;

    public ServicioAlumno() {
        alumnos = new ArrayList<Alumno>();
    }

    public void crearAlumno(String nombre, int[] cantNotas) {
        Alumno nuevoAlumno = new Alumno(nombre);
        for (int i = 0; i < cantNotas.length; i++) {
            nuevoAlumno.agregarNota(cantNotas[i]);
        }
        alumnos.add(nuevoAlumno);
    }

    public Double calcularNotaFinal(String nombre) {
        Double sumaNotas = 0.0;
        Alumno alumno = buscarAlumno(nombre);
        
        if (alumno == null) 
            return sumaNotas;

        ArrayList<Integer> notas = alumno.getNotas();
        for (Integer nota : notas) {
            sumaNotas += nota;
        }
        return sumaNotas / notas.size();
    }

    private Alumno buscarAlumno(String nombre) {
        Iterator<Alumno> it = alumnos.iterator();

        while (it.hasNext()) {
            Alumno alumno = it.next();
            if (alumno.getNombre().equals(nombre)) {
                return alumno;
            }
        }

        return null;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

}
