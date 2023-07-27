package ejercicio3_alumno_notas_arraylist;

import Servicio.ServicioAlumno;

public class Main {

    public static void main(String[] args) {
        ServicioAlumno servAlumno = new ServicioAlumno();
        int[] arrayNotas1 = {8,8,9};
        int[] arrayNotas2 = {10,10,9,10};
        servAlumno.crearAlumno("Carlos", arrayNotas1);
        servAlumno.crearAlumno("Franco", arrayNotas2);

        System.out.println("Carlos, nota final: " + servAlumno.calcularNotaFinal("Carlos"));
        System.out.println("Franco, nota final: " + servAlumno.calcularNotaFinal("Franco"));
        System.out.println("Pedro, nota final: " + servAlumno.calcularNotaFinal("Pedro"));

        System.out.println(servAlumno.getAlumnos().toString());
    }

}
