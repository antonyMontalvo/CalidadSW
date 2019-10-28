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
public class ClientTest {

    public ClientTest() {
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
     * Test of getIdClient method, of class Client.
     */
    @Test
    public void testGetIdClient() {
        System.out.println("getIdClient");
        Client instance = new Client();
        instance.setIdClient(0);
        int expResult = 0;
        int result = instance.getIdClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdClient method, of class Client.
     */
    @Test
    public void testSetIdClient() {
        System.out.println("setIdClient");
        int idClient = 0;
        Client instance = new Client();
        instance.setIdClient(idClient);
        assertEquals(idClient, instance.getIdClient());
    }

    /**
     * Test of getTelephone method, of class Client.
     */
    @Test
    public void testGetTelephone() {
        System.out.println("getTelephone");
        Client instance = new Client();
        instance.setTelephone("");
        String expResult = "";
        String result = instance.getTelephone();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelephone method, of class Client.
     */
    @Test
    public void testSetTelephone() {
        System.out.println("setTelephone");
        String telephone = "";
        Client instance = new Client();
        instance.setTelephone(telephone);
        assertEquals(telephone, instance.getTelephone());
    }

    /**
     * Test of getMail method, of class Client.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        Client instance = new Client();
        instance.setMail("");
        String expResult = "";
        String result = instance.getMail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMail method, of class Client.
     */
    @Test
    public void testSetMail() {
        System.out.println("setMail");
        String mail = "";
        Client instance = new Client();
        instance.setMail(mail);
        assertEquals(mail, instance.getMail());
    }

    /**
     * Test of getUsername method, of class Client.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Client instance = new Client();
        instance.setUsername("");
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Client.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Client instance = new Client();
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of getPassword method, of class Client.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Client instance = new Client();
        instance.setPassword("");
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Client.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Client instance = new Client();
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }

}
