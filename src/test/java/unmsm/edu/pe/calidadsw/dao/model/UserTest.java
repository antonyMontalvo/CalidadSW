/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.dao.model;

import java.util.Date;
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
public class UserTest {

    public UserTest() {
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
     * Test of getIdUser method, of class User.
     */
    @Test
    public void testGetIdUser() {
        System.out.println("getIdUser");
        User instance = new User();
        instance.setIdUser(0);
        int expResult = 0;
        int result = instance.getIdUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdUser method, of class User.
     */
    @Test
    public void testSetIdUser() {
        System.out.println("setIdUser");
        int idUser = 0;
        User instance = new User();
        instance.setIdUser(idUser);
        assertEquals(idUser, instance.getIdUser());
    }

    /**
     * Test of getDni method, of class User.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        User instance = new User();
        instance.setDni("");
        String expResult = "";
        String result = instance.getDni();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDni method, of class User.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        String dni = "";
        User instance = new User();
        instance.setDni(dni);
        assertEquals(dni, instance.getDni());
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User();
        instance.setName("");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        User instance = new User();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getLastname method, of class User.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        User instance = new User();
        instance.setLastname("");
        String expResult = "";
        String result = instance.getLastname();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastname method, of class User.
     */
    @Test
    public void testSetLastname() {
        System.out.println("setLastname");
        String lastname = "";
        User instance = new User();
        instance.setLastname(lastname);
        assertEquals(lastname, instance.getLastname());
    }

    /**
     * Test of getBirthdate method, of class User.
     */
    @Test
    public void testGetBirthdate() {
        System.out.println("getBirthdate");
        User instance = new User();
        instance.setBirthdate(null);
        Date expResult = null;
        Date result = instance.getBirthdate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBirthdate method, of class User.
     */
    @Test
    public void testSetBirthdate() {
        System.out.println("setBirthdate");
        Date birthdate = null;
        User instance = new User();
        instance.setBirthdate(birthdate);
        assertEquals(birthdate, instance.getBirthdate());
    }

}
