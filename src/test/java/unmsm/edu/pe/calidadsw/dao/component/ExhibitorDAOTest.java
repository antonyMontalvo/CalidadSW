/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.dao.component;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;

/**
 *
 * @author Antony
 */
public class ExhibitorDAOTest {

    public ExhibitorDAOTest() {
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
     * Test of create method, of class ExhibitorDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Exhibitor exhibitor = new Exhibitor("72410502", "Christian", "Garcia", new Date(1970, 9, 31), "Perú",
                "DataBase administrator");
        ExhibitorDAO instance = new ExhibitorDAO();
        boolean expResult = true;
        boolean result = instance.create(exhibitor);
        assertEquals(expResult, result);
    }

    /**
     * Test of read method, of class ExhibitorDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        ExhibitorDAO instance = new ExhibitorDAO();
        List<Exhibitor> result = instance.read();
        assertEquals(result, result);
    }

}
