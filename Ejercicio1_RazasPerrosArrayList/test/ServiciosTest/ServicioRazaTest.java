/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosTest;

import Entidad.RazaPerro;
import Servicio.ServicioRazaPerro;
import java.util.ArrayList;
import java.util.Collections;
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
    public void debeCrearNuevaRaza() {
        RazaPerro nuevaRaza = servRazaPerro.crearNuevaRaza("Beagle");
        assertEquals(nuevaRaza.getNombre(), "Beagle");
    }

    @Test
    public void debeAgregarNueva() {
        RazaPerro nuevaRaza1 = servRazaPerro.crearNuevaRaza("Beagle");
        RazaPerro nuevaRaza2 = servRazaPerro.crearNuevaRaza("Beagle");
        assertEquals(0, servRazaPerro.agregarRaza(nuevaRaza1));
        assertEquals(1, servRazaPerro.agregarRaza(nuevaRaza2));
    }

    @Test
    public void debeMostrarLista() {
        String[] razas = {"Beagle", "Salchicha", "Dogo", "Callejero"};
        String[] razas2 = {"Beagle", "Dogo", "Callejero"};

        for (String raza : razas) {
            servRazaPerro.agregarRaza(servRazaPerro.crearNuevaRaza(raza));
        }

        ArrayList<RazaPerro> razasPerros = servRazaPerro.getRazasPerros();
        for (int i = 0; i < razasPerros.size(); i++) {
            assertEquals(razasPerros.get(i).getNombre(), razas[i]);
        }

        servRazaPerro.quitarRaza("Salchicha");
        for (int i = 0; i < razasPerros.size(); i++) {
            assertEquals(razasPerros.get(i).getNombre(), razas2[i]);
        }

    }

    @Test
    public void debeQuitarRaza() {
        String[] razas = {"Beagle", "Salchicha", "Dogo", "Callejero"};
        for (String raza : razas) {
            servRazaPerro.agregarRaza(servRazaPerro.crearNuevaRaza(raza));
        }
        assertTrue(servRazaPerro.quitarRaza("Dogo"));
        assertTrue(servRazaPerro.quitarRaza("Salchicha"));
        assertFalse(servRazaPerro.quitarRaza("Labrador"));
    }

    @Test
    public void debeOrdenarPorNombre() {
        String[] razas = {"Salchicha", "Beagle", "Dogo", "Callejero"};
        String[] razasOrdenadasAsc = {"Beagle", "Callejero", "Dogo", "Salchicha"};
        String[] razasOrdenadasDesc = {"Salchicha", "Dogo", "Callejero", "Beagle"};

        for (String raza : razas) {
            servRazaPerro.agregarRaza(servRazaPerro.crearNuevaRaza(raza));
        }
        ArrayList<RazaPerro> razasPerros = servRazaPerro.getRazasPerros();

        Collections.sort(razasPerros, ServicioRazaPerro.compararPorNombreRazaAsc);
        for (int i = 0; i < razasPerros.size(); i++) {
            assertEquals(razasPerros.get(i).getNombre(), razasOrdenadasAsc[i]);
        }

        Collections.sort(razasPerros, ServicioRazaPerro.compararPorNombreRazaDesc);
        for (int i = 0; i < razasPerros.size(); i++) {
            assertEquals(razasPerros.get(i).getNombre(), razasOrdenadasDesc[i]);
        }
    }
}
