/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.dao.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unmsm.edu.pe.calidadsw.dao.DAOFactory;
import unmsm.edu.pe.calidadsw.dao.design.IEventDAO;
import unmsm.edu.pe.calidadsw.dao.model.Administrator;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;
import unmsm.edu.pe.calidadsw.dao.model.Event;

/**
 *
 * @author Antony
 */
public class EventDAOTest {

    static IEventDAO eventDAO = DAOFactory.getInstance().getEventDAO();

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
    public void testCreateBasic() {
        System.out.println("createBasic");

        Ambient ambient = new Ambient();
        ambient.setIdAmbient(1);
        Administrator administrator = new Administrator();
        administrator.setIdAdministrator(1);
        Event event = new Event();
        event.setTitle("Docker conference");
        event.setDescription("La primera conferencia del año.");
        event.setDate("2019-10-27");
        event.setState("creado");
        event.setAmbient(ambient);
        event.setAdministrator(administrator);

        int expResult = 0;
        int result = eventDAO.createBasic(event);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of read method, of class EventDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");

        List<Event> result = eventDAO.read();
        assertEquals(result, result);
    }

}
