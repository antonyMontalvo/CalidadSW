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
import unmsm.edu.pe.calidadsw.dao.design.IAssistantDAO;
import unmsm.edu.pe.calidadsw.dao.model.Assistant;
import unmsm.edu.pe.calidadsw.dao.model.Client;
import unmsm.edu.pe.calidadsw.dao.model.Event;

/**
 *
 * @author Antony
 */
public class AssistantDAOTest {

    static IAssistantDAO assistantDAO = DAOFactory.getInstance().getAssistantDAO();

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

        List<Client> result = assistantDAO.readAssistantsEvent(event);
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
        Assistant assistant = new Assistant();
        assistant.setClient(client);
        assistant.setEvent(event);

        boolean expResult = true;
        boolean result = assistantDAO.registerParticipant(assistant);
        assertEquals(expResult, result);
    }

}
