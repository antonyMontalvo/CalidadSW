/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.dao.component;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;

/**
 *
 * @author Antony
 */
public class AmbientDAOTest {

    public AmbientDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of create method, of class AmbientDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Ambient ambient = new Ambient("Auditorio San Marcos", "Cerrado", "Primer", 500, "Central frente al rectorado",
                "Creado");
        AmbientDAO instance = new AmbientDAO();
        boolean expResult = true;
        boolean result = instance.create(ambient);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class AmbientDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Integer id = 7;
        AmbientDAO instance = new AmbientDAO();
        boolean expResult = true;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of read method, of class AmbientDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        AmbientDAO instance = new AmbientDAO();
        List<Ambient> result = instance.read();
        assertEquals(result, result);
    }

}
