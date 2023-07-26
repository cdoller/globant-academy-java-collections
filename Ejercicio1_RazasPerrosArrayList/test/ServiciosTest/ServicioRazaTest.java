/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosTest;

import Entidad.RazaPerro;
import Servicio.ServicioRazaPerro;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServicioRazaTest {
    
    ServicioRazaPerro servRazaPerro;

    public ServicioRazaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        servRazaPerro = new ServicioRazaPerro();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void debeCrearNuevaRaza(){
        RazaPerro nuevaRaza = servRazaPerro.crearNuevaRaza("Beagle");
        assertEquals(nuevaRaza.getNombre(), "Beagle");
    }
    
    @Test
    public void debeAgregarNueva(){
        RazaPerro nuevaRaza1 = servRazaPerro.crearNuevaRaza("Beagle");
        RazaPerro nuevaRaza2 = servRazaPerro.crearNuevaRaza("Beagle");
        assertEquals(0, servRazaPerro.agregarRaza(nuevaRaza1));
        assertEquals(1, servRazaPerro.agregarRaza(nuevaRaza2));
    }
    
    @Test
    public void mostrarLista(){
        String[] razas = {"Beagle", "Salchica", "Dogo", "Callejero"};
        
        for(String raza : razas){
            servRazaPerro.agregarRaza(servRazaPerro.crearNuevaRaza(raza));
        }
        
        ArrayList<RazaPerro> razasPerros = servRazaPerro.getRazasPerros();
        for(int i=0; i<razasPerros.size(); i++){
            System.out.println(i);
            assertEquals(razasPerros.get(i).getNombre(), razas[i]);
        }
        
    }

}
