
package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 *
 * @author Usuario
 */
public class SesionTutoriaDAOTest {
    
    public SesionTutoriaDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRegistrarSesionTutoria() {
        System.out.println("registrarSesionTutoria");
        SesionTutoriaDAO sesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
        nuevaSesionTutoria.setNumTutoria("4");
        nuevaSesionTutoria.setFechaTutoria("2022-01-12");
        
        sesionTutoriaDAO.registrarSesionTutoria(nuevaSesionTutoria);

        String tutoriaBuscada = "4";
        ArrayList<SesionTutoria> expResult = new ArrayList<>();
        SesionTutoria tutoriaEsperada = new SesionTutoria();
        tutoriaEsperada.setNumTutoria("4");
        tutoriaEsperada.setFechaTutoria("2022-01-12");
        
        expResult.add(tutoriaEsperada);
        ArrayList<SesionTutoria> result = (ArrayList<SesionTutoria>) sesionTutoriaDAO.consultarSesionesTutoriaPorNumero(tutoriaBuscada);
        
        for(SesionTutoria sesionTutoria : result){
            System.out.println(String.format("%s %s", sesionTutoria.getNumTutoria(), sesionTutoria.getFechaTutoria()));
        }
        for(SesionTutoria sesionTutoria : expResult){
            System.out.println(String.format("%s %s", sesionTutoria.getNumTutoria(), sesionTutoria.getFechaTutoria()));
        }
        assertEquals(expResult, result);
    }
/*
    @Test
    public void testConsultarSesionesTutoriaPorNumero() {
        System.out.println("consultarSesionesTutoriaPorNumero");
        int tutoriaBuscada = 0;
        SesionTutoriaDAO instance = new SesionTutoriaDAO();
        List<SesionTutoria> expResult = null;
        List<SesionTutoria> result = instance.consultarSesionesTutoriaPorNumero(tutoriaBuscada);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of consultarSesionesTutoriaPorNumero method, of class SesionTutoriaDAO.
     */
    @Test
    public void testConsultarSesionesTutoriaPorNumero() {
        System.out.println("consultarSesionesTutoriaPorNumero");
        String tutoriaBuscada = "";
        SesionTutoriaDAO instance = new SesionTutoriaDAO();
        List<SesionTutoria> expResult = null;
        List<SesionTutoria> result = instance.consultarSesionesTutoriaPorNumero(tutoriaBuscada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCierreDeReporte method, of class SesionTutoriaDAO.
     */
    @Test
    public void testRegistrarCierreDeReporte() {
        System.out.println("registrarCierreDeReporte");
        SesionTutoriaDAO sesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
        nuevaSesionTutoria.setNumTutoria("4");
        nuevaSesionTutoria.setFechaCierreReportes("2022-06-05");
        
        sesionTutoriaDAO.registrarFechaDeCierreDeReporte(nuevaSesionTutoria, 1);

        int idTutoriaBuscada = 91;
        ArrayList<SesionTutoria> expResult = new ArrayList<>();
        SesionTutoria tutoriaEsperada = new SesionTutoria();
        tutoriaEsperada.setNumTutoria("4");
        tutoriaEsperada.setFechaCierreReportes("2022-06-05");
        
        expResult.add(tutoriaEsperada);
        ArrayList<SesionTutoria> result = (ArrayList<SesionTutoria>) sesionTutoriaDAO.consultarTutoriaPorId(idTutoriaBuscada);
        
        for(SesionTutoria sesionTutoria : result){
            System.out.println(String.format("%s",sesionTutoria.getFechaCierreReportes()));
        }
        for(SesionTutoria sesionTutoria : expResult){
            System.out.println(String.format("%s", sesionTutoria.getFechaCierreReportes()));
        }
        assertEquals(expResult, result);

    }
}
