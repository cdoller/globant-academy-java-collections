
import Entidad.Alumno;
import Servicio.ServicioAlumno;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServicioAlumnoTest {

    ServicioAlumno servAlumno;

    public ServicioAlumnoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        servAlumno = new ServicioAlumno();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void debeCrearAlumno() {
        int[] notas = {5, 6, 10};
        servAlumno.crearAlumno("Jose", notas);
        assertEquals(1, servAlumno.getAlumnos().size());
    }

    @Test
    public void debeCalcularNota() {
        int[] notas = {5, 6, 10};
        int[] notas2 = {};
        int[] notas3 = {10, 6, 7};
        servAlumno.crearAlumno("Carlos", notas);
        servAlumno.crearAlumno("Matias", notas2);
        servAlumno.crearAlumno("Jose", notas3);
        assertEquals(7.0, servAlumno.calcularNotaFinal(servAlumno.buscarAlumno("Carlos")), 0.01);
        assertEquals(0.0, servAlumno.calcularNotaFinal(servAlumno.buscarAlumno("Matias")), 0.01);
        assertEquals(7.66, servAlumno.calcularNotaFinal(servAlumno.buscarAlumno("Jose")), 0.01);
        assertEquals(0.0, servAlumno.calcularNotaFinal(servAlumno.buscarAlumno("Marcos")), 0.01);
    }

    @Test
    public void debeRetornarUnArrayList() {
        int[] notas = {5, 6, 10};
        servAlumno.crearAlumno("Jose", notas);
        Object alumno = servAlumno.getAlumnos();
        assertTrue(alumno instanceof ArrayList);
    }
    
    @Test
    public void debeBuscarAlumno(){
        int[] notas = {5, 6, 10};
        servAlumno.crearAlumno("Pepe", notas);
        servAlumno.crearAlumno("Samuel", notas);
        assertEquals("Samuel", servAlumno.buscarAlumno("Samuel").getNombre());
        assertNull(servAlumno.buscarAlumno("Sofia"));
    }

}
