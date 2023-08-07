/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entidad.Pelicula;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Servicio.ServicioPelicula;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ServicioPeliculaTest {

    private ServicioPelicula servPelicula;

    public ServicioPeliculaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        servPelicula = new ServicioPelicula();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void debeFiltrarPeliculasPorDuracionMayor() {
        servPelicula.crearPelicula("Harry Potter 3", "Alfonso Cuarón", 139);
        servPelicula.crearPelicula("Senior de los Anillos 2", "Peter Jackson", 179);
        servPelicula.crearPelicula("John Wick 4", "Chad Stahelski", 169);
        Integer duracionMinima = 169;
        ArrayList<Pelicula> peliculasFiltradas = servPelicula.filtrarPeliculasDuracionMayorA(duracionMinima);
        for (Pelicula peli : peliculasFiltradas) {
            assertTrue(peli.getDuracionMinutos() >= duracionMinima);
        }
    }

}
