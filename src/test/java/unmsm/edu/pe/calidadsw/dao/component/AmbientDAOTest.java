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
import unmsm.edu.pe.calidadsw.dao.design.IAmbientDAO;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;

/**
 *
 * @author Antony
 */
public class AmbientDAOTest {

    static IAmbientDAO ambientDAO = DAOFactory.getInstance().getAmbientDAO();

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

        Ambient ambient = new Ambient();
        ambient.setName("Auditorio San Marcos");
        ambient.setType("Cerrado");
        ambient.setFloor("Primer");
        ambient.setCapacity(300);
        ambient.setDescription("Central frente al rectorado");
        ambient.setState("Creado");

        boolean expResult = true;
        boolean result = ambientDAO.create(ambient);
        assertEquals(expResult, result);
    }

    /**
     * Test of read method, of class AmbientDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");

        List<Ambient> result = ambientDAO.read();
        assertEquals(result, result);
    }

}
