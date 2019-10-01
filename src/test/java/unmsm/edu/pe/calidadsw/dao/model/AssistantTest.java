/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.dao.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Antony
 */
public class AssistantTest {

    public AssistantTest() {
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
     * Test of getIdAssistant method, of class Assistant.
     */
    @Test
    public void testGetIdAssistant() {
        System.out.println("getIdAssistant");
        Assistant instance = new Assistant();
        instance.setIdAssistant(0);
        int expResult = 0;
        int result = instance.getIdAssistant();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdAssistant method, of class Assistant.
     */
    @Test
    public void testSetIdAssistant() {
        System.out.println("setIdAssistant");
        int idAssistant = 0;
        Assistant instance = new Assistant();
        instance.setIdAssistant(idAssistant);
        assertEquals(idAssistant, instance.getIdAssistant());
    }

    /**
     * Test of getClient method, of class Assistant.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        Assistant instance = new Assistant();
        instance.setClient(null);
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClient method, of class Assistant.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        Client client = null;
        Assistant instance = new Assistant();
        instance.setClient(client);
        assertEquals(client, instance.getClient());
    }

    /**
     * Test of getEvent method, of class Assistant.
     */
    @Test
    public void testGetEvent() {
        System.out.println("getEvent");
        Assistant instance = new Assistant();
        instance.setEvent(null);
        Event expResult = null;
        Event result = instance.getEvent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEvent method, of class Assistant.
     */
    @Test
    public void testSetEvent() {
        System.out.println("setEvent");
        Event event = null;
        Assistant instance = new Assistant();
        instance.setEvent(event);
        assertEquals(event, instance.getEvent());
    }

}
