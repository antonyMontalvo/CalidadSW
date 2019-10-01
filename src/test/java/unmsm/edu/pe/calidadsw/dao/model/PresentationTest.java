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
public class PresentationTest {

    public PresentationTest() {
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
     * Test of getIdPresentation method, of class Presentation.
     */
    @Test
    public void testGetIdPresentation() {
        System.out.println("getIdPresentation");
        Presentation instance = new Presentation();
        instance.setIdPresentation(0);
        int expResult = 0;
        int result = instance.getIdPresentation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdPresentation method, of class Presentation.
     */
    @Test
    public void testSetIdPresentation() {
        System.out.println("setIdPresentation");
        int idPresentation = 0;
        Presentation instance = new Presentation();
        instance.setIdPresentation(idPresentation);
        assertEquals(idPresentation, instance.getIdPresentation());
    }

    /**
     * Test of getStartTime method, of class Presentation.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        Presentation instance = new Presentation();
        instance.setStartTime(0);
        int expResult = 0;
        int result = instance.getStartTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStartTime method, of class Presentation.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        int startTime = 0;
        Presentation instance = new Presentation();
        instance.setStartTime(startTime);
        assertEquals(startTime, instance.getStartTime());
    }

    /**
     * Test of getEndTime method, of class Presentation.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        Presentation instance = new Presentation();
        instance.setEndTime(0);
        int expResult = 0;
        int result = instance.getEndTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEndTime method, of class Presentation.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        int endTime = 0;
        Presentation instance = new Presentation();
        instance.setEndTime(endTime);
        assertEquals(endTime, instance.getEndTime());
    }

    /**
     * Test of getEvent method, of class Presentation.
     */
    @Test
    public void testGetEvent() {
        System.out.println("getEvent");
        Presentation instance = new Presentation();
        instance.setEvent(null);
        Event expResult = null;
        Event result = instance.getEvent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEvent method, of class Presentation.
     */
    @Test
    public void testSetEvent() {
        System.out.println("setEvent");
        Event event = null;
        Presentation instance = new Presentation();
        instance.setEvent(event);
        assertEquals(event, instance.getEvent());
    }

    /**
     * Test of getExhibitor method, of class Presentation.
     */
    @Test
    public void testGetExhibitor() {
        System.out.println("getExhibitor");
        Presentation instance = new Presentation();
        instance.setExhibitor(null);
        Exhibitor expResult = null;
        Exhibitor result = instance.getExhibitor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExhibitor method, of class Presentation.
     */
    @Test
    public void testSetExhibitor() {
        System.out.println("setExhibitor");
        Exhibitor exhibitor = null;
        Presentation instance = new Presentation();
        instance.setExhibitor(exhibitor);
        assertEquals(exhibitor, instance.getExhibitor());
    }

}
