/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.dao.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Antony
 */
public class EventTest {

    public EventTest() {
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
     * Test of getIdEvent method, of class Event.
     */
    @Test
    public void testGetIdEvent() {
        System.out.println("getIdEvent");
        Event instance = new Event();
        instance.setIdEvent(0);
        int expResult = 0;
        int result = instance.getIdEvent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdEvent method, of class Event.
     */
    @Test
    public void testSetIdEvent() {
        System.out.println("setIdEvent");
        int idevent = 0;
        Event instance = new Event();
        instance.setIdEvent(idevent);
        assertEquals(idevent, instance.getIdEvent());
    }

    /**
     * Test of getTitle method, of class Event.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Event instance = new Event();
        instance.setTitle("");
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Event.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Event instance = new Event();
        instance.setTitle(title);
        assertEquals(title, instance.getTitle());
    }

    /**
     * Test of getDescription method, of class Event.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Event instance = new Event();
        instance.setDescription("");
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Event.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Event instance = new Event();
        instance.setDescription(description);
        assertEquals(description, instance.getDescription());
    }

    /**
     * Test of getDate method, of class Event.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Event instance = new Event();
        instance.setDate(null);
        String expResult = null;
        String result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class Event.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = null;
        Event instance = new Event();
        instance.setDate(date);
        assertEquals(date, instance.getDate());
    }

    /**
     * Test of getState method, of class Event.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Event instance = new Event();
        instance.setState("");
        String expResult = "";
        String result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class Event.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        String state = "";
        Event instance = new Event();
        instance.setState(state);
        assertEquals(state, instance.getState());
    }

    /**
     * Test of getAmbient method, of class Event.
     */
    @Test
    public void testGetAmbient() {
        System.out.println("getAmbient");
        Event instance = new Event();
        instance.setAmbient(null);
        Ambient expResult = null;
        Ambient result = instance.getAmbient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAmbient method, of class Event.
     */
    @Test
    public void testSetAmbient() {
        System.out.println("setAmbient");
        Ambient ambient = null;
        Event instance = new Event();
        instance.setAmbient(ambient);
        assertEquals(ambient, instance.getAmbient());
    }

    /**
     * Test of getAdministrator method, of class Event.
     */
    @Test
    public void testGetAdministrator() {
        System.out.println("getAdministrator");
        Event instance = new Event();
        instance.setAdministrator(null);
        Administrator expResult = null;
        Administrator result = instance.getAdministrator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdministrator method, of class Event.
     */
    @Test
    public void testSetAdministrator() {
        System.out.println("setAdministrator");
        Administrator administrator = null;
        Event instance = new Event();
        instance.setAdministrator(administrator);
        assertEquals(administrator, instance.getAdministrator());
    }

}
