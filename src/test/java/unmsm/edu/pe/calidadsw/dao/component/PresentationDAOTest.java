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
import unmsm.edu.pe.calidadsw.dao.model.Event;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;
import unmsm.edu.pe.calidadsw.dao.model.Presentation;

/**
 *
 * @author Antony
 */
public class PresentationDAOTest {

    public PresentationDAOTest() {
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
     * Test of readExhibitorsEvent method, of class PresentationDAO.
     */
    @Test
    public void testReadExhibitorsEvent() {
        System.out.println("readExhibitorsEvent");
        Event event = new Event();
        event.setIdEvent(1);
        PresentationDAO instance = new PresentationDAO();
        List<Exhibitor> result = instance.readExhibitorsEvent(event);
        assertEquals(result, result);
    }

    /**
     * Test of registerPresentation method, of class PresentationDAO.
     */
    @Test
    public void testRegisterPresentation() {
        System.out.println("registerPresentation");
        Event event = new Event();
        event.setIdEvent(1);
        Exhibitor exhibitor = new Exhibitor();
        exhibitor.setIdExhibitor(1);
        Presentation presentation = new Presentation(15, 17, event, exhibitor);
        
        PresentationDAO instance = new PresentationDAO();
        boolean expResult = true;
        boolean result = instance.registerPresentation(presentation);
        assertEquals(expResult, result);
    }

}