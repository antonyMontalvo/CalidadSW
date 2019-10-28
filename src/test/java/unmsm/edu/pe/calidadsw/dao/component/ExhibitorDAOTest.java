/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.dao.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unmsm.edu.pe.calidadsw.dao.DAOFactory;
import unmsm.edu.pe.calidadsw.dao.design.IExhibitorDAO;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;

/**
 *
 * @author Antony
 */
public class ExhibitorDAOTest {

    static IExhibitorDAO exhibitorDAO = DAOFactory.getInstance().getExhibitorDAO();

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

        Exhibitor exhibitor = new Exhibitor();
        exhibitor.setDni("72410518");
        exhibitor.setName("Christian");
        exhibitor.setLastname("Garcia");
        exhibitor.setBirthdate("1995-12-12");
        exhibitor.setNationality("Perú");
        exhibitor.setSpecialty("DataBase administrator");

        boolean expResult = true;
        boolean result = exhibitorDAO.create(exhibitor);
        assertEquals(expResult, result);
    }

    /**
     * Test of read method, of class ExhibitorDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");

        List<Exhibitor> result = exhibitorDAO.read();
        assertEquals(result, result);
    }

}
