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
public class ExhibitorTest {

    public ExhibitorTest() {
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
     * Test of getIdExhibitor method, of class Exhibitor.
     */
    @Test
    public void testGetIdExhibitor() {
        System.out.println("getIdExhibitor");
        Exhibitor instance = new Exhibitor();
        instance.setIdExhibitor(0);
        int expResult = 0;
        int result = instance.getIdExhibitor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdExhibitor method, of class Exhibitor.
     */
    @Test
    public void testSetIdExhibitor() {
        System.out.println("setIdExhibitor");
        int idExhibitor = 0;
        Exhibitor instance = new Exhibitor();
        instance.setIdExhibitor(idExhibitor);
        assertEquals(idExhibitor, instance.getIdExhibitor());
    }

    /**
     * Test of getNationality method, of class Exhibitor.
     */
    @Test
    public void testGetNationality() {
        System.out.println("getNationality");
        Exhibitor instance = new Exhibitor();
        instance.setNationality("");
        String expResult = "";
        String result = instance.getNationality();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNationality method, of class Exhibitor.
     */
    @Test
    public void testSetNationality() {
        System.out.println("setNationality");
        String nationality = "";
        Exhibitor instance = new Exhibitor();
        instance.setNationality(nationality);
        assertEquals(nationality, instance.getNationality());
    }

    /**
     * Test of getSpecialty method, of class Exhibitor.
     */
    @Test
    public void testGetSpecialty() {
        System.out.println("getSpecialty");
        Exhibitor instance = new Exhibitor();
        instance.setSpecialty("");
        String expResult = "";
        String result = instance.getSpecialty();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpecialty method, of class Exhibitor.
     */
    @Test
    public void testSetSpecialty() {
        System.out.println("setSpecialty");
        String specialty = "";
        Exhibitor instance = new Exhibitor();
        instance.setSpecialty(specialty);
        assertEquals(specialty, instance.getSpecialty());
    }

}
