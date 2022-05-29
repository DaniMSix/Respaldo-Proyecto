/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Tutorado;

/**
 *
 * @author DMS19
 */
public class TutoradoDAOTest {
    
    public TutoradoDAOTest() {
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
     * Test of mostrarTodosLosTutoradosRegistrados method, of class TutoradoDAO.
     */
    @Test
    public void testMostrarTodosLosTutoradosRegistrados() {
        System.out.println("mostrarTodosLosTutoradosRegistrados");
        TutoradoDAO instance = new TutoradoDAO();
        ArrayList<Tutorado> expResult = null;
        ArrayList<Tutorado> result = instance.mostrarTodosLosTutoradosRegistrados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarTutoradoPorMatricula method, of class TutoradoDAO.
     */
    @Test
    public void testBuscarTutoradoPorMatricula() {
        System.out.println("BuscarTutoradoPorMatricula");
        String matriculaBuscada = "S20045891";
        TutoradoDAO tutoradoDao = new TutoradoDAO();
        ArrayList<Tutorado> expResult = new ArrayList<>();
        Tutorado tutoradoEsperado = new Tutorado();
        tutoradoEsperado.setMatricula("S20045891");
        tutoradoEsperado.setNombre("Victor");
        tutoradoEsperado.setApellidoPaterno("Ramirez");
        tutoradoEsperado.setApellidoMaterno("Perez");
        tutoradoEsperado.setCorreo("victor@uv.mx");
        expResult.add(tutoradoEsperado);
        ArrayList<Tutorado> result = (ArrayList<Tutorado>) tutoradoDao.buscarTutoradoPorMatricula(matriculaBuscada);
        for(Tutorado tutorado : result){
            System.out.println(String.format("%s %s %s", tutorado.getMatricula(), tutorado.getNombre(), tutorado.getApellidoPaterno(), tutorado.getApellidoMaterno(), tutorado.getCorreo()));
        }
        for(Tutorado tutorado : expResult){
            System.out.println(String.format("%s %s %s", tutorado.getMatricula(), tutorado.getNombre(), tutorado.getApellidoPaterno(), tutorado.getApellidoMaterno(), tutorado.getCorreo()));
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarTutoradoPorTutor method, of class TutoradoDAO.
     */
    @Test
    public void testBuscarTutoradoPorTutor() {
        System.out.println("buscarTutoradoPorTutor");
        String cuentaUV = "";
        TutoradoDAO instance = new TutoradoDAO();
        ArrayList<Tutorado> expResult = null;
        ArrayList<Tutorado> result = instance.buscarTutoradoPorTutor(cuentaUV);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarTutorado method, of class TutoradoDAO.
     */
    @Test
    public void testRegistrarTutorado() {
        System.out.println("registrarTutorado");
        Tutorado tutorado = null;
        TutoradoDAO instance = new TutoradoDAO();
        instance.registrarTutorado(tutorado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTutoradoPorMatricula method, of class TutoradoDAO.
     */
    @Test
    public void testEliminarTutoradoPorMatricula() {
        System.out.println("eliminarTutoradoPorMatricula");
        String matriculaEliminada = "";
        TutoradoDAO instance = new TutoradoDAO();
        instance.eliminarTutoradoPorMatricula(matriculaEliminada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarTutorado method, of class TutoradoDAO.
     */
    @Test
    public void testActualizarTutorado() {
        System.out.println("actualizarTutorado");
        Tutorado tutorado = null;
        TutoradoDAO instance = new TutoradoDAO();
        instance.actualizarTutorado(tutorado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTutoradosPorNombreCompleto method, of class TutoradoDAO.
     */
    @Test
    public void testObtenerTutoradosPorNombreCompleto() {
        
    }

    /**
     * Test of buscarTutoradoPorNombre method, of class TutoradoDAO.
     */
    @Test
    public void testBuscarTutoradoPorNombre() {
        System.out.println("buscarTutoradoPorNombre");
        String nombreBuscado = "";
        TutoradoDAO instance = new TutoradoDAO();
        ArrayList<Tutorado> expResult = null;
        ArrayList<Tutorado> result = instance.buscarTutoradoPorNombre(nombreBuscado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
