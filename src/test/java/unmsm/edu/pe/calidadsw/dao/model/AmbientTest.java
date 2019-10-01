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
public class AmbientTest {
    
    public AmbientTest() {
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
     * Test of getIdAmbient method, of class Ambient.
     */
    @Test
    public void testGetIdAmbient() {
        System.out.println("getIdAmbient");
        Ambient instance = new Ambient();
        instance.setIdAmbient(0);
        int expResult = 0;
        int result = instance.getIdAmbient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdAmbient method, of class Ambient.
     */
    @Test
    public void testSetIdAmbient() {
        System.out.println("setIdAmbient");
        int idAmbient = 0;
        Ambient instance = new Ambient();
        instance.setIdAmbient(idAmbient);
        assertEquals(idAmbient, instance.getIdAmbient());
    }

    /**
     * Test of getName method, of class Ambient.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Ambient instance = new Ambient();
        instance.setName("");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Ambient.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Ambient instance = new Ambient();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getType method, of class Ambient.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Ambient instance = new Ambient();
        instance.setType("");
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class Ambient.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Ambient instance = new Ambient();
        instance.setType(type);
        assertEquals(type, instance.getType());
    }

    /**
     * Test of getFloor method, of class Ambient.
     */
    @Test
    public void testGetFloor() {
        System.out.println("getFloor");
        Ambient instance = new Ambient();
        instance.setFloor("");
        String expResult = "";
        String result = instance.getFloor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFloor method, of class Ambient.
     */
    @Test
    public void testSetFloor() {
        System.out.println("setFloor");
        String floor = "";
        Ambient instance = new Ambient();
        instance.setFloor(floor);
        assertEquals(floor, instance.getFloor());
    }

    /**
     * Test of getCapacity method, of class Ambient.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Ambient instance = new Ambient();
        instance.setCapacity(0);
        int expResult = 0;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCapacity method, of class Ambient.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int capacity = 0;
        Ambient instance = new Ambient();
        instance.setCapacity(capacity);
        assertEquals(capacity, instance.getCapacity());
    }

    /**
     * Test of getDescription method, of class Ambient.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Ambient instance = new Ambient();
        instance.setDescription("");
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Ambient.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Ambient instance = new Ambient();
        instance.setDescription(description);
        assertEquals(description, instance.getDescription());
    }

    /**
     * Test of getState method, of class Ambient.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Ambient instance = new Ambient();
        instance.setState("");
        String expResult = "";
        String result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class Ambient.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        String state = "";
        Ambient instance = new Ambient();
        instance.setState(state);
        assertEquals(state, instance.getState());
    }
    
}
