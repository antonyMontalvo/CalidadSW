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
public class AdministratorTest {
    
    public AdministratorTest() {
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
     * Test of getIdAdministrator method, of class Administrator.
     */
    @Test
    public void testGetIdAdministrator() {
        System.out.println("getIdAdministrator");
        Administrator instance = new Administrator();
        instance.setIdAdministrator(0);
        int expResult = 0;
        int result = instance.getIdAdministrator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdAdministrator method, of class Administrator.
     */
    @Test
    public void testSetIdAdministrator() {
        System.out.println("setIdAdministrator");
        int idAdministrator = 0;
        Administrator instance = new Administrator();
        instance.setIdAdministrator(idAdministrator);
        assertEquals(idAdministrator, instance.getIdAdministrator());
    }

    /**
     * Test of getUsername method, of class Administrator.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Administrator instance = new Administrator();
        instance.setUsername("");
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Administrator.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Administrator instance = new Administrator();
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of getPassword method, of class Administrator.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Administrator instance = new Administrator();
        instance.setPassword("");
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Administrator.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Administrator instance = new Administrator();
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }
    
}
