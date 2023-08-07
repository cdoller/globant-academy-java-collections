package ejercicio1_extra_numeros_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(">>> ");
            Integer nuevoNumero = input.nextInt();
            if (nuevoNumero.equals(-99)) {
                break;
            }
            numeros.add(nuevoNumero);
        }
        System.out.println("Se agregaron " + numeros.size() + " numeros");
        numeros.forEach(numero -> System.out.print(numero + " "));
        System.out.println("");
        System.out.println("La suma de los numeros es: " + calcularSuma(numeros));
        System.out.println("La suma de los numeros es: " + calcularSuma(numeros) / numeros.size());
    }

    public static Double calcularSuma(ArrayList<Integer> numeros) {
        Double suma = 0.0;
        for (Integer numero : numeros) {
            suma += numero;
        }
        return suma;
    }

}
