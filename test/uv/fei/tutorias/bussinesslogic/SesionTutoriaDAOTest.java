/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogic;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 *
 * @author DMS19
 */
public class SesionTutoriaDAOTest {
    
    public SesionTutoriaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registrarSesionTutoria method, of class SesionTutoriaDAO.
     */
    @Test
    public void testRegistrarSesionTutoria() throws Exception {
        System.out.println("registrarSesionTutoria");
        SesionTutoria sesionTutoria = null;
        SesionTutoriaDAO instance = new SesionTutoriaDAO();
        int expResult = 0;
        int result = instance.registrarSesionTutoria(sesionTutoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

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
     * Test of consultarTutoriaPorId method, of class SesionTutoriaDAO.
     */
    @Test
    public void testConsultarTutoriaPorId() {
        System.out.println("consultarTutoriaPorId");
        int idTutoriaBuscada = 0;
        SesionTutoriaDAO instance = new SesionTutoriaDAO();
        List<SesionTutoria> expResult = null;
        List<SesionTutoria> result = instance.consultarTutoriaPorId(idTutoriaBuscada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPeriodoPorId method, of class SesionTutoriaDAO.
     */
    @Test
    public void testBuscarPeriodoPorId() {
        System.out.println("buscarPeriodoPorId");
        String fechaInicio = "";
        String fechaFin = "";
        SesionTutoriaDAO instance = new SesionTutoriaDAO();
        int expResult = 0;
        int result = instance.buscarPeriodoPorId(fechaInicio, fechaFin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarFechasDeSesionTutoria method, of class SesionTutoriaDAO.
     */
    @Test
    public void testActualizarFechasDeSesionTutoria() throws Exception {
        System.out.println("actualizarFechasDeSesionTutoria");
        SesionTutoria sesionTutoria = null;
        int idPeriodo = 0;
        String numTutoria = "";
        SesionTutoriaDAO instance = new SesionTutoriaDAO();
        int expResult = 0;
        int result = instance.actualizarFechasDeSesionTutoria(sesionTutoria, idPeriodo, numTutoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarFechaDeCierreDeReporte method, of class SesionTutoriaDAO.
     */
    @Test
    public void testRegistrarFechaDeCierreDeReporte() throws Exception {
        System.out.println("registrarFechaDeCierreDeReporte");
        SesionTutoria sesionTutoria = null;
        int idPeriodo = 0;
        String numTutoria = "";
        SesionTutoriaDAO instance = new SesionTutoriaDAO();
        int expResult = 0;
        int result = instance.registrarFechaDeCierreDeReporte(sesionTutoria, idPeriodo, numTutoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
