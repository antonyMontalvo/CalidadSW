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

import unmsm.edu.pe.calidadsw.dao.model.Administrator;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;
import unmsm.edu.pe.calidadsw.dao.model.Event;

/**
 *
 * @author Antony
 */
public class EventDAOTest {

    public EventDAOTest() {
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
     * Test of create method, of class EventDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Ambient ambient = new Ambient();
        ambient.setIdAmbient(1);
        Administrator administrator = new Administrator();
        administrator.setIdAdministrator(1);
        Event event = new Event("Docker conference", "La primera conferencia del año.", new Date(119, 8, 31), "creado",
                ambient, administrator);

        EventDAO instance = new EventDAO();
        boolean expResult = true;
        boolean result = instance.create(event);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class EventDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Integer id = 7;
        EventDAO instance = new EventDAO();
        boolean expResult = true;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of read method, of class EventDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        EventDAO instance = new EventDAO();
        List<Event> result = instance.read();
        assertEquals(result, result);
    }

}
