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
import unmsm.edu.pe.calidadsw.dao.model.Assistant;
import unmsm.edu.pe.calidadsw.dao.model.Client;
import unmsm.edu.pe.calidadsw.dao.model.Event;

/**
 *
 * @author Antony
 */
public class AssistantDAOTest {
    
    public AssistantDAOTest() {
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
     * Test of readAssistantsEvent method, of class AssistantDAO.
     */
    @Test
    public void testReadAssistantsEvent() {
        System.out.println("readAssistantsEvent");
        Event event = new Event();
        event.setIdEvent(1);
        AssistantDAO instance = new AssistantDAO();
        List<Client> result = instance.readAssistantsEvent(event);
        assertEquals(result, result);
    }

    /**
     * Test of registerParticipant method, of class AssistantDAO.
     */
    @Test
    public void testRegisterParticipant() {
        System.out.println("registerParticipant");
        Client client = new Client();
        client.setIdClient(1);
        Event event = new Event();
        event.setIdEvent(3);
        Assistant assistant = new Assistant(client, event);
        
        AssistantDAO instance = new AssistantDAO();
        boolean expResult = true;
        boolean result = instance.registerParticipant(assistant);
        assertEquals(expResult, result);
    }
    
}
